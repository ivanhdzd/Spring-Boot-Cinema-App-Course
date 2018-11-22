package dev.ivanhdzd.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.ivanhdzd.app.model.User;
import dev.ivanhdzd.app.repository.IRoleRepository;
import dev.ivanhdzd.app.repository.IUserRepository;

@Service
public class UserService implements IUserService {
	/** Password encoder bean instance reference */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/** Users repository instance reference */
	@Autowired
	private IUserRepository userRepository;

	/** Roles repository instance reference */
	@Autowired
	private IRoleRepository roleRepository;

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
	 * Fins an user by it email.
	 *
	 * @param email to can find an user.
	 * @return user.
	 */
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> getAllUsersWithoutAdmin() {
		// return roleRepository.findByRoleNot("ADMINISTRATOR").stream().map(role -> role.get);
		return null;
	}

	/**
	 * Save user data.
	 *
	 * @param user data to save.
	 */
	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
}