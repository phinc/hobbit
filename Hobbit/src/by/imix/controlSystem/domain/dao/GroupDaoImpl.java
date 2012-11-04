package by.imix.controlSystem.domain.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import by.imix.controlSystem.domain.models.Group;

@Transactional(readOnly = true)
public class GroupDaoImpl implements GroupDao {
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	@Transactional
	public void save(Group group) {
		sessionFactory.getCurrentSession().save(group);
	}

	@Override
	@Transactional
	public void delete(Group group) {
		sessionFactory.getCurrentSession().delete(group);
	}

	@Override
	public Group getByName(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Group u where u.name = :name");
		query.setParameter("name", name);
		return (Group)query.uniqueResult();
	}

}
