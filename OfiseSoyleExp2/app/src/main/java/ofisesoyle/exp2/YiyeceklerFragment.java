package ofisesoyle.exp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import ofisesoyle_moduls.PriceList;
import ofisesoyle_moduls.ShoppingList;
import ofisesoyle_moduls.Urun;

/**
 * Created by Ugur.
 */
public class YiyeceklerFragment extends Fragment{
    public PriceList priceList = new PriceList();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.yiyecekler,container,false);
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
        priceList.prices();

        Button btnYMD =(Button)getView().findViewById(R.id.button_yiyecekler_md);
        btnYMD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Tusa Basildi!! IMD");
                Intent scanAct = new Intent(view.getContext(), MainActivity.class);
                startActivity(scanAct);

            }
        });

        Button btnYSV =(Button)getView().findViewById(R.id.button_sepeteYiy);
        btnYSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Tusa Basildi!! YSV");
                //Cesit
                Spinner spinner_cesit = (Spinner)getView().findViewById(R.id.spinner_yiyecek);
                String yiyecekCesit= spinner_cesit.getSelectedItem().toString();

                //Adet
                Spinner spinner_adet = (Spinner)getView().findViewById(R.id.spinner_yiyecek_adet);
                String yiyecekAdetS= spinner_adet.getSelectedItem().toString();
                int yiyecekAdet = 0;
                if(yiyecekAdetS=="1"){yiyecekAdet = 1;
                }else if(yiyecekAdetS=="2"){yiyecekAdet = 2;
                }else if(yiyecekAdetS=="3"){yiyecekAdet = 3;
                }else if(yiyecekAdetS=="4"){yiyecekAdet = 4;
                }else if(yiyecekAdetS=="5"){yiyecekAdet = 5;
                }else if(yiyecekAdetS=="6"){yiyecekAdet = 6;
                }else if(yiyecekAdetS=="7"){yiyecekAdet = 7;
                }else if(yiyecekAdetS=="8"){yiyecekAdet = 8;
                }else if(yiyecekAdetS=="9"){yiyecekAdet = 9;
                }else if(yiyecekAdetS=="10"){yiyecekAdet = 10;}

                String urunAciklama = new String("");


                Urun siparisUrun = new Urun(yiyecekCesit, urunAciklama, yiyecekAdet, yiyecekFiyatiBul(yiyecekCesit, urunAciklama));
                ShoppingList.urunSiparisList.add(siparisUrun);
                System.out.println(siparisUrun.urun_adi);

            }
        });
    }
    public double yiyecekFiyatiBul(String yiyecek_isim, String yiyecek_aciklama){

        double yiyecekFiyat = 0;
        for(int i = 0; i<priceList.getPrices().size();i++){
            if(priceList.getPrices().get(i).urun_isim.equals(yiyecek_isim) &&
                    priceList.getPrices().get(i).urun_boyut.equals(yiyecek_aciklama) ){
                yiyecekFiyat = priceList.getPrices().get(i).urun_fiyat;
            }
        }return yiyecekFiyat;
    }
}
