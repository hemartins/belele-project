package pt.belele.project.resources;

public class SeasonsResource
{
	private SeasonResource[] seasons;

	public SeasonsResource()
	{

	}

	public SeasonResource[] getSeasons()
	{
		return seasons;
	}

	public void setSeasons(SeasonResource[] seasons)
	{
		this.seasons = seasons;
	}
}
