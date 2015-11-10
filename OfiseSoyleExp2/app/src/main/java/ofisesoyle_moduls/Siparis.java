package ofisesoyle_moduls;

import java.util.ArrayList;

/**
 * Created by Ugur.
 */
public class Siparis {

    public ArrayList<Urun> urunSiparisList;
    public String adres;
    public String zaman;
    public String not;
    public double toplamFiyat;

    public Siparis(ArrayList<Urun> urunSiparisList, String adres, String zaman, String not,double toplamFiyat){
        this.urunSiparisList = urunSiparisList;
        this.adres = adres;
        this.zaman = zaman;
        this.not = not;
        this.toplamFiyat = toplamFiyat;
    }

    public ArrayList<Urun> getUrunSiparisList() {
        return urunSiparisList;
    }

    public void setUrunSiparisList(ArrayList<Urun> urunSiparisList) {
        this.urunSiparisList = urunSiparisList;
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
