package dev.ivanhdzd.app.model;

import java.util.Date;

import dev.ivanhdzd.app.Enumerator.Status;

public class Banner {
	private int id;
	private String title;
	private Date date;
	private String image;
	private Status status;

	public Banner() {
		date = new Date();
		status = Status.ACTIVE;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	// public void setDate(Date date) {
	// this.date = date;
	// }

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Banner { id: " + id + ", title: " + title + ", date: " + date + ", image: " + image + ", status: "
				+ status + " }";
	}
}