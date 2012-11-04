package by.imix.controlSystem.domain.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import by.imix.controlSystem.domain.models.User;

@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	@Transactional
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	@Transactional
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public User getByName(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.name = :name");
		query.setParameter("name", name);
		return (User)query.uniqueResult();
	}

}
