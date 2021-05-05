package Entities;

public class Discount {
    private int id;
    private String name;
    private double Ratio;

    public Discount(int id, String name, double Ratio) {
        this.id = id;
        this.name = name;
        this.Ratio = Ratio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRatio() {
        return Ratio;
    }

    public void setRatio(double Ratio) {
        this.Ratio = Ratio;
    }
}
