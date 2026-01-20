package zd.zmk.desktop.model;

import javafx.beans.property.*;

public class VendingMachineModel {
    
    private final IntegerProperty id;
    private final StringProperty serialNumber;
    private final StringProperty inventoryNumber;
    private final StringProperty model;
    private final StringProperty company;
    private final StringProperty status;
    private final StringProperty location;
    
    public VendingMachineModel() {
        this.id = new SimpleIntegerProperty();
        this.serialNumber = new SimpleStringProperty();
        this.inventoryNumber = new SimpleStringProperty();
        this.model = new SimpleStringProperty();
        this.company = new SimpleStringProperty();
        this.status = new SimpleStringProperty();
        this.location = new SimpleStringProperty();
    }
    
    public VendingMachineModel(int id, String serialNumber, String inventoryNumber, String model, 
                              String company, String status, String location) {
        this.id = new SimpleIntegerProperty(id);
        this.serialNumber = new SimpleStringProperty(serialNumber);
        this.inventoryNumber = new SimpleStringProperty(inventoryNumber);
        this.model = new SimpleStringProperty(model);
        this.company = new SimpleStringProperty(company);
        this.status = new SimpleStringProperty(status);
        this.location = new SimpleStringProperty(location);
    }
    
    // Getters
    public int getId() { return id.get(); }
    public String getSerialNumber() { return serialNumber.get(); }
    public String getInventoryNumber() { return inventoryNumber.get(); }
    public String getModel() { return model.get(); }
    public String getCompany() { return company.get(); }
    public String getStatus() { return status.get(); }
    public String getLocation() { return location.get(); }
    
    // Setters
    public void setId(int id) { this.id.set(id); }
    public void setSerialNumber(String serialNumber) { this.serialNumber.set(serialNumber); }
    public void setInventoryNumber(String inventoryNumber) { this.inventoryNumber.set(inventoryNumber); }
    public void setModel(String model) { this.model.set(model); }
    public void setCompany(String company) { this.company.set(company); }
    public void setStatus(String status) { this.status.set(status); }
    public void setLocation(String location) { this.location.set(location); }
    
    // Property getters for binding
    public IntegerProperty idProperty() { return id; }
    public StringProperty serialNumberProperty() { return serialNumber; }
    public StringProperty inventoryNumberProperty() { return inventoryNumber; }
    public StringProperty modelProperty() { return model; }
    public StringProperty companyProperty() { return company; }
    public StringProperty statusProperty() { return status; }
    public StringProperty locationProperty() { return location; }
}