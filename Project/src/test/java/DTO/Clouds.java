package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds {

	@JsonProperty("all")
	private Integer all;

	public Integer getAll(){
		return all;
	}

	public boolean checkCloudsRange(Integer all) { return (all >= 0 && all <= 100);}
}