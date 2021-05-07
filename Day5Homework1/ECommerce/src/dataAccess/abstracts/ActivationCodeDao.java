package dataAccess.abstracts;

import dataAccess.concretes.inMemory.InMemoryActivationCodeDao;
import entities.concretes.ActivationCode;
import entities.concretes.Customer;

import java.util.List;

public interface ActivationCodeDao {
    void addActivationCode(Customer customer);
    void deleteActivationCode(Customer customer, String activationCode);
    void updateActivationCode(Customer customer);
    List<ActivationCode> getActivationCodes();
}
