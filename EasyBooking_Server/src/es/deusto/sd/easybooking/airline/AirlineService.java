package es.deusto.sd.easybooking.airline;

import java.util.Date;

import es.deusto.sd.easybooking.dto.AirportDTO;
import es.deusto.sd.easybooking.dto.FlightDTO;
import es.deusto.sd.easybooking.dto.ServiceDTO;

// @Todo: Find a more appropriate name
public interface AirlineService {
	
	public FlightDTO searchFlight(AirportDTO origin, AirportDTO destinatin, Date departure);

	// We may want to not pass the full serviceDTO just the flight number might be enough
	public boolean confirmReservation(ServiceDTO service, int seatCount, String[] passangers);
	public FlightDTO getFlightData(int flightNumber);
}
