package Menurest;

//import java.awt.Component;

import javax.swing.JOptionPane;
//import java.util.List;

public class RestaurantApp {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Order order = new Order();

        // Welcome message
        JOptionPane.showMessageDialog(null, "Welcome to Our LittleBots Restaurant :D  !", "Welcome", JOptionPane.INFORMATION_MESSAGE);

        boolean ordering = true;
        while (ordering) {
        	
            // Display the menu
            String menuString = menu.getMenuString();

            //JOptionPane.showMessageDialog(null, menuString, "Menu", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(menuString);

            // Prompt for menu item selection
            String input = JOptionPane.showInputDialog("Enter the number of the item to add to your order, or 0 to finish:");
            if (input == null) break; // Exit if cancel is pressed

            try 
            {
                int choice = Integer.parseInt(input);

                if (choice == 0) 
                {
                    break;
                } 
                else if (choice > 0 && choice <= menu.getItems().size()) 
                {
                    MenuItem selectedItem = menu.getItems().get(choice - 1);
                    
                    // Prompt for quantity
                    String quantityInput = JOptionPane.showInputDialog("Enter quantity for " + selectedItem.getName() + ":");
                    if (quantityInput == null) break; // Exit if cancel is pressed

                    int quantity = Integer.parseInt(quantityInput);
                    order.addItem(selectedItem, quantity);
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Continue ordering prompt
                int continueOrdering = JOptionPane.showConfirmDialog(null, "Would you like to continue ordering?", "Continue", JOptionPane.YES_NO_OPTION);
                if (continueOrdering == JOptionPane.NO_OPTION) {
                    ordering = false;
                }
            } 
            catch (NumberFormatException e) 
            {
				JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE, null);
            }
        }

        // Display order summary
        String orderSummary = order.getOrderSummary();
        JOptionPane.showMessageDialog(null, orderSummary, "Order Summary", JOptionPane.INFORMATION_MESSAGE);

        // Prompt to save the order summary
        int saveOption = JOptionPane.showConfirmDialog(null, "Would you like to save the order bill to a file?", "Save", JOptionPane.YES_NO_OPTION);
        if (saveOption == JOptionPane.YES_OPTION) 
        {
            String filename = JOptionPane.showInputDialog("Enter email to save:");
            if (filename != null && !filename.trim().isEmpty()) {
                order.saveOrderSummaryToFile(filename);
                JOptionPane.showMessageDialog(null, "Order summary saved to " + filename, "Saved", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid email.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Goodbye message
        JOptionPane.showMessageDialog(null, "Thank you for dining with us in LittleBots Restaurant. Goodbye ;b  !", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
    }
}
