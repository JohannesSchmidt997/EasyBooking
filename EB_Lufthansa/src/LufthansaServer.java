import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LufthansaServer extends UnicastRemoteObject implements IRemote {

	public LufthansaServer(String ip, String port, String serviceName) throws RemoteException {
		
		String name = ip + ":" + port  +"/"+ serviceName;
		try {
			java.rmi.Naming.rebind(name, this);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void confirmReservation() {
		// TODO Auto-generated method stub
		
	}
}
