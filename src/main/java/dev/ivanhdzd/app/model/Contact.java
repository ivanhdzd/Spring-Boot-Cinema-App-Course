package dev.ivanhdzd.app.model;

import java.util.Arrays;

public class Contact {
	private int id;
	private String name;
	private String email;
	private int rating = 5;
	private String[] genres;
	private String[] notifications;
	private String comments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String[] getGenres() {
		return genres;
	}

	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	public String[] getNotifications() {
		return notifications;
	}

	public void setNotifications(String[] notifications) {
		this.notifications = notifications;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Contact { id: " + id + ", name: " + name + ", email: " + email + ", rating: " + rating + ", genres: "
				+ Arrays.toString(genres) + ", notifications: " + Arrays.toString(notifications) + ", comments:"
				+ comments + " }";
	}
}