package com.example;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.example.catalog.dto.Catalog;
import com.example.catalog.dto.Item;
import com.example.util.CustomJComboBox;
import com.example.util.Utilerias;

public class Main {
	
	private static void initFGUI(){
		
		System.out.println("OOOOOOOOOO");

		JFrame.setDefaultLookAndFeelDecorated(true);

		JFrame frame = new JFrame(Utilerias.getPropertyValue("titulo"));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Hello World");
		frame.getContentPane().add(label);
		
		
		//frame.pack();
		frame.setSize(320, 320);
		frame.setVisible(true);
		
	}
	
	JFrame frame;
    JButton nextButton = new JButton ("Next Screen");
    DefaultPanel p = new DefaultPanel();
    public void setup(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(p);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        StatusBar statusBar = new StatusBar();
        
        contentPane.add(statusBar, BorderLayout.SOUTH);
        
        frame.add(p);
//        frame.pack();
        frame.setSize(Integer.valueOf(Utilerias.getPropertyValue("width")), Integer.valueOf(Utilerias.getPropertyValue("height")));
    }

	
	public static void main(String[] args) {
		 Main demo = new Main();
	        demo.setup(Utilerias.getPropertyValue("data"));
	}
	
	
	
	 public class DefaultPanel extends JPanel { {
	        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	        this.add(new JLabel("Label One"));
	        this.add(new JLabel("Label Two"));
	        this.add(new JLabel("Label Three"));
	        this.add(new JLabel("Label Four"));
	        this.add(new JLabel("Label Five"));
	        JButton button = new JButton("Next Screen");
	        
	        CustomJComboBox<Catalog> comboBox = new CustomJComboBox();
	        List<Catalog> items= new ArrayList<>();
	        
	        items.add(new Catalog("2", "Y"));
	        items.add(new Catalog("1", "X"));
	        
	        comboBox.setDataSource(items);
	        comboBox.setDefaultValue(new Catalog("0", "2222222222"));
	        comboBox.init();
	        this.add(comboBox);
	        
	        button.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	System.out.println(((Catalog)comboBox.getSelectedItem()).getClave());
	                swapPanel();
	            }
	        });
	        this.add(button);
	    } }
	    public class PanelTwo extends JPanel {{
	        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	        this.add(new JButton("Button One"));
	        this.add(new JButton("Button Two"));
	        this.add(new JButton("Button Three"));
	        this.add(new JButton("Button Four"));
	        this.add(new JButton("Button Five"));
	    }}


	    protected void swapPanel() {
	        SwingUtilities.invokeLater(new Runnable() {

	            @Override
	            public void run() {


	                frame.remove(p);
	                frame.add(new PanelTwo());
	                frame.invalidate();
	                frame.revalidate();

	            }

	        });

	    }


}
