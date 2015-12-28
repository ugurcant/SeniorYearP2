package ofisesoyle_moduls;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class AllLists{
    public ArrayList<Receivable> productShoppingList = new ArrayList<>();
    public ArrayList<BasketProduct> productBasketList = new ArrayList<>();
    public ArrayList<BasketProduct> productOrderList = new ArrayList<>();

    public ArrayList<Receivable> getProductShoppingList() {return productShoppingList;}

    public ArrayList<BasketProduct> getProductBasketList() {return productBasketList;}

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
}
