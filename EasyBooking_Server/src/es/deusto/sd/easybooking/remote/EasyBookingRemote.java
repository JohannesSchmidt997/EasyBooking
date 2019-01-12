package es.deusto.sd.easybooking.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.deusto.sd.easybooking.airline.*;
import es.deusto.sd.easybooking.dto.AirportDTO;
import es.deusto.sd.easybooking.dto.ServiceDTO;

public class EasyBookingRemote extends UnicastRemoteObject implements IEasyBookingRemote {

	/**
	 * 
	 */
	private AirlineService gateways[];
	private static final long serialVersionUID = 1L;

	public EasyBookingRemote() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		gateways = new AirlineService[2];
		gateways[0] = new LufthansaGateway("127.0.0.1", "1234", "lufthansa");
		gateways[1] = new VuelingGateway("127.0.0.1", 5678);
		
	}

	@Override
	public long login(String user, String pass, String service) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AirportDTO> getAirportList() throws RemoteException {
		// TODO How do we do this?
		return null;
	}

	@Override
	public List<ServiceDTO> getServices(Date date, AirportDTO from, AirportDTO to) throws RemoteException {
		List<ServiceDTO> services = new ArrayList<>();
		for (int i = 0; i < gateways.length; i++){
			AirlineService gateway = gateways[i];
			List<ServiceDTO> airlineServices = gateway.searchFlights(from, to, date);
			services.addAll(airlineServices);
		}
		
		return services;
	}

	@Override
	public boolean register(String user, String pass, String service) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makeReservation(ServiceDTO service, int passengers, String passengerNames) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
