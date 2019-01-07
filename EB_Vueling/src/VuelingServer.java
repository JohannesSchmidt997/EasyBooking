import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class VuelingServer {
	/*
	 * 
	 * 	THIS ONE WORKS WITH SOCKET COMMUNICATION
	 * 
	 */
	
	
	public VuelingServer() {
		
		
		// @Todo: Init the list of flights
	}
	
	public void handleRequest(Socket socket) {
		
	}
	
	
	public void main(String[] args) {
		VuelingServer server = new VuelingServer();
		
		try {
			ServerSocket serverSocket = new ServerSocket();
			
			while (true) {
				// @Todo: Launch each request in a different thread
				server.handleRequest(serverSocket.accept());
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
