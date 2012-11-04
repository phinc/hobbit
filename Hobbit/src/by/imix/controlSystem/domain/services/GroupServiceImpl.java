package by.imix.controlSystem.domain.services;

import by.imix.controlSystem.domain.dao.GroupDao;
import by.imix.controlSystem.domain.models.Group;

public class GroupServiceImpl implements GroupService {
	
	private GroupDao groupDao;
	
	
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	@Override
	public Group getByName(String name) {
		return groupDao.getByName(name);
	}

	@Override
	public Group save(Group group) {
		Group test = getByName(group.getName());
		if (test == null) {
			groupDao.save(group);
			return group;
		} else {
			return test;
		}	
	}

}
