package com.example;

import com.example.domain.EDepartment;
import com.example.domain.EProduct;
import com.example.repository.DepartmentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ARUN on 10/12/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentRepositoryTest {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        Assert.assertNotNull(dataSource.getConnection());
    }

    @Test
    @Transactional
    public void saveDepartment() {

        EDepartment EDepartment = new EDepartment();
        EDepartment.setDepartmentId(101);
        EDepartment.setDepartmentName("manufactoring");
        EDepartment.setDepartmentDescription("manufactoring in a lab");
        EProduct EProduct1 = new EProduct();
        EProduct1.setProductId(1);
        EProduct1.setProductName("varilux");
        EProduct1.setProductDescription("lens");
        EProduct EProduct2 = new EProduct();
        EProduct2.setProductId(2);
        EProduct2.setProductDescription("lens");
        EProduct2.setProductName("crizal");
        List<EProduct> EProductList = new ArrayList<>();
        EProductList.add(EProduct1);
        EProductList.add(EProduct2);
        EDepartment.setProducts(EProductList);
        EDepartment savedEDepartment = departmentRepository.save(EDepartment);
        Assert.assertEquals(savedEDepartment.getDepartmentName(), EDepartment.getDepartmentName());
        Assert.assertEquals(savedEDepartment.getDepartmentId(), EDepartment.getDepartmentId());
        Assert.assertEquals(savedEDepartment.getProducts().size(), 2);
        Assert.assertEquals(savedEDepartment.getDepartmentDescription(), EDepartment.getDepartmentDescription());
    }
}
