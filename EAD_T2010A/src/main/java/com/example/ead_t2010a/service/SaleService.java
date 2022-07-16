package com.example.ead_t2010a.service;



import com.example.ead_t2010a.entity.Product;
import com.example.ead_t2010a.entity.Sale;
import com.example.ead_t2010a.repository.ProductRepository;
import com.example.ead_t2010a.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;
    public Iterable<Sale> findAll(){
        return saleRepository.findAll();
    }
//    public Product save(Product product){
//        return productRepository.save(product);
//    }
    public Optional<Sale> findById(Long SINo) {
        return saleRepository.findById(SINo);
    }

    public Sale save(Sale sale){
        return saleRepository.save(sale);
    }

    public void deleteById(Long SINo){
        saleRepository.deleteById(SINo);
    }
}
