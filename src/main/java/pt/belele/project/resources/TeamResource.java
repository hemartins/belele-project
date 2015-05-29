package pt.belele.project.resources;

public class TeamResource
{
	private LinksResource _links;

	private String name;

	private String code;

	private String shortName;

	private String squadMarketValue;

	private String crestUrl;

	public TeamResource()
	{

	}

	public LinksResource get_links()
	{
		return _links;
	}

	public void set_links(LinksResource _links)
	{
		this._links = _links;
	}

	public String getFixtures()
	{
		return _links.getFixtures().getHref();
	}

	// public String getPlayers()
	// {
	// return players;
	// }

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
