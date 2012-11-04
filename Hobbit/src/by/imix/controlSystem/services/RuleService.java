package by.imix.controlSystem.services;

import by.imix.controlSystem.models.DomainObjectAdapter;
import by.imix.controlSystem.models.Rule;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 29.10.12
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */
public interface RuleService {

    void save(Rule rule);

    void delete(Rule rule);

    Rule getById(Long id);

    Set<Rule> getByName(String name);
    
    Rule getByNameAndClient(String name, DomainObjectAdapter clientObject);
    
    void apply(Rule rule, DomainObjectAdapter domainObject);
}
