package by.imix.controlSystem.services;

import by.imix.controlSystem.models.Action;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
@Transactional(readOnly = true)
public class ActionServiceImpl implements ActionService {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void save(Action action) {
       sessionFactory.getCurrentSession().save(action);
    }

    @Override
    @Transactional
    public void delete(Action action) {
        sessionFactory.getCurrentSession().delete(action);
    }
}
