package es.deusto.sd.easybooking.dto;

import java.io.Serializable;
import java.util.Date;

public class ServiceDTO implements Serializable {
	
	public int flightNumber;
	public Date departure;
	
	// @Todo: How do we store the origin and destination airports?
	// we can have an AirportDTO here but I don't know how good of an idea it is
}
