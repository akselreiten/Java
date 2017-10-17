package exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Team implements Comparable<Team> {
		private String name; 
		private int leaguePoints, matchGoals, scoredGoals, goalsAgainst; 

		public Team(String name){
			this.name = name;
		}
		
		/*public String toString(){
			return name + " - " + leaguePoints + " p.";
		}*/
		
		public int getMatchGoals(){
			return matchGoals;
		}
		
		public void addGoals(int scored, int goalsAgainst){
			scoredGoals += scored; 
			this.goalsAgainst += goalsAgainst;
		}
		
		public void printGoals(){
			System.out.println("Goals scored: " + Integer.toString(scoredGoals));
			System.out.println("Goals against: " + Integer.toString(goalsAgainst));
		}
		
		public int getLeaguePoints(){
			return leaguePoints;
		}

		public void setMatchGoals(int num){
			if (num>0){
				matchGoals = num;
			}
		}

		public void addLeaguePoints(int num){
			if (num>0){
			leaguePoints += num;
			}
		}

		public String getName(){
			return name;
		}

		public int compareTo(Team other){
			int diff = other.getLeaguePoints() - this.getLeaguePoints(); 
			if (diff == 0){
				diff = other.scoredGoals - other.goalsAgainst - this.scoredGoals + this.goalsAgainst;
			}
			return diff; //If diff is positive, other will be sorted higher than this)
		}

	} //CLASS Team	
