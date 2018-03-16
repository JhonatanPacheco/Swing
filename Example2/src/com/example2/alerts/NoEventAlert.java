package com.example2.alerts;

import java.awt.Color;
import java.awt.Window;
import java.util.TimerTask;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import com.example2.components.Panel;
import com.example2.utilerias.Utils;


public class NoEventAlert extends JDialog {
	 Timer timer = null;
	 
	 TimerTask task;
	 int i = 32;
	 
	 private Panel panel;
	 private JLabel jLabel1;
	 private JLabel titulo;
	 private JLabel msj;
	 private JLabel msj1;
	 
	 public NoEventAlert(JFrame frame, boolean modal) {
		super(frame,"Error",modal);
		initComponentes();
		Utils.setOpaque(this, false);
		

	}

	private void initComponentes() {
		panel = new Panel();
		jLabel1 = new JLabel();
		titulo = new JLabel();
		msj = new JLabel();
		msj1 = new JLabel();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		pack();
		
	}

}
