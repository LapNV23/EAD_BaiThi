package com.example.ead_t2010a.service;



import com.example.ead_t2010a.entity.Product;
import com.example.ead_t2010a.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }
//    public Product save(Product product){
//        return productRepository.save(product);
//    }
    public Optional<Product> findById(String ProdID) {
        return productRepository.findById(ProdID);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteById(String ProdID){
        productRepository.deleteById(ProdID);
    }
}
