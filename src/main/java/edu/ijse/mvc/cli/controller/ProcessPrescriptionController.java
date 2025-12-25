package edu.ijse.mvc.cli.controller;

import edu.ijse.mvc.cli.dto.PrescriptionDTO;
import edu.ijse.mvc.cli.model.ProcessPrescriptionModel;

public class ProcessPrescriptionController {

    private final ProcessPrescriptionModel processPrescriptionModel = new ProcessPrescriptionModel();

    public boolean addPrescription(PrescriptionDTO prescriptionDTO) throws Exception {
        return processPrescriptionModel.processPrescription(prescriptionDTO);
    }

}
