package Menurest;

public class MenuItem 
{
    private String name;
    private double price;
    private boolean isCombo;

    public MenuItem(String name, double price, boolean isCombo) 
    {
        this.name = name;
        this.price = price;
        this.isCombo = isCombo;
    }

    public String getName() 
    {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isCombo() {
        return isCombo;
    }
}


