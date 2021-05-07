package business.abstracts;

import entities.concretes.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    List<Customer> getNotApprovedCustomers();
    List<Customer> getApprovedCustomer();
    void logIn(Customer customer);
    List<Customer> getAllCustomers();

}
