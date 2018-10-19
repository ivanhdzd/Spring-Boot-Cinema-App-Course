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

import dev.ivanhdzd.app.enumerator.Status;
import dev.ivanhdzd.app.enumerator.StatusConverter;

@Entity
@Table(name = "banners")
public class Banner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 8, nullable = false)
	private int id;

	@Column(name = "title", length = 64, nullable = false)
	private String title;

	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "image", length = 128, nullable = false)
	private String image;

	@Enumerated(EnumType.STRING)
	@Convert(converter = StatusConverter.class)
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