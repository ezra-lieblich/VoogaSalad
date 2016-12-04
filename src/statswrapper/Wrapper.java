package statswrapper;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;

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
		/*
		HttpURLConnection connection = null;  
		class WrapperData {
			String username;
			String password;
			
			public WrapperData(String user, String pass){
				this.username = user;
				this.password = pass;
			}
		}

		WrapperData data = new WrapperData(username, password);
		///First, all the GSON/JSon stuff up front
        Gson gson = new Gson();
        //convert java object to JSON format
        String json = gson.toJson(data);
        try {
		//Create connection
        URL url = new URL(baseURL + endpoint);
        String urlParameters = "stuff="+URLEncoder.encode(json, "UTF-8");

        connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");

        connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
        connection.setRequestProperty("Content-Language", "en-US");  

        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        //Send request
        DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
        wr.writeBytes (urlParameters);
        wr.flush ();
        wr.close ();
        }catch (Exception e) {
            e.printStackTrace();
            //return null;
        }
        */
		/*
		class WrapperData {
			String username;
			String password;
			
			public WrapperData(String user, String pass){
				this.username = user;
				this.password = pass;
			}
		}

		WrapperData data = new WrapperData(username, password);
		String       postUrl       = baseURL + endpoint;// put in your url
		Gson         gson          = new Gson();
		HttpClient   httpClient    = HttpClientBuilder.create().build();
		HttpPost     post          = new HttpPost(postUrl);
		StringEntity postingString = new StringEntity(gson.toJson(data));//gson.tojson() converts your pojo to json
		System.out.println("posting string: "+postingString);
		post.setEntity(postingString);
		post.setHeader("Content-Type", "application/json");
		HttpResponse  response = httpClient.execute(post);
		*/
		
		final URL url = new URL(baseURL + endpoint);
		final URLConnection urlConnection = url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		urlConnection.connect();
		final OutputStream outputStream = urlConnection.getOutputStream();
		outputStream.write(("{\"username\": \"" + username + "\",\"password\":\""+password+"\"}").getBytes("UTF-8"));
		outputStream.flush();
		final InputStream inputStream = urlConnection.getInputStream();
		
	/*
		String urlParameters  = "username="+username+"&password="+password;
		String json = "{\"username\":"+username+", \"password\":"+password+"}";
		System.out.println(json);
		HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 

	    try {
	        HttpPost request = new HttpPost(baseURL+endpoint);
	        StringEntity params =new StringEntity("details={\"username\":\"myname\", \"password\":\"20\"}");
	        System.out.println(params);
	        request.addHeader("content-type", "application/x-www-form-urlencoded");
	        request.setEntity(params);
	        HttpResponse response = httpClient.execute(request);

	        // handle response here...
	    }catch (Exception ex) {
	    	System.out.println(ex);
	        // handle exception here
	    } finally {
	        httpClient.getConnectionManager().shutdown(); //Deprecated
	    }
	    */
	    
	    /*
		---------------
		byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
		int    postDataLength = postData.length;
		URL url = new URL(baseURL+endpoint);
		  HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
	
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
		  */
	}
}
