package com.example.repository;

import com.example.domain.EDepartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ARUN on 10/12/2017.
 */
@Repository
public interface DepartmentRepository extends CrudRepository<EDepartment,Integer> {
}
