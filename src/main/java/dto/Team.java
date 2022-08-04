package dto;

public class Team implements Comparable<Team>{

    private int scoredGoals;
    private int receivedGoals;
    private String teamName;
    private int score;
    private int wins;
    private int losses;
    private int draws;
    private int matchCount;
    
    public int compareTo(Team t) {
        return score - t.score;
    }
    
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        else if (o instanceof Team) {
            return teamName.equals(((Team)o).teamName);
        }
        else if (o instanceof String) {
            return teamName.equals((String)o);
        }
        return false;
    }
    
    public Team(String teamName) {
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
 
    	return teamName + ",  "+ score + " pts";
    } 
}
