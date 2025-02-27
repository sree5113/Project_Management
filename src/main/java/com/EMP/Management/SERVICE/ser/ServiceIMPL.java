package com.EMP.Management.SERVICE.ser;

import com.EMP.Management.Entity.Employee;

import java.util.List;

public interface ServiceIMPL {
    Employee createEmp(Employee employee);

    Employee getById(Long id);

    List<Employee> getAll();

    Employee updateById(Long id, Employee employee);

    void deleteById(Long id);
}
