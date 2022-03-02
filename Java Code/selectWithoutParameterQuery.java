package net.sqliteinfo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class selectWithoutParameterQuery {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/moviefulldatas.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll() {
        String sql = "SELECT MovieName,Actor,Actress,YearofRelease,Director FROM moviestable";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // looping through the result set
            while (rs.next()) {
                System.out.println(rs.getString("MovieName") + "\t" +
                        rs.getString("Actor") + "\t" +
                        rs.getString("Actress") + "\t" +
                        rs.getInt("YearofRelease") + "\t" +
                        rs.getString("Director"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        selectWithoutParameterQuery app = new selectWithoutParameterQuery();
        app.selectAll();
    }

}