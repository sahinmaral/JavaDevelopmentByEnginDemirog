package Abstract;

import Entities.Customer;

import java.time.LocalDate;

public abstract class BaseCustomerManager implements CustomerService {
    public void addCustomer(Customer customer){
        System.out.println("Kayıt edildi");
    }
    public void deleteCustomer(Customer customer){
        System.out.println("Kayıt siindi");
    }
    public void getCustomers(){

    }
    public void updateCustomer(Customer customer, String firstName, String lastName, String nationalityId , LocalDate dateOfBirth) {
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setNationalityId(nationalityId);
        customer.setDateOfBirth(dateOfBirth);
        System.out.println("Customer modified : "+customer.getFirstName());
    }
    public void addCustomer(Customer[] _customers){

    }

}
