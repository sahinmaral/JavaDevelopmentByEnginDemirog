package dataAccess.concretes.inMemory;

import dataAccess.abstracts.ActivationCodeDao;
import entities.concretes.ActivationCode;
import entities.concretes.Customer;

import java.util.ArrayList;
import java.util.List;

public class InMemoryActivationCodeDao implements ActivationCodeDao {

    List<ActivationCode> activationCodes = new ArrayList<>();

    @Override
    public void addActivationCode(Customer customer) {
        String code = "ABC3D-AS23D-FG32D";
        ActivationCode activationCode = new ActivationCode(1,customer.getId(),code);
        activationCodes.add(activationCode);
    }

    @Override
    public void deleteActivationCode(Customer customer, String activationCode) {
        activationCodes.removeIf(code -> code.getActivationCode().equals(activationCode));
    }

    @Override
    public void updateActivationCode(Customer customer) {
        String activationCode = "HBBA-32FN-KJFE";
        for (ActivationCode code : activationCodes){
            if(code.getCustomerId() == customer.getId())
            {
                code.setActivationCode(activationCode);
            }
        }
    }

    @Override
    public List<ActivationCode> getActivationCodes() {
        return activationCodes;
    }


}
