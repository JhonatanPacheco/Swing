package com.example2.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuBar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.example2.AbstractViewControllerFactory;
import com.example2.config.I18N;
import com.example2.enums.ERoles;
import com.example2.utilerias.Constantes;
import com.example2.utilerias.ImageUtils;
import com.example2.utilerias.Utils;
import com.example2.utilerias.XMLUtils;

public class CustomXMLMenu extends JMenuBar {

	private static final long serialVersionUID = 1L;
	
	private Document document;
	List<String> menuRoles;
	List<ERoles> userRoles;

	public CustomXMLMenu(List<ERoles> userRoles) {
		try {
			this.userRoles = userRoles;
			Document doc = null;
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			doc = docBuilder.parse(ClassLoader.class.getResourceAsStream("/menu/menuDefinition.xml"));
			doc.normalize();
			this.document = doc;
			Element root = XMLUtils.getRoot(document);
			
			for (Element element : XMLUtils.getChildList(root)) {
				String label = I18N.lang(element.getAttribute(Constantes.MENU_TITLE));
				String key = element.getAttribute(Constantes.COMMAND);
				menuRoles = Utils.string2ArrayList(element.getAttribute(Constantes.ROLES), ",");
				if(menuRoles.contains(String.valueOf(userRoles.get(0).getId()))){
					CustomJMenu customJMenu = new CustomJMenu(label,ImageUtils.getScaledImage(element.getAttribute("icon")));
					customJMenu.setActionCommand(key);
					addChildsToNode(customJMenu, XMLUtils.getChildList(element));
					add(customJMenu);	
				}
				
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	private void addChildsToNode(CustomJMenu menu, List<Element> childList) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String command  = Constantes.EMPTY_STRING;
		String icon = Constantes.EMPTY_STRING;
		String label = Constantes.EMPTY_STRING;
		String roles = Constantes.EMPTY_STRING;
		for (Element element : childList) {
			command= element.getAttribute(Constantes.COMMAND);
			label = I18N.lang(element.getAttribute(Constantes.MENU_TITLE));
			icon = element.getAttribute(Constantes.MENU_ICON);
			roles = element.getAttribute(Constantes.ROLES);
			if (!XMLUtils.getChildList(element).isEmpty()) {
				menuRoles = Utils.string2ArrayList(roles, ",");
				if(menuRoles.contains(String.valueOf(userRoles.get(0).getId()))){
					CustomJMenu customJMenu = new CustomJMenu(label,ImageUtils.getScaledImage(icon));
					addChildsToNode(customJMenu, XMLUtils.getChildList(element));
					customJMenu.setActionCommand(command);
					menu.add(customJMenu);	
				}
			} else {
				menuRoles = Utils.string2ArrayList(roles, ",");
				if(menuRoles.contains(String.valueOf(userRoles.get(0).getId()))){
					CustomJMenuItem jMenuItem = new CustomJMenuItem(label,ImageUtils.getScaledImage(icon), command);
						jMenuItem.setActionCommand(command);
						jMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								AbstractViewControllerFactory.createViewController(jMenuItem.getActionCommand());
							}
						});
					menu.add(jMenuItem);
				}
				
			}
		}
	}

}
