package edu.ithaca.FootballApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class registerTeamTest {
    public static void main(String[] args) {
        Team EvertonFC = new Team ("EvertonFC","Everton");
        TeamOwner everton = new TeamOwner("Everton");
        Commissioner mainC= new Commissioner ("Admin");
        assertTrue(everton.registerTeam(EvertonFC));
        assertTrue(mainC.approveTeam("EveronFC"));


    }
}
