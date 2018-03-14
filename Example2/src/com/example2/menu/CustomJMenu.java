package com.example2.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;

public class CustomJMenu  extends JMenu  implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	private ImageIcon icon;
	private ActionListener actionListener;
	
	
	public CustomJMenu(String label, ImageIcon icon) {
		super(label);
		this.label = label;
		this.icon = icon;
		setIcon(this.icon);
		
				
		
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public ActionListener getActionListener() {
		return actionListener;
	}

	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	
	
}
