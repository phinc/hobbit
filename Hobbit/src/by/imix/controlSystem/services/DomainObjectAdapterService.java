package by.imix.controlSystem.services;

import by.imix.controlSystem.models.DomainObjectAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 19:33
 * To change this template use File | Settings | File Templates.
 */
public interface DomainObjectAdapterService {
    
    DomainObjectAdapter getByDomainObject(String type, Long identity);

    void saveOrUpdate(DomainObjectAdapter domainObjectAdapter);

    void delete(DomainObjectAdapter domainObjectAdapter);
}
