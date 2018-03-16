package com.example2.utilerias;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.Timer;

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
	public static void centerJDialog(JDialog jDialog) {
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		int nX = (int) (scr.getWidth() - jDialog.getWidth()) / 2;
		int nY = (int) (scr.getHeight() - jDialog.getHeight()) / 2;

		jDialog.setLocation(nX, nY);
	}

	public static void center(Object obj) {

		if(obj instanceof JWindow){
			centerJWindow((JWindow) obj);
		}else if(obj instanceof JFrame){
			centerFrame((JFrame) obj);
		}else if(obj instanceof JDialog){
			System.out.println("centrar dialog");
			centerJDialog((JDialog) obj);
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
	
	public static void fadeInFrame(final JFrame frame, int delay,final float incrementSize){
		final Timer timer = new Timer(delay,null) ;
		timer.setRepeats(true);
		timer.addActionListener(new ActionListener() {
			private float opacity = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				opacity +=incrementSize;
				frame.setOpacity(Math.min(opacity, 1));
				if(opacity >= 1){
					timer.stop();
				}
			}
		});
		frame.setOpacity(0);
		timer.start();
	}
	
	public static void fadeOutFrame(final JFrame frame, int delay,final float incrementSize){
		final Timer timer = new Timer(delay,null) ;
		timer.setRepeats(true);
		timer.addActionListener(new ActionListener() {
			private float opacity = 1;
			@Override
			public void actionPerformed(ActionEvent e) {
				opacity +=incrementSize;
				frame.setOpacity(Math.min(opacity, 0));
				if(opacity <= 0){
					timer.stop();
				}
			}
		});
		frame.setOpacity(1);
		timer.start();
	}
	/**
	 * 
	 * @param lista
	 * @param separador
	 * @return
	 */
	public static ArrayList<String> string2ArrayList(String lista, String separador){
		ArrayList<String> resultado = null;
		if(lista == null)
			return new ArrayList<>();
		if(separador == null)
			separador = "";
		
		boolean separadorVacio = separador.equals("") ? true: false;
		
		resultado = new ArrayList<>(Arrays.asList(lista.split(separador, -1)));
		
		if(separadorVacio && resultado != null && resultado.size() > 1){
			resultado.remove(0);
			if(resultado.size() > 1){
				resultado.remove(resultado.size()-1);
			}
		}
		
		return (resultado == null ? new ArrayList<>(): resultado);
		
	}

	public static void setOpaque(Window window, boolean opaque){
		try {
			Class<?> awtUtilsClass = Class.forName("com.sun.awt.AWTUtilities");
			if(awtUtilsClass != null){
				Method method = awtUtilsClass.getMethod("setWindowOpaque", Window.class,boolean.class);
				method.invoke(null, window, opaque);
			}
		} catch (Exception e) {
			
		}
	}
	
}
