package edu.ijse.mvc.cli.controller;

import edu.ijse.mvc.cli.dto.MedicineDTO;
import edu.ijse.mvc.cli.model.MedicineModel;

import java.util.ArrayList;

public class MedicineController {

    final private MedicineModel medicineModel = new MedicineModel();

    public boolean addMedicine(MedicineDTO medicineDTO) throws Exception{
       return medicineModel.addMedicine(medicineDTO);
    }

    public boolean updateMedicine(MedicineDTO medicineDTO) throws Exception{
        return medicineModel.updateMedicine(medicineDTO);
    }

    public boolean deleteMedicine(int id) throws Exception {
        return medicineModel.deleteMedicine(id);
    }

    public ArrayList <MedicineDTO> getAllMedicine() throws Exception {
        return medicineModel.getAllMedicine();
    }

}
