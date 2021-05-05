package Entities;

import Abstract.Entity;

public class Sale implements Entity {
    private int id;
    private int customerId;
    private String customerName;
    private String gameName;
    private double gamePrice;
    private String discountName;
    private double discountRatio;
    private double gamePriceWithDiscount;

    public Sale(int id,Customer customer,Game game,Discount discount){
        super();
        this.id = id;
        customerId = customer.getId();
        customerName = customer.getFirstName();
        gameName = game.getName();
        gamePrice = game.getPrice();
        discountName = discount.getName();
        discountRatio = discount.getRatio();
        gamePriceWithDiscount = game.getPrice()  - (game.getPrice()*discount.getRatio()/100);
    }

    public Sale(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(double gamePrice) {
        this.gamePrice = gamePrice;
    }

    public double getDiscountRatio() {
        return discountRatio;
    }

    public void setDiscountRatio(double discountRatio) {
        this.discountRatio = discountRatio;
    }

    public double getGamePriceWithDiscount() {
        return gamePriceWithDiscount;
    }

    public void setGamePriceWithDiscount(double gamePriceWithDiscount) {
        this.gamePriceWithDiscount = gamePriceWithDiscount;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }
}
