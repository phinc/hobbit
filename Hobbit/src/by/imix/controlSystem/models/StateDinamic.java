package by.imix.controlSystem.models;

import by.imix.controlSystem.models.State;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 12:32
 * To change this template use File | Settings | File Templates.
 */
public interface StateDinamic extends State {
    public void init();
    public void destroy();
}
