package com.example.init;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;

import com.example.forms.LoginForm;
import com.example.forms.Main;
import com.example.util.Utilerias;

public class SplashDemo {

	public static void main(String[] args) {
		SplashScreen splashScreen = new SplashScreen();
	}
}

class SplashScreen extends JWindow {
	private static final long serialVersionUID = 1L;
	static JProgressBar progressBar = new JProgressBar();
	static int count = 1, TIMER_PAUSE = 15, PROGBAR_MAX = 100;
	static Timer progressBarTimer;
	ActionListener al = new ActionListener() {
		@Override
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			progressBar.setValue(count);
			if (PROGBAR_MAX == count) {
				progressBarTimer.stop();
				SplashScreen.this.setVisible(false);
				createAndShowFrame();
			}
			count++;
		}
	};

	public SplashScreen() {
		Container container = getContentPane();

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder());
		container.add(panel, BorderLayout.CENTER);

		JLabel label = new JLabel(Utilerias.getPropertyValue("splash.title"));
		label.setFont(new Font("Verdana", Font.BOLD, 14));
		panel.add(label);

		progressBar.setMaximum(PROGBAR_MAX);
		container.add(progressBar, BorderLayout.SOUTH);
		pack();
		setVisible(true);
		startProgressBar();
		centreWindow(this);
	}

	public void centreWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

	private void startProgressBar() {
		progressBarTimer = new Timer(TIMER_PAUSE, al);
		progressBarTimer.start();
	}

	private void createAndShowFrame() {
		Main demo =   Main.getInstance();
		demo.setup();
		LoginForm login  = new LoginForm();
		demo.setFrame(login,login.getWidth(),login.getHeight() );
		
//		demo.setFrame(new App(),300,205);
		

	}
}
