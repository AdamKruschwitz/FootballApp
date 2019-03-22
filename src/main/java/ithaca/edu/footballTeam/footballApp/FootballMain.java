package ithaca.edu.footballTeam.footballApp;

public class FootballMain {

    public static void runApp(){
        String command = "";
        ReadingAndWritingIO io = new ReadingAndWritingIO();
        while (command.equals("exit") != true) {
            io.printToConsole("Please enter a command or enter Help for a list of commands");
            command = io.getUserInput();

        }

    }

    public static void runRound(){

    }


    public static void helpCommand(){
        ReadingAndWritingIO io = new ReadingAndWritingIO();
        io.printToConsole("Here is a list of commands");
        io.printToConsole("run tournament");
        io.printToConsole("show leader board");
    }

    public static void execution(String command){
        if(command.equals("help")){
              helpCommand();
        }
        else if(command.equals("show schedule")){
            //to do for showing a schedule
        }
        else if(command.equals("run tournament")){
            // to do for running all the matches in a schedule
            // setting up a schedule
            // selecting the first round
            // allowing the user to select a winner of the  round
            // advancing the winners  to next round
            // repeat until a final winner is declared
        }
        else if(command.equals("show leader board")){
            // to do for showing the current standings

        }




    }

    public static void main(String[] args){
        runApp();



    }
}
