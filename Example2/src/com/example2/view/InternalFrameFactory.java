package com.example2.view;

import javax.swing.JInternalFrame;

public abstract class InternalFrameFactory {

	public static JInternalFrame createFrameFactory(String command) {
		JInternalFrame internalFrame = null;
		switch (command) {
		case "initLogin":
			internalFrame = new LoginInternalFrame();
			break;
		
		}
		return internalFrame;
	}
}
