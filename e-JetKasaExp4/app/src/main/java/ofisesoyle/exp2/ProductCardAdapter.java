package ofisesoyle.exp2;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import ofisesoyle_moduls.Product;

/**
 * Created by Ugur.
 */
public class ProductCardAdapter extends BaseAdapter {

    private Activity mContext;
    public ArrayList<Product> productList = new ArrayList<Product>();
    private LayoutInflater mLayoutInflater = null;
    private FragmentManager fragmentManager;

    public ProductCardAdapter(Activity context, ArrayList<Product> list, FragmentManager fm) {
        mContext = context;
        productList = list;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        fragmentManager = fm;
    }
    static class YanUrunCardViewHolder {
        TextView urunIsmi, urunAciklamalar, fiyat, adet;
        Button sil;
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
        YanUrunCardViewHolder vh;

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.product_card, parent, false);
            vh = new YanUrunCardViewHolder();
            vh.urunIsmi = (TextView) convertView.findViewById(R.id.receivable_card_urun_isim);
            vh.urunAciklamalar = (TextView) convertView.findViewById(R.id.text_card_aciklama);
            vh.adet = (TextView) convertView.findViewById(R.id.text_card_adet);
            vh.fiyat = (TextView) convertView.findViewById(R.id.receivable_card_amount);
            vh.sil = (Button) convertView.findViewById(R.id.button_delete);

            final Product product = productList.get(position);
            vh.urunIsmi.setText(product.getProduct_name());
            vh.urunAciklamalar.setText(product.getProduct_info());
            vh.adet.setText(product.getBarcodeNo());
            vh.fiyat.setText(Double.toString(product.getProduct_price()));
            vh.sil.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    productList.remove(position);
                    refreshBasket();
                }
            });
            System.out.println(product.getProduct_name());

        }
        return convertView;
    }

    public void refreshBasket() {
        System.out.println("refreshBasket e girdi");
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.placeholder_basket, new ShoppingBasketFragment());
        ft.commit();
   }
}
