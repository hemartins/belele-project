package pt.belele.project.resources;

public class SeasonFixtureResource extends FixturesResource
{
	private FixturesLinks[] _links;

	public SeasonFixtureResource()
	{
		
	}
	
	public FixturesLinks[] get_links()
	{
		return _links;
	}

	public void set_links(FixturesLinks[] _links)
	{
		this._links = _links;
	}

	public String getSelf()
	{
		return _links[0].getSelf() != null ? _links[0].getSelf() : _links[1].getSelf();
	}

	public String getSoccerSeason()
	{
		return _links[0].getSoccerseason() != null ? _links[0].getSoccerseason() : _links[1].getSoccerseason();
	}
}
