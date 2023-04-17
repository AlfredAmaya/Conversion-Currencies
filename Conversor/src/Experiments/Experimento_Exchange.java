package Experiments;

import Currencies.Currencies;

public class Experimento_Exchange {
	public static void main(String[] args) {
		
		Currencies C1 = new Currencies();
		
		System.out.println(C1.Exchange("MXN","COP",100.0));
		
	}
}
