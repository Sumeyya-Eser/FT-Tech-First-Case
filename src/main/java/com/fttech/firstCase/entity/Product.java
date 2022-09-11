package com.fttech.firstCase.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    private String price;

    @Column(length = 50, nullable = false)
    private Date leDate;

}
