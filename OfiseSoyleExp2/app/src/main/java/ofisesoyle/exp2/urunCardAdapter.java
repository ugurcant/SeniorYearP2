package ofisesoyle.exp2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import ofisesoyle_moduls.Urun;

/**
 * Created by Ugur.
 */
public class urunCardAdapter extends BaseAdapter {

    private Activity mContext;
    public ArrayList<Urun> urunList = new ArrayList<Urun>();
    private LayoutInflater mLayoutInflater = null;
    private FragmentManager fragmentManager;
    public AnaSayfaFragment af;

    public urunCardAdapter(Activity context, ArrayList<Urun> list, FragmentManager fm) {
        mContext = context;
        urunList = list;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        fragmentManager = fm;
    }



    static class YanUrunCardViewHolder {
        TextView urunIsmi, urunAciklamalar, fiyat, adet;
        Button sil;
    }


    @Override
    public int getCount() {
        return urunList.size();
    }

    @Override
    public Object getItem(int position) {
        return urunList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        YanUrunCardViewHolder vh;

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.urun_card, parent, false);
            vh = new YanUrunCardViewHolder();
            vh.urunIsmi = (TextView) convertView.findViewById(R.id.text_card_urun_isim);
            vh.urunAciklamalar = (TextView) convertView.findViewById(R.id.text_card_aciklama);
            vh.adet = (TextView) convertView.findViewById(R.id.text_card_adet);
            vh.fiyat = (TextView) convertView.findViewById(R.id.text_card_fiyat);
            vh.sil = (Button) convertView.findViewById(R.id.button_delete);

            final Urun urun = urunList.get(position);
            vh.urunIsmi.setText(urun.getUrun_adi());
            vh.urunAciklamalar.setText(urun.getUrun_aciklama());
            vh.adet.setText(Integer.toString(urun.getAdet()));
            vh.fiyat.setText(Double.toString(urun.getFiyat()));
            vh.sil.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    urunList.remove(position);
//                    refreshSepet();
                }
            });
            System.out.println(urun.getUrun_adi());

        }
        return convertView;
    }

//    public void refreshSepet() {
//        Fragment newFragment = new SepetFragment();
//        FragmentTransaction transaction = mContext.getFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment_container,newFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}
