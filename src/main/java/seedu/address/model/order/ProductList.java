package seedu.address.model.order;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    private List<Product> menu;

    public ProductList() {
        this.menu = new ArrayList<>();
        menu.add(new Product("Chicken Rice", 4.50));
        menu.add(new Product("Mixed Rice", 4.50));
        menu.add(new Product("Beef Udon", 7.00));
        menu.add(new Product("Ice Cream", 2.50));
        menu.add(new Product("Caesar Salad", 5.50));
        menu.add(new Product("Smoked Salmon Bagel", 8.50));
        menu.add(new Product("Apple Juice", 1.50));
        menu.add(new Product("Cafe Latte", 3.00));
    }

    public Product getItem(int index) {
        return menu.get(index - 1);
    }
}
