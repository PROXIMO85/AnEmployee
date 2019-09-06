package com.amazon.employee.service;

import com.amazon.employee.dao.AnEmployeeDao;
import com.amazon.employee.model.AnEmployee;

import java.util.List;

public class AnEmployeeServiceImpl implements AnEmployeeService {

    private AnEmployeeDao anEmployeeDao;

    public AnEmployeeServiceImpl(AnEmployeeDao anEmployeeDao) {
        this.anEmployeeDao = anEmployeeDao;
    }

    @Override
    public List<AnEmployee> getEmployeeList() throws Exception {
        return anEmployeeDao.getEmployeeList();
    }

    @Override
    public String createEmployee(AnEmployee anEmployee) throws Exception {
        return anEmployeeDao.createEmployee(anEmployee);

    }

    @Override
    public AnEmployee getAnEmployeeById(long anemployeeId) throws Exception {
        return anEmployeeDao.getAnEmployeeById(anemployeeId);
    }

    @Override
    public String updateAnEmployee(AnEmployee anEmployee, long anemployeeId) throws Exception {
        return anEmployeeDao.updateAnEmployee(anEmployee, anemployeeId);
    }

    @Override
    public String deleteAnEmployee(long anemployeeId) throws Exception {
        return anEmployeeDao.deleteAnEmployee(anemployeeId);
    }
}
