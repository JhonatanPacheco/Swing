package com.example2.menu;

import javax.swing.ImageIcon;
import javax.swing.JMenu;

public class CustomJMenu <CustomMenu >  extends JMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	private ImageIcon icon;
	
	private CustomMenu menu;
	
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

	public CustomMenu getMenu() {
		return menu;
	}

	public void setMenu(CustomMenu menu) {
		this.menu = menu;
	}

	
	
}
