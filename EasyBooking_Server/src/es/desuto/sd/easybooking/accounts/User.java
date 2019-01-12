package es.desuto.sd.easybooking.accounts;

public class User {
	private String email;
	private String name;
	private long token;
	
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
	
	
	
	
}
