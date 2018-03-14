package com.example2;

import javax.swing.JInternalFrame;

import com.example2.controller.ControllerFactory;
import com.example2.view.InternalFrameFactory;

public abstract class AbstractViewControllerFactory {

	public static void createViewController(String command ) {
		JInternalFrame view = InternalFrameFactory.createFrameFactory(command);
		ControllerFactory.createController(view);
		Main.getInstance().getjDesktopPane().add(view);
		view.toFront();
	}

}
