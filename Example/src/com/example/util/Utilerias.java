package com.example.util;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;

public class Utilerias {

	private static Properties prop;

	static {
		InputStream is = null;
		try {
			prop = new Properties();
			is = ClassLoader.class.getResourceAsStream("/config.properties");
			prop.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Utilerias() {
	}

	public static String getPropertyValue(String key) {
		return prop.getProperty(key);
	}

	public static void centerFrame(JFrame frame) {

		// get the size of the screen, on systems with multiple displays,
		// the primary display is used
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// calculate the new location of the window
		int w = frame.getSize().width;
		int h = frame.getSize().height;

		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;

		// moves this component to a new location, the top-left corner of
		// the new location is specified by the x and y
		// parameters in the coordinate space of this component's parent
		frame.setLocation(x, y);

	}
	
	public static Frame [] getAllFrames(){
		Frame[] allFrames = Frame.getFrames();
		 for (Frame frame : allFrames)
		      System.out.println(frame.getName() + ": " + frame.getClass());
		return allFrames;
	}

}
