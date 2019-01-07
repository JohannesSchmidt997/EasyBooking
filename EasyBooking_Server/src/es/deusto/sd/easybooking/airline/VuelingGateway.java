package es.deusto.sd.easybooking.airline;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import es.deusto.sd.easybooking.dto.AirportDTO;
import es.deusto.sd.easybooking.dto.FlightDTO;
import es.deusto.sd.easybooking.dto.ServiceDTO;

public class VuelingGateway implements AirlineService {

	private String vuelingServerIp;
	private int vuelingServerPort;
	
	public VuelingGateway(String vuelingServerIp, int vuelingServerPort) {
		this.vuelingServerIp = vuelingServerIp;
		this.vuelingServerPort = vuelingServerPort;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FlightDTO> searchFlight(AirportDTO origin, AirportDTO destination, Date departure) {
		List<FlightDTO> result = null; // Will it be better if we initialize this to an empty list?
		try {
			Socket socket = new Socket(vuelingServerIp, vuelingServerPort);
			
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			
			out.writeUTF("search"); // It will be more efficient to use a numeric constant here
			out.writeObject(origin);
			out.writeObject(destination);
			out.writeObject(departure);
			
			result = (List<FlightDTO>) in.readObject(); // This should return a List<FlightDTO> object
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean confirmReservation(ServiceDTO service, int seatCount, String[] passangers) {
		try {
			Socket socket = new Socket(vuelingServerIp, vuelingServerPort);
			
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		
			out.writeUTF("confirm");
			
			// @Todo
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // It will be more efficient to use a numeric constant here
		
		
		return false;
	}

	@Override
	public FlightDTO getFlightData(int flightNumber) {
		FlightDTO result = null;
		try {
			Socket socket = new Socket(vuelingServerIp, vuelingServerPort);
			
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		
			out.writeUTF("get");
			
			// @Todo
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // It will be more efficient to use a numeric constant here
		
		
		
		return result;
	}

}
