package Experiments;

import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

import Currencies.Currencies;
import Currencies.Money;
import Tools.API_manager;
import Tools.Print_Configuration;

public class Experimento_5 {
	public static void main(String[] args) {
		
		Print_Configuration P_C = new Print_Configuration();
		P_C.Start_Configuration();
		
		
		
		String from="USD";
		
		Currencies Currencies1 = new Currencies();
		
		Set<Currency> Curren = new  HashSet<>();
		API_manager API = new API_manager(from);
		
		Curren = Currency.getAvailableCurrencies();
			
		Curren.stream().forEach(Act_curr -> {
			API.Request_Builder(Act_curr.getCurrencyCode(),API.TimeOut_Configuration(3));			
		try {
			
			API.Send_Request();
			
		} catch (Exception e) {
			System.out.println("");

			
		}
		
		try {
			if(Double.parseDouble(API.getBody())!=0.0){				
			Currencies1.addExchange(new Money(
					Act_curr.getDisplayName().toUpperCase(),
					Double.parseDouble(API.getBody()),
					Act_curr.getCurrencyCode()));
			}
					
		}catch (RuntimeException e) {
			System.out.println(" ");
		}
				
		});
		System.out.println(Currencies1.Exchange("MXN","COP",100.0));
		
	}
}
