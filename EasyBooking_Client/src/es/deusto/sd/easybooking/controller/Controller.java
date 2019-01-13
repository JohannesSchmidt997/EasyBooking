package es.deusto.sd.easybooking.controller;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;

import es.deusto.sd.easybooking.dto.*;
import es.deusto.sd.easybooking.remote.RMIServiceLocator;
import es.deusto.sd.easybooking.ui.*;

public class Controller {
	

	private RMIServiceLocator rmisl;
	private long token = -1L;
	private Login login;
	private Search search;
	private Register register;
	
	public Controller(String[] args) {
		rmisl = new RMIServiceLocator();
		rmisl.setService(args);
		login = new Login(this);
	}
	
	public void search(AirportDTO orig, AirportDTO dest, String year, String month, String day) {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		List<ServiceDTO> services = null;
		try {
			services = rmisl.getService().getServices(calendar.getTime(), orig, dest);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		for(ServiceDTO s : services)
			search.getListmodel().addElement(s);
	}
	
	public void signUp(String email, String pass, String name, String auth) {
		boolean result = false;
		try {
			result = rmisl.getService().register(email, pass, name, auth);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result) {
			register.dispose();
		}
	}
	
	public void openRegisterWindow() {
		register = new Register(this);
	}
	
	public boolean logIn(String email, String pass, String service) {
		try {
			token = rmisl.getService().login(email, pass, service);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (token == -1L) {
			JOptionPane.showMessageDialog(null, "User not found / wrong password");
			return false;
		} else {
			login.dispose();
			search = new Search(this);
			return true;
		}
	}
	
	public void getReservations() {
		;
	}
	
	public List<AirportDTO> getAirportList() {
		try {
			return rmisl.getService().getAirportList();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void makeReservation() {
		
	}
	
	public static void main(String[] args) {
		new Controller(args);
	}

}
