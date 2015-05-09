package pt.belele.project.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import ch.halarious.core.HalDeserializer;
import ch.halarious.core.HalExclusionStrategy;
import ch.halarious.core.HalResource;
import ch.halarious.core.HalSerializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HttpUtil
{
	public static String TOKEN = "f09705f2d2a04e5a91cdf1e8a7bf978b";
	
	public static String doSimpleGet(String endpoint, MultivaluedMap<String, Object> queryParams){
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(endpoint).queryParams(queryParams);
		Response response = target.request().accept(MediaType.APPLICATION_JSON).header("X-Auth-Token", TOKEN).get();
		
		if(response.getStatus()/100!=2)
			System.out.println("HTTP GET TO " + endpoint + " RETURNED " + response.getStatus());
		
		String json = response.readEntity(String.class);
		
		System.out.println("GOT RESPONSE: " + json);
		
		response.close();
		
		return json;
	}
	
	public static HalResource doGet(String endpoint, Class<?> objectClass)
	{
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(endpoint);
		Response response = target.request().accept(MediaType.APPLICATION_JSON).header("X-Auth-Token", TOKEN).get();
		
		if(response.getStatus()/100!=2)
			System.out.println("HTTP GET TO " + endpoint + " RETURNED " + response.getStatus());
		
		String json = response.readEntity(String.class);
		
		System.out.println("GOT RESPONSE: " + json);
		
		response.close();
		
		Gson gson;
		GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(HalResource.class, new HalSerializer());
        builder.registerTypeAdapter(HalResource.class, new HalDeserializer(objectClass));
        builder.setExclusionStrategies(new HalExclusionStrategy());
        gson = builder.create();
		
		return gson.fromJson(json, HalResource.class);
	}
	
	public static HalResource doGet(String endpoint, Class<?> objectClass, MultivaluedMap<String, Object> queryParams)
	{
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(endpoint).queryParams(queryParams);
		Response response = target.request().accept(MediaType.APPLICATION_JSON).header("X-Auth-Token", TOKEN).get();
		
		if(response.getStatus()/100!=2)
			System.out.println("HTTP GET TO " + endpoint + " RETURNED " + response.getStatus());
		
		String json = response.readEntity(String.class);
		
		System.out.println("GOT RESPONSE: " + json);
		
		response.close();
		
		Gson gson;
		GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(HalResource.class, new HalSerializer());
        builder.registerTypeAdapter(HalResource.class, new HalDeserializer(objectClass));
        builder.setExclusionStrategies(new HalExclusionStrategy());
        gson = builder.create();
		
		return gson.fromJson(json, HalResource.class);
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
