package Healthcaredatabase;

// Doctor can login, view profile, viewAppointments, Attend Patients and logout.
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor extends DBConections {

    static Scanner sc = new Scanner(System.in);
    static boolean va  = true;
    static boolean s = true;
    // static int user_curr =0;

    public static void login_doctorpass() throws SQLException, ClassNotFoundException {

        boolean v = true;
        System.out.println("------------------------------------------------------E-HealthCare-Management-System------------------------------------------------------");
        System.out.println("                                                           Welcome Doctor Login");
        // Scanner sc = new Scanner(System.in);
        System.out.println("Enter  doctor details");
        System.out.println("Enter doctor id ");
        int user1 = sc.nextInt();

        con = DBConections.getConnection();

        // PreparedStatement ps = con.prepareStatement("insert into login1 value(?,?)");
        // ps.setString(1, user);
        // ps.setInt(2, pass);
        // ps.executeUpdate();
        System.out.println("Verifying user name ");
        // System.out.println("Please enter id");

        // int user1 = sc.nextInt();
        System.out.println("enter password");
        int pass_dr = sc.nextInt();
        // con.prepareStatement("select*from login1");
        PreparedStatement ps1 = con.prepareStatement("select*from Doctor ");
        ResultSet rs = ps1.executeQuery();
        while (rs.next()) {
            int user2 = rs.getInt(1);
            int use3 = rs.getInt(7);
            if (user1 == user2 && pass_dr == use3) {
                System.out.println("welcome to E-Healthcare management syatem");
                // login_doctor();

                // break;
            } else {
                System.out.println("Please enter correct username & password");
                break;
            }
        }

        try {
            while (v) {
                System.out.println("Do you want to Continue : (Y/N)");
                char valueOfUser = sc.next().charAt(0);
                if (valueOfUser == 'y' || valueOfUser == 'Y') {
                    login_doctor();
                } else if (valueOfUser == 'n' || valueOfUser == 'N') {
                    v = false;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void login_doctor() throws SQLException, ClassNotFoundException {
        // user_curr=user1;
        System.out.println("1 View patient profile");
        System.out.println("2 view appointment");
        System.out.println("3 report");

        System.out.println("4 payment ");

        System.out.println("5 logout");

        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("view patient profile");
            patient_profile();
        } else if (choice == 2) {
            System.out.println("view appointment");
            view_Appointments();
        } else if (choice == 3) {
            System.out.println("report");
            report();
            
        }else if(choice==4){
            System.out.println("payment ");
            paymentview();

        }
        
        else if (choice == 5) {
            System.out.println("logout");
            logoutDoctor();
        } else {
            System.out.println("please valid enter ");
            try {
                while (s) {
                    System.out.println("Do you want to login  : (Y/N)");
                    char valueOfUser = sc.next().charAt(0);
                    if (valueOfUser == 'y' || valueOfUser == 'Y') {
                        login_doctor();
    
                    } else if (valueOfUser == 'n' || valueOfUser == 'N') {
                        s = false;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    static void patient_profile() throws SQLException {
        System.out.println("enter patient_id for check profile");
        int idd = sc.nextInt();

        System.out.println("Enter doctor id ");
        int dr_iid = sc.nextInt();

        PreparedStatement rs1 = con.prepareStatement("select * from appointment ");
        ResultSet rs7 = rs1.executeQuery();
        while (rs7.next()) {
            int user3 = rs7.getInt(1);
            int dr = rs7.getInt(5);
            if (idd == user3 && dr_iid == dr) {


                System.out.println(rs7.getInt(1) + "   ||   " + rs7.getString(2) + "   ||   " + rs7.getLong(3) + "   ||   " + rs7.getString(4) + "   ||   " + rs7.getInt(5) + "   ||   " + rs7.getString(6) + "   ||   " + rs7.getString(7) + "   ||   " + rs7.getString(8));
                break;

            // } else {
            //     System.out.println("patient id not matched");
            //     break;
            }
        
       
    }
    }

    static void view_Appointments() throws SQLException {
        System.out.println("enter dr_id for check appointment  ");
        int idd = sc.nextInt();

        PreparedStatement rs1 = con.prepareStatement("select * from appointment ");
        ResultSet rs7 = rs1.executeQuery();

        while (rs7.next()) {
            int user3 = rs7.getInt(5);
            if (idd == user3) {

                System.out.println(rs7.getInt(1) + "   ||   " + rs7.getString(2) + "   ||   " + rs7.getLong(3) + "   ||   " + rs7.getString(4) + "   ||   " + rs7.getInt(5) + "   ||   " + rs7.getString(6) + "   ||   " + rs7.getString(7) + "   ||   " + rs7.getString(8));
                break;

            } else {
                System.out.println("doctor id not matched");
                break;
            }
        }

    }

    static void report() throws SQLException {
        PreparedStatement ps = con.prepareStatement("insert into report values(?,?,?,?,?,?,?,?,?,?)");
        System.out.println("Enter dr_id");
        int id = sc.nextInt();
        ps.setInt(1, id);

        System.out.println("Enter patient_id");
        int patient_id = sc.nextInt();
        ps.setInt(2, patient_id);

        System.out.println("Enter doctor name");
        sc.nextLine();

        String d_name = sc.nextLine();
        ps.setString(3, d_name);

        System.out.println("Enter patient name");
        // sc.nextLine();

        String p_name = sc.nextLine();
        ps.setString(4, p_name);

        System.out.println("Enter patient age");
        int p_age = sc.nextInt();
        ps.setInt(5, p_age);

        System.out.println("Enter patient gender");
        sc.nextLine();

        String gender = sc.nextLine();
        ps.setString(6, gender);

        System.out.println("Enter blood group");
        // sc.nextLine();

        String blood = sc.nextLine();
        ps.setString(7, blood);

        System.out.println("patient treatement");
        // sc.nextLine();

        String treat = sc.nextLine();
        ps.setString(8, treat);

        System.out.println("patient dieases");
        // sc.nextLine();

        String diagnosis = sc.nextLine();
        ps.setString(9, diagnosis);

        System.out.println(" Follow Up");
        // sc.nextLine();

        String follow = sc.nextLine();
        ps.setString(10, follow);

        ps.executeUpdate();

    }

    //payment

    static void paymentview() throws SQLException{
         
        System.out.println("enter doctor id");
        int i =sc.nextInt();
        // ps.setInt(2, i);

        System.out.println("Enter patient id");
        int  patient_curr_id=sc.nextInt();
        // ps.setInt(1, patient_curr_id);
        PreparedStatement ps =con.prepareStatement("select * from payment");
        ResultSet rs7 = ps.executeQuery();
       

        // System.out.println("Enter doctor fees");
        // int fees =sc.nextInt();
        // ps.setInt(3, fees);

        while (rs7.next()) {
            int dri=rs7.getInt(2);
            int pai=rs7.getInt(1);
            if(patient_curr_id==rs7.getInt(1)&&(dri==i )&&(dri==pai)){
                System.out.println(rs7.getInt(1)+" "+rs7.getInt(2)+" "+rs7.getInt(3));
                break;
            }
            
            else{
                System.out.println("Entered wrong id ");
                break;
            }
            
        }

    }

    static void logoutDoctor() throws ClassNotFoundException, SQLException {
        while (va) {
            System.out.println("Do you want to logout : (Y/N)");
            char log_out = sc.next().charAt(0);
            if (log_out == 'y' || log_out == 'Y') {
                break;

            } else {
                // login_doctorpass();
            }
        }

    }

}
