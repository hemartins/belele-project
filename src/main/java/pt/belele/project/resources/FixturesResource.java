package pt.belele.project.resources;

public class FixturesResource
{
	private Integer count;

	private FixtureResource[] fixtures;

	public FixturesResource()
	{

	}

	public Integer getCount()
	{
		return count;
	}

	public void setCount(Integer count)
	{
		this.count = count;
	}

	public FixtureResource[] getFixtures()
	{
		return fixtures;
	}

	public void setFixtures(FixtureResource[] fixtures)
	{
		this.fixtures = fixtures;
	}
}
