package com.example.forms;

import java.awt.Component;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import com.example.util.Utilerias;

public final class Main {

	private JDesktopPane theDesktop;

	private JFrame frame;
	private static Main instance = null;
	private Component lastComponent;

	protected Main() {
		frame = new JFrame(Utilerias.getPropertyValue("titulo"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

	public static Main getInstance() {
		if (instance == null) {
			instance = new Main();
		}
		return instance;
	}

	public void setup() {
		frame.setVisible(true);
		Utilerias.centerFrame(frame);
	}

	public <T> void setFrame(T o, int width, int height) {
		frame.add((Component) o);
		frame.invalidate();
		frame.revalidate();
		frame.setSize(width, height);
		lastComponent = (Component) o;
		

	}

	public <T> void setFrame(T o) {
		
		frame.add((Component) o);
		frame.invalidate();
		frame.revalidate();
	}

	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Component getLastComponent() {
		return lastComponent;
	}

	public void setLastComponent(Component lastComponent) {
		this.lastComponent = lastComponent;
	}

}
