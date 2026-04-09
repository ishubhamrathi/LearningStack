package LLD.ProxyDesignPattern.dao.impl;

import LLD.ProxyDesignPattern.dao.EmployeeDao;
import LLD.ProxyDesignPattern.models.Client;
import LLD.ProxyDesignPattern.models.EmployeeEntity;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void create(Client client, EmployeeEntity employee) throws Exception {
        IO.println("Employee object created with following Details: " + employee.prettyEmployeeDetails());
    }

    @Override
    public void delete(Client client, int employeeId) throws Exception {
        IO.println("Employee object deleted with following Details: " + employeeId);
    }

    @Override
    public void get(Client client, int employeeId) throws Exception {
        IO.println("Employee object returned for: " + employeeId);
    }
}
