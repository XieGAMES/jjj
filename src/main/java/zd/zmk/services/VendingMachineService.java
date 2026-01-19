package zd.zmk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zd.zmk.entities.VendingMachine;
import zd.zmk.entities.VendingMachine.Status;
import zd.zmk.repositories.VendingMachineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VendingMachineService {

    @Autowired
    private VendingMachineRepository vendingMachineRepository;

    // Get all vending machines with pagination and filtering
    public Page<VendingMachine> getAllVendingMachines(
            Status status, 
            String model, 
            String company, 
            Pageable pageable) {
        return vendingMachineRepository.findByCriteria(status, model, company, pageable);
    }

    // Get vending machine by ID
    public Optional<VendingMachine> getVendingMachineById(Integer id) {
        return vendingMachineRepository.findById(id);
    }

    // Create a new vending machine
    public VendingMachine createVendingMachine(VendingMachine vendingMachine) {
        // Check if a vending machine with the same serial number already exists
        if (vendingMachineRepository.existsBySerialNumber(vendingMachine.getSerialNumber())) {
            throw new RuntimeException("Vending machine with serial number " +
                vendingMachine.getSerialNumber() + " already exists");
        }
        return vendingMachineRepository.save(vendingMachine);
    }

    // Update an existing vending machine
    public VendingMachine updateVendingMachine(Integer id, VendingMachine vendingMachineDetails) {
        VendingMachine vendingMachine = vendingMachineRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vending machine not found with id: " + id));

        // Check if the serial number is being changed and if the new serial number already exists
        if (!vendingMachine.getSerialNumber().equals(vendingMachineDetails.getSerialNumber()) &&
            vendingMachineRepository.existsBySerialNumber(vendingMachineDetails.getSerialNumber())) {
            throw new RuntimeException("Vending machine with serial number " +
                vendingMachineDetails.getSerialNumber() + " already exists");
        }

        vendingMachine.setSerialNumber(vendingMachineDetails.getSerialNumber());
        vendingMachine.setInventoryNumber(vendingMachineDetails.getInventoryNumber());
        vendingMachine.setModel(vendingMachineDetails.getModel());
        vendingMachine.setCompany(vendingMachineDetails.getCompany());
        vendingMachine.setStatus(vendingMachineDetails.getStatus());
        vendingMachine.setLocation(vendingMachineDetails.getLocation());
        vendingMachine.setMachineType(vendingMachineDetails.getMachineType());
        vendingMachine.setCountryOfOrigin(vendingMachineDetails.getCountryOfOrigin());
        vendingMachine.setManufacturingDate(vendingMachineDetails.getManufacturingDate());
        vendingMachine.setCommissioningDate(vendingMachineDetails.getCommissioningDate());
        vendingMachine.setLastCalibrationDate(vendingMachineDetails.getLastCalibrationDate());
        vendingMachine.setCalibrationIntervalMonths(vendingMachineDetails.getCalibrationIntervalMonths());
        vendingMachine.setTaResourceHours(vendingMachineDetails.getTaResourceHours());
        vendingMachine.setNextServiceDate(vendingMachineDetails.getNextServiceDate());
        vendingMachine.setServiceDurationHours(vendingMachineDetails.getServiceDurationHours());
        vendingMachine.setInventoryDate(vendingMachineDetails.getInventoryDate());
        vendingMachine.setCumulativeRevenue(vendingMachineDetails.getCumulativeRevenue());
        vendingMachine.setLastCalibrationUserId(vendingMachineDetails.getLastCalibrationUserId());

        return vendingMachineRepository.save(vendingMachine);
    }

    // Delete a vending machine
    public void deleteVendingMachine(Integer id) {
        VendingMachine vendingMachine = vendingMachineRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vending machine not found with id: " + id));
        vendingMachineRepository.delete(vendingMachine);
    }
}