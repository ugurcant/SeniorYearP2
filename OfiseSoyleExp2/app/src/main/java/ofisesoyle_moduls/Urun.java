package ofisesoyle_moduls;

/**
 * Created by Ugur.
 */
public class Urun {

    public String urun_adi;
    public String urun_aciklama;
    public int adet;
    public double fiyat;

    public Urun(String urun_adi, String urun_aciklama, int adet, double fiyat){
        this.urun_adi=urun_adi;
        this.urun_aciklama = urun_aciklama;
        this.adet=adet;
        this.fiyat = fiyat;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public String getUrun_aciklama() {return urun_aciklama;}

    public void setUrun_aciklama(String urun_aciklama) {this.urun_aciklama = urun_aciklama;}

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
}
