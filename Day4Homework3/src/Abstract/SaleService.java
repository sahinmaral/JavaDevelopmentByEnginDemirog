package Abstract;


import Entities.Customer;
import Entities.Discount;
import Entities.Game;
import Entities.Sale;

public interface SaleService {
    void addItem(Sale sale);
    void addItem(Sale[] _sales);
    void deleteItem(Sale sale);
    void getItemsForCustomer(Customer customer);
    void updateItem(Sale sale,Game game , Discount discount);
}
