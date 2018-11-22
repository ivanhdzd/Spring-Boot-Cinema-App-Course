package dev.ivanhdzd.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 8)
	private int id;

	@Column(name = "active", length = 1)
	private int active = 1;

	@Column(name = "username", length = 32)
	@NotEmpty(message = "Please provide your username")
	private String username;

	@Column(name = "email", length = 32)
	@Email(message = "Please provide a valid email")
	@NotEmpty(message = "Please provide your email")
	private String email;

	@Column(name = "password")
	@Length(min = 6, message = "*Your password must have at least 6 characters")
	@NotEmpty(message = "Please provide your password")
	private String password;

	@Column(name = "name", length = 32)
	@NotEmpty(message = "Please provide your name")
	private String name;

	@Column(name = "last_name", length = 64)
	@NotEmpty(message = "Please provide your last name")
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "id"))
	private Set<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getUsername() {
		return name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User: { id: " + id + ", active: " + active + ", username: " + username + ", email: " + email
				+ ", password: " + password + ", name: " + name + ", lastName: " + lastName + ", roles: " + roles
				+ " }";
	}
}