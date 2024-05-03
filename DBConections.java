package Healthcaredatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConections {

    static Connection con;

    // public static void main(String[] args) throws Exception {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        // System.out.println("Driver loaded successfully ");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "root@123");

        // System.out.println("connection established");
        return con;

        // PreparedStatement ps = con.prepareStatement("insert into register values('rohit ','rohit@gmail.com','1233','male','indore')");
        //      ps = con.prepareStatement("insert into register values('ajay','ajay@gmail.com','123','male','maksi')");
        //     int i = ps.executeUpdate();
        //     if (i > 0) {
        //         System.out.println("success");
        //     } else {
        //         System.out.println("fail");
        //     }
        // return con;
        // }
    }

}

	
// }
