package es.deusto.sd.google;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GoogleServer extends UnicastRemoteObject implements IGoogleServer {

	private static final long serialVersionUID = 1L;
	private ArrayList<User> users;
	
	public GoogleServer(String ip, String port, String serviceName) throws RemoteException {
		String name = ip + ":" + port  +"/"+ serviceName;
		try {
			java.rmi.Naming.rebind(name, this);
			
			users = new ArrayList<User>();
			
			users.add(new User("a@gmail.com", "a"));
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public boolean userExists(String email, String password) {
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.email.equals(email) && u.pass.equals(password)) {
				return true;
			}
		}
		return false;
	}

}

class User {
	
	String email;
	String pass;
	
	User(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}
}