package dataAccess.abstracts;

import entities.concretes.Customer;

import java.util.List;


public interface UserDao {
    void addCustomer(Customer customer);
    List<Customer> getNotApprovedCustomers();
    List<Customer> getApprovedCustomers();
    List<Customer> getAllCustomers();
}
