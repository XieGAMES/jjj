package zd.zmk.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zd.zmk.entities.Sale;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    // Find sales by vending machine
    List<Sale> findByVendingMachineId(Integer vendingMachineId);

    // Find sales by product
    List<Sale> findByProductId(Integer productId);

    // Find sales by payment method
    List<Sale> findByPaymentMethod(zd.zmk.entities.Sale.PaymentMethod paymentMethod);

    // Find sales by date range
    List<Sale> findBySaleDatetimeBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Find sales by multiple criteria with pagination
    @Query("SELECT s FROM Sale s WHERE " +
           "(:vendingMachineId IS NULL OR s.vendingMachine.id = :vendingMachineId) AND " +
           "(:productId IS NULL OR s.product.id = :productId) AND " +
           "(:paymentMethod IS NULL OR s.paymentMethod = :paymentMethod) AND " +
           "(:startDate IS NULL OR :endDate IS NULL OR (s.saleDatetime >= :startDate AND s.saleDatetime <= :endDate))")
    Page<Sale> findByCriteria(
        @Param("vendingMachineId") Integer vendingMachineId,
        @Param("productId") Integer productId,
        @Param("paymentMethod") zd.zmk.entities.Sale.PaymentMethod paymentMethod,
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate,
        Pageable pageable
    );

    // Find sales by multiple criteria without pagination
    @Query("SELECT s FROM Sale s WHERE " +
           "(:vendingMachineId IS NULL OR s.vendingMachine.id = :vendingMachineId) AND " +
           "(:productId IS NULL OR s.product.id = :productId) AND " +
           "(:paymentMethod IS NULL OR s.paymentMethod = :paymentMethod) AND " +
           "(:startDate IS NULL OR :endDate IS NULL OR (s.saleDatetime >= :startDate AND s.saleDatetime <= :endDate))")
    List<Sale> findByCriteria(
        @Param("vendingMachineId") Integer vendingMachineId,
        @Param("productId") Integer productId,
        @Param("paymentMethod") zd.zmk.entities.Sale.PaymentMethod paymentMethod,
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate
    );

    // Calculate total sales amount for a date range
    @Query("SELECT SUM(s.totalAmount) FROM Sale s WHERE " +
           "(:startDate IS NULL OR :endDate IS NULL OR (s.saleDatetime >= :startDate AND s.saleDatetime <= :endDate))")
    BigDecimal calculateTotalSalesAmount(
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate
    );

    // Count sales for a date range
    @Query("SELECT COUNT(s) FROM Sale s WHERE " +
           "(:startDate IS NULL OR :endDate IS NULL OR (s.saleDatetime >= :startDate AND s.saleDatetime <= :endDate))")
    Long countSales(
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate
    );
}