package ofisesoyle_moduls;

import java.util.ArrayList;

public class PriceList {
    ArrayList<Product> prices = new ArrayList<Product>();

    public void prices() {
       prices.add(new Product("123456","Latte","Tall",5.5));
    }
    public ArrayList<Product> getPrices(){
        return prices;
    }
}