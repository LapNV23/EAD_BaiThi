package com.example.ead_t2010a.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "products")
public class Product {
    @Id

    private String ProdID;
    private String ProdName;
    private String Description;
    private String DateOfManf;
    private double Price;
}
