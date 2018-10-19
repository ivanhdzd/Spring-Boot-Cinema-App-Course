package dev.ivanhdzd.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "details")
public class Detail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 8, nullable = false)
	private int id;

	@Column(name = "director", length = 64)
	private String director;

	@Column(name = "actors", length = 256)
	private String actors;

	@Column(name = "trailer", length = 256)
	private String trailer;

	@Column(name = "synopsis")
	private String synopsis;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	@Override
	public String toString() {
		return "Detail { id: " + id + ", director: " + director + ", actors: " + actors + ", trailer: " + trailer
				+ ", synopsis: " + synopsis + " }";
	}
}