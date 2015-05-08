package pt.belele.project.data;

import org.joda.time.DateTime;

import pt.belele.project.enums.FixtureStatus;
import ch.halarious.core.HalLink;
import ch.halarious.core.HalResource;

public class FixtureResource implements HalResource
{
	@HalLink
	private String self;
	
	@HalLink
	private String soccerseason;
	
	@HalLink
	private String homeTeam;
	
	@HalLink
	private String awayTeam;
	
	private DateTime date;
	
	private FixtureStatus status;
	
	private Integer matchday;
	
	private String homeTeamName;
	
	private String awayTeamName;
	
	private Result result;
}
