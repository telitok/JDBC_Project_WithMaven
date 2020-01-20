package JDBC_Practice;

import java.sql.*;

public class SimpleConnection {

    public static void main(String[] args) throws SQLException {

        /*
        hostname = 3.86.115.134
        port = 1521
        SID = xe
        URL formula = jdbc:oracle:thin:@3.86.115.134:1521:xe

        */


        String url = "jdbc:oracle:thin:@3.86.115.134:1521:xe";
        String username = "hr";
        String password = "hr";

        // Step 1
        Connection connection = DriverManager.getConnection(url, username, password);
        // System.out.println("Connected");

        //Step 2
        Statement statement = connection.createStatement();

        // Step 3
        ResultSet result = statement.executeQuery("select * from countries");

        while(result.next()){
            String countryname = result.getString("country_name");
            int region_id = result.getInt("region_id");

            if(countryname.equals("Germany")) {
                System.out.println(countryname+" "+region_id);
            }
        }

    }
}
