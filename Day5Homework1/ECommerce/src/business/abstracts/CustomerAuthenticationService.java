package business.abstracts;

import entities.concretes.Customer;

public interface CustomerAuthenticationService {
    void sendActivationEmail(Customer customer);
    void activateAccount(Customer customer, String activationCode);
}
