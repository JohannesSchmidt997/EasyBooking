package es.deusto.sd.easybooking.dto;

import java.io.Serializable;

public class FlightDTO implements Serializable{
	public String flightCode;
	public String airline;
	public String departureAirportCode;
	public String arrivalAirportCode;
	
	public FlightDTO() {
		
	}
}
