package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.SaleService;
import Adapters.MernisServiceAdapter;
import Entities.Customer;
import Entities.Discount;
import Entities.Game;
import Entities.Sale;

import java.util.ArrayList;
import java.util.List;

public class SaleManager implements SaleService {

    List<Sale> sales = new ArrayList<Sale>();


    @Override
    public void addItem(Sale sale) {
        System.out.println("Sale added");
        System.out.println("----------------------------");
        System.out.println("Customer : "+sale.getCustomerName());
        System.out.println("Item added : "+sale.getGameName());
        System.out.println("Game price : "+sale.getGamePrice() + " TRY");
        System.out.println("Discount : "+sale.getDiscountRatio() + " %");
        System.out.println("Game price with discount : "+sale.getGamePriceWithDiscount() + " TRY");
        System.out.println("----------------------------");
        sales.add(sale);
    }

    @Override
    public void addItem(Sale[] _sales) {
        System.out.println("Sales added");
        System.out.println("----------------------------");
        for(Sale sale : _sales)
        {
            System.out.println("Customer : "+sale.getCustomerName());
            System.out.println("Item added : "+sale.getGameName());
            System.out.println("Game price : "+sale.getGamePrice() + " TRY");
            System.out.println("Discount : "+sale.getDiscountRatio() + " %");
            System.out.println("Game price with discount : "+sale.getGamePriceWithDiscount() + " TRY");
            System.out.println("----------------------------");
            sales.add(sale);
        }
    }

    @Override
    public void deleteItem(Sale sale) {
        System.out.println("Customer : "+sale.getCustomerName());
        System.out.println("Item deleted : "+sale.getGameName());
        sales.remove(sale);
    }

    @Override
    public void getItemsForCustomer(Customer customer) {
        System.out.println("Sales");
        System.out.println("----------------------------");
        for (Sale sale : sales){
            if (sale.getCustomerId() == customer.getId())
            {
                System.out.println("Customer : "+sale.getCustomerName());
                System.out.println("Item added : "+sale.getGameName());
                System.out.println("Game price : "+sale.getGamePrice() + " TRY");
                System.out.println("Discount : "+sale.getDiscountRatio() + " %");
                System.out.println("Game price with discount : "+sale.getGamePriceWithDiscount() + " TRY");
                System.out.println("----------------------------");
            }
        }
    }


    @Override
    public void updateItem(Sale sale, Game game , Discount discount) {
        sale.setGamePrice(game.getPrice());
        sale.setDiscountName(discount.getName());
        sale.setDiscountRatio(discount.getRatio());
        sale.setGamePriceWithDiscount(sale.getGamePriceWithDiscount());

        System.out.println("Sale modified : "+game.getName());
    }


}
