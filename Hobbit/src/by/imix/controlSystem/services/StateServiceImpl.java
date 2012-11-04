package by.imix.controlSystem.services;

import by.imix.controlSystem.models.State;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
@Transactional(readOnly = true)
public class StateServiceImpl implements StateService {
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public State save(State state) {
        State test = getByName(state.getName());
        if (test == null) {
        	sessionFactory.getCurrentSession().save(state);
        	return state;
        } else {
        	return test;
        }
    	
    }

    @Override
    public List<State> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from StateImpl").list();
    }

	@Override
	public State getByName(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from StateImpl s where s.name = :name");
		query.setParameter("name", name);
		return (State)query.uniqueResult();
	}
}
