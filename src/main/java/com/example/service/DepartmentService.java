package com.example.service;

import com.example.domain.EDepartment;
import com.example.model.Department;
import com.example.repository.DepartmentRepository;
import com.example.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.util.MapperUtil.departmentMapper;
import static com.example.util.MapperUtil.eDepartmentMapper;

/**
 * Created by ARUN on 10/12/2017.
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department fineOne(Integer departmentId) {
        EDepartment eDepartment = departmentRepository.findOne(departmentId);
        Department department = null;
        if (eDepartment != null) {
            department = MapperUtil.departmentMapper.apply(eDepartment);
        }
        return department;
    }

    public Department save(Department department) {
        EDepartment edepartment = eDepartmentMapper.apply(department);
        return departmentMapper.apply(departmentRepository.save(edepartment));
    }
}
