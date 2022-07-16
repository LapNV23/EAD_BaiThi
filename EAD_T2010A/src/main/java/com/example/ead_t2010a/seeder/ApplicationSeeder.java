package com.example.ead_t2010a.seeder;

import com.example.ead_t2010a.entity.Product;
import com.example.ead_t2010a.entity.Sale;
import com.example.ead_t2010a.repository.ProductRepository;
import com.example.ead_t2010a.repository.SaleRepository;
import com.example.ead_t2010a.util.NumberUtil;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Slf4j
public class ApplicationSeeder implements CommandLineRunner {
    boolean createSeedData = true;
    final ProductRepository productRepository;
    final SaleRepository saleRepository;
    Faker faker;
    Random random = new Random();

    int numberOfSale = 100;

    public ApplicationSeeder(ProductRepository productRepository, SaleRepository saleRepository) {
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        if (createSeedData) {
            saleRepository.deleteAll();
            seedProduct();
            seedSale();
        }
    }

    private void seedProduct() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Produc-01","Táo",  "Ngon", "01-12-2020", 100));
        products.add(new Product("Product-02", "Ổi", "Ngon lắm", "17-07-2010", 1090));
        products.add(new Product("Product-03", "Lê","Cực ngon", "28-01-2015", 8200));
        products.add(new Product("Product-04", "Dứa",  "Ngon cực kì", "21-09-2018", 4400));
        products.add(new Product("Product-05","Xoài", "Không ngon", "30-06-2022", 10000));
        productRepository.saveAll(products);
    }

    private void seedSale() {
        List<Sale> saleList = new ArrayList<>();
        List<Product> productList = productRepository.findAll();
        for (int i = 0; i < numberOfSale; i++) {
            Sale sale = new Sale();
            sale.setSalesmanID(faker.number().numberBetween(1, 10));
            sale.setDOS(faker.name().name());
            sale.setProdID(productList.get(random.nextInt(productList.size())));
            sale.setSalesmanName(faker.name().fullName());
            saleList.add(sale);
        }
        saleRepository.saveAll(saleList);
    }
}
