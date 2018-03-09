package com.example2.menu;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class CustomMenu implements Serializable  {
	

	private int menuId;
	private String menuTitle;
	private String menuShortCut;
	private String menuCommand;
	private ImageIcon menuIcon;

	public CustomMenu(int menuId, String menuTitle, String menuShortCut, String menuCommand, ImageIcon menuIcon) {
		super();
		this.menuId = menuId;
		this.menuTitle = menuTitle;
		this.menuShortCut = menuShortCut;
		this.menuCommand = menuCommand;
		this.menuIcon = menuIcon;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public String getMenuShortCut() {
		return menuShortCut;
	}

	public void setMenuShortCut(String menuShortCut) {
		this.menuShortCut = menuShortCut;
	}

	public String getMenuCommand() {
		return menuCommand;
	}

	public void setMenuCommand(String menuCommand) {
		this.menuCommand = menuCommand;
	}

	public ImageIcon getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(ImageIcon menuIcon) {
		this.menuIcon = menuIcon;
	}

}
