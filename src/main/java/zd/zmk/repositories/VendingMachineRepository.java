package zd.zmk.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zd.zmk.entities.VendingMachine;
import zd.zmk.entities.VendingMachine.Status;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendingMachineRepository extends JpaRepository<VendingMachine, Integer> {
    
    // Find vending machines by status
    List<VendingMachine> findByStatus(Status status);
    
    // Find vending machines by model
    List<VendingMachine> findByModel(String model);
    
    // Find vending machines by company
    List<VendingMachine> findByCompany(String company);
    
    // Find vending machines by status, model, and company with pagination
    Page<VendingMachine> findByStatusAndModelAndCompany(
        Status status, 
        String model, 
        String company, 
        Pageable pageable
    );
    
    // Find vending machines by status with pagination
    Page<VendingMachine> findByStatus(Status status, Pageable pageable);
    
    // Find vending machines by model with pagination
    Page<VendingMachine> findByModel(String model, Pageable pageable);
    
    // Find vending machines by company with pagination
    Page<VendingMachine> findByCompany(String company, Pageable pageable);
    
    // Find vending machines by multiple criteria with pagination
    @Query("SELECT vm FROM VendingMachine vm WHERE " +
           "(:status IS NULL OR vm.status = :status) AND " +
           "(:model IS NULL OR vm.model = :model) AND " +
           "(:company IS NULL OR vm.company = :company)")
    Page<VendingMachine> findByCriteria(
        @Param("status") Status status,
        @Param("model") String model,
        @Param("company") String company,
        Pageable pageable
    );
    
    // Check if a vending machine exists by serial number
    boolean existsBySerialNumber(String serialNumber);
}