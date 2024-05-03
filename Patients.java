package Healthcaredatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// E-HealthCare-Management-System is a console based application which is built using java.
// This application helps in management of Patients, doctors, admin in a easy and comfortable way.
// using this Application patients can quickly Sign up, Login, view his/her profile, view doctors, book Appointment, 
// view Report, choose doctor, view Appointments, give feedback, pay online and logout. Admin can add Doctors,
// view patients list, view Doctors list,remove doctors, see feedback given by patients,view reports,logout.
// Doctor can login, view profile, viewAppointments, Attend Patients and logout.
import java.util.ArrayList;
import java.util.Scanner;

public class Patients extends DBConections {

    // boolean val;
    static Scanner sc = new Scanner(System.in);
    static boolean va  = true;
    static boolean vl = true;
    boolean s = true;
   static int patient_curr_id=0;

    static int patient_chooseid;

    // public static void main(String[] args) throws ClassNotFoundException, SQLException {
    //     // login_patients();
    //     // login_patientpass();
    //     signup_patient();
    // }
    //signup page 
    void signup_patient() throws ClassNotFoundException, SQLException {

        System.out.println("--------------------------------------------------E-HealthCare-Management-System ------------------------------------------------------");
        System.out.println("                                                     Welcome patient SignUp");
        // Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your SignUp details");
        con = DBConections.getConnection();
        PreparedStatement ps5 = con.prepareStatement("insert into patients values (?,?,?,?,?,?,?)");

        System.out.println("Enter id for patients sign up");
        int user = sc.nextInt();
        ps5.setInt(1, user);

        System.out.println("Enter patients name");
        sc.nextLine();

        String name = sc.nextLine();
        ps5.setString(2, name);

        System.out.println("Enter patients age");
        int age = sc.nextInt();
        ps5.setInt(3, age);

        System.out.println("Enter patient gender");
        sc.nextLine();
        String gender = sc.nextLine();
        ps5.setString(4, gender);

        System.out.println("Enter patient contact");
        long contact = sc.nextLong();
        ps5.setLong(5, contact);

        System.out.println("Enter patient address");
        sc.nextLine();

        String address = sc.nextLine();
        ps5.setString(6, address);

        // System.out.println("Enter patient appointment date ");
        // sc.nextLine();

        // String appointment = sc.next();
        // ps5.setString(7, appointment);

        System.out.println("Enter patient dieseases ");
        // sc.nextLine();

        String dieseases = sc.nextLine();
        ps5.setString(7, dieseases);
        ps5.executeUpdate();
        System.out.println("sign up successfully ");
        try {
            while (s) {
                System.out.println("Do you want to login  : (Y/N)");
                char valueOfUser = sc.next().charAt(0);
                if (valueOfUser == 'y' || valueOfUser == 'Y') {
                    login_patientpass();

                } else if (valueOfUser == 'n' || valueOfUser == 'N') {
                    s = false;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void login_patientpass() throws ClassNotFoundException, SQLException {

        boolean v = true;
        System.out.println("-----------------------------------------------------E-HealthCare-Management-System-----------------------------------------------");
        System.out.println("                                                         Welcome patient Login");
        // Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your login details");
        System.out.println("Enter id for patients login");
        int user1 = sc.nextInt();

        con = DBConections.getConnection();
        // PreparedStatement ps = con.prepareStatement("select  patient_id from  patients (?)");
        // ps.setInt(1, user1);
        // ps.executeUpdate();
        System.out.println("Verifying user name ");
        // System.out.println("Please enter your username");

        // String user1 = sc.next();
        // con.prepareStatement("select*from patients");
        PreparedStatement ps1 = con.prepareStatement("select*from patients");
        ResultSet rs = ps1.executeQuery();
        while (rs.next()) {
            int user2 = rs.getInt(1);
            if (user1 == user2) {
                System.out.println("---------------------------------------------welcome to E-Healthcare management system------------------------------------------------");
                // break;
            } else {
                System.out.println("Please enter correct username");
                break;
            }

        }
        try {
            while (v) {
                System.out.println("Do you want to Continue : (Y/N)");
                char valueOfUser = sc.next().charAt(0);
                if (valueOfUser == 'y' || valueOfUser == 'Y') {

                    login_patients(user1);

                } else if (valueOfUser == 'n' || valueOfUser == 'N') {
                    v = false;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//login page 
     static void login_patients(int user1) throws SQLException, ClassNotFoundException {
        patient_curr_id=user1;
        // if (username == user_name && password == login_password) {
        System.out.println("1-view  profile ");
        System.out.println("2-view doctor  list ");
        System.out.println("3-Book appointmnet ");
        System.out.println("4-view report");
        System.out.println("5-view Appointment");
        System.out.println("6-payment");
        System.out.println("7-logout ");

        // } else {
        //     System.out.println("please enter correct user name /password");
        // }
        int choice = sc.nextInt();

        // 1 view profile done
        if (choice == 1) {
            // System.out.println("view Profile ");
            // System.out.println("Enter profile id"); 
            // int pas_id = sc.nextInt();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select*from patients");

            while (rs.next()) {
                int iid = rs.getInt(1);
                if (patient_curr_id == iid && patient_curr_id==rs.getInt(1)) {
                    System.out.println(rs.getInt(1) + "   ||   " + rs.getString(2) + "   ||   " + rs.getInt(3) + "   ||   " + rs.getString(4) + "    ||   " + rs.getLong(5) + "   ||   " + rs.getString(6) + "   ||   " + rs.getString(7) );
                    break;

                }
               else{
                System.out.println("id doesn't match");
               }
            }

        } // 2 view doctor list done 
        else if (choice == 2) {
            System.out.println("view doctor list ");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select*from doctor");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "   ||   " + rs.getString(2) + "   ||   " + rs.getString(3) + "   ||   " + rs.getString(4) + "   ||   " + rs.getString(5) + "   ||   " + rs.getLong(6) + "   ||   " + rs.getInt(8));
            }
            //3 appointmnet book
        } else if (choice == 3) {
            System.out.println("appontmnet book");

            choose_dr();
            //view report
        } else if (choice == 4) {
            System.out.println("view report ");

            view_report();
            //view appointmnet
        } else if (choice == 5) {
            System.out.println("view appointment ");
            view_Appointment();

        } else if (choice == 6) {
            System.out.println("payment");
            payment();
        } else if (choice == 7) {
            logoutPatient();

        } else {
            System.out.println("please choose correct option");
        
        try {
            while (vl) {
                System.out.println("Do you want to Continue : (Y/N)");
                char valueOfUser = sc.next().charAt(0);
                if (valueOfUser == 'y' || valueOfUser == 'Y') {
                    login_patients(user1);

                } else if (valueOfUser == 'n' || valueOfUser == 'N') {
                    vl = false;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    }

    //3  appointmnet book  
    static void choose_dr() throws SQLException {
        // Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement("select * from Doctor");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "   ||   " + rs.getString(2) + "   ||   " + rs.getString(3) + "   ||   " + rs.getString(4) + "   ||   " + rs.getString(5) + "   ||   " + rs.getLong(6) + "   ||   " + rs.getInt(8));

        }

        PreparedStatement ps = con.prepareStatement("INSERT INTO appointment VALUES (?,?,?,?,?,?,?,?)");
        System.out.println("Enter dr name ");
        
        String name = sc.nextLine();
        ps.setString(6, name);

        System.out.println("Enter patient name");

        String p_name = sc.nextLine();
        ps.setString(2, p_name);

        System.out.println("Enter patient appointmnet date");
        String appoin_date = sc.nextLine();
        ps.setString(4, appoin_date);

        System.out.println("Enter booking time ");
        // sc.nextLine();

        String time = sc.nextLine();
        ps.setString(7, time);

        System.out.println("Enter patient id");
        int p_id = sc.nextInt();
        ps.setInt(1, p_id);

        System.out.println("Enter dr id");
        int pa_name = sc.nextInt();
        ps.setInt(5, pa_name);

        System.out.println("Enter doctor city");
        sc.nextLine();
        String city = sc.nextLine();
        ps.setString(8, city);

        System.out.println("Enter patient contact");
        long con = sc.nextLong();
        ps.setLong(3, con);

        ps.executeUpdate();

        System.out.println("appointment book successfully :");

    }
    //4 -view report

    static void view_report() throws SQLException {
        // System.out.println("Enter patient Id for view report");
        // int report = sc.nextInt();

        PreparedStatement ps = con.prepareStatement("select * from report");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            int paid = rs.getInt(2);
            if (patient_curr_id==paid) {

                System.out.println(rs.getInt(1) + "   ||   " + rs.getInt(2) + "   ||   " + rs.getString(3) + "   ||   " + rs.getString(4) + "   ||   " + rs.getInt(5) + "   ||   " + rs.getString(6) + "   ||   " + rs.getString(7) + "   ||   " + rs.getString(8) + "   ||   " + rs.getString(9) + "   ||   " + rs.getString(10));
                break;
            }
            else{
                System.out.println("please enter right id");
            }
        }

    }
    // 5 -view appointment

    static void view_Appointment() throws SQLException {
        // System.out.println("enter patient_id for check appointment");
        // int idd = sc.nextInt();

        PreparedStatement rs1 = con.prepareStatement("select * from appointment ");
        ResultSet rs7 = rs1.executeQuery();

        while (rs7.next()) {
            int user3 = rs7.getInt(1);
            if (patient_curr_id == user3 && patient_curr_id==rs7.getInt(1)) {

                System.out.println(rs7.getInt(1) + "   ||   " + rs7.getString(2) + "   ||   " + rs7.getLong(3) + "   ||   " + rs7.getString(4) + "   ||   " + rs7.getInt(5) + "   ||   " + rs7.getString(6) + "   ||   " + rs7.getString(7) + "   ||   " + rs7.getString(8));
                break;

            }
           
        }
    }
//paymnet method
    static void payment() throws SQLException {
        PreparedStatement ps =con.prepareStatement("insert into payment values(?,?,?)");
        // ResultSet rs7 = ps.executeQuery();

        System.out.println("enter doctor id");
        int i =sc.nextInt();
        ps.setInt(2, i);

        System.out.println("Enter patient id");
        int  patient_curr=sc.nextInt();
        ps.setInt(1, patient_curr);

        System.out.println("Enter doctor fees");
        int fees =sc.nextInt();
        ps.setInt(3, fees);
        ps.executeUpdate();

       

        // while (rs7.next()) {
        //     int dri=rs7.getInt(2);
        //     int pai=rs7.getInt(2);
        //     if(patient_curr_id==rs7.getInt(1)&&(dri==i)){
        //         System.out.println(rs7.getInt(1)+" "+rs7.getInt(2)+" "+rs7.getInt(3));
        //     }
            
        // }



    }

    static void logoutPatient() throws ClassNotFoundException, SQLException {
        while (va) {
            System.out.println("Do you want to logout : (Y/N)");
            char log_out = sc.next().charAt(0);
            if (log_out == 'y' || log_out == 'Y') {
                break;

            } else {
                login_patientpass();
            }
        }

    }

}
