package com.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ARUN on 10/12/2017.
 */
@Entity
@Table(name = "product")
public class EProduct implements Serializable {


    @Id
    @Generated(GenerationTime.INSERT)
    @Column(name = "product_id",columnDefinition = "serial")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id",nullable=false)
    private EDepartment department;


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public EDepartment getEDepartment() {
        return department;
    }

    public void setEDepartment(EDepartment department) {
        this.department = department;
    }
}
