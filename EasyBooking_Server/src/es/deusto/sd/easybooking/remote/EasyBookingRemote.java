package es.deusto.sd.easybooking.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.desuto.sd.easybooking.accounts.User;
import es.deusto.sd.easybooking.airline.*;
import es.deusto.sd.easybooking.classes.Airport;
import es.deusto.sd.easybooking.dto.*;
import es.deusto.sd.google.IGoogleServer;

public class EasyBookingRemote extends UnicastRemoteObject implements IEasyBookingRemote {

	/**
	 * 
	 */
	private AirlineService gateways[];
	private IGoogleServer google;
	private static final long serialVersionUID = 1L;

	public EasyBookingRemote() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		AirlineServiceFactory factory = new AirlineServiceFactory();
		gateways = new AirlineService[2];
		gateways[0] = factory.createService("lufthansa", new String[] {"127.0.0.1", "1234", "lufthansa"});//new LufthansaGateway("127.0.0.1", "1234", "lufthansa");
		gateways[1] = factory.createService("vueling", new String[] {"127.0.0.1", "5678"});//new VuelingGateway("127.0.0.1", 5678);
		
	}

	@Override
	public long login(String email, String pass, String service) throws RemoteException {
		// TODO get user with that email
		User user;
		if (false) // It doesn't exist
			return -1;
		long token = google.userExists(email, pass);
		if (user.getToken() != token)
			return -1;
		else
			return token;
	}

	@Override
	public List<AirportDTO> getAirportList() throws RemoteException {
		List<Airport> airportList = Airport.airportList;
		AirportAssembler assembler = new AirportAssembler();
		
		return assembler.assemble(airportList);
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
	public boolean register(String email, String pass, String name, String service) throws RemoteException {
		// TODO Auto-generated method stub
		long token = google.userExists(email, pass);
		if (token == -1)
			return false;
		
		else {
			User newUser = new User(email, name, token);
			// TODO save to DB
			return true;
		}
	}

	@Override
	public void makeReservation(ServiceDTO service, int passengers, String passengerNames, long userID) throws RemoteException {
		// TODO Save to DB, payment reservation
		// The user must be searched in the DB via userID
	}

}
