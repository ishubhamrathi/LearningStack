package LLD.ProxyDesignPattern.dao.impl;

import LLD.ProxyDesignPattern.dao.EmployeeDao;
import LLD.ProxyDesignPattern.models.Client;
import LLD.ProxyDesignPattern.models.EmployeeEntity;

public class EmployeeDaoProxyDaoImpl implements EmployeeDao {

    EmployeeDao employeeDao;

    public EmployeeDaoProxyDaoImpl() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(Client client, EmployeeEntity employee) throws Exception {
        if (client == Client.ADMIN) {
            employeeDao.create(client, employee);
            return;
        }

        throw new Exception("Access Denied");
    }

    @Override
    public void delete(Client client, int employeeId) throws Exception {
        if (client == Client.ADMIN) {
            employeeDao.delete(client, employeeId);
            return;
        }

        throw new Exception("Access Denied");
    }

    @Override
    public void get(Client client, int employeeId) throws Exception {
        if (client == Client.ADMIN || client == Client.USER) {
            employeeDao.get(client, employeeId);
        }
    }
}
