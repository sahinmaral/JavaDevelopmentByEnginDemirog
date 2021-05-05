import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.*;
import Entities.Customer;
import Entities.Discount;
import Entities.Game;
import Entities.Sale;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        //Instancing customer
        Customer customer1 = new Customer(1, "Şahin", "MARAL", "31241146608", LocalDate.of(2000,02,11));
        Customer customer2 = new Customer(2, "Mustafa", "MARAL", "99999999999", LocalDate.of(1973,01,01));

        //Adding customer by his/her Turkish Id to confirm if he/she is a real person (OK)
        //And getting all customers
        Customer[] customers = new Customer[]{customer1,customer2};
        BaseCustomerManager customerManager = new TurkishIdCustomerManager(new MernisServiceAdapter());
        customerManager.addCustomer(customer1);
        customerManager.getCustomers();


        //Instancing games and putting games in array
        Game game1 = new Game(1,35,"FPS","CS:GO");
        Game game2 = new Game(2,35,"FPS","Payday 2");
        Game[] games = new Game[]{game1,game2};

        //Adding games and getting all games
        GameManager gameManager = new GameManager();
        gameManager.addGame(games);
        gameManager.getGames();

        //Instancing discounts and putting discounts in array
        Discount discount1 = new Discount(1,"Halloween Day",10);
        Discount discount2 = new Discount(1,"New Year ",15);
        Discount[] discounts = new Discount[]{discount1,discount2};

        //Adding games and getting all games
        DiscountManager discountManager = new DiscountManager();
        discountManager.addDiscount(discounts);
        discountManager.getDiscounts();

        Sale sale1 = new Sale(1,customer1,game1,discount1);
        Sale sale2 = new Sale(2,customer2,game1,discount1);
        Sale[] sales = new Sale[]{sale1,sale2};

        SaleManager saleManager = new SaleManager();
        saleManager.addItem(sales);


        saleManager.getItemsForCustomer(customer1);

    }
}