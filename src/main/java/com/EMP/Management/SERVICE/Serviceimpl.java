package com.EMP.Management.SERVICE;

import com.EMP.Management.Entity.Employee;
import com.EMP.Management.REPOSITORY.EMPRepo;
import com.EMP.Management.SERVICE.ser.ServiceIMPL;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Serviceimpl implements ServiceIMPL {

    @Autowired
    private EMPRepo er;

    @Override
    public Employee createEmp(Employee employee) {
        return er.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return er.findById(id).orElseThrow(() -> new RuntimeException("ID not found"));
    }

    @Override
    public List<Employee> getAll() {
        return er.findAll();
    }

    @Override
    @Transactional
    public Employee updateById(Long id, Employee employee) {
        Employee existingEmployee = er.findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found"));
        existingEmployee.setName(employee.getName());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());
        return er.save(existingEmployee);
    }

    @Override
    public void deleteById(Long id) {
        if (!er.existsById(id)) {
            throw new RuntimeException("ID not found");
        }
        er.deleteById(id);
    }
}
