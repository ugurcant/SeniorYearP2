package ofisesoyle_moduls;

import java.util.ArrayList;

public class Order {

    public ArrayList<Product> productSiparisList;
    public String adres;
    public String zaman;
    public String not;
    public double toplamFiyat;

    public Order(ArrayList<Product> productSiparisList, String adres, String zaman, String not, double toplamFiyat){
        this.productSiparisList = productSiparisList;
        this.adres = adres;
        this.zaman = zaman;
        this.not = not;
        this.toplamFiyat = toplamFiyat;
    }

    public ArrayList<Product> getProductSiparisList() {
        return productSiparisList;
    }

    public void setProductSiparisList(ArrayList<Product> productSiparisList) {
        this.productSiparisList = productSiparisList;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getZaman() {
        return zaman;
    }

    public void setZaman(String zaman) {
        this.zaman = zaman;
    }

    public String getNot() {
        return not;
    }

    public void setNot(String not) {
        this.not = not;
    }

    public double getToplamFiyat(){
        return toplamFiyat;
    }
}
