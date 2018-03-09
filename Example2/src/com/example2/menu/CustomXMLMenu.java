package com.example2.menu;

import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	                CustomJMenu customJMenu = new CustomJMenu(I18N.lang(element.getAttribute("title")), ImageUtils.getScaledImage(element.getAttribute("icon")));
	                addChildsToNode(customJMenu, XMLUtils.getChildList(element));
	                add(customJMenu);
	            }
	        } catch (Exception ex) {
	            System.out.println(ex.toString());
	        }
	}
	
	private void addChildsToNode(CustomJMenu menu, List<Element> childList) {
        for (Element element : childList) {
            if (!XMLUtils.getChildList(element).isEmpty()) {
                CustomJMenu<JMenu> customJMenu = new CustomJMenu<JMenu>(element.getAttribute("title"), ImageUtils.getScaledImage(element.getAttribute("icon")));
                addChildsToNode(customJMenu, XMLUtils.getChildList(element));
                menu.add(customJMenu);
            } else {
                String label = element.getAttribute("title");
                String key = element.getAttribute("key");
                CustomJMenuItem<JMenuItem> jMenuItem = new CustomJMenuItem<JMenuItem>(label, ImageUtils.getScaledImage(element.getAttribute("icon")), key);
                
                menu.add(jMenuItem);
            }
        }
    }
	
	
	
	

}
