package by.imix.controlSystem.services;

import by.imix.controlSystem.models.AdapterStateEntity;
import by.imix.controlSystem.models.AdapterStateEntityImpl;
import by.imix.controlSystem.models.DomainObjectAdapter;
import by.imix.controlSystem.models.Instruction;
import by.imix.controlSystem.models.Rule;
import by.imix.controlSystem.models.RuleImpl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 29.10.12
 * Time: 15:25
 * To change this template use File | Settings | File Templates.
 */
@Transactional(readOnly = true)
public class RuleServiceImpl implements RuleService {
	
	private static final Logger LOG = Logger.getLogger(RuleServiceImpl.class);
    
    private SessionFactory sessionFactory;
    
    private AdapterStateEntityService adapterStateEntityService; 

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void setAdapterStateEntityService(
			AdapterStateEntityService adapterStateEntityService) {
		this.adapterStateEntityService = adapterStateEntityService;
	}


    @Override
    @Transactional
    public void save(Rule rule) {
        sessionFactory.getCurrentSession().save(rule);
    }

    @Override
    @Transactional
    public  void delete(Rule rule) {
        sessionFactory.getCurrentSession().delete(rule);
    }
    
    @Override
    public Rule getById(Long id) {
        return (Rule)sessionFactory.getCurrentSession().get(RuleImpl.class, id);
    }

    @Override
    public Set<Rule> getByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from RuleImpl r where r.name = :name");
        query.setParameter("name", name);
        return new HashSet<Rule>(query.list());
    }

	@Override
	public Rule getByNameAndClient(String name, DomainObjectAdapter clientObject) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select r from ClientImpl c join c.rules r where r.name = :name and " +
				"c.clientDomainObject = :client");
		query.setParameter("name", name);
		query.setParameter("client", clientObject);
		return (Rule)query.uniqueResult();
	}

	@Override
	@Transactional
	public void apply(Rule rule, DomainObjectAdapter domainObject) {
		rule = (Rule)sessionFactory.getCurrentSession().merge(rule);
		AdapterStateEntity ase;
		LOG.debug("Apply rule: " + rule.getName());
		for(Instruction instruction : rule.getInstructions()){
			for (DomainObjectAdapter recipient : instruction.getRecipients()) {
	            ase = new AdapterStateEntityImpl(domainObject, recipient, instruction.getState());
	            LOG.debug("Adapter state entity: " + ase + " action: " + instruction.getAction());
	            instruction.getAction().apply(ase, adapterStateEntityService);
	        }
        }
	}
}
