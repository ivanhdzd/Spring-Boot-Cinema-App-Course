package dev.ivanhdzd.app.model;

import java.util.Date;

import dev.ivanhdzd.app.Enumerator.Status;

public class Movie {
	private int id;
	private String title;
	private int duration;
	private String classification;
	private String genre;
	private Date premiereDate;
	private String image = "cinema.png";
	private Status status = Status.ACTIVE;
	private Detail detail;

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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getPremiereDate() {
		return premiereDate;
	}

	public void setPremiereDate(Date premiereDate) {
		this.premiereDate = premiereDate;
	}

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

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Movie { id: " + id + ", title: " + title + ", duration: " + duration + ", classification: "
				+ classification + ", genre: " + genre + ", premiereDate: " + premiereDate + ", image: " + image
				+ ", status: " + status + ", detail: " + detail + " }";
	}
}