package com.example.service;

import com.example.domain.EProduct;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.util.MapperUtil.eProductMapper;
import static com.example.util.MapperUtil.productMapper;

/**
 * Created by ARUN on 10/12/2017.
 */
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product findOne(Integer productId) {
        EProduct eProduct= productRepository.findOne(productId);
        return productMapper.apply(eProduct);
    }

    public Product save(Product product) {
        EProduct eProduct= productRepository.save(eProductMapper.apply(product));
        return productMapper.apply(eProduct);
    }
}
