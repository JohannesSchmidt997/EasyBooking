package es.deusto.sd.lufthansa;

import java.rmi.Remote;
import java.util.Date;
import java.util.List;

import es.deusto.sd.easybooking.dto.AirportDTO;
import es.deusto.sd.easybooking.dto.FlightDTO;

public interface ILufthansaServer extends Remote {
 	public List<FlightDTO> searchFlights(AirportDTO origin, AirportDTO destination, Date date);
	public void confirmReservation(); // @Todo
	public FlightDTO getFlightData(int flightNumber);
}
