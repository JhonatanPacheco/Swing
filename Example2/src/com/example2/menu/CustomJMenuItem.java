package com.example2.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

@SuppressWarnings("hiding")
public class CustomJMenuItem< CustomMenu extends JMenuItem  > extends JMenuItem implements ActionListener {

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
		
		//Referencia a un AbstractViewControllerFactory 
		if (key.equals("os.app.chrome")) {
            System.out.println("os.app.chrome");
        }
		
		/*
         * aqui todos los IF para cada una de las opciones del menu, por eso
         * digo que no es muy eficiente este metodo, muchos IF, pero ni modo xD
         */

	}

}
