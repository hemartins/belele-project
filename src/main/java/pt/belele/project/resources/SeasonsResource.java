package pt.belele.project.resources;

import java.util.List;

public class SeasonsResource
{
	private List<SeasonResource> seasons;

	public List<SeasonResource> getSeasons()
	{
		return seasons;
	}

	public void setSeasons(List<SeasonResource> seasons)
	{
		this.seasons = seasons;
	}
}