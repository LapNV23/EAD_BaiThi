package com.example.ead_t2010a.controller;

import com.example.ead_t2010a.entity.Product;
import com.example.ead_t2010a.service.ProductService;
import com.example.ead_t2010a.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(path = "api/v1/products")
public class ProductApi {
    @Autowired
    ProductService productService;
    @Autowired
    SaleService saleService;
    public ProductApi(ProductService productService, SaleService saleService) {
        this.productService = productService;
        this.saleService = saleService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> getList(){
        return ResponseEntity.ok(productService.findAll());
    }
}
