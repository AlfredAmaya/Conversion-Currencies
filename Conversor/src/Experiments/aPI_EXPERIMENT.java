package Experiments;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.time.Duration;
import java.util.Optional;

public class aPI_EXPERIMENT {
	public static void main(String[] args) {
		String from="USD";
		String to="MXN";
		Optional<Duration> dur = Optional.empty();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://currency-exchange.p.rapidapi.com/exchange?from="+from+"&to="+to+"&q=1.0"))
				.header("X-RapidAPI-Key", "bf7550d5e9mshb0da36ae4001295p16bf1ejsn897eb10a9608")
				.header("X-RapidAPI-Host", "currency-exchange.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		request.timeout();
		HttpResponse<String> response=null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println(response.body());
		}
		
		
	}
}
