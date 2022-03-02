package net.sqliteinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createTable {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/moviefulldatas.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS moviestable (\n"
                + "	MovieName text NOT NULL,\n"
                + "	Actor text NOT NULL,\n"
                + "	Actress text NOT NULL,\n"
                + "	YearofRelease int NOT NULL,\n"
                + "	Director text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewTable();
    }

}