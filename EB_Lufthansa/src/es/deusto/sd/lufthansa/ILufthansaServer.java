package es.deusto.sd.lufthansa;

import java.rmi.Remote;
import java.util.Date;
import java.util.List;

import es.deusto.sd.easybooking.dto.AirportDTO;
import es.deusto.sd.easybooking.dto.FlightDTO;
import es.deusto.sd.easybooking.dto.ServiceDTO;

public interface ILufthansaServer extends Remote {
 	public List<ServiceDTO> searchFlights(AirportDTO origin, AirportDTO destination, Date date);
	public boolean confirmReservation(); // @Todo
	public ServiceDTO getFlightData(int flightNumber);
}
