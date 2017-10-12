package com.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ARUN on 10/12/2017.
 */
@Entity
@Table(name = "department")
public class EDepartment {
    @Id
    @Generated(GenerationTime.INSERT)
    @Column(name="department_id",columnDefinition = "serial")
    private Integer departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_description")
    private String departmentDescription;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<EProduct> products = new ArrayList<>();



    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public List<EProduct> getProducts() {
        return products;
    }

    public void setProducts(List<EProduct> products) {
        this.products = products;
    }
}
