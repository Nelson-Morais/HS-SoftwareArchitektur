package de.hsos.swa.ssa.suchen;

import java.sql.*;

public class Main {

    static final String URL = "jdbc:derby:Z:\\SWA\\AB1\\lib\\WareDB";
    static final String query = "SELECT warennummer, name FROM Ware";

    public static void main(String[] arcs) throws SQLException {
        try(Connection conn = DriverManager.getConnection(URL)){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.print("ID: "+ rs.getInt("warennummer"));
                System.out.println(", name: "+ rs.getString("name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
