package by.imix.controlSystem.services;

import by.imix.controlSystem.models.State;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 22:28
 * To change this template use File | Settings | File Templates.
 */
public interface StateService {

    State getByName(String name);
	
	State save(State state);

    List<State> getAll();
}
