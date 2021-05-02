package inheritance;

public class Main {

	public static void main(String[] args) {
		IndividualCustomer engin = new IndividualCustomer();
		engin.customerNumber="12345";
		
		CorporateCustomer hepsiBurada = new CorporateCustomer();
		hepsiBurada.customerNumber="7890";

		SyndicateCustomer syndicate1 = new SyndicateCustomer();
		syndicate1.customerNumber="99999";
		
		CustomerManager customerManager = new CustomerManager();
		
		Customer[] customers = {engin,syndicate1,hepsiBurada};
		
		customerManager.addMultiple(customers);

	}

}
