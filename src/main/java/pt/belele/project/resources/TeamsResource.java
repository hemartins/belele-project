package pt.belele.project.resources;

public class TeamsResource
{
	private TeamsLinks[] _links;

	private Integer count;

	private TeamResource[] teams;

	public TeamsResource()
	{

	}

	public TeamsLinks[] get_links()
	{
		return _links;
	}

	public void set_links(TeamsLinks[] _links)
	{
		this._links = _links;
	}

	public String getSelf()
	{
		return _links[0].getSelf() != null ? _links[0].getSelf() : _links[1].getSelf();
	}

	public String getSoccerseason()
	{
		return _links[0].getSoccerseason() != null ? _links[0].getSoccerseason() : _links[1].getSoccerseason();
	}

	public Integer getCount()
	{
		return count;
	}

	public void setCount(Integer count)
	{
		this.count = count;
	}

	public TeamResource[] getTeams()
	{
		return teams;
	}

	public void setTeams(TeamResource[] teams)
	{
		this.teams = teams;
	}
}
