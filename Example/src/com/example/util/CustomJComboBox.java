package com.example.util;

import java.util.List;

import javax.swing.JComboBox;

import com.example.catalog.dto.Catalog;

public class CustomJComboBox<T> extends JComboBox<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<T> dataSource;

	private T defaultValue;

	public CustomJComboBox() {
		super();
	}

	@SuppressWarnings("unchecked")
	public void init() {

		
		addItem(defaultValue);
		for (T item : dataSource) {
			addItem(item);
		}
		setMaximumRowCount(4);
		addActionListener(e -> {
			JComboBox<T> c = (JComboBox<T>) e.getSource();
			T item = (T)c.getSelectedItem();

		});
		
		setSelectedItem(defaultValue);

	}

	public List<T> getDataSource() {
		return dataSource;
	}

	public void setDataSource(List<T> dataSource) {
		this.dataSource = dataSource;
	}

	public T getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(T defaultValue) {
		this.defaultValue = defaultValue;
	}

}
