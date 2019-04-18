package ithaca.edu.footballTeam.footballApp;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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

        return database;
    }

    void dropTable(String table, Database database) {
        String query = "DROP TABLE IF EXISTS " + table + ";";
        database.execute(query);
    }


    @Test
    void QueryTest() {
        Database database = resetDatabase();

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

    @Test
    void searchGamesByPlayerNameTest() throws SQLException {
        Database database = resetDatabase();

        database.execute(
                "INSERT INTO Games \n" +
                        "(Team1ID, Team2ID)\n" +
                        "VALUES(\n" +
                        "0, 1);"
        );

        database.execute(
                "INSERT INTO Games \n" +
                        "(Team1ID, Team2ID)\n" +
                        "VALUES(\n" +
                        "0, 2);"
        );

        database.execute(
                "INSERT INTO Games \n" +
                        "(Team1ID, Team2ID)\n" +
                        "VALUES(\n" +
                        "2, 1);"
        );

        database.execute(
                "INSERT INTO Players\n" +
                        "(ID, FirstName, LastName, TeamID)" +
                        "VALUES(" +
                        "0, " +
                        "'Al', " +
                        "'Perialis', " +
                        "0);"
        );

        database.execute(
                "INSERT INTO Players\n" +
                        "(ID, FirstName, LastName, TeamID)" +
                        "VALUES(" +
                        "1, " +
                        "'Danny', " +
                        "'Yowzers', " +
                        "0);"
        );

        database.execute(
                "INSERT INTO Players\n" +
                        "(ID, FirstName, LastName, TeamID)" +
                        "VALUES(" +
                        "2, " +
                        "'Adam', " +
                        "'Danger', " +
                        "1);"
        );

        database.execute(
                "INSERT INTO Players\n" +
                        "(ID, FirstName, LastName, TeamID)" +
                        "VALUES(" +
                        "3, " +
                        "'Killson', " +
                        "'Warmurder', " +
                        "1);"
        );

        database.execute(
                "INSERT INTO Players\n" +
                        "(ID, FirstName, LastName, TeamID)" +
                        "VALUES(" +
                        "4, " +
                        "'Bud', " +
                        "'Friendguy', " +
                        "2);"
        );

        database.execute(
                "INSERT INTO Players\n" +
                        "(ID, FirstName, LastName, TeamID)" +
                        "VALUES(" +
                        "5, " +
                        "'Super', " +
                        "'Man', " +
                        "2);"
        );

        database.execute(
                "INSERT INTO Players\n" +
                        "(ID, FirstName, LastName, TeamID)" +
                        "VALUES(" +
                        "5, " +
                        "'Bench', " +
                        "'Warmer', " +
                        "3);"
        );

        database.execute(
                "INSERT INTO Players\n" +
                        "(ID, FirstName, LastName, TeamID)" +
                        "VALUES(" +
                        "5, " +
                        "'Lone', " +
                        "'Wolf', " +
                        "NULL);"
        );

        ResultSet rs = database.searchGamesByPlayerName("Killson", "Warmurder");

        // Player has games result
        Assert.assertEquals("0", rs.getString("ID"));
        Assert.assertEquals("0", rs.getString("Team1ID"));
        Assert.assertEquals("1", rs.getString("Team2ID"));

        rs.next();
        Assert.assertEquals("2", rs.getString("ID"));
        Assert.assertEquals("2", rs.getString("Team1ID"));
        Assert.assertEquals("1", rs.getString("Team2ID"));

        Assert.assertFalse(rs.next());

        // Player doesn't exist
        ResultSet rs2 = database.searchGamesByPlayerName("Idont", "Existnow");
        Assert.assertFalse(rs.next());

        // Player exists with no games
        ResultSet rs3 = database.searchGamesByPlayerName("Bench", "Warmer");
        Assert.assertFalse(rs.next());

        // Player exists with no team
        ResultSet rs4 = database.searchGamesByPlayerName("Lone", "Wolf");
        Assert.assertFalse(rs.next());
    }
}
