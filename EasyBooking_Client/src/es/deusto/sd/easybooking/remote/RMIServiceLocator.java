package es.deusto.sd.easybooking.remote;

public class RMIServiceLocator {
	private IEasyBookingRemote remoteService;
	
	public void setService(String[] args) {
		String service = "//" + args[0] + ":" + args[1] + "/" + args[2];
		try {
			this.remoteService = (IEasyBookingRemote) java.rmi.Naming.lookup(service);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("* Service set");
	}
	
	public IEasyBookingRemote getService() {
		return remoteService;
	}
}
