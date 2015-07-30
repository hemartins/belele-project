package pt.belele.project.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class HttpUtil
{
	public static String TOKEN = "f09705f2d2a04e5a91cdf1e8a7bf978b";

	public static Object doGet(String endpoint, Class<?> objectClass)
	{
		System.out.println("GETTING " + endpoint);
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(endpoint);
		Response response = target.request().accept(MediaType.APPLICATION_JSON).header("X-Auth-Token", TOKEN).get();

		if (response.getStatus() / 100 != 2)
		{
			if (response.getStatus() == 429)
			{
				try
				{
					System.out.println("TOO MANY REQUESTS! WAITING 60s");
					Thread.sleep(60000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				response.close();
				return doGet(endpoint, objectClass);
			}
			response.close();
			System.out.println("HTTP GET TO " + endpoint + " RETURNED " + response.getStatus());
		}

		Object json = response.readEntity(objectClass);

		System.out.println("GOT RESPONSE: " + json);

		response.close();

		return json;
	}

	public static Object doGet(String endpoint, Class<?> objectClass, MultivaluedMap<String, Object> queryParams)
	{
		System.out.println("GETTING " +  endpoint);
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(endpoint).queryParams(queryParams);
		Response response = target.request().accept(MediaType.APPLICATION_JSON).header("X-Auth-Token", TOKEN).get();

		if (response.getStatus() / 100 != 2)
		{
			if (response.getStatus() == 429)
			{
				try
				{
					System.out.println("TOO MANY REQUESTS! WAITING 60s");
					Thread.sleep(60000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				response.close();
				return doGet(endpoint, objectClass, queryParams);
			}
			response.close();
			System.out.println("HTTP GET TO " + endpoint + " RETURNED " + response.getStatus());
		}
		Object json = response.readEntity(objectClass);

		System.out.println("GOT RESPONSE: " + json);

		response.close();

		return json;
	}

	// public static String doPut()
	// {
	//
	// }
	//
	// public static String doPost()
	// {
	//
	// }
}
