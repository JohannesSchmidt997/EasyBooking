package es.deusto.sd.easybooking.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import es.deusto.sd.easybooking.dto.*;

public interface IEasyBookingRemote extends Remote {
	// Returned long = user token
	public long login(String user, String pass, String service) throws RemoteException;
	public boolean register(String user, String pass, String service) throws RemoteException;
	public List<AirportDTO> getAirportList() throws RemoteException;
	public List<ServiceDTO> getServices(Date date, AirportDTO from, AirportDTO to) throws RemoteException;
	// TODO: return type for payment
	public void makeReservation(ServiceDTO service, int passengers, String passengerNames) throws RemoteException;
	// TODO: more functions
}
