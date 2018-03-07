package com.example.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.example.catalog.dto.LoginDTO;
import com.example.forms.DefaultPanel;
import com.example.forms.LoginForm;
import com.example.forms.Main;
import com.example.util.Utilerias;

public class LoginAction implements ActionListener {

	private LoginForm form;

	public LoginAction(LoginForm form) {
		this.form = form;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();

		doAction(source.getName());

	}

	private void doAction(String btnSource) {

		switch (btnSource) {
		case "_login":
			String pwd = form.getPasswordText().getText();
			String user = form.getUserText().getText();
			if(user.trim().length()!=0 && pwd.trim().length() >=8){
				LoginDTO dto = new LoginDTO();
				dto.setUser(user);
				dto.setPassword(pwd);	
				Main main =  Main.getInstance();
				
				main.getFrame().remove(form);
				main.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
				main.setFrame(new DefaultPanel());
			}else{
				JOptionPane.showMessageDialog(null, btnSource + " no esta registrado");	
			}
			
			
			


			break;
		case "_registro":
			JOptionPane.showMessageDialog(null, btnSource + " no esta registrado");
			break;
		default:
			JOptionPane.showMessageDialog(null, btnSource + " no esta registrado");

		}

	}

}
