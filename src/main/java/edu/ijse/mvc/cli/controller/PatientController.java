package edu.ijse.mvc.cli.controller;

import edu.ijse.mvc.cli.dto.PatientDTO;
import edu.ijse.mvc.cli.model.PatientModel;

public class PatientController {

    final private PatientModel patientModel = new PatientModel();

    public String savePatient(PatientDTO patientDTO) throws Exception{
        return patientModel.savePatient(patientDTO);
    }

    public String updatePatient(PatientDTO patientDTO) throws Exception{
        return patientModel.updatePatient(patientDTO);
    }

    public String deletePatient(int id) throws Exception {
        return patientModel.deletePatient(id);
    }

}
