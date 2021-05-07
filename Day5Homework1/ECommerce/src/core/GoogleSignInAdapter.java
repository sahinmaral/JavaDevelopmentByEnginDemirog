package core;

import GoogleSignUp.GoogleSignInManager;
import entities.concretes.Customer;

public class GoogleSignInAdapter implements SignInService {

    GoogleSignInManager signInManager = new GoogleSignInManager();

    @Override
    public void SignIn(Customer customer) {
        signInManager.login( customer.getFirstName(), customer.getLastName(), customer.getEmail() ,  customer.getPassword());
    }
}
