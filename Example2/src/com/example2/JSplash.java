package com.example2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;

import com.example2.config.Config;
import com.example2.config.I18N;
import com.example2.menu.CustomXMLMenu;

public class JSplash extends JWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblVersion = new JLabel("1.0.0");
	static JProgressBar progressBar = new JProgressBar();
	static int count = 1, TIMER_PAUSE = 15, PROGBAR_MAX = 100;
	static Timer progressBarTimer;

	ActionListener al = new ActionListener() {
		
		private void createAndShowFrame() {

			JFrame f = new JFrame(Config.getProperty("APP.TITLE"));
			f.setJMenuBar(new CustomXMLMenu());
			
			f.setSize(400, 400);
			f.setVisible(true);
			I18N.init();

		}
		
		@Override
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			progressBar.setValue(count);
			if (PROGBAR_MAX == count) {
				progressBarTimer.stop();
				setVisible(false);

				createAndShowFrame();
			}
			count++;
		}
	};

	

	public static void main(String[] args) {
		new JSplash().setVisible(true);
	}

	public JSplash() {
		init();
		center(this);
	}

	private void init() {
		JPanel pnlImage = new JPanel();
		ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("images/Lighthouse.jpg"), "splash");
		JLabel lblBack = new JLabel(/* image */);
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		lblBack.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		getLayeredPane().add(lblBack, new Integer(Integer.MIN_VALUE));
		pnlImage.setLayout(null);
		pnlImage.setOpaque(false);
		pnlImage.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		pnlImage.add(this.lblVersion);
		this.lblVersion.setForeground(Color.GREEN);
		this.lblVersion.setFont(new Font("Dialog", Font.PLAIN, 12));
		this.lblVersion.setBounds(image.getIconWidth()  - 150, 20, 120, 20);
		this.lblVersion.setHorizontalTextPosition(SwingConstants.RIGHT);
		progressBar.setMaximum(PROGBAR_MAX);
		progressBar.setBounds(25, image.getIconHeight()-100 - 25, image.getIconWidth() -100 - 50, 20);
		pnlImage.add(progressBar);
		setContentPane(pnlImage);
		setSize(image.getIconWidth()-100, image.getIconHeight()-100);
		startProgressBar();
	}

	private void startProgressBar() {
		progressBarTimer = new Timer(TIMER_PAUSE, al);
		progressBarTimer.start();
	}

	private void center(JWindow jWindow) {
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		int nX = (int) (scr.getWidth() - getWidth()) / 2;
		int nY = (int) (scr.getHeight() - getHeight()) / 2;

		jWindow.setLocation(nX, nY);
	}

}
