package es.deusto.sd.easybooking.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.sd.easybooking.controller.Controller;
import es.deusto.sd.easybooking.dto.*;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class Search extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4417132203441942766L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private DefaultListModel<ServiceDTO> listmodel;

	/**
	 * Create the frame.
	 * @param controller 
	 */
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblDepartureAirport = new JLabel("Departure airport");
		panel_1.add(lblDepartureAirport);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JComboBox<AirportDTO> comboBoxDeparture = new JComboBox<AirportDTO>();
		panel_2.add(comboBoxDeparture);
		
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblDestinationAirport = new JLabel("Destination airport");
		panel_3.add(lblDestinationAirport);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JComboBox<AirportDTO> comboBoxDestination = new JComboBox<AirportDTO>();
		panel_4.add(comboBoxDestination);
		
		List<AirportDTO> airportList = Controller.getInstance().getAirportList();
		for (AirportDTO a : airportList) {
			comboBoxDeparture.addItem(a);
			comboBoxDestination.addItem(a);
		}
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JLabel lblDepartureDate = new JLabel("<html>Departure date <br>(dd/mm/yyyy)");
		lblDepartureDate.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblDepartureDate);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		textField = new JTextField();
		panel_6.add(textField);
		textField.setColumns(2);
		
		JLabel label = new JLabel("/");
		panel_6.add(label);
		
		textField_1 = new JTextField();
		panel_6.add(textField_1);
		textField_1.setColumns(2);
		
		JLabel label_1 = new JLabel("/");
		panel_6.add(label_1);
		
		textField_2 = new JTextField();
		panel_6.add(textField_2);
		textField_2.setColumns(4);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener((e) -> Controller.getInstance().search((AirportDTO)comboBoxDeparture.getSelectedItem(), (AirportDTO)comboBoxDestination.getSelectedItem(), 
				textField_2.getText(), textField_1.getText(), textField.getText()));
		panel_7.add(btnSearch);
		
		JPanel panel_8 = new JPanel();
		splitPane.setRightComponent(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JButton btnMakeReservation = new JButton("Make reservation");
		panel_8.add(btnMakeReservation, BorderLayout.SOUTH);
		
		listmodel = new DefaultListModel<>();
		JList<ServiceDTO> list = new JList<ServiceDTO>(listmodel);
		panel_8.add(list, BorderLayout.CENTER);
	}

	public DefaultListModel<ServiceDTO> getListmodel() {
		return listmodel;
	}

}
