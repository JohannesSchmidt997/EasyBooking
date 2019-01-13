package es.deusto.sd.easybooking.airline;

public class AirlineServiceFactory {
	public AirlineService createService(String name, String[] args) {
		if (name.toLowerCase().equals("lufthansa"))
			return new LufthansaGateway(args[0], args[1], args[2]);
		else if (name.toLowerCase().equals("vueling"))
			return new VuelingGateway(args[0], Integer.parseInt(args[1]));
		else
			return null;
	}
}
