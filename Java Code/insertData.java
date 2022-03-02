package net.sqliteinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertData {
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

    public void insert(String name, String actor , String actress , int year ,String director) {
        String sql = "INSERT INTO moviestable(MovieName,Actor,Actress,YearofRelease,Director) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, actor);
            pstmt.setString(3, actress);
            pstmt.setInt(4, year);
            pstmt.setString(5, director);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        insertData app = new insertData();
        app.insert("Mankatha" , "Ajith Kumar" , "Raai Laxmi" , 2011 , "Venkat Prabhu");
        app.insert("Kaithi" , "Karthi" , "Black Sheep Deepthi" , 2019 , "Lokesh Kanagaraj");
        app.insert("Soorarai Pottru" , "Suriya" , "Aparna Balamurali" , 2020 , "Sudha Kongara Prasad");
    }

}