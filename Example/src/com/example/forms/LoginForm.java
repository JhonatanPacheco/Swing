package com.example.forms;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.example.actions.LoginAction;

public class LoginForm extends JPanel{

	
	private JTextField userText;
	private JPasswordField passwordText;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginForm() {
		setSize(300, 150);
		placeComponents();
		setVisible(true);
		
	}
	
	private void placeComponents() {
		setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setName("_login");
		loginButton.setBounds(10, 80, 80, 25);
		add(loginButton);

		JButton registerButton = new JButton("register");
		registerButton.setName("_register");
		registerButton.setBounds(180, 80, 80, 25);
		add(registerButton);

		LoginAction action = new LoginAction(this);
		loginButton.addActionListener(action);
		registerButton.addActionListener(action);
		
	}

	public JTextField getUserText() {
		return userText;
	}

	public void setUserText(JTextField userText) {
		this.userText = userText;
	}

	public JPasswordField getPasswordText() {
		return passwordText;
	}

	public void setPasswordText(JPasswordField passwordText) {
		this.passwordText = passwordText;
	}
}