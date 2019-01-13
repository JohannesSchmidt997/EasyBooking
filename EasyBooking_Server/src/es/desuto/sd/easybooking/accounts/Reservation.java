package es.desuto.sd.easybooking.accounts;

import es.deusto.sd.easybooking.classes.Service;

public class Reservation {
	private Service service;
	private int numPassengers;
	private String[] passengerNames;
	
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public int getNumPassengers() {
		return numPassengers;
	}
	public void setNumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}
	public String[] getPassengerNames() {
		return passengerNames;
	}
	public void setPassengerNames(String[] passengerNames) {
		this.passengerNames = passengerNames;
	}
	
}
