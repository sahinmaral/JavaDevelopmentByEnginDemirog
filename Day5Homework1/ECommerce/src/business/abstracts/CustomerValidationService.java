package business.abstracts;

import entities.concretes.Customer;

import java.util.List;

public interface CustomerValidationService {
    boolean checkEmailIsValid(String email);
    boolean checkEmailIsExist(String email , List<Customer> customers);
    boolean isEmptyInformations(Customer customer);
    boolean checkAccountIsApproved(Customer customer, List<Customer> customers);
    boolean checkAccountIsValid(Customer customer,List<Customer> customers);
    boolean checkFirstLastNameLength(Customer customer);
    boolean checkPasswordLength(Customer customer);
}
