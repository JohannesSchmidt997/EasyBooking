package es.desuto.sd.easybooking.accounts;

import java.util.List;

public class User {
	private String email;
	private String name;
	private long token;
	
	private List<Reservation> reservations;
	
	public User(String email, String name, long token) {
		super();
		this.email = email;
		this.name = name;
		this.token = token;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getToken() {
		return token;
	}

	public void setToken(long token) {
		this.token = token;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
}
