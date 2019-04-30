package ithaca.edu.footballTeam.footballApp;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    Connection c = null;

    public Database() {

        try {
            // load the sqlite-JDBC driver using the current class loader
            Class.forName("org.sqlite.JDBC");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //sSystem.out.println(c);
    }

    /**
     * Run an SQL query on the database and return the result set.
     * NOTE: Must be used with query that returns ResultSet. If no result set is expected, use execute instead
     * @param query
     * @return resultSet
     */
    ResultSet query(String query) {
        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = c.createStatement();
            rs = statement.executeQuery(query);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    /**
     * Run an SQL query on the database with no return
     * @param query
     */
    void execute(String query) {
        Statement statement = null;

        try {
            statement = c.createStatement();
            statement.execute(query);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    ResultSet searchGamesByPlayerName(String firstname, String lastname) {
        //join Games and Players where games.team1ID = Players.teamID
        // and Players.FirstName = firstname
        // and Players.LastName = lastname

        String query =
                "SELECT Games.ID, Games.Team1ID, Games.Team2ID, Players.FirstName, Players.LastName FROM\n" +
                        "Games INNER JOIN Players ON (Games.Team1ID = Players.TeamID OR Games.Team2ID = Players.TeamID) WHERE " +
                        "Players.FirstName = \"" + firstname + "\"\n" +
                        "AND Players.LastName = \"" + lastname + "\"";
        return query(query);
    }

    /**
     * Returns the result set of all players in given team
     * @param teamname
     * @return ResultSet
     */
    ResultSet searchPlayersByTeam(String teamname) {
        // Select Players.FirstName, Players.LastName from Players INNER JOIN Teams ON Players.TeamID = Teams.ID
        // WHERE Teams.TeamName = teamname;
        return null;
    }

    public static void main(String[] args) {
        Database db = new Database();
    }
}
