package es.deusto.sd.easybooking.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceDTO implements Serializable {
	
	public Date departure;
	public float price;
	
	// @Todo: How do we store the origin and destination airports?
	// we can have an AirportDTO here but I don't know how good of an idea it is
	// 
	// Very good, we have no time to think of any other way
	
	public FlightDTO flight;
	
	private static SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm");
	
	@Override
	public String toString() {
		return flight.flightCode + " " + dateformat.format(departure) + " - " + flight.airline + " - " + flight.departureAirportCode + " -> " + flight.arrivalAirportCode;
	}
}
