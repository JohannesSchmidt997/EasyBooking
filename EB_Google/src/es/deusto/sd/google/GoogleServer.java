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
			
			users.add(new User("a@gmail.com", "a", 12345L));
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public long userExists(String email, String password) {
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.email.equals(email) && u.pass.equals(password)) {
				return u.token;
			}
		}
		return -1L;
	}

}

class User {
	
	String email;
	String pass;
	long token;
	
	User(String email, String pass, long token) {
		this.email = email;
		this.pass = pass;
		this.token = token;
	}
}