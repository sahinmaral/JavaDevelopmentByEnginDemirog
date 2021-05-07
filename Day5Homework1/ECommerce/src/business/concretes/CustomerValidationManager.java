package business.concretes;

import business.abstracts.CustomerValidationService;
import entities.concretes.Customer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerValidationManager implements CustomerValidationService {

    public boolean checkEmailIsExist(String email,List<Customer> customers){
        for (Customer customer : customers)
        {
            if(customer.getEmail().equals(email)) return true;
        }
        return false;
    }

    @Override
    public boolean isEmptyInformations(Customer customer) {
        return customer.getFirstName().equals("") ||
                customer.getLastName().equals("") ||
                customer.getEmail().equals("") ||
                customer.getPassword().equals("");
    }

    public boolean checkAccountIsApproved(Customer _customer, List<Customer> customers)
    {
        for (Customer customer : customers)
        {
            if(customer.getEmail().equals(_customer.getEmail()) && customer.getEmail().equals(_customer.getEmail()))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkAccountIsValid(Customer customer,List<Customer> customers) {
        for (Customer item : customers)
        {
            if (item.getEmail().equals(customer.getEmail()) && item.getPassword().equals(customer.getPassword()))
                return true;
        }
        return false;
    }

    public boolean checkFirstLastNameLength(Customer customer){
        return customer.getFirstName().length() < 2 || customer.getLastName().length() < 2;
    }

    public boolean checkPasswordLength(Customer customer)
    {
        return customer.getPassword().length() <= 6;
    }


    @Override
    public boolean checkEmailIsValid(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher m = pattern.matcher(email);
        return !m.matches();
    }


}
