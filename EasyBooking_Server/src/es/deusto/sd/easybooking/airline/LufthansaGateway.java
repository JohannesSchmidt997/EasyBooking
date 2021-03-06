package es.deusto.sd.easybooking.airline;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import es.deusto.sd.easybooking.dto.AirportDTO;
import es.deusto.sd.easybooking.dto.FlightDTO;
import es.deusto.sd.easybooking.dto.ServiceDTO;
import es.deusto.sd.lufthansa.ILufthansaServer;

public class LufthansaGateway implements AirlineService {

	private ILufthansaServer ls;
	
	public LufthansaGateway(String ip, String port, String serviceName) {
		String name = ip + ":" + port + "/" + serviceName;
		try {
			ls = (ILufthansaServer) java.rmi.Naming.lookup(name);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ServiceDTO> searchFlights(AirportDTO origin, AirportDTO destination, Date departure) {
		return ls.searchFlights(origin, destination, departure);
	}

	@Override
	public boolean confirmReservation(ServiceDTO service, int seatCount, String[] passangers) {
		// @Todo
		return ls.confirmReservation();
	}

	@Override
	public ServiceDTO getFlightData(int flightNumber) {
		return ls.getFlightData(flightNumber);
	}
	
}
