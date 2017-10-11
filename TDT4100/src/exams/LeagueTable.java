package exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LeagueTable{

	private final List<Team> teams;
	private List<MatchResult> matches = new ArrayList<MatchResult>(); 
	private List<Team> leagueTable = new ArrayList<Team>(); 

	public LeagueTable(List<Team> teams){
		this.teams = new ArrayList<Team>(teams); 
		leagueTable.addAll(teams); 
	}

	public String toString(){
		String outstr = "League table 2017\n"; 
		int num = 1;
		for (Team t : leagueTable){
			outstr += Integer.toString(num) + ". " + t.getName() + " - " + Integer.toString(t.getLeaguePoints()) + "points \n";
			num++;
		}
		return outstr;
	}
	
	public List<MatchResult> getMatches(){
		return matches;
	}

	public void addMatch(MatchResult result){
		if (!(teams.contains(result.hometeam)) || !(teams.contains(result.awayteam))) {
			throw new IllegalArgumentException("One or both teams don't exist in the league.");
		}

		matches.add(result);

		if (result.isWinner(result.hometeam)){
			result.hometeam.addLeaguePoints(3); 
		} else if (result.isWinner(result.awayteam)){
			result.awayteam.addLeaguePoints(3); 
		} else if (result.isDraw()){
			result.hometeam.addLeaguePoints(1); 
			result.awayteam.addLeaguePoints(1); 
		}
		updateLeagueTable();
	}

	public void updateLeagueTable(){
		Collections.sort(leagueTable);
	}

	public List<String> getTeamNames(){
		List<String> teamNames = new ArrayList<String>(); 
		for (Team t : teams){
			teamNames.add(t.getName()); 
		}
		return teamNames; 
	}

	public int getParticipantPoints(MatchResult result, Team team){
		if (result.isParticipant(team)){
			if (result.isWinner(team)){
				return 3; 
			} else if (result.isDraw()){
				return 1; 
			} 
			return 0;
		} else {
			throw new IllegalArgumentException(team + " did not play this match. Enter valid team.");
		}
	}
	
	public static void main(String[] args) {
		/*
		List<Team> teams = new ArrayList<Team>();
		Team rosenborg = new Team("Rosenborg"); Team molde = new Team("Molde");	Team lyn = new Team("Lyn");
		teams.add(rosenborg); teams.add(molde); teams.add(lyn);
		
		LeagueTable league = new LeagueTable(teams); 
		MatchResult game1 = new MatchResult(molde, rosenborg);
		game1.setGoals(molde, 20); game1.setGoals(rosenborg, 1);
		MatchResult game2 = new MatchResult(lyn, molde);
		game2.setGoals(lyn, 4); game2.setGoals(molde, 4);
		league.addMatch(game1); league.addMatch(game2); 
		
		MatchResult game3 = new MatchResult(lyn,rosenborg);
		game3.setGoals(lyn,10); game3.setGoals(rosenborg,4);
		league.addMatch(game3);
		System.out.println(league);
		
		molde.printGoals();
		*/
		
		String test = "12-34-150";
		System.out.println(test);
		String[] split = test.split("-");
		
		for (int i=0; i<split.length; i++){
			for (int j=0; j<split[i].length(); j++){
				char c = split[i].charAt(j);
				System.out.println(c);
				if (Character.isDigit(c)){
					System.out.println("true");
				}
			}
		}
		
	}

}
