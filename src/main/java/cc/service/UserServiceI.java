package cc.service;

import java.util.List;

import cc.model.User;

public interface UserServiceI {
	public User getUserById(String id);
	List<User> getAll();
	public int insert(User user);
}
