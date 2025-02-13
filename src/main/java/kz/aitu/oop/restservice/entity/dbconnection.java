package kz.aitu.oop.restservice.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbconnection {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String username = "postgres";
    private final String password = "janerke6"; // Replace with actual password

    public Connection getConnectionToDb() {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
            return con;
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            return null;
        }
    }

    public void setupDatabase() {
        try (Connection con = getConnectionToDb(); Statement st = con.createStatement()) {
            if (con == null) return;

            // Create Players Table
            String createPlayersTable = "CREATE TABLE IF NOT EXISTS players (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(100) NOT NULL, " +
                    "age INT NOT NULL, " +
                    "sport VARCHAR(50) NOT NULL, " +
                    "position VARCHAR(50) NOT NULL)";
            st.executeUpdate(createPlayersTable);

            // Create Sports Clubs Table
            String createSportsClubsTable = "CREATE TABLE IF NOT EXISTS sports_clubs (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(100) NOT NULL, " +
                    "city VARCHAR(100) NOT NULL)";
            st.executeUpdate(createSportsClubsTable);

            System.out.println("Tables created successfully");
        } catch (SQLException e) {
            System.out.println("Error setting up database: " + e.getMessage());
        }
    }

    public void insertSampleData() {
        try (Connection con = getConnectionToDb(); Statement st = con.createStatement()) {
            if (con == null) return;

            // Insert Sample Players
            String insertPlayers = "INSERT INTO players (name, age, sport, position) VALUES " +
                    "('Nurzhan', 18, 'Volleyball', 'Middle Blocker'), " +
                    "('Yerassyl', 18, 'Volleyball', 'Setter'), " +
                    "('Alibek', 19, 'football', 'Goalkeeper')";
            st.executeUpdate(insertPlayers);

            // Insert Sample Sports Clubs
            String insertClubs = "INSERT INTO sports_clubs (name, city) VALUES " +
                    "('Japan National team', 'Tokyo'), " +
                    "('Brazil monsters', 'Rio-de-Janeiro'), " +
                    "('Chicago', 'Texas')";
            st.executeUpdate(insertClubs);

            System.out.println("Sample data inserted successfully");
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }

    public void getPlayers() {
        try (Connection con = getConnectionToDb(); Statement st = con.createStatement()) {
            if (con == null) return;

            ResultSet rs = st.executeQuery("SELECT * FROM players");
            System.out.println("\n Players:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Sport: " + rs.getString("sport") +
                        ", Position: " + rs.getString("position"));
            }
        } catch (SQLException e) {
            System.out.println(" Error retrieving players: " + e.getMessage());
        }
    }

    public void getSportsClubs() {
        try (Connection con = getConnectionToDb(); Statement st = con.createStatement()) {
            if (con == null) return;

            ResultSet rs = st.executeQuery("SELECT * FROM sports_clubs");
            System.out.println("\n Sports Clubs:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", City: " + rs.getString("city"));
            }
        } catch (SQLException e) {
            System.out.println(" Error retrieving sports clubs: " + e.getMessage());
        }
    }
}
