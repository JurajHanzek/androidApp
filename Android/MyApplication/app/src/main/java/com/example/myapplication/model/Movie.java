package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Movie {

	@SerializedName("idMovie")
	private Long idMovie;

	private String title;
	@SerializedName("releaseyear")
	private String releaseyear;
	@SerializedName("synopsis")
	private String synopsis;
	@SerializedName("trailerUrl")
	private String trailerUrl;
	@SerializedName("durationMin")
	private Integer durationMin;
	@SerializedName("directorId")
	private Long directorId;
	@SerializedName("rated")
	private String rated;
	@SerializedName("image")
	private String image;
	@SerializedName("idgenre")
	private Long idgenre;
	@SerializedName("movieStudioid")
	private Long movieStudioid;
	
	
	public Movie(Long idMovie, String title, String releaseyear, String synopsis, String trailerUrl,
			Integer durationMin, Long directorId, String rated, String image, Long idgenre, Long movieStudioid) {
		super();
		this.idMovie = idMovie;
		this.title = title;
		this.releaseyear = releaseyear;
		this.synopsis = synopsis;
		this.trailerUrl = trailerUrl;
		this.durationMin = durationMin;
		this.directorId = directorId;
		this.rated = rated;
		this.image = image;
		this.idgenre = idgenre;
		this.movieStudioid = movieStudioid;
	}

	public Long getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(Long idMovie) {
		this.idMovie = idMovie;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseyear() {
		return releaseyear;
	}

	public void setReleaseyear(String releaseyear) {
		this.releaseyear = releaseyear;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}

	public Integer getDurationMin() {
		return durationMin;
	}

	public void setDurationMin(Integer durationMin) {
		this.durationMin = durationMin;
	}

	public Long getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Long directorId) {
		this.directorId = directorId;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getIdgenre() {
		return idgenre;
	}

	public void setIdgenre(Long idgenre) {
		this.idgenre = idgenre;
	}

	public Long getMovieStudioid() {
		return movieStudioid;
	}

	public void setMovieStudioid(Long movieStudioid) {
		this.movieStudioid = movieStudioid;
	}

	
	public Movie() {}
//	
//	

}
