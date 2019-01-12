package es.deusto.sd.easybooking.classes;

import java.util.ArrayList;
import java.util.List;

public class Airport {
	private String code;
	private String name;
	
	
	// TODO: We don't have any other way to look for the airports?
	public static List<Airport> airportList;
	
	// Executed at class load
	{
		airportList = new ArrayList<>();
		// TODO Get from DB
		airportList.add(new Airport("MAD", "Madrid"));
		airportList.add(new Airport("BIO", "Bilbao"));
	}
	
	public Airport(String code, String name) {
		this.code = code;
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
