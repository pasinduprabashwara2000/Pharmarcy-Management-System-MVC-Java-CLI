package edu.ijse.mvc.cli.view;

import edu.ijse.mvc.cli.controller.ProcessPrescriptionController;
import edu.ijse.mvc.cli.dto.PrescriptionDTO;

import java.util.Scanner;

public class ProcessPrescriptionView {

    final private ProcessPrescriptionController processPrescriptionController = new ProcessPrescriptionController();
    final private Scanner input = new Scanner(System.in);

    public void ProcessPrescription() throws Exception {

        System.out.println("");
        System.out.println("=================================");
        System.out.println("=====Prescription Management=====");
        System.out.println("=================================");
        System.out.println("");

        System.out.print("Input Patient ID : ");
        int pid = input.nextInt();

        System.out.print("Input Medicine ID : ");
        int mid = input.nextInt();

        PrescriptionDTO prescriptionDTO = new PrescriptionDTO(0,pid,mid,null);

        if(processPrescriptionController.addPrescription(prescriptionDTO)){
            System.out.println("");
            System.out.println("Prescription Process Completed");
        } else {
            System.out.println("");
            System.out.println("Prescription Process Failed");
        }

    }

}
