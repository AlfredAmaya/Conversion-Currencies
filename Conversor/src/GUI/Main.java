package GUI;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import Currencies.Currencies;
import Currencies.Money;
import Tools.API_manager;
import Units.Unit;
import Units.Unit_System;
import Units.Units_Group;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.SwingConstants;

public class Main {
	static int Progress=0;
	static int MAX;
	private static JTextField date;
	
	public static void main(String[] args) {
		
		//UI Configuration
			
		try { UIManager.setLookAndFeel(new FlatDarkLaf());}
		catch (Exception e1) {e1.printStackTrace();	}finally {FlatDarkLaf.setup();}
		
		//Variables Configuration
			//Variables cambiarias
		
			Currencies C1 = new Currencies();
			String from="USD";
			
			Set<Currency> Curren = new  HashSet<>();
			API_manager API = new API_manager(from);
			Curren = Currency.getAvailableCurrencies();	
			
			//Variables de distancia
			Units_Group U_G = new Units_Group("Distances");
			Unit_System Metric = new Unit_System("Metric", "Distancia", 3.2805);
			Unit_System English = new Unit_System("English", "Distancia", 0.3048);
			
						
			U_G.addUnit(new Unit("metro","m",1.0,Metric));
			U_G.addUnit(new Unit("centimetro","cm",0.01,Metric));
			U_G.addUnit(new Unit("Kilometro","km",1000.0,Metric));
			
			U_G.addUnit(new Unit("pie","ft",1.0,English));
			U_G.addUnit(new Unit("pulgada","in",0.083333,English));
			U_G.addUnit(new Unit("Milla","mi",5280.0,English));
			
		//JFrame configuration
		JFrame MainFrame = new JFrame();
		JFrame.setDefaultLookAndFeelDecorated(false);
		MainFrame.getContentPane().setLayout(null);
		MainFrame.setSize(649, 263);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//tabs configuration
		
		JTabbedPane Tabs = new JTabbedPane();
		Tabs.setLocation(0, 0);
		Tabs.setSize(632,218);
		
		//Comboboxmodel configuration
		
		DefaultComboBoxModel<Money> model1 = new  DefaultComboBoxModel<>();
		DefaultComboBoxModel<Money> model2 = new  DefaultComboBoxModel<>();
		
		//Creacion de los Paneles de Distancais y Exchange
		
			JPanel Exchange = new JPanel();
			JComboBox<Money> From = new JComboBox<>();
			From.setEditable(true);
			From.setForeground(new Color(255, 255, 255));
			From.setBounds(105, 68, 128, 21);
			
				JLabel from_labl = new JLabel("From:");
				from_labl.setFont(new Font("Tahoma", Font.PLAIN, 16));
				from_labl.setBounds(53, 66, 42, 20);	
				
				JComboBox<Money> To = new JComboBox<>();
				To.setEditable(true);
				To.setBounds(413, 68, 128, 21);
					
				JLabel to_labl = new JLabel("To:");
				to_labl.setFont(new Font("Tahoma", Font.PLAIN, 16));
				to_labl.setBounds(379, 66, 24, 20);
						
			JLabel Amount = new JLabel("Amount:");
			Amount.setFont(new Font("Tahoma", Font.PLAIN, 16));
			Amount.setBounds(156, 34, 61, 20);
			
			JButton ExchangeBtn = new JButton("EXCHANGE");
			
			ExchangeBtn.setBorder(null);
			ExchangeBtn.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
			ExchangeBtn.setBounds(105, 131, 81, 23);
			
			
			JTextField  Value = new JTextField();
			Value.setBackground(UIManager.getColor("Button.light"));
			//Value.setBorder();
			Value.setBounds(227, 37, 225, 19);
			Value.setColumns(10);
			
			
			
			
			
			JButton Intercambiar = new JButton();
			Intercambiar.setBorder(null);
			Intercambiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			Intercambiar.setText("SWITCH");
			Intercambiar.setForeground(null);
			Intercambiar.setBounds(280, 68, 55, 17);
			Exchange.setLayout(null);
			
			
			
					
	
	
	JTextArea Curren_Info_1 = new JTextArea();
	Curren_Info_1.setBackground(null);
	Curren_Info_1.setBounds(105, 99, 188, 22);
	Exchange.add(Curren_Info_1);
	
	JTextArea Curren_Info_2 = new JTextArea();
	Curren_Info_2.setBackground(null);
	Curren_Info_2.setBounds(353, 96, 188, 22);
	Exchange.add(Curren_Info_1);
	
	JLabel Result = new JLabel("Result:");
	Result.setFont(new Font("Tahoma", Font.PLAIN, 16));
	Result.setBounds(227, 134, 50, 20);
	
	JTextField Resultado= new JTextField();
	Resultado.setBorder(null);
	Resultado.setHorizontalAlignment(SwingConstants.LEFT);
	Resultado.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Resultado.setEnabled(false);
	Resultado.setForeground(Color.RED);
	Resultado.setColumns(10);
	Resultado.setBackground((Color) null);
	Resultado.setBounds(287, 133, 140, 21);
	
	ExchangeBtn.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			String format = "0.000";
			String r;
			NumberFormat formatter = new DecimalFormat(format);
			Resultado.setText(null);
			r=formatter.format(C1.Exchange((Money)From.getSelectedItem(),(Money)To.getSelectedItem(),Double.parseDouble(Value.getText())));
			System.out.println("Exchange:"+r);
			Resultado.setText(r);
			
		}
	});
	
	Intercambiar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			Object from_index = From.getSelectedItem();
			Object to_index = To.getSelectedItem();
			From.setSelectedItem(to_index);
			To.setSelectedItem(from_index);		
			
		}
	});
	
	From.addItemListener(new ItemListener() {
	  	@Override
		public void itemStateChanged(ItemEvent e) {
			Money from_item = (Money) From.getSelectedItem();
			Curren_Info_1.setText("["+"$"+from_item.getDollar_Value()+"]"+","+"'"+from_item.getName()+"'");
		}
	});
	
	To.addItemListener(new ItemListener() {
	  	@Override
		public void itemStateChanged(ItemEvent e) {
			Money to_item = (Money)To.getSelectedItem();
			Curren_Info_2.setText("["+"$"+to_item.getDollar_Value()+"]"+","+"'"+to_item.getName()+"'");
			
		}
	});
		
	
	//add Exchange
	Exchange.add(ExchangeBtn);
	Exchange.add(From);
	Exchange.add(from_labl);
	Exchange.add(To);
	Exchange.add(to_labl);
	Exchange.add(Amount);
	Exchange.add(Value);
	Exchange.add(Curren_Info_1);
	Exchange.add(Curren_Info_2);
	Exchange.add(Intercambiar);
	Exchange.add(Result);
	Exchange.add(Resultado);
	Tabs.addTab("Converter",Exchange);		
	
	JLabel Descarga = new JLabel("Downloading Values . . .");
	Descarga.setBounds(195, 42, 240, 25);
	Descarga.setForeground(SystemColor.activeCaption);
	Descarga.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
	//Barra de progreso
	JProgressBar Loading = new  JProgressBar();
	Loading.setBounds(166, 67, 324, 22);
	Loading.setFont(new Font("Tahoma", Font.PLAIN, 15));
	Loading.setForeground(SystemColor.activeCaption);
	Loading.setMinimum(0);
	Loading.setStringPainted(true);
	Loading.setMaximum(Curren.size());
	Loading.setVisible(true);
	Descarga.setVisible(true);
	MainFrame.getContentPane().add(Tabs);
	MainFrame.getContentPane().add(Descarga);
	MainFrame.getContentPane().add(Loading);
		
			//Invisible Tabs
			Tabs.setVisible(false);
				
		//MainFrame Visibility
        MainFrame.setVisible(true);
		
		
		//Descargar Valores
		Curren.stream().forEach(Act_curr -> {
			API.Request_Builder(Act_curr.getCurrencyCode(),API.TimeOut_Configuration(2));			
		try {API.Send_Request();} catch (Exception e) { }
		finally {
			Progress++;
			System.out.println(Progress);
			SwingUtilities.invokeLater(new Runnable() {
                public void run() {Loading.setValue(Progress);}
            });
		}
		try {
			String format = "0.000";
			String r;
			NumberFormat formatter = new DecimalFormat(format);
			String s_val;
			Double val=Double.parseDouble(API.getBody());
			
			
			if(val!=0.0){	
				s_val=formatter.format(val);
				System.out.println("["+Act_curr.getNumericCode()+"]"+","+Act_curr.getDisplayName().toUpperCase()+","+API.getBody());
				C1.addExchange(new Money(
				Act_curr.getDisplayName().toUpperCase(),
				Double.parseDouble(s_val),
				Act_curr.getCurrencyCode()));
			}
					
		}catch(RuntimeException e) { }
		});
		
		//Charge Data combobox
		C1.getExchange_Rates().stream().sorted().forEach(c->{
			model1.addElement(c);
			model2.addElement(c);
		});
		From.setModel(model1);
		To.setModel(model2);
		To.setSelectedIndex(0);
		
		JLabel lblNewLabel = new JLabel("Conversion Rates");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(227, 10, 172, 17);
		Exchange.add(lblNewLabel);
		
		date = new JTextField();
		date.setBackground(null);
		date.setBorder(null);
		date.setBounds(494, 13, 96, 19);
		Exchange.add(date);
		date.setColumns(10);
		date.setText(C1.getEx_Date());
		
		
		//Visibilize
		Tabs.setVisible(true);
		
		
	}
}
