package by.imix.controlSystem.domain.dao;

import by.imix.controlSystem.domain.models.User;

public interface UserDao {
	
	void save(User user);
	
	void delete(User user);
	
	/*
	 * return an user by the given name
	 */
	User getByName(String name);
}
