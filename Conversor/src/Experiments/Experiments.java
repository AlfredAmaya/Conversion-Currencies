package Experiments;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

public class Experiments {
	public static void main(String[] args) {
		
		
		
		double price = 1278893.4567;
		int t;
		Set<Currency> Curren = new  HashSet<>();
		
		Curren = Currency.getAvailableCurrencies();
		t=Curren.size();
		Curren.stream().sorted(Comparator.comparing(Currency::getCurrencyCode)).forEach(currency -> {
			System.out.println("("+currency.getDisplayName().toUpperCase()+")");
			System.out.println("/C="+currency.getCurrencyCode()+"/S="+currency.getSymbol()+"/NC="+currency.getNumericCode());
			
		});
		System.out.println(t);
		System.out . printf("The total price is $%, .2f\n", price) ;
		DecimalFormat df = new DecimalFormat ("0,00.00");
		System.out.println("The total price is $" + df.format(price));
	}
}
