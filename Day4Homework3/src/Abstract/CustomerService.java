package Abstract;

import Entities.Customer;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    void addCustomer(Customer[] _customers);
    void deleteCustomer(Customer customer);
    void getCustomers();
    List<Customer> retrieveCustomers();
    void updateCustomer(Customer customer, String firstName, String lastName, String nationalityId , LocalDate dateOfBirth);
}
