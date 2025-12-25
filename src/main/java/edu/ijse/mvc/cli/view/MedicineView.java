package edu.ijse.mvc.cli.view;

import edu.ijse.mvc.cli.controller.MedicineController;
import edu.ijse.mvc.cli.dto.MedicineDTO;

import java.util.Scanner;

public class MedicineView {

    final private MedicineController medicineController = new MedicineController();
    final private Scanner input = new Scanner(System.in);

    public void MedicineManagement() throws Exception{

        System.out.println("");
        System.out.println("=============================");
        System.out.println("=====Medicine Management=====");
        System.out.println("==============================");
        System.out.println("");

        System.out.println("1. Add Medicine");
        System.out.println("2. Update Medicine");
        System.out.println("3. Delete Medicine");
        System.out.println("4. Search Medicine");

        System.out.println("");
        System.out.print("Input Your Number : ");
        int num = input.nextInt();

        switch (num) {

            case 1 : MedicineView medicineView = new MedicineView();
                     medicineView.addMedicine();
                     break;

            case 2 : MedicineView medicineView2 = new MedicineView();
                     medicineView2.updateMedicine();

            default:
                break;
        }

    }

    public void addMedicine() throws Exception{

        System.out.println("");
        System.out.println("=============================");
        System.out.println("=========Add Medicine========");
        System.out.println("=============================");
        System.out.println("");

        System.out.print("Input Medicine Name : ");
        String name = input.nextLine();

        System.out.print("Input Unit Price :");
        double price = input.nextDouble();

        System.out.print("Input Stock Quantity : ");
        int qty = input.nextInt();

        MedicineDTO medicineDTO = new MedicineDTO(0,name,price,qty);

        if(medicineController.addMedicine(medicineDTO)){
            System.out.println("Medicine Added Successfully");
        } else {
            System.out.println("Medicine Added Failed");
        }

    }

    public void updateMedicine() throws Exception{

        System.out.println("");
        System.out.println("==============================");
        System.out.println("=======Update Medicine========");
        System.out.println("==============================");
        System.out.println("");

        System.out.print("Input Medicine Id : ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Input Medicine Name : ");
        String name = input.nextLine();

        System.out.print("Input Medicine Unit Price : ");
        double price = input.nextDouble();

        System.out.print("Input Medicine Stock Quantity : ");
        int qyt = input.nextInt();

        MedicineDTO medicineDTO = new MedicineDTO(id,name,price,qyt);

        if(medicineController.updateMedicine(medicineDTO)){
            System.out.println("");
            System.out.println("Medicine Updated Successfully");
        } else {
            System.out.println("");
            System.out.println("Medicine Updated Failed");
        }

    }

}
