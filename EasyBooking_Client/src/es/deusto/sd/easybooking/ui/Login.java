package es.deusto.sd.easybooking.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

import es.deusto.sd.easybooking.controller.Controller;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame{

	/**
	 * Create the application.
	 */
	
	private JTextField textField;
	private JPasswordField passwordField;

	public Login() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		
		JLabel lblUsername = new JLabel("Username");
		panel_5.add(lblUsername);
		
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(20);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		
		JLabel lblPassword = new JLabel("Password");
		panel_6.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		panel_6.add(passwordField);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JButton btnLoginWithFacebook = new JButton("Login with Facebook");
		btnLoginWithFacebook.setEnabled(false);
		panel_2.add(btnLoginWithFacebook);
		
		JButton btnLoginWithGoogle = new JButton("Login with Google");
		btnLoginWithGoogle.addActionListener((e) -> Controller.getInstance().logIn(textField.getText(), String.copyValueOf(passwordField.getPassword()), "google"));
		panel_2.add(btnLoginWithGoogle);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JButton btnRegister = new JButton("Register");
		panel_3.add(btnRegister);
		
		JPanel panel_1 = new JPanel();
		this.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblWelcomeToEasybooking = new JLabel("Welcome to Easybooking");
		panel_1.add(lblWelcomeToEasybooking);
	}

}
