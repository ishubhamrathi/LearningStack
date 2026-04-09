package LLD.ProxyDesignPattern;

import LLD.ProxyDesignPattern.dao.EmployeeDao;
import LLD.ProxyDesignPattern.dao.impl.EmployeeDaoProxyDaoImpl;
import LLD.ProxyDesignPattern.models.Client;
import LLD.ProxyDesignPattern.models.EmployeeEntity;

public class Main {
    void main() {
        IO.println("=== Proxy Design Pattern LLD Implementation === ");
        try {
            EmployeeDao employeeDao = new EmployeeDaoProxyDaoImpl();
            employeeDao.create(Client.USER, new EmployeeEntity("John Doe", 32, 1));
            IO.println("Operation Successful");
        } catch (Exception e) {
            IO.println(e.getMessage());
        }

        try {
            EmployeeDao employeeDao = new EmployeeDaoProxyDaoImpl();
            employeeDao.create(Client.ADMIN, new EmployeeEntity("John Doe", 32, 1));
            IO.println("Operation Successful");
        } catch (Exception e) {
            IO.println(e.getMessage());
        }
    }
}
