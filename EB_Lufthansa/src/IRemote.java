import java.rmi.Remote;

public interface IRemote extends Remote {
// 	public FlightDTO getFlights(AirportDTO origin, Airport destination, Date date);
	public void confirmReservation(); // @Todo
}
