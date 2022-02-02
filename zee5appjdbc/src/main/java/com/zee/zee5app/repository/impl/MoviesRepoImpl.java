package com.zee.zee5app.repository.impl;

import java.util.HashSet;

import java.util.Optional;
import java.util.Set;


import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MoviesRepo2;

public class MoviesRepoImpl implements MoviesRepo2 {

	private Set<Movies> set = new HashSet<>();
	
	private MoviesRepoImpl() {
		
	}
	
	private static MoviesRepo2 movieRepo;
	
	public static MoviesRepo2 getInstance() {
		
		if(movieRepo==null) {
			return new MoviesRepoImpl();
		}
		return movieRepo;
	}
	
	@Override
	public String addMovies(Movies movie) {
		// TODO Auto-generated method stub
		return this.set.add(movie)?"success":"fail";
	}

	@Override
	public Movies[] getAllMovies() {
		// TODO Auto-generated method stub
		Movies[] movie = new Movies[set.size()];
		return set.toArray(movie);
	}

	@Override
	public Optional<Movies> getMoviesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		Movies movie2 = null;
		for(Movies movie:set) {
			if(movie.getId().equals(id)) {
				movie2 = movie;
				break;
			}
		}
		return Optional.ofNullable(Optional.of(movie2).orElseThrow(()-> new IdNotFoundException("id not found ")));
	}

	@Override
	public String deleteMovies(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movies> optional = this.getMoviesById(id);
		if(optional.isPresent()) {
			boolean result = set.remove(optional.get());
			if(result) {
				return "Success";
			}
			else
				return "Fail";
		}else {
			throw new IdNotFoundException("id not found exception");
		}
	}

	@Override
	public String modifyMovies(String id, Movies movie) {
		// TODO Auto-generated method stub
		return null;
	}

}
