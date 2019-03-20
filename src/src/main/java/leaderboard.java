package src.main.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Arraylist1{
    public static void leaderboard(String args[]){
        ArrayList<String> teamsList = new ArrayList<String>();
        teamsList.add("Brazil");
        teamsList.add("Jamaica");
        teamsList.add("Argentina");
        teamsList.add("England");
        teamsList.add("Spain");

        System.out.println("Unsorted Arraylist: " + teamsList);

        Collections.sort(teamsList);

        System.out.println("Sorted ArrayList" + "in Descending order: " + teamsList);


    }


}
