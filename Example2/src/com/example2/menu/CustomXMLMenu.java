package com.example2.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.example2.AbstractViewControllerFactory;
import com.example2.Main;
import com.example2.config.I18N;
import com.example2.utilerias.ImageUtils;
import com.example2.utilerias.XMLUtils;

public class CustomXMLMenu extends JMenuBar {

	private static final long serialVersionUID = 1L;
	
	private Document document;

	public CustomXMLMenu() {
		try {
			Document doc = null;
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			doc = docBuilder.parse(ClassLoader.class.getResourceAsStream("/menu/menuDefinition.xml"));
			doc.normalize();
			this.document = doc;
			Element root = XMLUtils.getRoot(document);
			
			
			for (Element element : XMLUtils.getChildList(root)) {
				String label = I18N.lang(element.getAttribute("title"));
				String key = element.getAttribute("command");
				CustomJMenu customJMenu = new CustomJMenu(I18N.lang(element.getAttribute("title")),
						ImageUtils.getScaledImage(element.getAttribute("icon")));
				customJMenu.setActionCommand(key);
				addChildsToNode(customJMenu, XMLUtils.getChildList(element));
				add(customJMenu);
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	private void addChildsToNode(CustomJMenu menu, List<Element> childList) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String command  ="";
		for (Element element : childList) {
			command= element.getAttribute("command");
			if (!XMLUtils.getChildList(element).isEmpty()) {
				String label = I18N.lang(element.getAttribute("title"));
				CustomJMenu customJMenu = new CustomJMenu(I18N.lang(element.getAttribute("title")),ImageUtils.getScaledImage(element.getAttribute("icon")));
				addChildsToNode(customJMenu, XMLUtils.getChildList(element));
				customJMenu.setActionCommand(command);
				menu.add(customJMenu);
			} else {
				String label = I18N.lang(element.getAttribute("title"));
				CustomJMenuItem jMenuItem = new CustomJMenuItem(label,ImageUtils.getScaledImage(element.getAttribute("icon")), command);
				if(!"".equals(command)){
					jMenuItem.setActionCommand(command);
					jMenuItem.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							AbstractViewControllerFactory.createViewController(jMenuItem.getActionCommand());
						}
					});
				}
				
				menu.add(jMenuItem);
			}
		}
	}

}
