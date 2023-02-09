package com.hanzek.zavrsni.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.Director;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.beans.MovieRating;
import com.hanzek.zavrsni.beans.MovieStudio;
import com.hanzek.zavrsni.beans.Ocjene;
import com.hanzek.zavrsni.beans.UserRating;
import com.hanzek.zavrsni.beans.android.MovieInfo;
import com.hanzek.zavrsni.beans.android.MovieRating2;
import com.hanzek.zavrsni.service.HomeService;
import com.hanzek.zavrsni.service.MovieService;

@CrossOrigin("*")
@RestController
public class AndroidController {
	@Autowired
	private HomeService iHomeService;
	@Autowired
	private MovieService iMovieService;
	
	
	@GetMapping("/android/movie/{id}")
	public ResponseEntity<MovieInfo> findMovieByID(@PathVariable Long id) {
		MovieInfo movieInfo = new MovieInfo();
		Movie movie= iMovieService.findMovieByID(id);
		movieInfo.setTitle(movie.getTitle());
		movieInfo.setReleaseyear(movie.getReleaseyear());
		movieInfo.setSynopsis(movie.getSynopsis());
		movieInfo.setTrailerUrl(movie.getTrailerUrl());
		movieInfo.setDurationMin(movie.getDurationMin());
		movieInfo.setRated(movie.getRated());
		movieInfo.setImage(movie.getImage());
		
		Director director= iMovieService.findDirector(id);
		MovieStudio movieStudio= iMovieService.findStudio(id);
		
		movieInfo.setMovieStudioName(movieStudio.getName());
		movieInfo.setDirectorName(director.getName());
		movieInfo.setDirectorLastName(director.getLastName());
		
		
		return new ResponseEntity<>(movieInfo,HttpStatus.OK);
	}
	
	//Getta actore po filmu
		@GetMapping("/android/actors/{id}")
		public ResponseEntity<List<Actor>> findMovieActors(@PathVariable Long id) {
			List<Actor> actors= iMovieService.findActors(id);
			return new ResponseEntity<>(actors,HttpStatus.OK);
		}
		
		@GetMapping("/android/movie/ocjena/{id}")
		public ResponseEntity <Ocjene> dohvatiOcjenu(@PathVariable Long id) {
			Ocjene ocj= iMovieService.dohvatiOcjenu(id);
			return new ResponseEntity<>(ocj,HttpStatus.OK);
		}
	
		@GetMapping("android/movie/comments/{id}")
		public ResponseEntity<List<MovieRating2>> dohvatiRejting(@PathVariable Long id) {
			List<MovieRating> ratings = iHomeService.dohvatiRejting();
			List<MovieRating2> ratings2 = new ArrayList();
			
			for (MovieRating rating_ : ratings) {
				if(rating_.getIdMovie().equals(id)) {
					MovieRating2 temp = new MovieRating2();
					temp.setIdRating(id);
					temp.setKomentar(rating_.getKomentar());
					temp.setRating(rating_.getRating().toString());
					temp.setUserName(rating_.getIdUser().toString());
					ratings2.add(temp);
				}
			}
			return new ResponseEntity<>(ratings2, HttpStatus.OK);
		}
		
		@PostMapping("/android/movie/rate/{id}")
		public ResponseEntity<MovieRating2> addRating(@PathVariable Long id,@RequestBody MovieRating2 mv) {
			UserRating ur = new UserRating();
			ur.setIdMovie(id);
			//ur.setIdRating(2L);
			ur.setIdUser(1L);
			ur.setKomentar(mv.getKomentar());
			ur.setRating(Double.valueOf(mv.getRating()));
			iMovieService.rateMovie(ur);
			return new ResponseEntity<>(mv,HttpStatus.OK);
		}

}
