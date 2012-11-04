package by.imix.controlSystem.models;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 19:45
 * To change this template use File | Settings | File Templates.
 */
public interface DomainObjectStateList {

    DomainObjectAdapter getDomainObjectAdapter();

    List<AdapterStateEntity> getAdapterStateEntities();
}
