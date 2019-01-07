package es.deusto.sd.easybooking.airline;

import java.util.Date;

import es.deusto.sd.easybooking.dto.AirportDTO;
import es.deusto.sd.easybooking.dto.FlightDTO;
import es.deusto.sd.easybooking.dto.ServiceDTO;

public class Airline1Gateway implements AirlineService {

	@Override
	public FlightDTO searchFlight(AirportDTO origin, AirportDTO destinatin, Date departure) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean confirmReservation(ServiceDTO service, int seatCount, String[] passangers) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FlightDTO getFlightData(int flightNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
