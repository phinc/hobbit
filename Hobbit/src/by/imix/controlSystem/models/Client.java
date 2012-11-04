package by.imix.controlSystem.models;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 21:26
 * To change this template use File | Settings | File Templates.
 */
public interface Client {

    DomainObjectAdapter getClientDomainObject();

    Set<Rule> getRules();

//    void apply(DomainObjectAdapter domainObject);
}
