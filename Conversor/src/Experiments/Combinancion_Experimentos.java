package Experiments;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.Comparator;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Combinancion_Experimentos {
	public static void main(String[] args) {
		String from="USD";
		
		Set<Currency> Curren = new  HashSet<>();
		Curren = Currency.getAvailableCurrencies();
			
		Curren.stream().forEach(Act_curr -> {
			
			System.out.println("("+Act_curr.getDisplayName().toUpperCase()+")");
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
			System.out.println(response.body());
			
		} catch (IOException e) {
			System.out.println("-");
			
		}
		catch (InterruptedException e) {
			System.out.println("No encontrado");
		}
		
		});
	}
}
