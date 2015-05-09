package pt.belele.project.resources;

import ch.halarious.core.HalBaseResource;
import ch.halarious.core.HalLink;

public class TeamResource extends HalBaseResource
{
	@HalLink
	private String fixtures;

	@HalLink
	private String players;

	private String name;

	private String code;

	private String shortName;

	private String squadMarketValue;

	private String crestUrl;

	public String getFixtures()
	{
		return fixtures;
	}

	public void setFixtures(String fixtures)
	{
		this.fixtures = fixtures;
	}

	public String getPlayers()
	{
		return players;
	}

	public void setPlayers(String players)
	{
		this.players = players;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getShortName()
	{
		return shortName;
	}

	public void setShortName(String shortName)
	{
		this.shortName = shortName;
	}

	public String getSquadMarketValue()
	{
		return squadMarketValue;
	}

	public void setSquadMarketValue(String squadMarketValue)
	{
		this.squadMarketValue = squadMarketValue;
	}

	public String getCrestUrl()
	{
		return crestUrl;
	}

	public void setCrestUrl(String crestUrl)
	{
		this.crestUrl = crestUrl;
	}
}
