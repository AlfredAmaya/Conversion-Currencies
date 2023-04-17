package Tools;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class API_manager {
	private String From;
	private HttpResponse<String> API_response;
	private HttpRequest API_request;
	
	public API_manager(String from) {
		this.From = from.toUpperCase();
		this.API_response=null;
		this.API_request=null;
	}
	
	public Duration TimeOut_Configuration(int Segundos){
		Duration dur = Duration.between(LocalTime.now(),LocalTime.now().plus(Segundos,ChronoUnit.SECONDS));
		return dur;
	}
	
	public  void Request_Builder(String To,Duration dur){
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://currency-exchange.p.rapidapi.com/exchange?from="+this.From+"&to="+To+"&q=1.0"))
				.header("X-RapidAPI-Key", "bf7550d5e9mshb0da36ae4001295p16bf1ejsn897eb10a9608")
				.header("X-RapidAPI-Host", "currency-exchange.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.timeout(dur)
				.build();
		this.API_request = request;
	}
	
	public void Send_Request() throws Exception{
		 this.API_response = HttpClient.newHttpClient().send(this.API_request, HttpResponse.BodyHandlers.ofString());
	}
	
	public String getBody() {
		return API_response.body();
	}
}

