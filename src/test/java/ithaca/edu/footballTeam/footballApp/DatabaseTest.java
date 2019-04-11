package ithaca.edu.footballTeam.footballApp;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class DatabaseTest {

    private Database resetDatabase() {
        Database database = new Database();

        // Drop all tables in the database
        dropTable("Teams", database);
        dropTable("Games", database);
        dropTable("Goals", database);
        dropTable("Players", database);
        dropTable("PlayersToGoals", database);
        dropTable("Tournaments", database);
        dropTable("Leagues", database);
        dropTable("Cards", database);

        String addTeamsTableQuery =
                "CREATE TABLE Teams (\n" +
                        "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "TeamName varchar(255)\n" +
                        ") ;";
        database.execute(addTeamsTableQuery);

        String addGamesTableQuery =
                "CREATE TABLE Games (\n" +
                        "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "Team1ID INTEGER,\n" +
                        "Team2ID INTEGER,\n" +
                        "LeagueID INTEGER,\n" +
                        "TournamentID INTEGER,\n" +
                        "FOREIGN KEY (Team1ID) REFERENCES Teams(ID),\n" +
                        "FOREIGN KEY (Team2ID) REFERENCES Teams(ID)\n);";
        database.execute(addGamesTableQuery);

        String addPlayersTableQuery =
                "CREATE TABLE Players (\n" +
                        "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "FirstName varchar(255),\n" +
                        "LastName varchar(255),\n" +
                        "TeamID INTEGER,\n" +
                        "FOREIGN KEY (TeamID) REFERENCES Teams(ID)\n" +
                        ");";
        database.execute(addPlayersTableQuery);

        String addGoalsTableQuery =
                "CREATE TABLE Goals (\n" +
                        "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "PlayerID INTEGER NOT NULL,\n" +
                        "FOREIGN KEY (PlayerID) REFERENCES Players(ID)\n" +
                        ");";
        database.execute(addGoalsTableQuery);

        String addPlayersToGoals =
                "CREATE TABLE PlayersToGoals (\n" +
                        "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "PlayerID INTEGER NOT NULL,\n" +
                        "GoalID INTEGER NOT NULL,\n" +
                        "FOREIGN KEY (PlayerID) REFERENCES Players(ID),\n" +
                        "FOREIGN KEY (GoalID) REFERENCES Goals(ID)\n" +
                        ");";
        database.execute(addPlayersToGoals);

        String addTournamentsTable =
                "CREATE TABLE Tournaments (\n" +
                        "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "TournamentName varchar(255)\n" +
                        ");";
        database.execute(addTournamentsTable);

        String addLeaguesTable =
                "CREATE TABLE Leagues (\n" +
                        "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "LeagueName varchar(255)\n" +
                        ");";
        database.execute(addLeaguesTable);

        String addCardsTable =
                "CREATE TABLE Cards (\n" +
                        "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "Reason varchar(255),\n" +
                        "GameID INTEGER NOT NULL,\n" +
                        "Type INTEGER NOT NULL,\n" +
                        "PlayerID INTEGER NOT NULL,\n" +
                        ");";
        database.execute(addCardsTable);

        // Insert 11 Players
        for(int i=0; i<11; i++) {
            String playerIndex = Integer.toString(i);
            String addPlayer =
                    "INSERT INTO Players\n" +
                            "(ID, FirstName, LastName, TeamID)" +
                            "VALUES(" +
                             playerIndex+", " +
                            "'firstName"+playerIndex+"', " +
                            "'lastName"+playerIndex+"', " +
                            "0);";
            database.execute(addPlayer);
        }

        return database;
    }

    void dropTable(String table, Database database) {
        String query = "DROP TABLE IF EXISTS " + table + ";";
        database.execute(query);
    }

    @Test
    void QueryTest() {
        Database database = new Database();
        resetDatabase();

        ResultSet rs = database.query("SELECT * FROM Players");
        System.out.println("rs: " + rs);
        List<Player> result = new ArrayList<>();
        int i = 0;
        try {
            //ResultSetMetaData metaData = rs.getMetaData();
            //int numOfColumns = metaData.getColumnCount();
            while (rs.next()) {
                Assert.assertEquals(Integer.toString(i), rs.getString("ID"));
                Assert.assertEquals("firstName"+i, rs.getString("FirstName"));
                Assert.assertEquals("lastName"+i, rs.getString("LastName"));
                Assert.assertEquals("0", rs.getString("TeamID"));
                i++;
            }
            Assert.assertEquals(i, 11);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
