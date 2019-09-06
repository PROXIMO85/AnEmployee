package com.amazon.employee.service;

import com.amazon.employee.model.AnEmployee;

import java.util.List;

public interface AnEmployeeService {

    List<AnEmployee> getEmployeeList() throws Exception;
    String createEmployee (AnEmployee anEmployee) throws Exception;
    AnEmployee getAnEmployeeById(long anemployeeId) throws Exception;
    String updateAnEmployee (AnEmployee anEmployee, long anemployeeId) throws Exception;
    String deleteAnEmployee (long anemployeeId) throws Exception;
}
