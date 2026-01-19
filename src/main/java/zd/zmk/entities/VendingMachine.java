package zd.zmk.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vending_machines")
public class VendingMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "integer")
    private Integer id;


    @NotBlank(message = "Serial number is required")
    @Size(max = 100, message = "Serial number must not exceed 100 characters")
    @Column(unique = true, nullable = false)
    private String serialNumber;

    @NotBlank(message = "Inventory number is required")
    @Size(max = 100, message = "Inventory number must not exceed 100 characters")
    @Column(unique = true, nullable = false, name = "inventory_number")
    private String inventoryNumber;

    @NotBlank(message = "Model is required")
    @Size(max = 100, message = "Model must not exceed 100 characters")
    @Column(nullable = false)
    private String model;

    @NotBlank(message = "Company is required")
    @Size(max = 100, message = "Company must not exceed 100 characters")
    @Column(nullable = false, name = "manufacturer")
    private String company;

    @NotNull(message = "Status is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Size(max = 255, message = "Location must not exceed 255 characters")
    @Column(name = "location")
    private String location;

    public enum MachineType {
        cash, card, both
    }

    @NotNull(message = "Machine type is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "machine_type", nullable = false)
    private MachineType machineType;

    @Size(max = 100, message = "Country of origin must not exceed 100 characters")
    @Column(name = "country_of_origin")
    private String countryOfOrigin;

    @Column(name = "manufacturing_date")
    private LocalDateTime manufacturingDate;

    @Column(name = "commissioning_date")
    private LocalDateTime commissioningDate;

    @Column(name = "last_calibration_date")
    private LocalDateTime lastCalibrationDate;

    @Column(name = "calibration_interval_months", columnDefinition = "integer default 12")
    private Integer calibrationIntervalMonths = 12;

    @Column(name = "ta_resource_hours", columnDefinition = "integer")
    private Integer taResourceHours;

    @Column(name = "next_service_date")
    private LocalDateTime nextServiceDate;

    @Column(name = "service_duration_hours", columnDefinition = "integer")
    private Integer serviceDurationHours;

    @Column(name = "inventory_date")
    private LocalDateTime inventoryDate;

    @Column(name = "cumulative_revenue", columnDefinition = "decimal(12, 2) default 0.00")
    private BigDecimal cumulativeRevenue = BigDecimal.ZERO;

    @Column(name = "last_calibration_user_id", columnDefinition = "integer")
    private Integer lastCalibrationUserId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum Status {
        ACTIVE, INACTIVE, MAINTENANCE, OUT_OF_SERVICE
    }

    // Constructors
    public VendingMachine() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public VendingMachine(String serialNumber, String inventoryNumber, String model, String company, Status status, String location, MachineType machineType) {
        this();
        this.serialNumber = serialNumber;
        this.inventoryNumber = inventoryNumber;
        this.model = model;
        this.company = company;
        this.status = status;
        this.location = location;
        this.machineType = machineType;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        this.updatedAt = LocalDateTime.now();
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
        this.updatedAt = LocalDateTime.now();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
        this.updatedAt = LocalDateTime.now();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
        this.updatedAt = LocalDateTime.now();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public void setMachineType(MachineType machineType) {
        this.machineType = machineType;
        this.updatedAt = LocalDateTime.now();
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDateTime manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCommissioningDate() {
        return commissioningDate;
    }

    public void setCommissioningDate(LocalDateTime commissioningDate) {
        this.commissioningDate = commissioningDate;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getLastCalibrationDate() {
        return lastCalibrationDate;
    }

    public void setLastCalibrationDate(LocalDateTime lastCalibrationDate) {
        this.lastCalibrationDate = lastCalibrationDate;
        this.updatedAt = LocalDateTime.now();
    }

    public Integer getCalibrationIntervalMonths() {
        return calibrationIntervalMonths;
    }

    public void setCalibrationIntervalMonths(Integer calibrationIntervalMonths) {
        this.calibrationIntervalMonths = calibrationIntervalMonths;
        this.updatedAt = LocalDateTime.now();
    }

    public Integer getTaResourceHours() {
        return taResourceHours;
    }

    public void setTaResourceHours(Integer taResourceHours) {
        this.taResourceHours = taResourceHours;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(LocalDateTime nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
        this.updatedAt = LocalDateTime.now();
    }

    public Integer getServiceDurationHours() {
        return serviceDurationHours;
    }

    public void setServiceDurationHours(Integer serviceDurationHours) {
        this.serviceDurationHours = serviceDurationHours;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getInventoryDate() {
        return inventoryDate;
    }

    public void setInventoryDate(LocalDateTime inventoryDate) {
        this.inventoryDate = inventoryDate;
        this.updatedAt = LocalDateTime.now();
    }

    public BigDecimal getCumulativeRevenue() {
        return cumulativeRevenue;
    }

    public void setCumulativeRevenue(BigDecimal cumulativeRevenue) {
        this.cumulativeRevenue = cumulativeRevenue;
        this.updatedAt = LocalDateTime.now();
    }

    public Integer getLastCalibrationUserId() {
        return lastCalibrationUserId;
    }

    public void setLastCalibrationUserId(Integer lastCalibrationUserId) {
        this.lastCalibrationUserId = lastCalibrationUserId;
        this.updatedAt = LocalDateTime.now();
    }
}