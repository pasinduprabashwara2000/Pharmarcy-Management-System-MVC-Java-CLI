package edu.ijse.mvc.cli.model;

import edu.ijse.mvc.cli.db.DBConnection;
import edu.ijse.mvc.cli.dto.PatientDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PatientModel {

    public boolean savePatient(PatientDTO patientDTO) throws Exception {

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO patients (name, contact) VALUES (?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,patientDTO.getName());
        pstm.setString(2,patientDTO.getContact());

        return pstm.executeUpdate() > 0;

    }

    public boolean updatePatient(PatientDTO patientDTO) throws Exception {

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "UPDATE patients SET name = ?, contact = ? WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,patientDTO.getName());
        pstm.setString(2,patientDTO.getContact());
        pstm.setInt(3,patientDTO.getId());

        return pstm.executeUpdate() > 0;

    }

    public boolean deletePatient(int id) throws Exception {

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM patients WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);

        return pstm.executeUpdate() > 0;
    }

    public ArrayList <PatientDTO> getAll() throws Exception {

        ArrayList <PatientDTO> patientDTOS = new ArrayList<>();

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM patients";
        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rst = pstm.executeQuery();

        while (rst.next()){
           PatientDTO patientDTO = new PatientDTO(
                   rst.getInt("id"),
                   rst.getString("name"),
                   rst.getString("contact")
           );
           patientDTOS.add(patientDTO);
        }

        return patientDTOS;

    }

}
