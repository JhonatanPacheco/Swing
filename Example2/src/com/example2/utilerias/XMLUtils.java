package com.example2.utilerias;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtils {
	
	public static Element getRoot(Document document ) {
        if (document == null) {
            return null;
        }
        List<Element> list = getChildList(document);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
	
	public static List<Element> getChildList(Node node) {
        List<Element> list = new ArrayList<Element>();
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                list.add((Element) nodeList.item(i));
            }
        }
        return list;
    }

}
