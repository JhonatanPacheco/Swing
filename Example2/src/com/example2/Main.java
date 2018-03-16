package com.example2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example2.config.I18N;
import com.example2.controller.MainFrameController;
import com.example2.utilerias.ImageUtils;
import com.example2.utilerias.Utils;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	private JDesktopPane jDesktopPane;
	private static Main instance = null;

	private List<?> auth;

	private Main() {
		setTitle(I18N.lang("desktop.title"));
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		addWindowListener(new MainFrameController());

		Image im = ImageUtils.getScaledImage(Utils.getAPPPropertyValue("APP.ICON")).getImage();
		setIconImage(im);

		jDesktopPane = new JDesktopPane();
//		jDesktopPane.setBackground(Color.BLUE);
		contentPane.add(jDesktopPane, BorderLayout.CENTER);
		contentPane.add(new StatusBar(), BorderLayout.SOUTH);
		
		

	}

	public static Main getInstance() {
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

	public List<?> getAuth() {
		return auth;
	}

	public void setAuth(List<?> auth) {
		this.auth = auth;
	}

	class StatusBar extends JPanel {

		public StatusBar() {
			setLayout(new BorderLayout());
			setPreferredSize(new Dimension(10, 23));

			JPanel rightPanel = new JPanel(new BorderLayout());
			rightPanel.add(new JLabel(new AngledLinesWindowsCornerIcon()), BorderLayout.SOUTH);
			rightPanel.setOpaque(false);

			add(rightPanel, BorderLayout.EAST);
			setBackground(SystemColor.control);
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			int y = 0;
			g.setColor(new Color(156, 154, 140));
			g.drawLine(0, y, getWidth(), y);
			y++;
			g.setColor(new Color(196, 194, 183));
			g.drawLine(0, y, getWidth(), y);
			y++;
			g.setColor(new Color(218, 215, 201));
			g.drawLine(0, y, getWidth(), y);
			y++;
			g.setColor(new Color(233, 231, 217));
			g.drawLine(0, y, getWidth(), y);

			y = getHeight() - 3;
			g.setColor(new Color(233, 232, 218));
			g.drawLine(0, y, getWidth(), y);
			y++;
			g.setColor(new Color(233, 231, 216));
			g.drawLine(0, y, getWidth(), y);
			y = getHeight() - 1;
			g.setColor(new Color(221, 221, 220));
			g.drawLine(0, y, getWidth(), y);

		}

	}

	class AngledLinesWindowsCornerIcon implements Icon {
		private final Color WHITE_LINE_COLOR = new Color(255, 255, 255);

		private final Color GRAY_LINE_COLOR = new Color(172, 168, 153);
		private static final int WIDTH = 13;

		private static final int HEIGHT = 13;

		public int getIconHeight() {
			return WIDTH;
		}

		public int getIconWidth() {
			return HEIGHT;
		}

		public void paintIcon(Component c, Graphics g, int x, int y) {

			g.setColor(WHITE_LINE_COLOR);
			g.drawLine(0, 12, 12, 0);
			g.drawLine(5, 12, 12, 5);
			g.drawLine(10, 12, 12, 10);

			g.setColor(GRAY_LINE_COLOR);
			g.drawLine(1, 12, 12, 1);
			g.drawLine(2, 12, 12, 2);
			g.drawLine(3, 12, 12, 3);

			g.drawLine(6, 12, 12, 6);
			g.drawLine(7, 12, 12, 7);
			g.drawLine(8, 12, 12, 8);

			g.drawLine(11, 12, 12, 11);
			g.drawLine(12, 12, 12, 12);

		}

	}
}
