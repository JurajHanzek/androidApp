package com.hanzek.zavrsni.beans.android;

public class MovieInfo {
	
	
	private Long idMovie;
	private String title; 
	private String releaseyear;
	private String synopsis;
	private String trailerUrl;
	private Integer durationMin;
	
	private String rated;
	private String image;

	private String movieStudioName;

	
	private String directorName;
	private String directorLastName;
	
	
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

	public String getMovieStudioName() {
		return movieStudioName;
	}
	public void setMovieStudioName(String movieStudioName) {
		this.movieStudioName = movieStudioName;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getDirectorLastName() {
		return directorLastName;
	}
	public void setDirectorLastName(String directorLastName) {
		this.directorLastName = directorLastName;
	}
	
	

}
