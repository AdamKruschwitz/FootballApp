package ithaca.edu.footballTeam.footballApp;

import java.io.*;
import java.util.Scanner;


public class ReadingAndWritingIO {


    /**
     * Elvis Okumu
     * Comp311000 sp19
     * This IO file that contains all the methods to make reading to and writing from a file or the console easier
     */

    public String getUserInput() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String input = myObj.nextLine();  // Read user input
        return input;
    }

    public void printToConsole(String input){
        System.out.println(input);
    }


}
