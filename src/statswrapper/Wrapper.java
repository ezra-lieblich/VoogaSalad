package statswrapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
 

public class Wrapper {
	
	private final String baseURL = "http://voogasquad.herokuapp.com/";

	public void addStates(String endpoint) {
		Client client = ClientBuilder.newClient();
		Response response = client.target(baseURL + endpoint)
				.request(MediaType.TEXT_PLAIN_TYPE).get();
	}
	
	public void login(String username, String password){
		
	}
	
	public void createAccount(String username, String password) throws IOException{
		String endpoint = "createaccount";//?username="+username+"&password="+password;
		String urlParameters  = "username="+username+"&password="+password;
		String json = "{\"username\":"+username+", \"password\":"+password+"}";
		byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
		int    postDataLength = postData.length;
		URL url = new URL(baseURL+endpoint);
		  HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		  /*
		  httpCon.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
		  */
		  httpCon.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		  httpCon.setDoOutput(true);
		  httpCon.setRequestMethod("POST");
		  //httpCon.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
		  
		  //httpCon.getOutputStream().write(urlParameters.getBytes("UTF-8"));
		  
		  OutputStream os = httpCon.getOutputStream();
          os.write(json.getBytes("UTF-8"));
          os.close();
          
		  OutputStreamWriter out = new OutputStreamWriter(
		      httpCon.getOutputStream());
		  System.out.println(httpCon.getResponseCode());
		  System.out.println(httpCon.getResponseMessage());
		  out.close();
	}
}
