package com.example2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.example2.Main;
import com.example2.config.I18N;
import com.example2.utilerias.ImageUtils;
import com.example2.utilerias.Utils;

public class LoginInternalFrame extends JInternalFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;
	private JButton loginButton;
	private Main escritorio;

	public LoginInternalFrame() {
		//Hacemos uso del consturtor de la clase heredada
		super(I18N.lang("login.title"),false,false,false,false);
		this.escritorio = Main.getInstance();

		setSize(400, 200);
		setLocation((escritorio.getWidth() - this.getWidth()) / 2, (escritorio.getHeight() - this.getHeight()) / 4);
		setFrameIcon(ImageUtils.getScaledImage(Utils.getAPPPropertyValue("APP.LOGIN.ICON")));

		JPanel loginPanel = new JPanel();
		usernameTxt = new JTextField(25);
		passwordTxt = new JPasswordField(25);
		JLabel usernameLbl = new JLabel(I18N.lang("login.username"));
		JLabel passwordLbl = new JLabel(I18N.lang("login.password"));
		loginButton = new JButton(I18N.lang("login.button"));
		JButton cancelButton = new JButton(I18N.lang("login.cancel"));

		loginPanel.add(usernameLbl);
		loginPanel.add(usernameTxt);
		loginPanel.add(passwordLbl);
		loginPanel.add(passwordTxt);
		loginPanel.setBorder(new LineBorder(Color.GRAY));
		loginPanel.add(loginButton);
		loginPanel.add(cancelButton);

		getContentPane().add(BorderLayout.CENTER, loginPanel);
		setVisible(true);
	}

	public JTextField getUsernameTxt() {
		return usernameTxt;
	}

	public void setUsernameTxt(JTextField usernameTxt) {
		this.usernameTxt = usernameTxt;
	}

	public JPasswordField getPasswordTxt() {
		return passwordTxt;
	}

	public void setPasswordTxt(JPasswordField passwordTxt) {
		this.passwordTxt = passwordTxt;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println();
		
	}

}