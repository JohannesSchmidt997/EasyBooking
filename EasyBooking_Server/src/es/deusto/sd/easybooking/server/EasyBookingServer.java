package es.deusto.sd.easybooking.server;

import java.rmi.Naming;

import es.deusto.sd.easybooking.remote.*;

public class EasyBookingServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new SecurityManager());
		
		String nameserver = "//" + args[0] + ":" + args[1] + "/" + args[2];
		
		try {
			IEasyBookingRemote remote = new EasyBookingRemote();
			Naming.rebind(nameserver, remote);
			System.out.println("* EasyBooking remote service '" + nameserver + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ EasyBookingRemote exception:" + e.getMessage());
			e.printStackTrace();
		}
	}

}
