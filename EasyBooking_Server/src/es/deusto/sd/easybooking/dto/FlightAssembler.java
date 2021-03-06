package es.deusto.sd.easybooking.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.sd.easybooking.classes.Flight;

public class FlightAssembler {
	
	public FlightAssembler() {
		
	}
	
	public List<FlightDTO> assemble(List<Flight> in) {
		List<FlightDTO> result = new ArrayList<FlightDTO>();
		for (int i = 0; i < in.size(); i++) {
			result.add(assemble(in.get(i)));
		}
		return result;
	}
	
	public FlightDTO assemble(Flight f) {
		FlightDTO flight = new FlightDTO();
		flight.airline = f.getAirline().getName();
		flight.departureAirportCode = f.getOrigin().getCode();
		flight.arrivalAirportCode = f.getDestination().getCode();
		return flight;
	}
	
}