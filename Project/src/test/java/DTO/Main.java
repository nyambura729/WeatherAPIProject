package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

	@JsonProperty("temp")
	private Double temp;

	@JsonProperty("temp_min")
	private Double tempMin;

	@JsonProperty("humidity")
	private Integer humidity;

	@JsonProperty("pressure")
	private Integer pressure;

	@JsonProperty("feels_like")
	private Double feelsLike;

	@JsonProperty("temp_max")
	private Double tempMax;

	@JsonProperty("sea_level")
	private Integer seaLevel;

	@JsonProperty("ground_level")
	private Integer grndLevel;

	public Double getTemp() {
		return temp;
	}

	public Double getTempMin() {
		return tempMin;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public Integer getPressure() {
		return pressure;
	}

	public Double getFeelsLike() {
		return feelsLike;
	}

	public Double getTempMax() {
		return tempMax;
	}

	public Integer getSeaLevel() {
		return seaLevel;
	}

	public Integer getGrndLevel() {
		return grndLevel;
	}

	public boolean checkTempsAboveZero(Double temp) {
		return temp > 0;
	}

	public boolean checkPressureRange(Integer pressure) {
		return (pressure > 800 && pressure < 2000);
	}

	public boolean checkHumidityRange(Integer humidity) {
		return (humidity > 0 && humidity <= 100);
	}

	public boolean checkSeaLevelRange(Integer seaLevel) {
		if (seaLevel != null) {
			return (seaLevel > 800 && seaLevel < 2000);
		} else {
			return true;
		}
	}

	public boolean checkGrndLevelRange(Integer grndLevel) {
		if (grndLevel != null) {
			return (grndLevel > 800 && grndLevel < 2000);
		}
		else {
			return true;
		}
	}
}