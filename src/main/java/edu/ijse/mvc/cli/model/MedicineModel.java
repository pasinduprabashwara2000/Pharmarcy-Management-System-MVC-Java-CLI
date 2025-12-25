package edu.ijse.mvc.cli.model;

import edu.ijse.mvc.cli.db.DBConnection;
import edu.ijse.mvc.cli.dto.MedicineDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MedicineModel {

    public boolean addMedicine(MedicineDTO medicineDTO) throws Exception {

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO medicines (name, unit_price, stock_quantity) VALUES (?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,medicineDTO.getName());
        pstm.setDouble(2,medicineDTO.getUnitPrice());
        pstm.setInt(3,medicineDTO.getStockQuantity());

        return pstm.executeUpdate() > 0;

    }

    public boolean updateMedicine(MedicineDTO medicineDTO) throws Exception {

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "UPDATE medicines set name = ?, unit_price = ?, stock_quantity = ? WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,medicineDTO.getName());
        pstm.setDouble(2,medicineDTO.getUnitPrice());
        pstm.setInt(3,medicineDTO.getStockQuantity());
        pstm.setInt(4,medicineDTO.getId());

        return pstm.executeUpdate() > 0;

    }

    public boolean deleteMedicine(int id) throws Exception {

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM medicines WHERE id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);

        return pstm.executeUpdate() > 0;

    }

    public ArrayList <MedicineDTO> getAllMedicine() throws Exception {

        ArrayList <MedicineDTO> medicineDTOS = new ArrayList<>();

        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM medicines";
        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rst = pstm.executeQuery();

        while (rst.next()){
            MedicineDTO medicineDTO = new MedicineDTO(
                rst.getInt("id"),
                rst.getString("name"),
                rst.getDouble("unit_price"),
                rst.getInt("stock_quantity")
            );
            medicineDTOS.add(medicineDTO);
        }

        return medicineDTOS;

    }

}
