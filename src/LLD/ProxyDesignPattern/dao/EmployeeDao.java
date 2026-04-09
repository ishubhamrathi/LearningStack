package LLD.ProxyDesignPattern.dao;

import LLD.ProxyDesignPattern.models.Client;
import LLD.ProxyDesignPattern.models.EmployeeEntity;

public interface EmployeeDao {
    public void create(Client client, EmployeeEntity employee) throws Exception;
    public void delete(Client client, int employeeId) throws Exception;
    public void get(Client client, int employeeId) throws Exception;
}
