package dev.ivanhdzd.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dev.ivanhdzd.app.enumerator.Status;
import dev.ivanhdzd.app.enumerator.StatusConverter;

@Entity
@Table(name = "news")
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 8, nullable = false)
	private int id;

	@Column(name = "title", length = 64, nullable = false)
	private String title;

	@Temporal(TemporalType.DATE)
	@Column(name = "publication_date", nullable = false)
	private Date publicationDate;

	@Enumerated(EnumType.STRING)
	@Convert(converter = StatusConverter.class)
	@Column(name = "status", length = 8, nullable = false)
	private Status status;

	@Column(name = "details", length = 512, nullable = false)
	private String details;

	public News() {
		publicationDate = new Date();
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