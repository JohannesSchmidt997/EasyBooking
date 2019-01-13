package es.deusto.sd.easybooking.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.sd.easybooking.classes.Service;

public class ServiceAssembler {

	public List<ServiceDTO> assemble(List<Service> in) {
		List<ServiceDTO> result = new ArrayList<>();
		for (int i = 0; i < in.size(); i++) {
			result.add(assemble(in.get(i)));
		}
		return result;
	}
	
	public ServiceDTO assemble(Service a) {
		ServiceDTO service = new ServiceDTO();
		service.departure = a.getDepartureDate();
		service.price = a.getPrice();
		service.flight = new FlightAssembler().assemble(a.getFlight());
		
		return service;
	}
}
