package Adapters;

import Abstract.CustomerCheckService;
import Entities.Customer;
import MernisService.GLFKPSPublicSoap;

import java.rmi.RemoteException;
import java.util.Locale;

public class MernisServiceAdapter implements CustomerCheckService {
    @Override
    public boolean CheckIfRealPerson(Customer customer){

        GLFKPSPublicSoap client = new GLFKPSPublicSoap();

        try {
            return client.TCKimlikNoDogrula(
                    Long.parseLong(customer.getNationalityId()),
                    customer.getFirstName().toUpperCase(),
                    customer.getLastName().toUpperCase(),
                    customer.getDateOfBirth().getYear());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
