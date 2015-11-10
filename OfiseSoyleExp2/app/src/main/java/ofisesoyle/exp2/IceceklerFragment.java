package ofisesoyle.exp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import ofisesoyle_moduls.PriceList;
import ofisesoyle_moduls.ShoppingList;
import ofisesoyle_moduls.Urun;

/**
 * Created by Ugur on 24.05.2015.
 */
public class IceceklerFragment extends Fragment {

    public PriceList priceList = new PriceList();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.icecekler,container,false);
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

        Button btnIMD =(Button)getView().findViewById(R.id.button_icecekler_md);
        btnIMD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Tusa Basildi!! IMD");
                Intent scanAct = new Intent(view.getContext(), MainActivity.class);
                startActivity(scanAct);
            }
        });

        Button btnISV =(Button)getView().findViewById(R.id.button_sepeteIce);
        btnISV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Tusa Basildi!! ISV");
                //Cesit
                Spinner spinner_cesit = (Spinner)getView().findViewById(R.id.spinner_icecek);
                String icecekCesit= spinner_cesit.getSelectedItem().toString();

                //Boyut
                RadioGroup rgBoyut = (RadioGroup)getView().findViewById(R.id.radioGroup_boyut);
                int id_boyut= rgBoyut.getCheckedRadioButtonId();
                RadioButton btn_boyut = (RadioButton) rgBoyut.findViewById(id_boyut);
                String icecekBoyut = (String) btn_boyut.getText();

                //Süt
                RadioGroup rgSut = (RadioGroup)getView().findViewById(R.id.radioGroup_sut);
                int id_sut = rgSut.getCheckedRadioButtonId();
                RadioButton btn_sut = (RadioButton) rgSut.findViewById(id_sut);
                String icecekSut = (String) btn_sut.getText();

                //Kafein
                CheckBox cb_kafein = (CheckBox)getView().findViewById(R.id.checkBox_kafein);
                String icecekKafein = new String("");
                if(cb_kafein.isChecked()){
                    icecekKafein = "Kafeinli";
                }else{
                    icecekKafein = "Kafeinsiz";
                }

                //Adet
                Spinner spinner_adet = (Spinner)getView().findViewById(R.id.spinner_icecekler_adet);
                String icecekAdetS = spinner_adet.getSelectedItem().toString();
                int icecekAdet = 1;
                if(icecekAdetS=="1"){icecekAdet = 1;
                }else if(icecekAdetS=="2"){icecekAdet = 2;
                }else if(icecekAdetS=="3"){icecekAdet = 3;
                }else if(icecekAdetS=="4"){icecekAdet = 4;
                }else if(icecekAdetS=="5"){icecekAdet = 5;
                }else if(icecekAdetS=="6"){icecekAdet = 6;
                }else if(icecekAdetS=="7"){icecekAdet = 7;
                }else if(icecekAdetS=="8"){icecekAdet = 8;
                }else if(icecekAdetS=="9"){icecekAdet = 9;
                }else if(icecekAdetS=="10"){icecekAdet = 10;}

                String siparisUrunAciklama = new String(icecekBoyut +", "+icecekSut+", "+icecekKafein);
                ShoppingList.urunSiparisList.add(new Urun(icecekCesit, siparisUrunAciklama, icecekAdet, icecekFiyatıBul(icecekCesit,icecekBoyut)));
                System.out.println(icecekFiyatıBul(icecekCesit,icecekBoyut));
            }
        });
    }
    public double icecekFiyatıBul(String icecek_isim, String icecek_boyut){
        double icecekFiyat = 0;
        for(int i = 0; i<priceList.getPrices().size();i++){
            if(priceList.getPrices().get(i).urun_isim.equals(icecek_isim) &&
                    priceList.getPrices().get(i).urun_boyut.equals(icecek_boyut) ){
                icecekFiyat = priceList.getPrices().get(i).urun_fiyat;
            }
        }return icecekFiyat;
    }
}
