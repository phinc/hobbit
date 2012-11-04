package by.imix.controlSystem.services;

import by.imix.controlSystem.models.Action;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 23:11
 * To change this template use File | Settings | File Templates.
 */
public interface ActionService {

    void save(Action action);

    void delete(Action action);
}
