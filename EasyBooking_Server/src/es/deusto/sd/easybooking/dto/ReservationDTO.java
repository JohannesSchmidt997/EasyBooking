package es.deusto.sd.easybooking.dto;

import java.io.Serializable;

public class ReservationDTO implements Serializable {
	public ServiceDTO service;
	public int numPassengers;
	public String[] passengerNames;
}
