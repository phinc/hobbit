package by.imix.controlSystem.services;

import by.imix.controlSystem.models.DomainObjectAdapter;
import by.imix.controlSystem.models.Client;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */
public interface ClientService {
    
    Client getByName(String name, DomainObjectAdapter client);

    void save(Client ruleApplier);

    void delete(Client ruleApplier);
    
    void applyRules(Client ruleApplier, DomainObjectAdapter domainObject);

}
