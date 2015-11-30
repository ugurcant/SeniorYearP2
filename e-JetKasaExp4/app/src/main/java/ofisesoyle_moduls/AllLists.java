package ofisesoyle_moduls;

import java.util.ArrayList;

public class AllLists {
    public ArrayList<Receivable> productShoppingList = new ArrayList<>();
    public ArrayList<Product> productBasketList = new ArrayList<>();
    public ArrayList<Order> productOrderList = new ArrayList<>();

    public ArrayList<Receivable> getProductShoppingList() {
        return productShoppingList;
    }

    public void addToProductShoppingList(Receivable receivable) {
        productShoppingList.add(receivable);
    }

    public ArrayList<Product> getProductBasketList() {
        return productBasketList;
    }

    public ArrayList<Product> addToProductBasketList(Product product) {
        productBasketList.add(product);
        return productBasketList;
    }

    public ArrayList<Order> getProductOrderList() {
        return productOrderList;
    }

    public ArrayList<Order> addToProductOrderList(Order order) {
        productOrderList.add(order);
        return productOrderList;
    }
}
