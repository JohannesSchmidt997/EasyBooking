package es.deusto.sd.easybooking.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JButton btnLoginWithFacebook = new JButton("Login with Facebook");
		panel_2.add(btnLoginWithFacebook);
		
		JButton btnLoginWithGoogle = new JButton("Login with Google");
		panel_2.add(btnLoginWithGoogle);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JButton btnRegister = new JButton("Register");
		panel_3.add(btnRegister);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblWelcomeToEasybooking = new JLabel("Welcome to Easybooking");
		panel_1.add(lblWelcomeToEasybooking);
	}

}
