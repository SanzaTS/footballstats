package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import dto.Football;

public class Statistics {

	public static void main(String[] args) throws FileNotFoundException {
		
		
        File file = new File("FootballResults.txt");
        Scanner scan = new Scanner(file);
        String fileString = "";

        
      
        
        List<Football> teamsArray = new ArrayList<Football>();
        
        while (scan.hasNextLine()) {
            fileString = scan.nextLine();
            String[]match = fileString.split(",");

            if (match.length == 5 && match[0].equals("F")) {
                int team1score = Integer.valueOf(match[3].trim());
                int team2score = Integer.valueOf(match[4].trim());

                // Create a temp team to search the List
                Football team1 = new Football(match[1]);
                // Search the list
                if (!teamsArray.contains(team1)) {
                    // Not in the list already. Add it
                    teamsArray.add(team1);
                }
                else {
                    // Already in the List. Use that one.
                    team1 = teamsArray.get(teamsArray.indexOf(team1));
                }
                // Repeat for team 2
                Football team2 = new Football(match[2]);
                if (!teamsArray.contains(team2)) {
                    teamsArray.add(team2);
                }
                else {
                    team2 = teamsArray.get(teamsArray.indexOf(team2));
                }
                team1.teamValues(team1score, team2score);
                team2.teamValues(team2score, team1score);
            }
        }
        System.out.println("Name                   M   W   D   L   GF    GA   GD   Pts");
        // Sort and print
        
        
        teamsArray
            .stream()
            .sorted(Comparator.reverseOrder())
            .forEach(t -> System.out.println(t));
        
       
        
        scan.close();
	}
	

}
