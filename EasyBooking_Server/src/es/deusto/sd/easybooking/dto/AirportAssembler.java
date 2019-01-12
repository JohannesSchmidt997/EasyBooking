package es.deusto.sd.easybooking.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.sd.easybooking.classes.Airport;

public class AirportAssembler {

	public AirportAssembler() {
		
	}
	
	public List<AirportDTO> assemble(List<Airport> in) {
		List<AirportDTO> result = new ArrayList<>();
		for (int i = 0; i < in.size(); i++) {
			result.add(assemble(in.get(i)));
		}
		return result;
	}
	
	public AirportDTO assemble(Airport a) {
		AirportDTO airport = new AirportDTO();
		airport.code = a.getCode();
		airport.fullName = a.getName();
		return airport;
	}
}
