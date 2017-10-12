package com.example.controller;

import com.example.domain.EProduct;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import jdk.internal.org.objectweb.asm.commons.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ARUN on 10/12/2017.
 */
@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Product findProduct(@RequestParam("product_id") Integer productId){
      return  productService.findOne(productId);
    }
    @RequestMapping(path = "/save",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public @ResponseBody Product saveProduct(@RequestBody Product product){
        return  productService.save(product);
    }
}
