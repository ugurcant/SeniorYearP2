package ofisesoyle.exp2;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ofisesoyle_moduls.BasketProduct;


public class PaymentFinishedCardAdapter extends BaseAdapter {

    private Activity mContext;
    public ArrayList<BasketProduct> productList = new ArrayList<BasketProduct>();
    private LayoutInflater mLayoutInflater = null;
    private FragmentManager fragmentManager;

    public PaymentFinishedCardAdapter(Activity context, ArrayList<BasketProduct> list, FragmentManager fm) {
        mContext = context;
        productList = list;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        fragmentManager = fm;
    }
    static class PaymentFinishedCardViewHolder {
        TextView urunIsmi, urunAciklamalar, fiyat, adet;
    }
    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        PaymentFinishedCardViewHolder vh;

        if (convertView == null) {

            convertView = mLayoutInflater.inflate(R.layout.paymentfinished_card, parent, false);
            vh = new PaymentFinishedCardViewHolder();

            vh.urunIsmi = (TextView) convertView.findViewById(R.id.receivable_card_urun_isim_pf);
            vh.urunAciklamalar = (TextView) convertView.findViewById(R.id.text_card_aciklama_pf);
            vh.adet = (TextView) convertView.findViewById(R.id.text_card_adet_pf);
            vh.fiyat = (TextView) convertView.findViewById(R.id.receivable_card_price_pf);

            final BasketProduct product = productList.get(position);
            vh.urunIsmi.setText(product.getBasketProduct_name());
            vh.urunAciklamalar.setText(product.getBasketProduct_info());
            vh.adet.setText(Integer.toString(product.getBasketProduct_amount()));
            vh.fiyat.setText(Double.toString(product.getBasketProduct_price()*product.getBasketProduct_amount()) + " TL");
            System.out.println(product.getBasketProduct_name());
        }
        return convertView;
    }
}
