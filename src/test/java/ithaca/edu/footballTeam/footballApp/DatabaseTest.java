package ithaca.edu.footballTeam.footballApp;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class DatabaseTest {

    private Database resetDatabase() {
        Database database = new Database();

        // Drop all tables in the database
        database.query(
                "SET @tables = NULL;\n" +
                "SELECT GROUP_CONCAT('`', table_schema, '`.`', table_name,'`') INTO @tables FROM information_schema.tables \n" +
                "  WHERE table_schema = 'myDatabase' AND table_name LIKE BINARY 'del%';\n" +
                "\n" +
                "SET @tables = CONCAT('DROP TABLE ', @tables);\n" +
                "PREPARE stmt1 FROM @tables;\n" +
                "EXECUTE stmt1;\n" +
                "DEALLOCATE PREPARE stmt1;"
        );

        String addTeamsTableQuery =
                "CREATE TABLE Teams (\n" +
                        "ID int NOT NULL\n" +
                        "TeamName varchar(255)\n" +
                        "PRIMARY KEY (ID)\n" +
                        ") ;";
        database.query(addTeamsTableQuery);

        String addGamesTableQuery =
                "CREATE TABLE Games (\n" +
                        "ID int NOT NULL\n" +
                        "Team1ID int\n" +
                        "Team2ID int\n" +
                        "PRIMARY KEY (ID)\n" +
                        "FOREIGN KEY (Team1ID) REFERENCES Teams(ID)\n" +
                        "FOREIGN KEY (Team2ID) REFERENCES Teams(ID)\n) ;";
        database.query(addGamesTableQuery);

        String addPlayersTableQuery =
                "CREATE TABLE Players (\n" +
                        "ID int NOT NULL\n" +
                        "FirstName varchar(255)\n" +
                        "lastName varchar(255)\n" +
                        "TeamID int\n" +
                        "PRIMARY KEY (ID)\n" +
                        "FOREIGN KEY (TeamID) REFERENCES Teams(ID)\n" +
                        ") ;";

        String addGoalsTableQuery =
                "CREATE TABLE Goals (\n" +
                        "ID int NOT NULL\n" +
                        "PlayerID int NOT NULL\n" +
                        "PRIMARY KEY (ID)\n" +
                        "FOREIGN KEY (PlayerID) REFERENCES Players(ID)\n" +
                        ") ;";
        database.query(addGoalsTableQuery);

        String addPlayersToGoals =
                "CREATE TABLE PlayersToGoals (\n" +
                        "ID int NOT NULL\n" +
                        "PlayerID int NOT NULL\n" +
                        "GoalID int NOT NULL\n" +
                        "PRIMARY KEY (ID)\n" +
                        "FOREIGN KEY (PlayerID) REFERENCES Players(ID)\n" +
                        "FOREIGN KEY (GoalID) REFERENCES Goals(ID)\n" +
                        ") ;";
        database.query(addPlayersToGoals);

        String addTournamentsTable =
                "CREATE TABLE Tournaments (\n" +
                        "ID int NOT NULL" +
                        "TournamentName varchar(255)\n" +
                        "PRIMARY KEY (ID)\n" +
                        ") ;";
        database.query(addTournamentsTable);

        for(int i=0; i<11; i++) {
            String playerIndex = Integer.toString(i);
            String addPlayer =
                    "INSERT INTO Players\n" +
                            "VALUES(" +
                             playerIndex+", " +
                            "firstName"+playerIndex+", " +
                            "lastName"+playerIndex+", " +
                            "0) ;";
            database.query(addPlayer);
        }

        return database;
    }

    @Test
    void QueryTest() {
        Database database = new Database();
        resetDatabase();

        ResultSet rs = database.query("SELECT * FROM PLAYER");
        List<Player> result = new ArrayList<>();
        int i = 1;
        try {
            while (rs.next()) {
                System.out.println(rs.getString(i++));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
