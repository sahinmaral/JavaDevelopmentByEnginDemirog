package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.CustomerCheckService;
import Entities.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TurkishIdCustomerManager extends BaseCustomerManager {
    List<Customer> customers = new ArrayList<>();

    private CustomerCheckService customerCheckService;

    public TurkishIdCustomerManager(CustomerCheckService customerCheckService) {
        this.customerCheckService = customerCheckService;
    }

    @Override
    public void addCustomer(Customer customer) {
        if (customerCheckService.checkIfRealPerson(customer))
        {
            customers.add(customer);
            System.out.println("Customer added : "+customer.getFirstName());
        }
        else
        {
            System.out.println("Not a valid person");
        }

    }

    @Override
    public void addCustomer(Customer[] _customers) {

        for(Customer customer : _customers ) {
            if (customerCheckService.checkIfRealPerson(customer)) {
                customers.add(customer);
                System.out.println("Customer added : " + customer.getFirstName());
            } else {
                System.out.println("Customer : "+customer.getFirstName()+" is not valid person");
            }
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
        System.out.println("Customer deleted : "+customer.getFirstName());
    }

    @Override
    public void getCustomers() {

        System.out.println("Customers");
        System.out.println("----------------------------");
        for (Customer customer:customers) {
            System.out.println("Customer name : "+customer.getFirstName());
            System.out.println("Customer surname : "+customer.getLastName());
            System.out.println("----------------------------");
        }

    }

    @Override
    public List<Customer> retrieveCustomers() {
        return customers;
    }


    @Override
    public void updateCustomer(Customer customer, String firstName, String lastName, String nationalityId , LocalDate dateOfBirth) {
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setNationalityId(nationalityId);
        customer.setDateOfBirth(dateOfBirth);
        System.out.println("Customer modified : "+customer.getFirstName());
    }
}
