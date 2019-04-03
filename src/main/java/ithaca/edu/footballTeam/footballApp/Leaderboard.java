package ithaca.edu.footballTeam.footballApp;

import java.util.*;


public class Leaderboard {
    //variables
    private HashMap leaderBoard = new HashMap<String,Integer>();


    /**
     * @Hashmaps generate a constructor
     */
    //constructors
    public Leaderboard(List<Team> ){
        hs = new HashMap<String,Integer>();
//        hs.put("teamA", 42);
//        hs.put("teamB", 60);
//        hs.put("teamC", 55);
//        hs.put("teamD", 9);
    }

    //Methods

    /**
     * @return Sorted Hashmaps
     */
    public String leaderboard(){

        String toString = "";
        Map<String,Integer> hsBoard = new HashMap<String,Integer>();
//        hs.put("teamA", new Integer(42));
//        hs.put("teamB", new Integer(60));
//        hs.put("teamC", new Integer(55));
//        hs.put("teamD", new Integer(9));



        for (Map.Entry<String,Integer> entry : hsBoard.entrySet()){
            System.out.println("Team: " + entry.getKey() + " Points: " + entry.getValue());
            //toString = "Team name: " + entry.getKey() + " Points: " + entry.getValue();
        }
        Map<String, Integer> sortedMap = sortByValue(hsBoard); // sorts map
        return toString;
    }

    private Map<String, Integer> sortByValue(Map<String, Integer> hsBoard) {
        Map<String, Integer> sortedMap = sortByValue(hsBoard); // sorts map
        //arraylist put hashmaps inside
//        String[] teamsList = { "teamA","teamB","teamC","teamD" };
        String[] sortedList = {};




        //teamsList = hsBoard;
        return sortedMap;
    }

}
