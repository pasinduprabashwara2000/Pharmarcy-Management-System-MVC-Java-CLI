package edu.ijse.mvc.cli.dto;

import java.time.LocalDate;

public class PrescriptionDTO {

    private int id;
    private int patientId;
    private int medicineId;
    private LocalDate prescribedDate;

    public PrescriptionDTO() {
    }

    public PrescriptionDTO(int id, int patientId, int medicineId, LocalDate prescribedDate) {
        this.id = id;
        this.patientId = patientId;
        this.medicineId = medicineId;
        this.prescribedDate = prescribedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public LocalDate getPrescribedDate() {
        return prescribedDate;
    }

    public void setPrescribedDate(LocalDate prescribedDate) {
        this.prescribedDate = prescribedDate;
    }

    @Override
    public String toString() {
        return "PrescriptionDTO{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", medicineId=" + medicineId +
                ", prescribedDate=" + prescribedDate +
                '}';
    }
}
