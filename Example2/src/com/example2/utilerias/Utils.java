package com.example2.utilerias;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JWindow;

import com.example2.config.I18N;



public class Utils {

	private static Properties prop;

	static {
		InputStream is = null;
		try {
			prop = new Properties();
			is = ClassLoader.class.getResourceAsStream("/app.properties");
			prop.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Utils() {
	}

	public static String getAPPPropertyValue(String key) {
		return prop.getProperty(key);
	}

	public static void centerFrame(JFrame frame) {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		// calculate the new location of the window
		int w = frame.getSize().width;
		int h = frame.getSize().height;

		int x = (dim.width - w / 2) / 2;
		int y = (dim.height - h / 2) / 2;

		// moves this component to a new location, the top-left corner of
		// the new location is specified by the x and y
		// parameters in the coordinate space of this component's parent
		frame.setLocation(x - (x / 8), y - (y / 4));

	}

	public static void centerJWindow(JWindow jWindow) {
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		int nX = (int) (scr.getWidth() - jWindow.getWidth()) / 2;
		int nY = (int) (scr.getHeight() - jWindow.getHeight()) / 2;

		jWindow.setLocation(nX, nY);
	}

	public static void center(Object obj) {

		if(obj instanceof JWindow){
			centerJWindow((JWindow) obj);
		}else if(obj instanceof JFrame){
			centerFrame((JFrame) obj);
		}
	}

	public static Frame[] getAllFrames() {
		Frame[] allFrames = Frame.getFrames();
		return allFrames;
	}

	public static boolean confirmBeforeExit() {

		if (JOptionPane.showConfirmDialog(null, I18N.lang("desktop.confirmbeforeexitdialog.text"),
				I18N.lang("desktop.confirmbeforeexitdialog.title"), JOptionPane.YES_NO_OPTION) == 0) {
			return true;
		}

		return false;
	}

	public static ImageIcon getIcon(String path) {
		return new ImageIcon(ClassLoader.getSystemResource(path), "");
	}
}
