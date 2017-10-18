package exams;

public class MatchResult {

	public final Team hometeam, awayteam; 

	public MatchResult(Team hometeam, Team awayteam){
		this.hometeam = hometeam; 
		this.awayteam = awayteam;
	}

	public String toString(){
		return hometeam.getName() + "-" + awayteam.getName() + ": " + hometeam.getMatchGoals() + "-" + awayteam.getMatchGoals(); 
	}

	public int getGoals(Team team){
		if (isParticipant(team)){
			return team.getMatchGoals();
		} else {
			throw new IllegalArgumentException("Hey");
		}
	}

	public void setGoals(Team team, int goals){
		if (isParticipant(team)){
			team.setMatchGoals(goals);
			
			if (team == hometeam){
				hometeam.addGoals(goals, 0);
				awayteam.addGoals(0, goals);
			} else if (team == awayteam){
				awayteam.addGoals(goals, 0);
				hometeam.addGoals(0, goals);
			}
			
		}
	}

	public int getScore(){
		return getGoals(hometeam) - getGoals(awayteam); 
	}

	public boolean isParticipant(Team team){
		return (team == hometeam || team == awayteam);
	}

	public boolean isDraw(){
		return (getScore() == 0);
	}

	public boolean isWinner(Team team){
		return (team == hometeam && getScore() > 0 || team == awayteam && getScore() < 0);

	}
	
}
