package by.imix.controlSystem.services;

import by.imix.controlSystem.models.AdapterStateEntity;
import by.imix.controlSystem.models.DomainObjectAdapter;
import by.imix.controlSystem.services.AdapterStateEntityService;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */
@Transactional(readOnly = true)
public class AdapterStateEntityServiceImpl implements AdapterStateEntityService {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void insert(AdapterStateEntity adapterStateEntity) {
        sessionFactory.getCurrentSession().save(adapterStateEntity);
    }

    @Override
    @Transactional
    public void delete(AdapterStateEntity adapterStateEntity) {
        sessionFactory.getCurrentSession().delete(adapterStateEntity);
    }

    @Override
    public AdapterStateEntity loadById(Integer id) {
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "from AdapterStateEntityImpl a where a.id =:id");
        query.setParameter("id", id);
        return (AdapterStateEntity)query.list();
    }

    @Override
    public List<AdapterStateEntity> getByAdapter(Integer id) {
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "from AdapterStateEntityImpl a where a.adapter.id =:id");
        query.setParameter("id", id);
        return (List<AdapterStateEntity>)query.list();  
    }

    @Override
    public List<AdapterStateEntity> getByAdapter(DomainObjectAdapter adapter) {
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "from AdapterStateEntityImpl a where a.adapter =:adapter");
        query.setParameter("adapter", adapter);
        return (List<AdapterStateEntity>)query.list();
    }
}
