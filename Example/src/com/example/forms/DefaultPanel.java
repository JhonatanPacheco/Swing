package com.example.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.catalog.dto.Item;
import com.example.util.CustomJComboBox;

public class DefaultPanel extends JPanel {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DefaultPanel() {

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("Label One"));
		this.add(new JLabel("Label Two"));
		this.add(new JLabel("Label Three"));
		this.add(new JLabel("Label Four"));
		this.add(new JLabel("Label Five"));
		JButton button = new JButton("Next Screen");

		CustomJComboBox<Item> comboBox = new CustomJComboBox<Item>();
		List<Item> items = new ArrayList<>();

		comboBox.setDefaultValue(new Item(-1, "--------"));
		items.add(new Item(2, "Y"));
		items.add(new Item(1, "X"));

		comboBox.setDataSource(items);

		comboBox.init();

		this.add(comboBox);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println(((Item)comboBox.getSelectedItem()).getDescription());
				Item i = (Item) comboBox.getSelectedItem();
				System.out.println(i.getId());
				if (i.getId() != -1) {
					// swapPanel();
				}

			}
		});
		this.add(button);
	}
}
