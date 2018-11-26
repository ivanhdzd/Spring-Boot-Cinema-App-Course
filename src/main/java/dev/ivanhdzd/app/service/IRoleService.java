package dev.ivanhdzd.app.service;

import java.util.List;

import dev.ivanhdzd.app.model.Role;

public interface IRoleService {
	public List<Role> getAllRoles();
	public List<Role> getAllRolesWithoutAdmin();
	public Role getRole(String role);
}