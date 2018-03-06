package com.example.util;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import com.example.catalog.dto.Item;

public class CboBoxRender extends BasicComboBoxRenderer  {
	
	
	@Override
	public Component getListCellRendererComponent(JList list, Object value,
		      int index, boolean isSelected, boolean cellHasFocus) {
		    super.getListCellRendererComponent(list, value, index, isSelected,
		        cellHasFocus);
		    if (value != null) {
		      Item item = (Item) value;
		      setText(item.getDescription().toUpperCase());
		    }
		    if (index == -1) {
		      Item item = (Item) value;
		      setText("" + item.getId());
		    }
		    return this;
		  }

}
