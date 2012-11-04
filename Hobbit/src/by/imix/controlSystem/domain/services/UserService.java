package by.imix.controlSystem.domain.services;

import by.imix.controlSystem.domain.models.User;

public interface UserService {
	
	/*
	 * return user with the given name.
	 */
	User getByName(String name);
	
	User save(User user);
}
