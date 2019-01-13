package es.deusto.sd.easybooking.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.desuto.sd.easybooking.accounts.Reservation;

public class ReservationAssembler {

	public List<ReservationDTO> assemble(List<Reservation> in) {
		List<ReservationDTO> result = new ArrayList<ReservationDTO>();
		for (int i = 0; i < in.size(); i++) {
			result.add(assemble(in.get(i)));
		}
		return result;
	}
	
	public ReservationDTO assemble(Reservation f) {
		ReservationDTO reservation = new ReservationDTO();
		reservation.numPassengers = f.getNumPassengers();
		reservation.passengerNames = Arrays.copyOf(f.getPassengerNames(), f.getPassengerNames().length);
		reservation.service = new ServiceAssembler().assemble(f.getService());
		return reservation;
	}
}
