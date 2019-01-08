package es.deusto.sd.lufthansa;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.deusto.sd.easybooking.dto.AirportDTO;
import es.deusto.sd.easybooking.dto.FlightDTO;

public class LufthansaServer extends UnicastRemoteObject implements ILufthansaServer {

	private ArrayList<Flight> flights;
	
	public LufthansaServer(String ip, String port, String serviceName) throws RemoteException {
		
		String name = ip + ":" + port  +"/"+ serviceName;
		try {
			java.rmi.Naming.rebind(name, this);
			flights = new ArrayList<Flight>();
			
			Airport bilbao = new Airport("Bilbao", "BIO");
			Airport madrid = new Airport("Madrid", "MAD");
			Airport london = new Airport("London", "LON");
			
			// @Note: For some reason I don't understand DateFormat.parse(String) is not a static method!
			DateFormat df = DateFormat.getInstance();
			flights.add(new Flight(0002, bilbao, london, df.parse("07/01/2019")));
			flights.add(new Flight(0001, madrid, bilbao, df.parse("07/01/2019")));
			flights.add(new Flight(0003, london, madrid, df.parse("08/01/2019")));
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean confirmReservation() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<FlightDTO> searchFlights(AirportDTO origin, AirportDTO destination, Date date) {
		ArrayList<Flight> matches = new ArrayList<Flight>();
		
		for (int i = 0; i < flights.size(); i++) {
			Flight f = flights.get(i);
			if (f.origin.name.equals(origin.fullName) && f.destination.name.equals(destination.fullName) && f.date.equals(date)) {
				matches.add(f);
			}
		}
		
		FlightAssembler fa = new FlightAssembler();
		List<FlightDTO> result = fa.assemble(matches);
		
		return result;
	}

	@Override
	public FlightDTO getFlightData(int flightNumber) {
		Flight f = null;
		for (int i = 0; i < flights.size(); i++) {
			f = flights.get(i);
			if (f.code == flightNumber) {
				break;
			}
		}
		
		if (f != null) {
			FlightAssembler fa = new FlightAssembler();
			FlightDTO result = fa.assemble(f);
			return result;
		}
		else {
			System.out.println("No flights with that number");
			return null;
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		if (args.length == 3) {
			try {
				new LufthansaServer(args[0], args[1], args[2]);
			} catch (RemoteException e) {
				System.out.println("Lufthansa server constructor failed");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("3 parameters are expected, you passed " + args.length);
		}
	}
}

//@Temp: Place holder classes needed to build the data base of flights
//@Todo: Move them to their own files OR ¿reuse the ones from EasyBooking_Server, as a .jar?

class Airport {
	String name;
	String code;
	
	public Airport(String name, String code) {
		this.name = name;
		this.code = code;
	}

}	

class Flight {
	int code;
	Airport origin, destination;
	Date date;
	int seatCount;
	int availableSeats;
	
	public Flight(int code, Airport origin, Airport destination, Date date) {
		this.code = code;
		this.origin = origin;
		this.destination = destination;
		this.date = date;
	}
}