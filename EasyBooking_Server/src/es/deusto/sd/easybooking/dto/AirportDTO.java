package es.deusto.sd.easybooking.dto;

import java.io.Serializable;

public class AirportDTO implements Serializable {
	public String code;
	public String fullName;
	
	@Override
	public String toString() {
		return code + " - " + fullName;
	}
}
