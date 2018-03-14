package com.example2.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.example2.AbstractViewControllerFactory;
import com.example2.utilerias.Utils;

public class MainFrameController extends WindowAdapter {
	
	@Override
	public void windowClosing(WindowEvent ev) {
		if (Utils.confirmBeforeExit()) {
			System.exit(0);
		}
	}
	@Override
	public void windowOpened(WindowEvent e) {
		AbstractViewControllerFactory.createViewController("initLogin");
	}
//	 @Override
//      public void windowIconified(WindowEvent we) {
//        setState(JFrame.NORMAL);
//      }

}
