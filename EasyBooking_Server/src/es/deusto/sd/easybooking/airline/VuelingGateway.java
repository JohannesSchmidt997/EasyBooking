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
			out.writeInt(flightNumber);
			
			// @Todo: If the airline does not have any flight with the given number it will
			// return some error code, NOT IMPLEMENTED yet, so we will need to check if what
			// we read from the read from the socket is a valid object.
			// We could make the VuelingServer return a boolean + the FlightDTO, if the boolean is true
			// it will be followed by the DTO else there is no DTO and the flightNumber does not match any flight
			// However, there might be the possiblity that we always pass a valid flightNumber, 
			// it depends on how we write our program
			
			FlightDTO f = (FlightDTO) in.readObject();
			return f;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // It will be more efficient to use a numeric constant here
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
	}

}
