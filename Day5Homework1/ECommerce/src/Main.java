
import business.abstracts.CustomerAuthenticationService;
import business.abstracts.CustomerValidationService;
import business.concretes.CustomerAuthenticationManager;
import business.concretes.CustomerManager;
import business.concretes.CustomerValidationManager;
import core.GoogleSignInAdapter;
import core.SignInService;
import dataAccess.abstracts.ActivationCodeDao;
import dataAccess.abstracts.UserDao;
import dataAccess.concretes.inMemory.InMemoryActivationCodeDao;
import dataAccess.concretes.inMemory.InMemoryCustomerDao;
import entities.concretes.Customer;


public class Main {

    public static void main(String[] args) {

        Customer customer1 = new Customer(
                1,
                "Şahin",
                "Maral",
                "oyun.sahin@hotmail.com",
                "1234566"
        );

        Customer customer2 = new Customer(
                2,
                "Ali",
                "Maral",
                "sahin.maral@hotmail.com",
                "1234566"
        );

        Customer customer3 = new Customer(
                3,
                "Veli",
                "Maral",
                "oyun.sahin@gmail.com",
                "1234566"
        );

        //ToDo : Tam olarak yapılamadı
        SignInService service = new GoogleSignInAdapter();
        service.SignIn(customer3);

        UserDao userDao = new InMemoryCustomerDao();
        ActivationCodeDao activationCodeDao = new InMemoryActivationCodeDao();
        CustomerValidationService validationService = new CustomerValidationManager();
        CustomerAuthenticationService authenticationService = new CustomerAuthenticationManager(userDao,activationCodeDao);

        CustomerManager customerManager = new CustomerManager(userDao, validationService , activationCodeDao);
        customerManager.addCustomer(customer1);
        customerManager.addCustomer(customer2);

        authenticationService.sendActivationEmail(customer1);

        authenticationService.activateAccount(customer1,"ABC3D-AS23D-FG32D");

        customerManager.logIn(customer1);
        customerManager.logIn(customer2);

        System.out.println("Hesaplar");
        for (Customer customer : customerManager.getAllCustomers())
        {
            System.out.println("-------------------------------");
            System.out.println("Ad : "+customer.getFirstName());
            System.out.println("Soyad : "+customer.getLastName());
            System.out.println("Email : "+customer.getEmail());
            System.out.println("Onaylandı mı ? : "+customer.getIsApproved());
            System.out.println("-------------------------------");
        }




    }

}
