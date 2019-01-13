package es.deusto.sd.easybooking.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.sd.easybooking.dto.ServiceDTO;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class BookFlight extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;



	/**
	 * Create the frame.
	 */
	public BookFlight(ServiceDTO service) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		String info = "<html>Flight " + service.flight.flightCode + "<br>Departure airport: " + service.flight.departureAirport + "<br>Destination airport: "
				+ service.flight.arrivalAirport + "<br>Airline: " + service.flight.airline + "<br>Date: " + service.departure + "<br>Price: "
				+ service.price + "€";
		
		JLabel lblFlightinfolabel = new JLabel(info);
		panel.add(lblFlightinfolabel);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_1);
		
		JLabel lblSeats = new JLabel("Number of seats");
		panel_1.add(lblSeats);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2);
		
		JLabel lblnameOfPassengers = new JLabel("<html>Name of passengers<br>(Separated by comma)");
		panel_2.add(lblnameOfPassengers);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(25);
		
		JButton btnMakePayment = new JButton("Make payment");
		contentPane.add(btnMakePayment, BorderLayout.SOUTH);
	}

}
