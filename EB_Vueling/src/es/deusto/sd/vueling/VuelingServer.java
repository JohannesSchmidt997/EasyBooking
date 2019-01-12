package es.deusto.sd.vueling;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VuelingServer {
	/*
	 * 
	 * 	THIS ONE WORKS WITH SOCKET COMMUNICATION
	 * 
	 */
	
	// @Todo: (private) ArrayList or hashmap or treemap of flights
	
	private ArrayList<Flight> flights;
	
	public VuelingServer() {
		
		// @Todo: Init the list of flights
		flights = new ArrayList<Flight>();
		
		Airport bilbao = new Airport("Bilbao", "BIO");
		Airport madrid = new Airport("Madrid", "MAD");
		
		try {
			// @Note: For some reason I don't understand DateFormat.parse(String) is not a static method!
			DateFormat df = DateFormat.getInstance();
			flights.add(new Flight(0000, bilbao, madrid, df.parse("07/01/2019")));
			flights.add(new Flight(0001, madrid, bilbao, df.parse("07/01/2019")));
			flights.add(new Flight(0000, bilbao, madrid, df.parse("08/01/2019")));
			
		
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void handleRequest(Socket socket) {
		/*
		 * @Description: This is a very stupid protocol to implement different
		 * types of requests. It always start with a string that
		 * identifies the request the client wants to perform 
		 * followed by the arguments needed for that operation
		 */
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		
			String action = in.readUTF();

			if (action.equals("search")) {
				// Read arguments
				AirportDTO origin = (AirportDTO) in.readObject();
				AirportDTO destination = (AirportDTO) in.readObject();
				Date date = (Date) in.readObject();
				
				// Search for matching flights
				ArrayList<Flight> matches = new ArrayList<Flight>();
				
				for (int i = 0; i < flights.size(); i++) {
					Flight f = flights.get(i);
					if (f.origin.name.equals(origin.name) && f.destination.name.equals(destination.name) && f.date.equals(date)) {
						matches.add(f);
					}
				}
				
				
				// Assemble and return list of FlightDTOs
				FlightAssembler fa = new FlightAssembler();
				List<FlightDTO> result_list = fa.assemble(matches);
				out.writeObject(result_list);
				
			}
			else if (action.equals("confirm")) {
				// @Todo
				// Read arguments
				
			}
			else if (action.equals("get")) {
				// Read argument
				int flightNumber = in.readInt();
				
				// Search flight
				Flight f = null;
				for (int i = 0; i < flights.size(); i++) {
					f = flights.get(i);
					if (f.code == flightNumber) {
						break;
					}
				}
				
				if (f != null) {
					// Assemble and return the FlightDTO
					FlightAssembler fa = new FlightAssembler();
					FlightDTO result = fa.assemble(f);
					out.writeObject(result);
				}
				else {
					System.out.println("No flights with that number");
					// @Todo: Notify the client that the flight number does not have a match
				}
				
			}
			else {
				// Unknown action, ignore message
				System.out.println("Unknown request: " + action);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void main(String[] args) {
		VuelingServer server = new VuelingServer();
		
		try {
			ServerSocket serverSocket = new ServerSocket();
			
			while (true) {
				// @Todo: Launch each request in a different thread.
				// accept() might create a thread? Investigate!
				Socket socket = serverSocket.accept();
				server.handleRequest(socket);
				socket.close();
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

//@Temp: Place holder classes this should be part of the .jar of EasyBooking_Server
class AirportDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
}

class FlightAssembler {
	
	public FlightAssembler() {
		
	}
	
	public List<FlightDTO> assemble(List<Flight> in) {
		List<FlightDTO> result = new ArrayList<FlightDTO>();
		for (int i = 0; i < in.size(); i++) {
			result.add(new FlightDTO(in.get(i)));
		}
		return result;
	}
	
	public FlightDTO assemble(Flight f) {
		return new FlightDTO(f);
	}
	
}

class FlightDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public FlightDTO(Flight f) {
		
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