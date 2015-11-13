package ofisesoyle.exp2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import ofisesoyle_moduls.ShoppingList;
import ofisesoyle_moduls.Siparis;
import ofisesoyle_moduls.Urun;

/**
 * Created by Ugur.
 */
public class SiparisFragment extends Fragment {

    public static Siparis yeniSiparis;
    public double toplamFiyat;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.siparisi_tamamla,container,false);
        v.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        return v;
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

     /*    double siparisUcret = calcHizmetBedelliFiyat(calcToplamFiyat(ShoppingList.urunSiparisList));
        String siparisUcretS = Double.toString(siparisUcret);

       TextView mf = (TextView) getView().findViewById(R.id.text_tutar);
        mf.setText(siparisUcretS);

        Button btnST =(Button) getView().findViewById(R.id.button_siparis_onay);
        btnST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Zaman
                Spinner spinner_zaman = (Spinner)getView().findViewById(R.id.spinner_teslimat_zaman);
                String secilenZaman= spinner_zaman.getSelectedItem().toString();

                //Adres
                Spinner spinner_adres = (Spinner)getView().findViewById(R.id.spinner_teslimat_adres);
                String secilenAdres= spinner_adres.getSelectedItem().toString();

                //Not
                EditText editText_not = (EditText)getView().findViewById(R.id.editText_teslimat_not);
                String kullaniciNotu = editText_not.getText().toString();


                yeniSiparis = new Siparis(ShoppingList.urunSiparisList,secilenAdres,secilenZaman,kullaniciNotu, calcHizmetBedelliFiyat(calcToplamFiyat(ShoppingList.urunSiparisList)));

                Connection con = null;
                try {
                    con = DriverManager.getConnection("160.153.45.64", "dbAdmin", "d087c00CCN");
                    if (!con.isClosed()) {
                        Date date = Calendar.getInstance().getTime();
                        String dateString = date.toString();

                        ArrayList<Urun> gonderilicekUrunler = new ArrayList<Urun>();
                        gonderilicekUrunler = SiparisFragment.yeniSiparis.getUrunSiparisList();

                        for(int i = 0; i<= gonderilicekUrunler.size();i++){
                            String mySQLquery1 = new String("INSERT INTO `orders` VALUES(NULL,'"+SiparisFragment.yeniSiparis.getAdres()+"','"+SiparisFragment.yeniSiparis.getZaman()+"','"+SiparisFragment.yeniSiparis.getNot()+"','"+dateString+ "', '79')");
                            con.createStatement().executeQuery(mySQLquery1);
                            int generatedOrderID = 1000+i;
                            String detailRow = new String( gonderilicekUrunler.get(i).getAdet()+" Adet "+gonderilicekUrunler.get(i).getUrun_aciklama()+"--->"+calcHizmetBedelliFiyat(calcToplamFiyat(ShoppingList.urunSiparisList)));
                            String mySQLquery2 = new String("INSERT INTO `order_details` VALUES(NULL,'"+generatedOrderID+"','" +detailRow + "')");
                            con.createStatement().executeQuery(mySQLquery2);
                        }
                        Toast.makeText(view.getContext(), "Siparişiniz gönderilmiştir.", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    System.out.print("Exception: " + e.getMessage());
                } finally {
                    try {
                        if (con != null)
                            con.close();
                    } catch (java.sql.SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public double calcToplamFiyat(ArrayList<Urun> uruns){
        for(int i = 0; i<uruns.size();i++){
            toplamFiyat += uruns.get(i).getFiyat();
        }return toplamFiyat;
    }
    public double calcHizmetBedelliFiyat(double tfiyat){
        double sonFiyat = 0;
        if(tfiyat >= 25){
            sonFiyat = tfiyat + 6;
        }else if(tfiyat > 25 && tfiyat <= 50){
            sonFiyat = tfiyat + 12;
        }else if(tfiyat > 50){
            sonFiyat = tfiyat + 20;
        }
        return sonFiyat;
    }*/
}
}
