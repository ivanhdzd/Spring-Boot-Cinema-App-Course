package dev.ivanhdzd.app.model;

public class Detail {
	private int id;
	private String director;
	private String actors;
	private String trailer;
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