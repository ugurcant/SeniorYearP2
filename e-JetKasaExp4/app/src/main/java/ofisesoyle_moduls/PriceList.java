package ofisesoyle_moduls;

import java.util.ArrayList;

public class PriceList {
    ArrayList<Product> prices = new ArrayList<Product>();

    public void prices() {
        prices.add(new Product("123456","DummyProduct1","Example1",5.5));
        prices.add(new Product("1234567890","DummyProduct2","Example2",7.5));
    }
    public ArrayList<Product> getPrices(){
        return prices;
    }

    public boolean findFromPriceList(String barcode){
        boolean controller = true;
        int i = 0;
        while(i <= (prices.size() + 1)){
            if(prices.get(i).barcodeNo.equals(barcode)) {
                controller = true;
                break;
            }else{
                if(i == (prices.size()+1)){
                    controller = false;
                    break;
                }else if(i <= prices.size()){
                    i++;
                }
            }
        }
        return controller;
    }
    public Product getFromPriceList(String barcode){
        Product product = new Product("","","",0);
        int i = 0;
        while(i<= prices.size()){
            if(prices.get(i).barcodeNo.equals(barcode)){
                product = prices.get(i);
                break;
            }else{
                i++;
            }
        }
        return product;
    }
}