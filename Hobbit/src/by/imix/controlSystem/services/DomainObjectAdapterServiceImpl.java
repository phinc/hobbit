package by.imix.controlSystem.services;

import by.imix.controlSystem.models.DomainObjectAdapter;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 19:37
 * To change this template use File | Settings | File Templates.
 */
@Transactional(readOnly = true)
public class DomainObjectAdapterServiceImpl implements DomainObjectAdapterService {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public DomainObjectAdapter getByDomainObject(String type, Long identity) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from DomainObjectAdapterImpl d where d.identity = :identity and d.type = :type");
        query.setParameter("identity", identity);
        query.setParameter("type", type);
        return (DomainObjectAdapter)query.uniqueResult();
    }

    @Override
    @Transactional
    public void saveOrUpdate(DomainObjectAdapter domainObjectAdapter) {
        sessionFactory.getCurrentSession().saveOrUpdate(domainObjectAdapter);
    }

    @Override
    @Transactional
    public void delete(DomainObjectAdapter domainObjectAdapter) {
        sessionFactory.getCurrentSession().delete(domainObjectAdapter);
    }
}
