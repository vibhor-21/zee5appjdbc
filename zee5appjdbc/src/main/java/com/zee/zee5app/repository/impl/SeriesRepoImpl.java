package com.zee.zee5app.repository.impl;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SeriesRepo;

public class SeriesRepoImpl implements SeriesRepo {

	private Set<Series> treeSet = new TreeSet<>();
	
	private SeriesRepoImpl() {
		
	}
	private static SeriesRepo seriesRepo;
	
	public static SeriesRepo getInstance() {
		if(seriesRepo==null) {
			return new SeriesRepoImpl();
		}
		return seriesRepo;
	}
	@Override
	public String addSeries(Series serie) {
		// TODO Auto-generated method stub
		return this.treeSet.add(serie)?"success":"fail";
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		Series[] series = new Series[treeSet.size()];
		return treeSet.toArray(series);
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Series serie2= null;
		for(Series serie:treeSet) {
			if(serie.getId().equals(id)) {
				serie2 = serie;
				break;
			}
		}
		return Optional.ofNullable(Optional.of(serie2).orElseThrow(()-> new IdNotFoundException("id not found ")));
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Series> optional = this.getSeriesById(id);
		if(optional.isPresent()) {
			boolean result = treeSet.remove(optional.get());
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
	public String modifySeries(String id, Series serie) {
		// TODO Auto-generated method stub
		return null;
	}

}
