package business.concretes;

import business.abstracts.CustomerAuthenticationService;
import dataAccess.abstracts.ActivationCodeDao;
import dataAccess.abstracts.UserDao;
import entities.concretes.ActivationCode;
import entities.concretes.Customer;

public class CustomerAuthenticationManager implements CustomerAuthenticationService {
    private UserDao userDao;
    private ActivationCodeDao activationCodeDao;

    public CustomerAuthenticationManager(UserDao userDao,ActivationCodeDao activationCodeDao) {
        this.userDao = userDao;
        this.activationCodeDao = activationCodeDao;
    }

    @Override
    public void sendActivationEmail(Customer customer) {
        System.out.println("Aktivasyon kodunuz "+ customer.getEmail() + " email adresine gönderildi");
    }

    @Override
    public void activateAccount(Customer customer, String activationCode) {
        int customerId = 0;
        int control = 0;
        for (ActivationCode code : activationCodeDao.getActivationCodes()){
            if(code.getActivationCode().equals(activationCode) && customer.getId() == code.getCustomerId()){
                customerId = code.getCustomerId();
            }
        }
        for (Customer item : userDao.getNotApprovedCustomers())
        {
            if (item.getId() == customerId)
            {
                item.setIsApproved(true);
                control++;
            }
        }

        if (control == 1)
            System.out.println("Tebrikler , hesabınız onaylandı , "+customer.getFirstName());
        else
            System.out.println("Aktivasyon kodunuz yanlış");





    }
}
