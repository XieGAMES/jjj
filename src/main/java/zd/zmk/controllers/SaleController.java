package zd.zmk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zd.zmk.entities.Sale;
import zd.zmk.services.SaleService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    // GET /api/sales - список продаж с фильтрами
    @GetMapping
    public ResponseEntity<Page<Sale>> getAllSales(
            @RequestParam(required = false) Integer vendingMachineId,
            @RequestParam(required = false) Integer productId,
            @RequestParam(required = false) Sale.PaymentMethod paymentMethod,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("desc") ?
            Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Sale> sales = saleService.getAllSales(
            vendingMachineId, productId, paymentMethod, startDate, endDate, pageable);

        return ResponseEntity.ok(sales);
    }

    // GET /api/sales/{id} - детали продажи
    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Integer id) {
        Optional<Sale> sale = saleService.getSaleById(id);

        if (sale.isPresent()) {
            return ResponseEntity.ok(sale.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST /api/sales - регистрация продажи
    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        Sale createdSale = saleService.createSale(sale);
        return ResponseEntity.ok(createdSale);
    }

    // GET /api/sales/aggregated - агрегированные данные (сумма за период)
    @GetMapping("/aggregated")
    public ResponseEntity<SaleAggregatedData> getAggregatedData(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

        BigDecimal totalAmount = saleService.calculateTotalSalesAmount(startDate, endDate);
        Long totalSales = saleService.countSales(startDate, endDate);

        SaleAggregatedData aggregatedData = new SaleAggregatedData(totalAmount, totalSales);
        return ResponseEntity.ok(aggregatedData);
    }

    // Inner class for aggregated data response
    public static class SaleAggregatedData {
        private BigDecimal totalAmount;
        private Long totalSales;

        public SaleAggregatedData(BigDecimal totalAmount, Long totalSales) {
            this.totalAmount = totalAmount != null ? totalAmount : BigDecimal.ZERO;
            this.totalSales = totalSales != null ? totalSales : 0L;
        }

        public BigDecimal getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
        }

        public Long getTotalSales() {
            return totalSales;
        }

        public void setTotalSales(Long totalSales) {
            this.totalSales = totalSales;
        }
    }
}