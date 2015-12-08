package ofisesoyle_moduls;

import java.util.ArrayList;

public class AllLists {
    public ArrayList<Receivable> productShoppingList = new ArrayList<>();
    public ArrayList<BasketProduct> productBasketList = new ArrayList<>();
    public ArrayList<AllOrders> productAllOrdersList = new ArrayList<>();
    public ArrayList<Order> productOrderList = new ArrayList<>();

    public ArrayList<Receivable> getProductShoppingList() {return productShoppingList;}

    public ArrayList<BasketProduct> getProductBasketList() {return productBasketList;}

    public ArrayList<AllOrders> getProductAllOrdersList() {return productAllOrdersList;}

    public void addToProductShoppingList(Receivable receivable) {
        productShoppingList.add(receivable);
    }

    public ArrayList<BasketProduct> addToProductBasketList(BasketProduct product) {
        productBasketList.add(product);
        return productBasketList;
    }

    public double calculateTotalPrice(){
        double total = 0;
        for(int i = 0; i < productBasketList.size();i++ ){
            total = total + (productBasketList.get(i).getBasketProduct_price()*productBasketList.get(i).getBasketProduct_amount());
        }
        return total;
    }

    public ArrayList<AllOrders> addToProductOrderList(AllOrders allOrders) {
        productAllOrdersList.add(allOrders);
        return productAllOrdersList;
    }
}
