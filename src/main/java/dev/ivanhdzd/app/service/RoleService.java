package dev.ivanhdzd.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ivanhdzd.app.model.Role;
import dev.ivanhdzd.app.repository.IRoleRepository;

@Service
public class RoleService implements IRoleService {
	/** Roles repository instance reference */
	@Autowired
	private IRoleRepository roleRepository;

	/**
	 * Get all roles.
	 *
	 * @return roles list.
	 */
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	/**
	 * Get all roles without ADMINISTRATOR role.
	 *
	 * @return roles list.
	 */
	@Override
	public List<Role> getAllRolesWithoutAdmin() {
		return roleRepository.findByRoleNot("ADMINISTRATOR");
	}

	/**
	 * Get role by it value.
	 *
	 * @param role value.
	 * @return role.
	 */
	@Override
	public Role getRole(String role) {
		return roleRepository.findByRole(role);
	}
}