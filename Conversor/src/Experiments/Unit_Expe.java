package Experiments;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Units.*;
import Units.Unit_System;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Unit_Expe {
	
	public static void main(String[] args) {
		Units_Group U_G = new Units_Group("Distances");
		Unit_System Metric = new Unit_System("Metric", "Distancia", 3.2805);
		Unit_System English = new Unit_System("English", "Distancia", 0.3048);
		
		Unit metro = new Unit("metro","m",1.0,Metric);
		Unit pie = new Unit("pie","ft",1.0,English);
		
		U_G.addUnit(metro);
		U_G.addUnit(new Unit("centimetro","cm",0.01,Metric));
		U_G.addUnit(new Unit("Kilometro","km",1000.0,Metric));
		
		U_G.addUnit(pie);
		U_G.addUnit(new Unit("pulgada","in",0.083333,English));
		U_G.addUnit(new Unit("Milla","mi",5280.0,English));
		
		System.out.println((metro.Convert(pie,1.0)).toString());
		
		U_G.printUnit_list();
		
		JFrame frame = new JFrame();
		frame.setSize(500,300);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		JComboBox<Unit> From = new JComboBox<>();
		From.setBounds(55, 84, 128, 32);
		JComboBox<Unit> To = new JComboBox<>();
		To.setBounds(231, 87, 135, 26);
		
		DefaultComboBoxModel<Unit> model1= new DefaultComboBoxModel<>();			
		model1.addAll(U_G.getUnit_List());
		DefaultComboBoxModel<Unit> model2= new DefaultComboBoxModel<>();			
		model2.addAll(U_G.getUnit_List());
		
		From.setModel(model1);
		To.setModel(model2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel);
		
		panel.setLayout(null);
		panel.add(From);
		panel.add(To);
		
		JButton btnNewButton = new JButton("New button");
		
		btnNewButton.setBounds(60, 149, 85, 21);
		panel.add(btnNewButton);
		
		JTextField textField = new JTextField();
		textField.setBounds(165, 39, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(181, 150, 96, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Unit fromS = model1.getElementAt(From.getSelectedIndex());
				Unit toS = model2.getElementAt(To.getSelectedIndex());
				Double Result = fromS.Convert(toS,Double.parseDouble(textField.getText()));
				textField_1.setText(Result.toString());
			}
		});
		
		frame.setVisible(true);
		
		/*
		U_G.getUnit_List().forEach(U->{
			
		});
		*/
		
		
		
	}
}
