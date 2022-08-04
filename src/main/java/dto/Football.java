package dto;

import java.util.Formatter;

public class Football implements Comparable<Football>{
    private int scoredGoals;
    private int receivedGoals;
    private String teamName;
    private int score;
    private int wins;
    private int losses;
    private int draws;
    private int matchCount;
    
    public int compareTo(Football f) {
        return score - f.score;
    }
    
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        else if (o instanceof Football) {
            return teamName.equals(((Football)o).teamName);
        }
        else if (o instanceof String) {
            return teamName.equals((String)o);
        }
        return false;
    }
    
    public Football(String teamName) {
        this.teamName = teamName;
    }
    
    public void teamValues(int scoredGoals, int receivedGoals) {
        this.scoredGoals += scoredGoals;
        this.receivedGoals += receivedGoals;
        matchCount++;
        if (scoredGoals < receivedGoals) {
            losses++;
        }
        else if (scoredGoals > receivedGoals) {
            wins++;
            score += 3;
        }
        else {
            draws++;
            score += 1;
        }
    }           

    @SuppressWarnings("resource")
	public String toString() {
    	
    	int goalDiff = scoredGoals - receivedGoals;
        return new Formatter().format("%-20s %3d %3d %3d %3d %4d %4d %4d %4d",
            teamName, matchCount, wins, draws, losses, scoredGoals, receivedGoals,goalDiff, score)
            .toString();
    } 
    
  
}
