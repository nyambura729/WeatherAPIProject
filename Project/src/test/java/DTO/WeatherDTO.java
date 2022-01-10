package DTO;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDTO {

	@JsonProperty("visibility")
	private Integer visibility;

	@JsonProperty("timezone")
	private Integer timezone;

	@JsonProperty("main")
	private Main main;

	@JsonProperty("clouds")
	private Clouds clouds;

	@JsonProperty("sys")
	private Sys sys;

	@JsonProperty("dt")
	private Integer dt;	// this might be better changed to a Date object later

	@JsonProperty("coord")
	private Coord coord;

	@JsonProperty("weather")
	private List<WeatherItem> weather;

	@JsonProperty("name")
	private String name;

	@JsonProperty("cod")
	private Integer cod;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("base")
	private String base;

	@JsonProperty("wind")
	private Wind wind;

	public Integer getVisibility(){
		return visibility;
	}

	public Integer getTimezone(){
		return timezone;
	}

	public Main getMain(){
		return main;
	}

	public Clouds getClouds(){
		return clouds;
	}

	public Sys getSys(){
		return sys;
	}

	public Integer getDt(){
		return dt;
	}

	public Coord getCoord(){
		return coord;
	}

	public List<WeatherItem> getWeather(){
		return weather;
	}

	public String getName(){
		return name;
	}

	public Integer getCod(){
		return cod;
	}

	public Integer getId(){
		return id;
	}

	public String getBase(){
		return base;
	}

	public Wind getWind(){
		return wind;
	}

	public boolean visibilityIsInteger(){
		return visibility.getClass() == Integer.class;}

	public boolean timezoneIsInteger(){
		return timezone.getClass() == Integer.class;}

	public boolean dtIsInteger(){
		return dt.getClass() == Integer.class;}

	public boolean nameIsString(){
		return name.getClass() == String.class;}

	public boolean codIsInteger(){
		return cod.getClass() == Integer.class;}

	public boolean idIsInteger(){
		return id instanceof Integer;}

	public boolean baseIsString(){
		return base instanceof String;}
	}




