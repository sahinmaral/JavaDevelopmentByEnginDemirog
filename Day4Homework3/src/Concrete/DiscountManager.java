package Concrete;

import Abstract.DiscountService;
import Entities.Discount;
import Entities.Game;

import java.util.ArrayList;
import java.util.List;

public class DiscountManager implements DiscountService {

    List<Discount> discounts = new ArrayList<Discount>();

    @Override
    public void addDiscount(Discount discount) {
        discounts.add(discount);
        System.out.println("Discount added : "+discount.getName());
    }

    @Override
    public void addDiscount(Discount[] _discounts) {
        for (Discount discount : _discounts){
            discounts.add(discount);
            System.out.println("Discount added : "+discount.getName());
        }
    }

    @Override
    public void deleteDiscount(Discount discount) {
        discounts.remove(discount);
        System.out.println("Discount deleted : "+discount.getName());
    }

    @Override
    public void getDiscounts() {
        System.out.println("Discounts");
        System.out.println("----------------------------");
        for (Discount discount : discounts){
            System.out.println("Discount name : "+discount.getName());
            System.out.println("Discount ratio : "+discount.getRatio() + " %");

            System.out.println("----------------------------");
        }


    }

    @Override
    public void updateDiscount(Discount discount, String name, int ratio) {
        discount.setName(name);
        discount.setRatio(ratio);
        System.out.println("Discount modified : "+discount.getName());
    }
}
