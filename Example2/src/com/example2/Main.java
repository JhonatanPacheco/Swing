package com.example2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import com.example2.config.I18N;
import com.example2.controller.MainFrameController;
import com.example2.utilerias.ImageUtils;
import com.example2.utilerias.Utils;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	private JDesktopPane jDesktopPane;
	private static Main instance = null;

	private Main() {
		setTitle(I18N.lang("desktop.title"));
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		addWindowListener(new MainFrameController() );

		Image im = ImageUtils.getScaledImage(Utils.getAPPPropertyValue("APP.ICON")).getImage();
		setIconImage(im);
		
		jDesktopPane = new JDesktopPane();
		jDesktopPane.setBackground(Color.BLUE);
		add(jDesktopPane);
		
	}

	public static Main getInstance(){
		if (instance == null) {
			instance = new Main();
		}
		return instance;
	}

	public JDesktopPane getjDesktopPane() {
		return jDesktopPane;
	}

	public void setjDesktopPane(JDesktopPane jDesktopPane) {
		this.jDesktopPane = jDesktopPane;
	}
	
}
