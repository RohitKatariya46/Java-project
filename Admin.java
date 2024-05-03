package Healthcaredatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin extends DBConections {

    // static Connection con;
    // con  = DBConections.getConnection();
    static Scanner sc = new Scanner(System.in);
    static boolean val = true;
    static boolean v = true;

    public static void login_Adminpass() throws SQLException, ClassNotFoundException {

        // boolean v = true;
        System.out.println("---------------------------------------------E-HealthCare-Management-System-----------------------------------------");
        System.out.println("                                              Welcome Admin Login");
        // Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter Your login details");
        System.out.println("Enter username ");
        String user = sc.next();
        System.out.println("Enter password");
        int pass = sc.nextInt();
        con = DBConections.getConnection();
        

        // PreparedStatement ps = con.prepareStatement("insert into login1 value(?,?)");
        // ps.setString(1, user);
        // ps.setInt(2, pass);
        // ps.executeUpdate();
        System.out.println("Verifying user name ");
        // System.out.println("Please enter your username");

        // String user1 = sc.next();
        // con.prepareStatement("select*from login1");
        System.out.println("--------------------------------welcome to E-Healthcare management system-------------------------------");

        PreparedStatement ps1 = con.prepareStatement("select*from login1 ");
        ResultSet rs = ps1.executeQuery();
        while (rs.next()) {
            String user2 = rs.getString(1);
            int pa=rs.getInt(2);
            if (user.equals(user2) && pass==pa) {
                // login_Admin();
                try{
                    while (v) {

                        System.out.println("Do you want to Continue : (Y/N)");
                        char valueOfUser = sc.next().charAt(0);
                        if (valueOfUser == 'y' || valueOfUser == 'Y') {
                            login_Admin();
                           
                        } else if (valueOfUser == 'n' || valueOfUser == 'N') {
                            v = false;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                // break;
            } else {
                System.out.println("Please enter correct name /password");
                break;
            }

        }
       

    }

    //  Admin  login page
    static void login_Admin() throws SQLException {
        System.out.println("1-add doctor ");
        System.out.println("2-view doctor  list ");
        System.out.println("3-view Patients list ");
        System.out.println("4-remove doctor ");
        System.out.println("5-view report ");
        System.out.println("6-logout");
        // } else {
        // System.out.println("please enter correct user name /password");
        // }
        int choice = sc.nextInt();
        // 1 add doctor 
        if (choice == 1) {
            add_doctors();
        } //view doctor list 
        else if (choice == 2) {
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select*from doctor");
            while (rs.next()) {

                System.out.println(rs.getInt(1) + "    ||   " + rs.getString(2) + "   ||   " + rs.getString(3) + "   ||   " + rs.getString(4) + "   ||   " + rs.getString(5) + "   ||   " + rs.getLong(6) + "   ||   " + rs.getInt(7) + "  ||   " + rs.getInt(8));
            }

        } // 3 view patient list 
        else if (choice == 3) {
            System.out.println("view patients list ");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select*from patients");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "   ||   " + rs.getString(2) + "   ||   " + rs.getInt(3) + "   ||   " + rs.getString(4) + "   ||   " + rs.getLong(5) + "   ||   " + rs.getString(6) + "   ||   " + rs.getString(7));

            }
        } else if (choice == 4) {
            System.out.println("remove doctor ");
            removedr();
        } else if (choice == 5) {
            System.out.println("view report ");

            view_report();
        } else if (choice == 6) {
            logout();
            
            System.out.println("logout successfully ");
            
            
            
            
        } 
        else {
            System.out.println("please choose correct option");
            
    

        try {
            while (v) {
                System.out.println("Do you want to Continue : (Y/N)");
                char valueOfUser = sc.next().charAt(0);
                if (valueOfUser == 'y' || valueOfUser == 'Y') {
                    login_Admin();

                } else if (valueOfUser == 'n' || valueOfUser == 'N') {
                    v = false;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

    //login page end 
    // 1 doctors add 
    static void add_doctors() throws SQLException {

        PreparedStatement ps2 = con.prepareStatement("insert into Doctor values(?,?,?,?,?,?,?,?)");
        System.out.println("   enter dr id");
        int id = sc.nextInt();
        ps2.setInt(1, id);
        sc.nextLine();

        System.out.println("   Enter Dr name");

        String name = sc.nextLine();
        ps2.setString(2, name);

        System.out.println("   Enter dr speciality");
        String special = sc.nextLine();
        ps2.setString(3, special);

        System.out.println("   Enter dr timing");
        String timng = sc.nextLine();
        ps2.setString(4, timng);

        System.out.println("   Enter dr city");
        String city = sc.nextLine();
        ps2.setString(5, city);

        System.out.println("   Enter dr contact");
        Long contact = sc.nextLong();
        ps2.setLong(6, contact);

        System.out.println("   Enter dr password");
        int password = sc.nextInt();
        ps2.setInt(7, password);
        System.out.println("Enter doctor fees");
        int fee = sc.nextInt();
        ps2.setInt(8, fee);

        ps2.executeUpdate();

    }

    //   4 remove doctors
    static void removedr() throws SQLException {

        PreparedStatement ps3 = con.prepareStatement("delete  from Doctor where dr_id = ?");
        System.out.println("enter dr id");
        int id = sc.nextInt();
        ps3.setInt(1, id);
        ps3.executeUpdate();
        System.out.println("1 row deleted " + id);

    }

    //5 view report
    static void view_report() throws SQLException {
        System.out.println("Enter patient Id for view report");
        int reports = sc.nextInt();

        PreparedStatement ps = con.prepareStatement("select * from report");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int pa_id = rs.getInt(2);
            if (reports == pa_id) {

                System.out.println(rs.getInt(1) + "   ||   " + rs.getInt(2) + "   ||   " + rs.getString(3) + "    ||   " + rs.getString(4) + "   ||   " + rs.getInt(5) + "   ||   " + rs.getString(6) + "   ||   " + rs.getString(7) + "   ||   " + rs.getString(8) + "   ||   " + rs.getString(9) + "   ||   " + rs.getString(10));
                break;
            }
            else{
                System.out.println("Entered wrong id  ");
                break;
            }
        }

    }

    //6 logout 
    static void logout() {
        while (val) {
            System.out.println("Do you want to logout : (Y/N)");
            char log_out = sc.next().charAt(0);
            if (log_out == 'y' || log_out == 'Y') {
                break;
            } else {
                
            }
        }
    }

    // public static void main(String[] args) throws SQLException, ClassNotFoundException {
    //     Admin log = new Admin();
    //     log.login_Adminpass();
    // }
}
