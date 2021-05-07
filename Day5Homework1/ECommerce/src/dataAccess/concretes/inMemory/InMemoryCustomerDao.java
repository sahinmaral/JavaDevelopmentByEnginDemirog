package dataAccess.concretes.inMemory;

import dataAccess.abstracts.UserDao;
import entities.concretes.Customer;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerDao implements UserDao {
    List<Customer> customers = new ArrayList<>();
    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public List<Customer> getNotApprovedCustomers() {
        List<Customer> c = new ArrayList<>();
        for (Customer customer : customers)
        {
            if(!customer.getIsApproved())
            c.add(customer);
        }
        return c;
    }

    @Override
    public List<Customer> getApprovedCustomers() {
        List<Customer> c = new ArrayList<>();
        for (Customer customer : customers)
        {
            if (customer.getIsApproved())
                c.add(customer);
        }
        return c;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }


}
