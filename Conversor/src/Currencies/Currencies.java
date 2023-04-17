package Currencies;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Currencies {
	private static List<Money> Exchange_Rates = new ArrayList<>();
	private	static Map<String,Double> Rates = new HashMap<>();
	private LocalDate Exchange_Date = LocalDate.now();
	
	public Currencies() {
		this.addExchange(new Money("DOLAR AMERICANO",1.0,"USD"));
		/*
		this.addExchange(new Money("PESO MEXICANO",18.125700000000002,"MXN"));
		this.addExchange(new Money("PESO COLOMBIANO",4569.49,"COP"));
		*/
	}
	
	public Currencies(List<Money> E_R) {
		this.Exchange_Rates = E_R;
		this.addExchange(new Money("DOLAR AMERICANO",1.0,"USD"));
	}
	
	public List<Money> getExchange_Rates(){
		return this.Exchange_Rates;
	}
	
	public boolean verify_Exchange_Rates(Money money) {
		return this.Exchange_Rates.contains(money);
	}
	
	public void addExchange(Money money) {
		this.Exchange_Rates.add(money);
		this.Rates.put(money.getCode(),money.getDollar_Value());	
	}
	
	
	public Map<String,Double> getRates(){
		return this.Rates;
	}
	
	public Double Exchange(Money From,Money To,Double Value) {
		Double Result;
		
		System.out.println("Valor del "+From.getName()+"-"+From.getDollar_Value());
		System.out.println("Valor del "+To.getName()+"-"+To.getDollar_Value());
		Result=((1/From.getDollar_Value())*(Value))*(To.getDollar_Value());
		
		return Result;
	}
	
	public String getEx_Date() {
		return this.Exchange_Date.toString();
	}
	
	@Override
	public String toString() {
		return ("Exchange Rates-"+this.Exchange_Date+"-Base Dolar"+"\r\n");
	}
	
	
}
