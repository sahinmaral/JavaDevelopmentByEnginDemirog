package Adapters;

import Abstract.CustomerCheckService;
import Entities.Customer;
import MernisService.IMCKPSPublicSoap;

import java.util.Locale;

public class MernisServiceAdapter implements CustomerCheckService {



    @Override
    public boolean checkIfRealPerson(Customer customer) {

        IMCKPSPublicSoap client = new IMCKPSPublicSoap();

        try{
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
