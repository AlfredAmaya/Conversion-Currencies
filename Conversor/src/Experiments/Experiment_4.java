package Experiments;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

import Currencies.Currencies;
import Currencies.Money;
import Tools.Print_Configuration;

public class Experiment_4 {
	public static void main(String[] args) {
		
		Print_Configuration P_C = new Print_Configuration();
		P_C.Start_Configuration();
		
		String from="USD";
		
		Currencies Currencies1 = new Currencies();
		
		Set<Currency> Curren = new  HashSet<>();
		
		Curren = Currency.getAvailableCurrencies();
		
		
		System.out.println("---------------------------Inicio de Carga-----------------------");	
		Curren.stream().forEach(Act_curr -> {
			
			Duration dur = Duration.between(LocalTime.now(),LocalTime.now().plus(3,ChronoUnit.SECONDS));
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://currency-exchange.p.rapidapi.com/exchange?from="+from+"&to="+Act_curr.getCurrencyCode()+"&q=1.0"))
					.header("X-RapidAPI-Key", "bf7550d5e9mshb0da36ae4001295p16bf1ejsn897eb10a9608")
					.header("X-RapidAPI-Host", "currency-exchange.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.timeout(dur)
					.build();
			HttpResponse<String> response=null;
			
		try {
			
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("("+Act_curr.getDisplayName().toUpperCase()+")"+"-"+"["+Act_curr.getCurrencyCode()+"]");
			System.out.println(response.body());
			
		} catch (IOException e) {
			System.out.println("Error de Entrada");
			
		}
		catch (InterruptedException e) {
			System.out.println("No encontrado");
		}
		
		try {
			if(Double.parseDouble(response.body())!=0.0){				
			Currencies1.addExchange(new Money(
					Act_curr.getDisplayName().toUpperCase(),
					Double.parseDouble(response.body()),
					Act_curr.getCurrencyCode()));
			}
					
		}catch (RuntimeException e) {
			System.out.println("Error de ejecucion");
		}
		
		
		
		
		
		
		});
		System.out.println("---------------------------Fin de Carga-----------------------");
		System.out.println("___________________________Chequeo del mapa______________________");
		
		Currencies1.getRates().entrySet().forEach(curr ->{
			
			System.out.println(curr.getKey()+"-"+curr.getValue());
			
		});
		System.out.println("___________________________Chequeo del mapa______________________");

	}
}
