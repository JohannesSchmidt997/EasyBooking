import java.rmi.Remote;
import java.util.Date;

public interface IRemote extends Remote {
 	public FlightDTO getFlights(AirportDTO origin, Airport destination, Date date);
	public void confirmReservation(); // @Todo
	public FlightDTO getFlightData(int flightNumber);
}
