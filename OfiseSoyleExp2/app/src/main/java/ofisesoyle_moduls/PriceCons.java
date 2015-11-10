package ofisesoyle_moduls;

/**
 * Created by Ugur on 26.05.2015.
 */
public class PriceCons {
    public String urun_isim;
    public String urun_boyut;
    public double urun_fiyat;

    public PriceCons(String urun_isim, String urun_boyut,double urun_fiyat){
        this.urun_isim=urun_isim;
        this.urun_boyut=urun_boyut;
        this.urun_fiyat=urun_fiyat;
    }

    public String getUrun_isim() {
        return urun_isim;
    }

    public void setUrun_isim(String urun_isim) {
        this.urun_isim = urun_isim;
    }

    public double getUrun_fiyat() {
        return urun_fiyat;
    }

    public void setUrun_fiyat(double urun_fiyat) {
        this.urun_fiyat = urun_fiyat;
    }

    public String getUrun_boyut() {
        return urun_boyut;
    }

    public void setUrun_boyut(String urun_boyut) {
        this.urun_boyut = urun_boyut;
    }
}
