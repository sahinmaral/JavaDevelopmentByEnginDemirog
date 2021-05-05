package Abstract;

import Entities.Discount;
import Entities.Game;

public interface DiscountService {
    void addDiscount(Discount discount);
    void addDiscount(Discount[] _discounts);
    void deleteDiscount(Discount discount);
    void getDiscounts();
    void updateDiscount(Discount discount, String name, int Ratio);
}
