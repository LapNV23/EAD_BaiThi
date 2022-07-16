package com.example.ead_t2010a.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long SINo;
    private long SalesmanID;
    private String SalesmanName;
    @ManyToOne
    @JoinColumn(name = "ProdID", referencedColumnName = "ProdID")
    private Product ProdID;
    private String DOS;
}
