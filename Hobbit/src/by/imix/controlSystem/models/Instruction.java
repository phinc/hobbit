package by.imix.controlSystem.models;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 12:46
 * To change this template use File | Settings | File Templates.
 */
public interface Instruction {

    /**
     *
     * @return  action to be executed
     */
    Action getAction();

    /**
     *
     * @return  the state to be applied to the recipients
     */
    State getState();

    /**
     *
     * @return the list of recipients who receive the new permissions (states) on target domain object
     */
    Set<DomainObjectAdapter> getRecipients();

    /**
     * Executes the current action on the target domain object
     * @param target
     */
//    public void apply(DomainObjectAdapter domainObject);
}
