package dev.ivanhdzd.app.service;

import java.util.List;

import dev.ivanhdzd.app.model.User;

public interface IUserService {
	public Boolean thereAreUsersRegisterd();
	public User findUserByEmail(String email);
	public List<User> getAllUsersWithoutAdmin();
	public void saveUser(User user);
}