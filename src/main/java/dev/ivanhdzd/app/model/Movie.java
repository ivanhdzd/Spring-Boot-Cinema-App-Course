package dev.ivanhdzd.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dev.ivanhdzd.app.enumerator.Classification;
import dev.ivanhdzd.app.enumerator.ClassificationConverter;
import dev.ivanhdzd.app.enumerator.Status;
import dev.ivanhdzd.app.enumerator.StatusConverter;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 8, nullable = false)
	private int id;

	@Column(name = "title", length = 64, nullable = false)
	private String title;

	@Column(name = "duration", length = 4, nullable = false)
	private int duration;

	@Enumerated(EnumType.STRING)
	@Convert(converter = ClassificationConverter.class)
	@Column(name = "classification", length = 2, nullable = false)
	private Classification classification;

	@Column(name = "genre", length = 64, nullable = false)
	private String genre;

	@Column(name = "premiere_date", nullable = false)
	private Date premiereDate;

	@Column(name = "image", length = 128, nullable = false)
	private String image = "cinema.png";

	@Enumerated(EnumType.STRING)
	@Convert(converter = StatusConverter.class)
	@Column(name = "status", length = 8, nullable = false)
	private Status status = Status.ACTIVE;

	@OneToOne
	@JoinColumn(name = "id_detail")
	private Detail detail;

	@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
	private List<Timetable> timetables;

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

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
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

	public List<Timetable> getTimetables() {
		return timetables;
	}

	public void setTimetables(List<Timetable> timetables) {
		this.timetables = timetables;
	}

	@Override
	public String toString() {
		return "Movie { id: " + id + ", title: " + title + ", duration: " + duration + ", classification: "
				+ classification + ", genre: " + genre + ", premiereDate: " + premiereDate + ", image: " + image
				+ ", status: " + status + ", detail: " + detail + " }";
	}
}