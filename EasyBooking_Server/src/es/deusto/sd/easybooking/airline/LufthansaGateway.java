package es.deusto.sd.easybooking.airline;

import java.util.Date;
import java.util.List;

import es.deusto.sd.easybooking.dto.AirportDTO;
import es.deusto.sd.easybooking.dto.FlightDTO;
import es.deusto.sd.easybooking.dto.ServiceDTO;
import es.deusto.sd.lufthansa.*;

public class LufthansaGateway implements AirlineService {

	private LufthansaServer ls;
	
	public LufthansaGateway(String ip, String port, String serviceName) {
		String name = ip + ":" + port + "/" + serviceName;
		ls = (LufthansaServer) java.rmi.Naming.lookup(name);
	}

	@Override
	public List<FlightDTO> searchFlight(AirportDTO origin, AirportDTO destination, Date departure) {
		return ls.searchFlight(origin, destination, departure);
	}

	@Override
	public boolean confirmReservation(ServiceDTO service, int seatCount, String[] passangers) {
		// @Todo
		return false;
	// 	return ls.confirmReservation
	}

	@Override
	public FlightDTO getFlightData(int flightNumber) {
		return ls.getFlightData(flightNumber);
	}
	
}
