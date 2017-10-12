package com.example.util;

import com.example.domain.EDepartment;
import com.example.domain.EProduct;
import com.example.model.Department;
import com.example.model.Product;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by ARUN on 10/12/2017.
 */
public class MapperUtil {
    public static Function<EProduct, Product> productMapper = eProduct -> {
        return new Product.Builder()
                .productId(eProduct.getProductId())
                .productName(eProduct.getProductName())
                .productDescription(eProduct.getProductDescription())
                .department(new Department.Builder()
                        .departmentId(eProduct.getEDepartment().getDepartmentId())
                        .departmentName(eProduct.getEDepartment().getDepartmentName())
                        .departmentDescription(eProduct.getEDepartment().getDepartmentDescription()).build())
                .build();
    };
    public static Function<Product, EProduct> eProductMapper = product -> {
        EDepartment eDepartment = null;
        if(product.department()!=null) {
            eDepartment = new EDepartment();
            eDepartment.setDepartmentId(product.department().departmentId());
            eDepartment.setDepartmentName(product.department().departmentName());
            eDepartment.setDepartmentDescription(product.department().departmentDescription());
        }

        EProduct eProduct = new EProduct();
        eProduct.setProductId(product.productId());
        eProduct.setProductName(product.productName());
        eProduct.setProductDescription(product.productDescription());
        eProduct.setEDepartment(eDepartment);
        return eProduct;

    };
    public static Function<EDepartment, Department> departmentMapper = eDepartment -> {
        return new Department.Builder().departmentId(eDepartment.getDepartmentId())
                .departmentName(eDepartment.getDepartmentName())
                .departmentDescription(eDepartment.getDepartmentDescription())
                .products(eDepartment.getProducts().stream().map(eProduct -> {
                            return new Product.Builder()
                                    .productId(eProduct.getProductId())
                                    .productName(eProduct.getProductName())
                                    .productDescription(eProduct.getProductDescription()).build();
                        }
                ).collect(Collectors.toList())).build();
    };
    public static Function<Department, EDepartment> eDepartmentMapper = department -> {
        EDepartment eDepartment = new EDepartment();
        eDepartment.setDepartmentId(department.departmentId());
        eDepartment.setDepartmentName(department.departmentName());
        eDepartment.setDepartmentDescription(department.departmentDescription());
        eDepartment.setProducts(department.products().stream().map(eProductMapper).collect(Collectors.toList()));
        return eDepartment;
    };

}
