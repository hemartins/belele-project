package pt.belele.project.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class HttpUtil
{
	public static String doGet(String endpoint, MultivaluedMap<String, Object> headers, MediaType mediaType)//, Class<?> objectClass)
	{
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(endpoint);
		Response response = target.request().accept(mediaType).headers(headers).get();
		
		if(response.getStatus()/100!=2)
			System.out.println("HTTP GET TO " + endpoint + " RETURNED " + response.getStatus());
		
		String obj = response.readEntity(String.class);
		
		response.close();
		
		return obj;
	}

//	public static String doPut()
//	{
//
//	}
//
//	public static String doPost()
//	{
//
//	}
}
