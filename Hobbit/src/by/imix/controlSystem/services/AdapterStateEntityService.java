package by.imix.controlSystem.services;

import by.imix.controlSystem.models.AdapterStateEntity;
import by.imix.controlSystem.models.DomainObjectAdapter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
public interface AdapterStateEntityService {

    void insert(AdapterStateEntity adapterStateEntity);
    
    void delete(AdapterStateEntity adapterStateEntity);

    AdapterStateEntity loadById(Integer id);
    
    List<AdapterStateEntity> getByAdapter(Integer id);

    List<AdapterStateEntity> getByAdapter(DomainObjectAdapter adapter);
}
