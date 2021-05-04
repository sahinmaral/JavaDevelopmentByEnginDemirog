package com.company;

import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;


import java.time.LocalDate;

public class Main {

    public static void main(String[] args){

        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Şahin");
        customer.setLastName("MARAL");
        customer.setDateOfBirth(LocalDate.of(1973,02,11));
        //customer.setNationalityId();      TC kimliğim girildiğince çalışıyor

        BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
        customerManager.Save(customer);



    }
}
