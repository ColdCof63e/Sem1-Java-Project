package Menurest;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        // Add 10 items and 3 combos to the menu
        items.add(new MenuItem("Burger", 8.99, false));
        items.add(new MenuItem("Pizza", 10.99, false));
        items.add(new MenuItem("Salad", 6.99, false));
        items.add(new MenuItem("Soda", 2.50, false));
        items.add(new MenuItem("Fries", 3.50, false));
        items.add(new MenuItem("Ice Cream", 4.00, false));
        items.add(new MenuItem("Steak", 15.99, false));
        items.add(new MenuItem("Pasta", 12.99, false));
        items.add(new MenuItem("Chicken Wings", 9.50, false));
        items.add(new MenuItem("Coffee", 3.00, false));

        // Add combos
        items.add(new MenuItem("Combo 1: Burger + Fries + Soda", 13.99, true));
        items.add(new MenuItem("Combo 2: Pizza + Salad + Soda", 18.99, true));
        items.add(new MenuItem("Combo 3: Steak + Pasta + Soda", 25.99, true));
    }

    public List<MenuItem> getItems() 
    {
        return items;
    }

    public String getMenuString() 
    {
        StringBuilder menuBuilder = new StringBuilder("MENU:\n");
        for (int i = 0; i < items.size(); i++) 
        {
            MenuItem item = items.get(i);
            menuBuilder.append(String.format("%d. %s - $%.2f%n", i + 1, item.getName(), item.getPrice()));
        }
        return menuBuilder.toString();
    }
}
