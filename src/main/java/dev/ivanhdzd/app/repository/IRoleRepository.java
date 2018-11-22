package dev.ivanhdzd.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ivanhdzd.app.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
	public Role findByRole(String role);
	public List<Role> findByRoleNot(String role);
}