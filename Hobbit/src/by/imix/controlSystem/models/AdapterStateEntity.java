package by.imix.controlSystem.models;

import javax.persistence.MappedSuperclass;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */
public interface AdapterStateEntity {

    /**
     *
     * @return  adapter for secured object
     */
    DomainObjectAdapter getAdapter();

    /**
     *
     * @return  the access permission for the secured object
     */
    State getState();

    /**
     *
     * @return adapter who can get access to secured object according to the permission (state)
     */
    DomainObjectAdapter getClient();
}
