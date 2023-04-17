package Experiments;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import Currencies.Currencies;
import Currencies.Money;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;






public class GUI_TABB_experiments {
	private static JTextField Resultado;
	
	
	public static void main(String[] args) {
				
			Currencies C1 = new Currencies();
			//C1.Exchange("MXN","COP",100.0);
			try {
				UIManager.setLookAndFeel(new FlatDarkLaf());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Frame
			JFrame Frame = new JFrame();
			JFrame.setDefaultLookAndFeelDecorated(false);
			Frame.getContentPane().setLayout(null);
			Frame.setSize(632, 218);
			
				JTabbedPane Tabs = new JTabbedPane();
				Tabs.setLocation(0, 0);
				Tabs.setSize(608,184);
						
						 DefaultComboBoxModel<Money> model1 = new  DefaultComboBoxModel<>();
						 
						 C1.getExchange_Rates().forEach(c->{
							 model1.addElement(c);
						 });
						 
						 DefaultComboBoxModel<Money> model2 = new  DefaultComboBoxModel<>();
						 
						 C1.getExchange_Rates().forEach(c->{
							 model2.addElement(c);
						 });
					
						
					JPanel Exchange = new JPanel();
					Exchange.setLayout(null);
					
					

							JComboBox<Money> From = new JComboBox<>(model1);
							From.setForeground(new Color(255, 255, 255));
							From.setBounds(76, 58, 150, 21);
							
								JLabel from = new JLabel("From:");
								from.setFont(new Font("Tahoma", Font.PLAIN, 16));
								from.setBounds(20, 61, 45, 13);	
								
								JComboBox<Money> To = new JComboBox<>(model2);
								To.setBounds(445, 58, 137, 21);
									
								JLabel to = new JLabel("To:");
								to.setFont(new Font("Tahoma", Font.PLAIN, 16));
								to.setBounds(420, 61, 28, 13);
										
							JLabel Amount = new JLabel("Amount:");
							Amount.setFont(new Font("Tahoma", Font.PLAIN, 16));
							Amount.setBounds(10, 24, 86, 13);
							
							JButton ExchangeBtn = new JButton("EXCHANGE");
							
							ExchangeBtn.setBorder(null);
							ExchangeBtn.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
							ExchangeBtn.setBounds(280, 104, 119, 29);
							
							
							JTextField  Value = new JTextField();
							Value.setBackground(UIManager.getColor("Button.light"));
							//Value.setBorder();
							Value.setBounds(74, 23, 166, 19);
							Value.setColumns(10);
							
							
							
							
							
							JButton Intercambiar = new JButton();
							Intercambiar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
								}
							});
							Intercambiar.setBorder(null);
							Intercambiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
							Intercambiar.setText("SWITCH");
							Intercambiar.setForeground(null);
							Intercambiar.setBounds(283, 56, 104, 21);
							
									
					
					
					JTextArea Curren_Info_1 = new JTextArea();
					Curren_Info_1.setBackground(null);
					Curren_Info_1.setBounds(76, 89, 176, 44);
					Exchange.add(Curren_Info_1);
					
					JTextArea Curren_Info_2 = new JTextArea();
					Curren_Info_2.setBackground(null);
					Curren_Info_2.setBounds(409, 89, 184, 44);
					Exchange.add(Curren_Info_1);
					
					JLabel Result = new JLabel("Result:");
					Result.setFont(new Font("Tahoma", Font.PLAIN, 16));
					Result.setBounds(331, 25, 56, 13);
					
					Resultado= new JTextField();
					Resultado.setFont(new Font("Tahoma", Font.PLAIN, 17));
					Resultado.setBorder(null);
					Resultado.setEnabled(false);
					Resultado.setForeground(Color.RED);
					Resultado.setColumns(10);
					Resultado.setBackground((Color) null);
					Resultado.setBounds(396, 24, 197, 19);
					
					ExchangeBtn.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							Resultado.setText( C1.Exchange(model1.getElementAt(From.getSelectedIndex()).getCode(),model1.getElementAt(To.getSelectedIndex()).getCode(),Double.parseDouble( Value.getText())).toString());
						}
					});
					
					Intercambiar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
							System.out.println(From.getSelectedItem());
							System.out.println(To.getSelectedItem());
							
							Object from_index = From.getSelectedItem();
							Object to_index = To.getSelectedItem();
																			
							From.setSelectedItem(to_index);
							To.setSelectedItem(from_index);
							
							
						}
					});
					
					
					//Agregar a Exchange
					Exchange.add(ExchangeBtn);
					Exchange.add(From);
					Exchange.add(from);
					Exchange.add(To);
					Exchange.add(to);
					Exchange.add(Amount);
					Exchange.add(Value);
					Exchange.add(Curren_Info_1);
					Exchange.add(Curren_Info_2);
					Exchange.add(Intercambiar);
					Exchange.add(Result);
					Exchange.add(Resultado);
					Tabs.addTab("Converter",Exchange);
					
					
					
						
					JPanel Config = new JPanel();
									
				Tabs.addTab("Configuration",Config);
								
			Frame.getContentPane().add(Tabs);			
			Frame.setVisible(true);
			
		}
}
