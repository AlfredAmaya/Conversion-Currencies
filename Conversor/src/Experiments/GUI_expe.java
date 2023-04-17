package Experiments;
import javax.swing.*;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import Currencies.Currencies;
import Currencies.Money;
import Tools.API_manager;

import java.awt.Color;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;
import java.awt.Font;


public class GUI_expe {
	
	static int Progress=0;
	static int MAX;
	
	public static void main(String[] args) {
		FlatLightLaf.setup();
		//CREACION DE LA INTERFAZ	
		try {
			UIManager.setLookAndFeel(new FlatDarkLaf());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		JFrame MainFrame = new JFrame();
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setUndecorated(true);
		MainFrame.getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		MainFrame.setSize(500, 300);
		MainFrame.getContentPane().setLayout(null);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JProgressBar Loading = new  JProgressBar();
		Loading.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Loading.setForeground(new Color(123, 189, 123));
		Loading.setBounds(84, 125, 324, 40);
		Loading.setMinimum(0);
		Loading.setStringPainted(true);
		
		JLabel lblNewLabel = new JLabel("Descargando valores . . .");
        lblNewLabel.setForeground(new Color(123, 189, 123));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(140, 90, 240, 25);
        
        
        JTabbedPane Tab = new JTabbedPane();
        Tab.setSize(500,300);
        
        JPanel Exchange = new JPanel();
        
        JPanel Distance = new JPanel();
        JPanel Temper = new JPanel();
        
         Tab.addTab("Distances Converter",Distance);
         Tab.addTab("Exchange Machine",Exchange);
         Tab.addTab("Temperature Converter",Temper);
         
		
		
		// CARGA DE INFORMACION
		//API
		String from="USD";
		Currencies Currencies1 = new Currencies();
		Set<Currency> Curren = new  HashSet<>();
		API_manager API = new API_manager(from);
		Curren = Currency.getAvailableCurrencies();
		//
		
		
		
		Loading.setMaximum(Curren.size());
		MainFrame.getContentPane().add(Loading);        
        MainFrame.getContentPane().add(lblNewLabel);
        MainFrame.getContentPane().add(Tab);
        
        Loading.setVisible(true);
        lblNewLabel.setVisible(true);
        MainFrame.setVisible(true);
        /*
        Distance.setVisible(false);
        Exchange.setVisible(false);
        Temper.setVisible(false);
		*/
		Tab.setVisible(false);
		
		
		//CREAR MAPA DE VALORES
			
		Curren.stream().forEach(Act_curr -> {
			API.Request_Builder(Act_curr.getCurrencyCode(),API.TimeOut_Configuration(3));			
		try {
			
			API.Send_Request();
			
		} catch (Exception e) { }
		finally {
			Progress++;
			System.out.println(Progress);
			SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Loading.setValue(Progress);
                }
            });
		}
		
		
		try {
			if(Double.parseDouble(API.getBody())!=0.0){				
				Currencies1.addExchange(new Money(
					Act_curr.getDisplayName().toUpperCase(),
					Double.parseDouble(API.getBody()),
					Act_curr.getCurrencyCode()));
			}
					
		}catch (RuntimeException e) { }
				
	  });
		lblNewLabel.setVisible(false);
		Loading.setVisible(false);
		
		Tab.setVisible(true);
		
	}
}
