package edu.ijse.mvc.cli.model;

import edu.ijse.mvc.cli.db.DBConnection;
import edu.ijse.mvc.cli.dto.PrescriptionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProcessPrescriptionModel {

    public boolean processPrescription(PrescriptionDTO prescriptionDTO) throws Exception {

        Connection conn = DBConnection.getInstance().getConnection();

        try {
            conn.setAutoCommit(false);

            String sql = "INSERT INTO prescriptions (patient_id, medicine_id) VALUES (?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, prescriptionDTO.getPatientId());
            pstm.setInt(2, prescriptionDTO.getMedicineId());

            if (pstm.executeUpdate() == 0) {
                conn.rollback();
                return false;
            }

            conn.commit();
            return true;

        } catch (Exception e) {
            conn.rollback();
            System.out.println(e.getMessage());
            return false;
        } finally {
            conn.setAutoCommit(true);
        }
    }

}
