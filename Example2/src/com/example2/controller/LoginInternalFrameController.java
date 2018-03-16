package com.example2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JInternalFrame;

import com.example2.Main;
import com.example2.dto.UserDTO;
import com.example2.dummy.DummyUsers;
import com.example2.enums.ERoles;
import com.example2.menu.CustomXMLMenu;
import com.example2.view.LoginInternalFrame;

public class LoginInternalFrameController {
	
	private LoginInternalFrame view;
	
	public LoginInternalFrameController(final JInternalFrame _view) {
		this.view = (LoginInternalFrame) _view;
		
		this.view.getLoginButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String, UserDTO> users = DummyUsers.getInstance().getUsers();
				if(users.containsKey(view.getUsernameTxt().getText())){
					List<ERoles> roles = users.get(view.getUsernameTxt().getText()).getRoles();
					Main.getInstance().setJMenuBar( (new CustomXMLMenu(roles)));
					view.setVisible(false);
				}else{
					System.out.println("Errrrrrrror usr not avalible");
				}
				
				
			}
		});
	}

}
