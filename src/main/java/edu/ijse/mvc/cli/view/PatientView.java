package edu.ijse.mvc.cli.view;

import edu.ijse.mvc.cli.controller.PatientController;
import edu.ijse.mvc.cli.dto.PatientDTO;
import java.util.ArrayList;
import java.util.Scanner;

public class PatientView {

    final private PatientController patientController = new PatientController();
    final private Scanner input = new Scanner(System.in);

    public void PatientManagement() throws Exception {

        System.out.println("");
        System.out.println("============================");
        System.out.println("=====Patient Management=====");
        System.out.println("=============================");
        System.out.println("");

        System.out.println("1. Add Patients");
        System.out.println("2. Update Patients");
        System.out.println("3. Delete Patients");
        System.out.println("4. Search Patients");

        System.out.println("");
        System.out.print("Input Number : ");
        int num = input.nextInt();

        switch (num) {
            case 1:
                PatientView patientView = new PatientView();
                patientView.addPatient();
                break;
            case 2:
                PatientView patientView2 = new PatientView();
                patientView2.updatePatient();
                break;
            case 3:
                 PatientView patientView3 = new PatientView();
                 patientView3.deletePatient();
                 break;
            case 4:
                 PatientView patientView4 = new PatientView();
                 patientView4.searchPatient();

            default:
                break;
        }
    }

    public void addPatient() throws Exception {

        System.out.println("");
        System.out.println("============================");
        System.out.println("=========Add Patient========");
        System.out.println("=============================");
        System.out.println("");

        System.out.print("Input Patient Name : ");
        String name = input.nextLine();

        System.out.print("Input Patient Contact Number : ");
        String contact = input.nextLine();

        PatientDTO patientDTO = new PatientDTO(0,name,contact);

        if(patientController.savePatient(patientDTO)){
            System.out.println("");
            System.out.println("Patient Saved Successfully");
        } else {
            System.out.println("");
            System.out.println("Patient Saved Failed");
        }

    }

    public void updatePatient() throws Exception {

        System.out.println("");
        System.out.println("=============================");
        System.out.println("========Update Patient=======");
        System.out.println("=============================");
        System.out.println("");

        System.out.print("Input Patient ID : ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Input Patient Name : ");
        String name = input.nextLine();

        System.out.print("Input Patient Contact Number : ");
        String contact = input.nextLine();

        PatientDTO patientDTO = new PatientDTO(id,name,contact);

        if(patientController.updatePatient(patientDTO)){
            System.out.println("");
            System.out.println("Patient Updated Successfully");
        } else {
            System.out.println("");
            System.out.println("Patient Updated Failed");
        }
    }

    public void deletePatient() throws Exception {

        System.out.println("");
        System.out.println("=============================");
        System.out.println("========Delete Patient=======");
        System.out.println("=============================");
        System.out.println("");

        System.out.print("Input Patient ID : ");
        int id = input.nextInt();

        if (patientController.deletePatient(id)){
            System.out.println("");
            System.out.println("Patient Deleted Successfully");
        } else {
            System.out.println("");
            System.out.println("Patient Deleted Failed");
        }

    }

    public void searchPatient() throws Exception {

        System.out.println("");
        System.out.println("==============================");
        System.out.println("========Search Patients=======");
        System.out.println("==============================");
        System.out.println("");

        ArrayList <PatientDTO> patientDTOS = patientController.getAllPatients();

        for (PatientDTO patientDTO : patientDTOS){
            System.out.printf("%-10s %-20s %-15s%n",
                    patientDTO.getId(),
                    patientDTO.getName(),
                    patientDTO.getContact());
        }

    }

}

