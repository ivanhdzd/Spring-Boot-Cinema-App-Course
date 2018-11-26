package dev.ivanhdzd.app.service;

import java.util.List;

import dev.ivanhdzd.app.model.User;

public interface IUserService {
	public User findUserById(int id);
	public User findUserByEmail(String email);
	public List<User> getAllUsersWithoutAdmin();
	public Boolean thereAreUsersRegisterd();
	public void saveUser(User user);
	public void delete(int id);
}