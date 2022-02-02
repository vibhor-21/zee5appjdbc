package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Movies;

public class MoviesRepo {
	
	private Movies[] movies = new Movies[10];
	private static int count=-1;
	private MoviesRepo() {
		
	}
	
	public String addMovies(Movies movie) {
		if(count==movies.length-1) {
			Movies[] temp = new Movies[2*movies.length];
			System.arraycopy(movies,0,temp,0,movies.length);
			movies = temp;
			movies[++count] = movie;
			return "success";
		}
		movies[++count] = movie;
		return "success";
	}
	
	public Movies[] getAllMovies() {
		return movies;
	}
	
	public Movies getMoviesById(String id) {
		for(Movies movie : movies) {
			if(movie!=null && movie.getId().equals(id)) {
				return movie;
			}
		}
		return null;
	}
	
	public String deleteMovies(String id) {
		boolean flag = false;
		for(int i=0;i<movies.length;i++) {
			if(movies[i].getId().equals(id)) {
				while(i<movies.length-1) {
					movies[i] = movies[i+1];
					i++;
				}
			}
			flag=true;
		}
		return flag?"Successfully deleted":"Not Matched";
	}
	
	public String modifyMovies(String id, Movies movie) {
		
		boolean flag = false;
		for(int i=0;i<movies.length;i++) {
			if(movies[i].getId().equals(id)) {
				movies[i] = movie;
				flag = true;
				break;
			}
		}
		return flag?"Updated":"Cannot update";
	}
	
	private static MoviesRepo moviesRepo;
	
	public static MoviesRepo getInstance() {
		if(moviesRepo==null) {
			moviesRepo = new MoviesRepo();
		}
		return moviesRepo;
	}
	
}
