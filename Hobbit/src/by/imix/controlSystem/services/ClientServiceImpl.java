package by.imix.controlSystem.services;

import by.imix.controlSystem.models.AdapterStateEntity;
import by.imix.controlSystem.models.AdapterStateEntityImpl;
import by.imix.controlSystem.models.DomainObjectAdapter;
import by.imix.controlSystem.models.Client;
import by.imix.controlSystem.models.Instruction;
import by.imix.controlSystem.models.Rule;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class ClientServiceImpl implements ClientService {
	
	private static final Logger LOG = Logger.getLogger(ClientServiceImpl.class.getName());
	
    private SessionFactory sessionFactory;
    
    private AdapterStateEntityService adapterStateEntityService; 

    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setAdapterStateEntityService(
			AdapterStateEntityService adapterStateEntityService) {
		this.adapterStateEntityService = adapterStateEntityService;
	}



	@Transactional(readOnly = true)
    @Override
    public Client getByName(String name, DomainObjectAdapter client) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select r from ClientImpl r join r.rules rules where rules.name=:name AND r.clientDomainObject=:client");
        query.setParameter("name", name);
        query.setParameter("client", client);
        return (Client)query.uniqueResult();
    }

    @Override
    public void save(Client ruleApplier) {
        sessionFactory.getCurrentSession().save(ruleApplier);
    }

    @Override
    public void delete(Client ruleApplier) {
        sessionFactory.getCurrentSession().delete(ruleApplier);
    }

	@Override
	public void applyRules(Client ruleApplier, DomainObjectAdapter domainObject) {		
		Client applier = (Client)sessionFactory.getCurrentSession().merge(ruleApplier);
		AdapterStateEntity ase;
		for (Rule rule : applier.getRules()) {
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
}
