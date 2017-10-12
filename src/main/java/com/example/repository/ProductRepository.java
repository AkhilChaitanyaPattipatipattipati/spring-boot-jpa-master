package com.example.repository;

import com.example.domain.EProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ARUN on 10/12/2017.
 */
@Repository
public interface ProductRepository extends CrudRepository<EProduct,Integer> {
}
