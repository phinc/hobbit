package by.imix.controlSystem.models;

import javax.persistence.MappedSuperclass;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
public interface DomainObjectAdapter {

    /**
     *
     * @return the full class name of the domain object
     */
    String getType();

    /**
     *
     * @return identificator of the domain object
     */
    Long getIdentity();
}
