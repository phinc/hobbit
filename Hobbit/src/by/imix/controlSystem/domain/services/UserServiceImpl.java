package by.imix.controlSystem.domain.services;

import by.imix.controlSystem.domain.dao.UserDao;
import by.imix.controlSystem.domain.models.User;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User getByName(String name) {
		return userDao.getByName(name);
	}

	@Override
	public User save(User user) {
		userDao.save(user);
		return user;
	}

}
