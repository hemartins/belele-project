package pt.belele.project.resources;

public class TeamFixtureResource extends FixturesResource
{
	LinksResource _links;
	
	public TeamFixtureResource()
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

	public String getSelf()
	{
		return _links.getSelf().getHref();
	}

	public String getTeam()
	{
		return _links.getTeam().getHref();
	}
}
