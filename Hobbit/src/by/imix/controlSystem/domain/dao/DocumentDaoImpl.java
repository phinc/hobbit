package by.imix.controlSystem.domain.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import by.imix.controlSystem.domain.models.Document;

@Transactional(readOnly = true)
public class DocumentDaoImpl implements DocumentDao {
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	@Transactional
	public void save(Document document) {
		sessionFactory.getCurrentSession().save(document);		
	}

	@Override
	@Transactional
	public void delete(Document document) {
		sessionFactory.getCurrentSession().delete(document);		
	}

}
