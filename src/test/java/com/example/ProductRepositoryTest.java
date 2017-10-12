package com.example;

import com.example.domain.EDepartment;
import com.example.domain.EProduct;
import com.example.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by ARUN on 10/12/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        Assert.assertNotNull(dataSource.getConnection());
    }

    @Test
    @Transactional
    public void saveProduct() {
        EProduct EProduct = new EProduct();
        EProduct.setProductId(1);
        EProduct.setProductName("prevencia");
        EProduct.setProductDescription("lens");
        EDepartment EDepartment = new EDepartment();
        EDepartment.setDepartmentId(101);
        EDepartment.setDepartmentName("manufactoring");
        EDepartment.setDepartmentDescription("manufactoring in a lab");
        EProduct.setEDepartment(EDepartment);

        EProduct savedEProduct = productRepository.save(EProduct);
        Assert.assertEquals(savedEProduct.getProductId(), EProduct.getProductId());
        Assert.assertEquals(savedEProduct.getProductName(), EProduct.getProductName());
        Assert.assertEquals(savedEProduct.getProductDescription(), EProduct.getProductDescription());
    }

    @Test
    @Transactional
    public void selectProduct() {
        EProduct EProduct4 = new EProduct();
        EProduct4.setProductId(2);
        EProduct4.setProductName("prevencia");
        EProduct4.setProductDescription("lens");
        EDepartment EDepartment4 = new EDepartment();
        EDepartment4.setDepartmentId(101);
        EDepartment4.setDepartmentName("manufactoring");
        EDepartment4.setDepartmentDescription("manufactoring in a lab");
        EProduct4.setEDepartment(EDepartment4);
        productRepository.save(EProduct4);

        EProduct selectedEProduct = productRepository.findOne(EProduct4.getProductId());

        Assert.assertEquals(selectedEProduct.getProductId(), EProduct4.getProductId());
        Assert.assertEquals(selectedEProduct.getProductName(), EProduct4.getProductName());

    }
}
