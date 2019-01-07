package es.deusto.sd.easybooking.dto;

public class AirportDTO {
	public String code;
	public String fullName;
	
	@Override
	public String toString() {
		return code + " - " + fullName;
	}
}
