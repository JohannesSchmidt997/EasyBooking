import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class LufthansaServer extends UnicastRemoteObject implements IRemote {

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
	public void confirmReservation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FlightDTO getFlights(AirportDTO origin, Airport destination, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlightDTO getFlightData(int flightNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}

//@Temp: Place holder classes this should be part of the .jar of EasyBooking_Server
class AirportDTO implements Serializable {
	String name;
}

class FlightDTO implements Serializable {
	
	
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
	
	public Flight(int code, Airport origin, Airport destination, Date date) {
		this.code = code;
		this.origin = origin;
		this.destination = destination;
		this.date = date;
	}
}