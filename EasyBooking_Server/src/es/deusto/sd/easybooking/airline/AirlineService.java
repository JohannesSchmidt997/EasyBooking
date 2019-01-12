package es.deusto.sd.easybooking.airline;

import java.util.Date;
import java.util.List;

import es.deusto.sd.easybooking.dto.AirportDTO;
import es.deusto.sd.easybooking.dto.FlightDTO;
import es.deusto.sd.easybooking.dto.ServiceDTO;

// @Todo: Find a more appropriate name AirlineGateway
public interface AirlineService {
	
	public List<ServiceDTO> searchFlights(AirportDTO origin, AirportDTO destination, Date departure);

	// We may want to not pass the full serviceDTO just the flight number might be enough
	public boolean confirmReservation(ServiceDTO service, int seatCount, String[] passangers);
	public ServiceDTO getFlightData(int flightNumber);
}
