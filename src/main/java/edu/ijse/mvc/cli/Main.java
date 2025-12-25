package edu.ijse.mvc.cli;

import edu.ijse.mvc.cli.view.CanclePrescriptionView;
import edu.ijse.mvc.cli.view.MedicineView;
import edu.ijse.mvc.cli.view.PatientView;
import edu.ijse.mvc.cli.view.ProcessPrescriptionView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("");
            System.out.println("==================================================");
            System.out.println("=====Pharmacy Prescription Management System======");
            System.out.println("==================================================");

            System.out.println("");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Medicines");
            System.out.println("3. Process Prescription");
            System.out.println("4. Cancel Prescription");
            System.out.println("5. Inventory Report");

            System.out.println("");
            System.out.print("Input Your Number : ");
            int num = input.nextInt();

            switch (num){

                case 1 :
                    PatientView patientView = new PatientView();
                    patientView.PatientManagement();
                    break;

                case 2 :
                    MedicineView medicineView = new MedicineView();
                    medicineView.MedicineManagement();
                    break;

                case 3 :
                    ProcessPrescriptionView processPrescriptionView = new ProcessPrescriptionView();
                    processPrescriptionView.ProcessPrescription();
                    break;

                case 4 :
                    CanclePrescriptionView canclePrescriptionView = new CanclePrescriptionView();


                default:
            }

        }
    }
}