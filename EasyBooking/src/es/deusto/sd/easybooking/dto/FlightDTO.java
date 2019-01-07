package es.deusto.sd.easybooking.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightDTO {
	public Date departureDate;
	public String flightCode;
	public String airline;
	public AirportDTO departureAirport;
	public AirportDTO arrivalAirport;
	public double price;
	
	private static SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm");
	
	@Override
	public String toString() {
		return flightCode + " " + dateformat.format(departureDate) + " - " + airline + " - " + departureAirport.code + " -> " + arrivalAirport.code;
	}
}
