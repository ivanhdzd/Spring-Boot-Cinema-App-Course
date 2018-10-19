package dev.ivanhdzd.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "timetables")
public class Timetable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 8, nullable = false)
	private int id;

	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "time", nullable = false)
	private String time; // HH:mm

	@Column(name = "room", length = 64, nullable = false)
	private String room;

	@Column(name = "price", nullable = false)
	private double price;

	@ManyToOne
	@JoinColumn(name = "id_movie")
	private Movie movie;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Horary { id: " + id + ", date: " + date + ", time: " + time + ", room: " + room + ", price: " + price
				+ ", movie: " + movie + " }";
	}
}