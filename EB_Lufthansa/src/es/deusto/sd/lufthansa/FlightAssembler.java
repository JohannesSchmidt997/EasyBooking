package es.deusto.sd.lufthansa;

import java.util.ArrayList;
import java.util.List;

import es.deusto.sd.easybooking.dto.FlightDTO;
import es.deusto.sd.easybooking.dto.ServiceDTO;


public class FlightAssembler {

	public FlightAssembler() {
		
	}
	
	public List<ServiceDTO> assemble(List<Flight> in) {
		List<ServiceDTO> result = new ArrayList<ServiceDTO>();
		for (int i = 0; i < in.size(); i++) {
			result.add(assemble(in.get(i)));
		}
		return result;
	}
	
	public ServiceDTO assemble(Flight f) {
		ServiceDTO result = new ServiceDTO();
		result.flightNumber = f.code;
		result.departure = f.date;
		return result;
	}
}
