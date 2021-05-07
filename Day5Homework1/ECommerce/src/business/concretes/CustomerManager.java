package business.concretes;

import business.abstracts.CustomerService;
import business.abstracts.CustomerValidationService;
import dataAccess.abstracts.ActivationCodeDao;
import dataAccess.abstracts.UserDao;
import entities.concretes.ActivationCode;
import entities.concretes.Customer;

import java.util.List;


public class CustomerManager implements CustomerService {

    private UserDao userDao;
    private CustomerValidationService validationService;
    private ActivationCodeDao activationDao;

    public CustomerManager(UserDao userDao, CustomerValidationService validationService , ActivationCodeDao activationDao) {
        this.userDao = userDao;
        this.validationService = validationService;
        this.activationDao = activationDao;
    }

    @Override
    public void logIn(Customer customer) {
            if(validationService.checkAccountIsApproved(customer,userDao.getNotApprovedCustomers()))
                System.out.println("Hesabınız onaylanmamış , e-mailine gelen kod ile onaylayınız , "+ customer.getFirstName());
            else if (!validationService.checkAccountIsValid(customer,userDao.getApprovedCustomers()))
                System.out.println("Email veya parolanız yanlış  , tekrar deneyiniz , "+customer.getFirstName());
            else System.out.println("Başarılı bir şekilde giriş yaptınız , "+customer.getFirstName());

    }

    @Override
    public List<Customer> getAllCustomers() {
        return userDao.getAllCustomers();
    }


    @Override
    public void addCustomer(Customer customer) {

        if(validationService.isEmptyInformations(customer))
            System.out.println("Lütfen boş bıraktığınız alanları doldurunuz, "+customer.getFirstName());
        else if (validationService.checkPasswordLength(customer))
            System.out.println("Parolanız en az 6 karakterden oluşmalıdır, "+customer.getFirstName());
        else if(validationService.checkEmailIsValid(customer.getEmail()))
            System.out.println("E-posta alanı e-posta formatında olmalıdır, "+customer.getFirstName());
        else if (validationService.checkEmailIsExist(customer.getEmail(),userDao.getNotApprovedCustomers()))
            System.out.println("E-posta daha önce kullanılmış, "+customer.getFirstName());
        else if (validationService.checkFirstLastNameLength(customer))
            System.out.println("Ad ve soyad en az iki karakterden oluşmalıdır, "+customer.getFirstName());
        else{
            System.out.println("Kaydınız oluşturuldu : " + customer.getFirstName());
            activationDao.addActivationCode(customer);
            userDao.addCustomer(customer);
        }
    }

    @Override
    public List<Customer> getNotApprovedCustomers() {
        return userDao.getNotApprovedCustomers();
    }

    @Override
    public List<Customer> getApprovedCustomer() {
        return userDao.getApprovedCustomers();
    }


}
