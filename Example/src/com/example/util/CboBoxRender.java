package com.example.util;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import com.example.catalog.dto.Item;

public class CboBoxRender extends BasicComboBoxRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if (value != null) {
			Item item = (Item) value;
			setText(String.valueOf(item.getId()));
		}
		if (index == -1) {
			Item item = (Item) value;
			setText(item.getDescription());
		}
		return this;
	}

}
