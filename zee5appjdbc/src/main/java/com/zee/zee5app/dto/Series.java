package com.zee.zee5app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Series {
	private String Name;
	private String release_date;
	private String trailer;
	private String language;
	private String[] cast;
	private long length;
	private String id;
}
