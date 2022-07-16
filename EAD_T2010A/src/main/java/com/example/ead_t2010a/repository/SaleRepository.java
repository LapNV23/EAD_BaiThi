package com.example.ead_t2010a.repository;



import com.example.ead_t2010a.entity.Product;
import com.example.ead_t2010a.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
