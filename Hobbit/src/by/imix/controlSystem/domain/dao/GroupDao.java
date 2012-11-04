package by.imix.controlSystem.domain.dao;

import by.imix.controlSystem.domain.models.Group;

public interface GroupDao {
	
	void save(Group group);
	
	void delete(Group group);
	
	Group getByName(String name);
}
