package ofisesoyle.exp2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


import ofisesoyle_moduls.Order;

/**
 * Created by Ugur.
 */
public class SiparisFragment extends Fragment {

    public static Order yeniOrder;
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

     /*    double siparisUcret = calcHizmetBedelliFiyat(calcToplamFiyat(ShoppingList.productSiparisList));
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


                yeniOrder = new Order(ShoppingList.productSiparisList,secilenAdres,secilenZaman,kullaniciNotu, calcHizmetBedelliFiyat(calcToplamFiyat(ShoppingList.productSiparisList)));

                Connection con = null;
                try {
                    con = DriverManager.getConnection("160.153.45.64", "dbAdmin", "d087c00CCN");
                    if (!con.isClosed()) {
                        Date date = Calendar.getInstance().getTime();
                        String dateString = date.toString();

                        ArrayList<Product> gonderilicekUrunler = new ArrayList<Product>();
                        gonderilicekUrunler = SiparisFragment.yeniOrder.getProductSiparisList();

                        for(int i = 0; i<= gonderilicekUrunler.size();i++){
                            String mySQLquery1 = new String("INSERT INTO `orders` VALUES(NULL,'"+SiparisFragment.yeniOrder.getAdres()+"','"+SiparisFragment.yeniOrder.getZaman()+"','"+SiparisFragment.yeniOrder.getNot()+"','"+dateString+ "', '79')");
                            con.createStatement().executeQuery(mySQLquery1);
                            int generatedOrderID = 1000+i;
                            String detailRow = new String( gonderilicekUrunler.get(i).getBarcodeNo()+" Adet "+gonderilicekUrunler.get(i).getProduct_info()+"--->"+calcHizmetBedelliFiyat(calcToplamFiyat(ShoppingList.productSiparisList)));
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

    public double calcToplamFiyat(ArrayList<Product> uruns){
        for(int i = 0; i<uruns.size();i++){
            toplamFiyat += uruns.get(i).getProduct_price();
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
