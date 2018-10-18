package dev.ivanhdzd.app.model;

import java.util.Date;

import dev.ivanhdzd.app.Enumerator.Status;

public class News {
	private int id;
	private String title;
	private Date publicationDate;
	private Status status;
	private String details;

	public News() {
		this.publicationDate = new Date();
		this.status = Status.ACTIVE;
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

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "News { id: " + id + ", title: " + title + ", publicationDate: " + publicationDate + ", status: " + status
				+ ", details: " + details + " }";
	}
}