package zd.zmk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zd.zmk.entities.VendingMachine;
import zd.zmk.entities.VendingMachine.Status;
import zd.zmk.services.VendingMachineService;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/vending-machines")
public class VendingMachineController {

    @Autowired
    private VendingMachineService vendingMachineService;

    // GET /api/vending-machines - список всех ТА
    @GetMapping
    public ResponseEntity<Page<VendingMachine>> getAllVendingMachines(
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String company,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        
        Sort sort = sortDir.equalsIgnoreCase("desc") ? 
            Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        
        Page<VendingMachine> vendingMachines = vendingMachineService.getAllVendingMachines(
            status, model, company, pageable);
        
        return ResponseEntity.ok(vendingMachines);
    }

    // GET /api/vending-machines/{id} - получение ТА по ID
    @GetMapping("/{id}")
    public ResponseEntity<VendingMachine> getVendingMachineById(@PathVariable Integer id) {
        Optional<VendingMachine> vendingMachine = vendingMachineService.getVendingMachineById(id);

        if (vendingMachine.isPresent()) {
            return ResponseEntity.ok(vendingMachine.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST /api/vending-machines - создание ТА
    @PostMapping
    public ResponseEntity<VendingMachine> createVendingMachine(
            @Valid @RequestBody VendingMachine vendingMachine) {
        VendingMachine createdVendingMachine = vendingMachineService.createVendingMachine(vendingMachine);
        return new ResponseEntity<>(createdVendingMachine, HttpStatus.CREATED);
    }

    // PUT /api/vending-machines/{id} - обновление ТА
    @PutMapping("/{id}")
    public ResponseEntity<VendingMachine> updateVendingMachine(
            @PathVariable Integer id,
            @Valid @RequestBody VendingMachine vendingMachineDetails) {
        try {
            VendingMachine updatedVendingMachine = vendingMachineService.updateVendingMachine(id, vendingMachineDetails);
            return ResponseEntity.ok(updatedVendingMachine);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/vending-machines/{id} - удаление ТА
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendingMachine(@PathVariable Integer id) {
        try {
            vendingMachineService.deleteVendingMachine(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}