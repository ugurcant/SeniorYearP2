package ofisesoyle.exp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.Spinner;

import ofisesoyle_moduls.PriceList;
import ofisesoyle_moduls.ShoppingList;
import ofisesoyle_moduls.Urun;

/**
 * Created by Ugur.
 */
public class TatlilarFragment extends Fragment {
    public PriceList priceList = new PriceList();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tatlilar,container,false);
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

        Button btnTMD =(Button)getView().findViewById(R.id.button_tatlilar_md);
        btnTMD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Tusa Basildi!! IMD");
                Intent scanAct = new Intent(view.getContext(), MainActivity.class);
                startActivity(scanAct);

            }
        });

        Button btnTSV =(Button)getView().findViewById(R.id.button_sepeteTat);
        btnTSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Tusa Basildi!! TSV");

                //Cesit
                Spinner spinner_cesit = (Spinner)getView().findViewById(R.id.spinner_tatli);
                String tatliCesit= spinner_cesit.getSelectedItem().toString();

                //Adet
                Spinner spinner_adet = (Spinner)getView().findViewById(R.id.spinner_tatli_adet);
                String tatliAdetS= spinner_adet.getSelectedItem().toString();
                int tatliAdet = 0;
                if(tatliAdetS=="1"){tatliAdet = 1;
                }else if(tatliAdetS=="2"){tatliAdet = 2;
                }else if(tatliAdetS=="3"){tatliAdet = 3;
                }else if(tatliAdetS=="4"){tatliAdet = 4;
                }else if(tatliAdetS=="5"){tatliAdet = 5;
                }else if(tatliAdetS=="6"){tatliAdet = 6;
                }else if(tatliAdetS=="7"){tatliAdet = 7;
                }else if(tatliAdetS=="8"){tatliAdet = 8;
                }else if(tatliAdetS=="9"){tatliAdet = 9;
                }else if(tatliAdetS=="10"){tatliAdet = 10;}

                String urunAciklama = new String("");

                Urun siparisUrun = new Urun(tatliCesit, urunAciklama, tatliAdet, tatliFiyatiBul(tatliCesit, urunAciklama));
                ShoppingList.urunSiparisList.add(siparisUrun);

            }
        });
    }
    public double tatliFiyatiBul(String tatli_isim, String tatli_aciklama){

        double tatliFiyat = 0;
        for(int i = 0; i<priceList.getPrices().size();i++){
            if(priceList.getPrices().get(i).urun_isim.equals(tatli_isim) &&
                    priceList.getPrices().get(i).urun_boyut.equals(tatli_aciklama) ){
                tatliFiyat = priceList.getPrices().get(i).urun_fiyat;
            }
        }return tatliFiyat;
    }
}
