package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.regex.Pattern;

public class WeatherItem{

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("description")
	private String description;

	@JsonProperty("main")
	private String main;

	@JsonProperty("id")
	private Integer id;

	public String getIcon(){
		return icon;
	}

	public String getDescription(){
		return description;
	}

	public String getMain(){
		return main;
	}

	public Integer getId(){
		return id;
	}

	public boolean checkIconFormat(String icon) {
		String matchRegex = "[0-9]{2}[d|n]";
		boolean result = Pattern.matches(matchRegex, icon);
		return result;
	}

	public boolean checkIdRange(Integer id) { return (id >= 200 && id <= 804);}
}