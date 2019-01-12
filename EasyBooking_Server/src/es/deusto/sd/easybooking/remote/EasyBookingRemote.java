package es.deusto.sd.easybooking.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import es.deusto.sd.easybooking.dto.AirportDTO;
import es.deusto.sd.easybooking.dto.ServiceDTO;

public class EasyBookingRemote extends UnicastRemoteObject implements IEasyBookingRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EasyBookingRemote() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public long login(String user, String pass, String service) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AirportDTO> getAirportList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceDTO> getServices(Date date, AirportDTO from, AirportDTO to) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
