package by.imix.controlSystem.domain.services;

import by.imix.controlSystem.domain.models.Group;

public interface GroupService {
	
	/*
	 * searches for group by the given name
	 */
	Group getByName(String name);
	
	Group save(Group group);
	
}
