package zd.zmk.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zd.zmk.entities.VendingMachine;
import zd.zmk.services.VendingMachineService;

import java.util.Optional;

@Service
public class WebVendingMachineService {

    @Autowired
    private VendingMachineService vendingMachineService;

    public Page<VendingMachine> getAllVendingMachines() {
        // In a real implementation, we would fetch from the API
        // For now, we'll use the existing service
        // Using a large page size to get all records
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);
        return vendingMachineService.getAllVendingMachines(null, null, null, pageable);
    }

    public Optional<VendingMachine> getVendingMachineById(Long id) {
        // In a real implementation, we would fetch from the API
        // For now, we'll use the existing service
        return vendingMachineService.getVendingMachineById(Math.toIntExact(id));
    }

    public VendingMachine saveVendingMachine(VendingMachine vendingMachine) {
        // In a real implementation, we would call the API
        // For now, we'll use the existing service
        return vendingMachineService.createVendingMachine(vendingMachine);
    }

    public void deleteVendingMachine(Long id) {
        // In a real implementation, we would call the API
        // For now, we'll use the existing service
        vendingMachineService.deleteVendingMachine(Math.toIntExact(id));
    }
}