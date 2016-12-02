package statswrapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class Wrapper {
	
	private final String baseURL = "http://voogachat.herokuapp.com/";

	public void addStates(String endpoint) {
		Client client = ClientBuilder.newClient();
		Response response = client.target(baseURL + endpoint)
				.request(MediaType.TEXT_PLAIN_TYPE).get();
	}

}
