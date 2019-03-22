package ithaca.edu.footballTeam.footballApp;

import java.util.*;

public class FootballMain {

    public static void runApp(){
        String command = "";
        ReadingAndWritingIO io = new ReadingAndWritingIO();
        while (command.equals("exit") != true) {
            io.printToConsole("Please enter a command or enter Help for a list of commands");
            command = io.getUserInput();
            execution(command);

        }

    }

    public static void runRound(){

    }


    public static void helpCommand(){
        ReadingAndWritingIO io = new ReadingAndWritingIO();
        io.printToConsole("Here is a list of commands");
        io.printToConsole("run tournament");
    }

    public static void execution(String command){
        Map<String, Integer> leaderBoard = new HashMap<String, Integer>();
        ReadingAndWritingIO io = new ReadingAndWritingIO();
        List<Team> winners = new ArrayList<Team>();


        if(command.equals("help") || command.equals("Help")){
              helpCommand();
        }
        else if(command.equals("show schedule")){
            //to do for showing a schedule
        }
        else if(command.equals("run tournament")){
            Roster validRoster = new Roster(true);


            Team team1 = new Team(validRoster, "Manchester U");
            Team team2 = new Team(validRoster, "Manchester city");
            Team team3 = new Team(validRoster, "Barcelona");
            Team team4 = new Team(validRoster, "Kenya FC");



            leaderBoard.put(team1.getTeamName(), 0);
            leaderBoard.put(team2.getTeamName(), 0);
            leaderBoard.put(team3.getTeamName(), 0);
            leaderBoard.put(team4.getTeamName(), 0);

            int matchAmount = 3;
            int currentMatchAmount = 0;

            Match match = new Match(team1, team2, 1);
            io.printToConsole("Round 1");
            io.printToConsole("Select winner between "+ team1.getTeamName() + " " + " and " + team2.getTeamName());
            String teamName = io.getUserInput();

            Team winner1;
            if(teamName.equals(team1.getTeamName())){
                winner1 = team1;
                leaderBoard.put(team1.getTeamName(),1);

            }
            else{
                winner1 = team2;
                leaderBoard.put(team2.getTeamName(),1);
            }
            io.printToConsole("Round 2");
            io.printToConsole("Select winner between "+ team3.getTeamName() + " " + " and " + team4.getTeamName());
            teamName = io.getUserInput();

            Team winner2;
            if(teamName.equals(team3.getTeamName())){
                winner2 = team3;
                leaderBoard.put(team3.getTeamName(),1);

            }
            else{
                winner2 = team4;
                leaderBoard.put(team4.getTeamName(),1);
            }

            io.printToConsole("Round 3");
            io.printToConsole("Select winner between "+ winner1.getTeamName() + " " + " and " + winner2.getTeamName());
            teamName = io.getUserInput();
            Team grandWinner;
            if(teamName.equals(winner1.getTeamName())){
                grandWinner = winner1;
                leaderBoard.put(winner1.getTeamName(),1);

            }
            else{
                grandWinner = winner2;
                leaderBoard.put(winner2.getTeamName(),1);
            }
            io.printToConsole("Your champion is " + grandWinner.getTeamName());










        }
        else if(command.equals("show leader board")){
            // to do for showing the current standings

        }




    }

    public static void main(String[] args){
        runApp();



    }
}
