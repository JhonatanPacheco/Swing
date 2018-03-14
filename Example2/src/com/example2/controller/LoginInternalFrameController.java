package com.example2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;

import com.example2.Main;
import com.example2.menu.CustomXMLMenu;
import com.example2.view.LoginInternalFrame;

public class LoginInternalFrameController {
	
	private LoginInternalFrame view;
	
	public LoginInternalFrameController(final JInternalFrame _view) {
		this.view = (LoginInternalFrame) _view;
		
		this.view.getLoginButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getInstance().setJMenuBar( (new CustomXMLMenu()));
				view.setVisible(false);
			}
		});
	}

}
