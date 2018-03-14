package com.example2.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

public class CustomJMenuItem extends JMenuItem implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;

	public CustomJMenuItem(String label, ImageIcon icon, String key) {
		super(label, icon);
		this.key = key;
		addActionListener(getActionListener());
		setActionCommand(key);
	}

	private ActionListener getActionListener() {
		return this;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("com.example2.utilerias.LoginAction")){
			
		}

	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}



}
