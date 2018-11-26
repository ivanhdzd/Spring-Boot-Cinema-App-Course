package dev.ivanhdzd.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.ivanhdzd.app.model.User;
import dev.ivanhdzd.app.repository.IUserRepository;

@Service
public class UserService implements IUserService {
	/** Password encoder bean instance reference */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/** Users repository instance reference */
	@Autowired
	private IUserRepository userRepository;

	/**
	 * Find an user by it ID.
	 *
	 * @param id to can find an user.
	 * @return user.
	 */
	@Override
	public User findUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) return optional.get();
		else return null;
	}

	/**
	 * Find an user by it email.
	 *
	 * @param email to can find an user.
	 * @return user.
	 */
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/**
	 * Get all users without ADMINISTRATOR role.
	 *
	 * @return users list.
	 */
	@Override
	public List<User> getAllUsersWithoutAdmin() {
		return userRepository.findByRoles_RoleNot("ADMINISTRATOR");
	}

	/**
	 * Check if there are users already registered.
	 *
	 * @return true if there are users already registered, else returns false.
	 */
	@Override
	public Boolean thereAreUsersRegisterd() {
		long usersCount = userRepository.count();
		return usersCount > 0;
	}

	/**
	 * Save user data.
	 *
	 * @param user data to save.
	 */
	@Override
	public void saveUser(User user) {
		if (user.getPassword() != null && user.getPassword() != "") {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		} else {
			User oldUser = findUserById(user.getId());
			user.setPassword(oldUser.getPassword());
		}
		userRepository.save(user);
	}

	/**
	 * Delete an user by it ID.
	 *
	 * @param id user to delete.
	 */
	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}
}