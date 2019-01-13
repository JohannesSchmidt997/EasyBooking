package es.deusto.sd.easybooking.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.sd.easybooking.controller.Controller;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3948549127469905348L;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox<String> comboBox_auth;
	private JComboBox<String> comboBox_payment;
	private Controller controller;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Register(Controller controller) {
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_5);
		
		JLabel lblEmail = new JLabel("Email");
		panel_5.add(lblEmail);
		
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(30);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_6.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_6);
		
		JLabel lblPassword = new JLabel("Password");
		panel_6.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(30);
		panel_6.add(passwordField);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_7.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_7);
		
		JLabel lblName = new JLabel("Name");
		panel_7.add(lblName);
		
		textField_1 = new JTextField();
		panel_7.add(textField_1);
		textField_1.setColumns(30);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2);
		
		JLabel lblAuthorizationSystem = new JLabel("Authorization system");
		panel_2.add(lblAuthorizationSystem);
		
		comboBox_auth = new JComboBox<String>(/*new String[] {"Google"}*/);
		panel_2.add(comboBox_auth);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel.add(panel_3);
		
		JLabel lblPaymentMethod = new JLabel("Payment method");
		panel_3.add(lblPaymentMethod);
		
		comboBox_payment = new JComboBox<String>(/*new String[] {"Paypal", "Visa"}*/);
		panel_3.add(comboBox_payment);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener((e) -> this.controller.signUp(textField.getText(), String.copyValueOf(passwordField.getPassword()), textField_1.getText(), (String) comboBox_auth.getSelectedItem()));
		panel_4.add(btnRegister);
	}

}
