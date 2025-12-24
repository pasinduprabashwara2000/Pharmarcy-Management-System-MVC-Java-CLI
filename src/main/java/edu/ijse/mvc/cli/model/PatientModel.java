package edu.ijse.mvc.cli.model;

import edu.ijse.mvc.cli.db.DBConnection;
import edu.ijse.mvc.cli.dto.PatientDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PatientModel {

    public String savePatient(PatientDTO patientDTO) throws Exception {

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO patients (name, contact) VALUES (?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,patientDTO.getName());
        pstm.setString(2,patientDTO.getContact());

        if (pstm.executeUpdate() > 0){
            System.out.println("");
            System.out.println("Patient Saved Successfully");
        } else {
            System.out.println("");
            System.out.println("Patient Saved Failed");
        }

        return sql;
    }

    public String updatePatient(PatientDTO patientDTO) throws Exception {

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "UPDATE patients SET name = ?, contact = ? WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,patientDTO.getName());
        pstm.setString(2,patientDTO.getContact());
        pstm.setInt(3,patientDTO.getId());

        if(pstm.executeUpdate() > 0){
            System.out.println("");
            System.out.println("Patient Update Successfully");
        } else {
            System.out.println("");
            System.out.println("Patient Update Failed");
        }

        return sql;

    }

    public String deletePatient(int id) throws Exception {

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM patients WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);

        if (pstm.executeUpdate() > 0) {
            System.out.println("");
            System.out.println("Patient Deleted Successfully");
        } else {
            System.out.println("");
            System.out.println("Patient Deleted Failed");
        }

        return sql;
    }

}
