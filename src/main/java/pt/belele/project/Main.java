package pt.belele.project;

import javax.ws.rs.core.MediaType;

import pt.belele.project.data.TeamResource;
import pt.belele.project.util.HttpUtil;
import ch.halarious.core.HalDeserializer;
import ch.halarious.core.HalExclusionStrategy;
import ch.halarious.core.HalResource;
import ch.halarious.core.HalSerializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main
{

	public static void main(String[] args)
	{
		Gson gson;
		GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(HalResource.class, new HalSerializer());
        builder.registerTypeAdapter(HalResource.class, new HalDeserializer(TeamResource.class));
        builder.setExclusionStrategies(new HalExclusionStrategy());
        gson = builder.create();
        
		String json = HttpUtil.doGet("http://api.football-data.org/alpha/teams/5", null, MediaType.APPLICATION_JSON_TYPE);
		TeamResource team = (TeamResource) gson.fromJson(json, HalResource.class);
		System.out.println("JSON: " + json +"\nTEAM: " + team);
	}

}
