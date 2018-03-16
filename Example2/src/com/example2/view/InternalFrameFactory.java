package com.example2.view;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;

import com.example2.Main;
import com.example2.alerts.NoEventAlert;
import com.example2.utilerias.Utils;

public abstract class InternalFrameFactory {
	static JInternalFrame internalFrame = null;
	public static JInternalFrame createFrameFactory(String command) {
		
		switch (command) {
		case "initLogin":
			internalFrame = new LoginInternalFrame();
			break;
		default:
			internalFrame = new JInternalFrame();
			JDialog d = new NoEventAlert(Main.getInstance(),true);
			
			d.setSize(200, 200);
			Utils.center(d);
			d.setVisible(true);
			d.pack();
			break;
		}
		return internalFrame;
	}
}
