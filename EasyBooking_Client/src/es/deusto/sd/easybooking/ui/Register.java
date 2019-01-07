package es.deusto.sd.easybooking.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3948549127469905348L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Register() {
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
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_1);
		
		JLabel lblEmail = new JLabel("Email");
		panel_1.add(lblEmail);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(30);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2);
		
		JLabel lblAuthorizationSystem = new JLabel("Authorization system");
		panel_2.add(lblAuthorizationSystem);
		
		JComboBox<String> comboBox_auth = new JComboBox<String>(new String[] {"Facebook", "Google"});
		panel_2.add(comboBox_auth);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel.add(panel_3);
		
		JLabel lblPaymentMethod = new JLabel("Payment method");
		panel_3.add(lblPaymentMethod);
		
		JComboBox<String> comboBox_payment = new JComboBox<String>(new String[] {"Paypal", "Visa"});
		panel_3.add(comboBox_payment);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JButton btnRegister = new JButton("Register");
		panel_4.add(btnRegister);
	}

}
