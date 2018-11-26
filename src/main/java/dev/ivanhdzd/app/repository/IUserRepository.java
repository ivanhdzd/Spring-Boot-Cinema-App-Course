package dev.ivanhdzd.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ivanhdzd.app.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);
	public List<User> findByRoles_RoleNot(String role);
}