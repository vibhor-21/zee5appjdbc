package com.zee.zee5app.repository;


import java.util.Optional;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.IdNotFoundException;

public interface MoviesRepo2 {

	public String addMovies(Movies movie);
	public Movies[] getAllMovies();
	public Optional<Movies> getMoviesById(String id) throws IdNotFoundException;
	public String deleteMovies(String id) throws IdNotFoundException;
	public String modifyMovies(String id, Movies movie);
	
}
