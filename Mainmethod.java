package Healthcaredatabase;

// package Healthcare_project;
import java.util.Scanner;

public class Mainmethod {

    public static void main(String[] args) {
         Admin log = new Admin();

        Patients pt = new Patients();
        Doctor dt = new Doctor();

        Scanner sc = new Scanner(System.in);
        System.out.println("1-Admin ");
        System.out.println("2-Patients");
        System.out.println("3-Doctor");

        int choice = sc.nextInt();
        try {

            if (choice == 1) {
                System.out.println("Admin login ");

                log.login_Adminpass();

            } else if (choice == 2) {
                System.out.println("Press -1 :for patient signup ");
                System.out.println("Press -2 :for patient login ");

                int loginid = sc.nextInt();

                if (loginid == 1) {
                    pt.signup_patient();

                } else if (loginid == 2) {
                    pt.login_patientpass();

                } else {
                    System.out.println("not matched");

                }

            } else if (choice == 3) {
                dt.login_doctorpass();

            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // log.AdminEndProcess();
            // pt.patientEndProcess();

        }

    }
}
