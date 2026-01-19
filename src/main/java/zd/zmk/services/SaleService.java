package zd.zmk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zd.zmk.entities.Sale;
import zd.zmk.repositories.SaleRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public Page<Sale> getAllSales(
            Integer vendingMachineId,
            Integer productId,
            Sale.PaymentMethod paymentMethod,
            LocalDateTime startDate,
            LocalDateTime endDate,
            Pageable pageable) {
        
        return saleRepository.findByCriteria(vendingMachineId, productId, paymentMethod, startDate, endDate, pageable);
    }

    public Optional<Sale> getSaleById(Integer id) {
        return saleRepository.findById(id);
    }

    public Sale createSale(Sale sale) {
        // Set sale date if not provided
        if (sale.getSaleDatetime() == null) {
            sale.setSaleDatetime(LocalDateTime.now());
        }

        return saleRepository.save(sale);
    }

    public List<Sale> getSalesByCriteria(
            Integer vendingMachineId,
            Integer productId,
            Sale.PaymentMethod paymentMethod,
            LocalDateTime startDate,
            LocalDateTime endDate) {
        
        return saleRepository.findByCriteria(vendingMachineId, productId, paymentMethod, startDate, endDate);
    }

    public BigDecimal calculateTotalSalesAmount(LocalDateTime startDate, LocalDateTime endDate) {
        return saleRepository.calculateTotalSalesAmount(startDate, endDate);
    }

    public Long countSales(LocalDateTime startDate, LocalDateTime endDate) {
        return saleRepository.countSales(startDate, endDate);
    }
}