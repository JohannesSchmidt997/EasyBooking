package es.deusto.sd.lufthansa;

import java.rmi.Remote;
import java.util.Date;
import java.util.List;

public interface IRemote extends Remote {
 	public List<FlightDTO> searchFlights(AirportDTO origin, Airport destination, Date date);
	public void confirmReservation(); // @Todo
	public FlightDTO getFlightData(int flightNumber);
}
