package edu.ijse.mvc.cli.controller;

import edu.ijse.mvc.cli.dto.PatientDTO;
import edu.ijse.mvc.cli.model.PatientModel;

import java.util.ArrayList;

public class PatientController {

    final private PatientModel patientModel = new PatientModel();

    public boolean savePatient(PatientDTO patientDTO) throws Exception{
        return patientModel.savePatient(patientDTO);
    }

    public boolean updatePatient(PatientDTO patientDTO) throws Exception{
        return patientModel.updatePatient(patientDTO);
    }

    public boolean deletePatient(int id) throws Exception {
        return patientModel.deletePatient(id);
    }

   public ArrayList <PatientDTO> getAllPatients() throws Exception {
        return patientModel.getAll();
   }

}
