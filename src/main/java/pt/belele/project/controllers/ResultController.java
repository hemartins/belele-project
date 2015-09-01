package pt.belele.project.controllers;


public class ResultController {
//	private ResultDAO resultDAO;
//
//	public ResultController() {
//		resultDAO = new ResultDAO();
//	}
//
//	public Result createResult(Fixture f, String fullTimeHome,
//			String fullTimeAway, String halfTimeHome, String halfTimeAway) {
//
//		if (fullTimeHome == null || fullTimeAway == null
//				|| halfTimeHome == null || halfTimeAway == null) {
//			return null;
//		}
//
//		if (fullTimeHome.isEmpty() || fullTimeAway.isEmpty()
//				|| halfTimeHome.isEmpty() || halfTimeAway.isEmpty()) {
//			return null;
//		}
//
//		try {
//			Result r = resultDAO.findByFixtureId(f.getId());
//
//			r.setFullTimeAwayTeamGoals(Integer.valueOf(fullTimeAway));
//			r.setFullTimeHomeTeamGoals(Integer.valueOf(fullTimeAway));
//			r.setHalfTimeAwayTeamGoals(Integer.valueOf(fullTimeAway));
//			r.setHalfTimeHomeTeamGoals(Integer.valueOf(fullTimeAway));
//
//			resultDAO.update(r);
//		} catch (NoResultException e) {
//			resultDAO.insert(new Result(Integer.valueOf(fullTimeHome), Integer
//					.valueOf(fullTimeAway), Integer.valueOf(halfTimeHome),
//					Integer.valueOf(halfTimeAway), f));
//
//			f.setStatus(Fixture.FixtureStatus.FINISHED);
//		}
//
//		Result res = resultDAO.findByFixtureId(f.getId());
//		f.setResult(res);
//
//		return res;
//	}
}
