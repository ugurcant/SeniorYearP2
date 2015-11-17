package ofisesoyle_moduls;

import java.util.ArrayList;

/**
 * Created by Ugur
 *
 */
public class PriceList {
    ArrayList<Product> prices = new ArrayList<Product>();

    public void prices() {
       prices.add(new Product(123456,"Latte","Tall",5.5));
       prices.add(new Product(789456,"Latte", "Grande", 6.5));
       prices.add(new Product(458412,"Latte", "Venti", 7.25));
    }
    public ArrayList<Product> getPrices(){
        return prices;
    }
}