package es.deusto.sd.easybooking.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import es.deusto.sd.easybooking.classes.Flight;

public class FlightDTO {
	public String flightCode;
	public String airline;
	public AirportDTO departureAirport;
	public AirportDTO arrivalAirport;
	
	public FlightDTO() {
		
	}
}
