package es.deusto.sd.lufthansa;

import java.util.ArrayList;
import java.util.List;

import es.deusto.sd.easybooking.dto.FlightDTO;


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
		return new FlightDTO();
	}
}
