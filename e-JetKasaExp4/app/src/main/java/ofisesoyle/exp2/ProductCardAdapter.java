package ofisesoyle.exp2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

import ofisesoyle_moduls.BasketProduct;

/**
 * Created by Ugur.
 */
public class ProductCardAdapter extends BaseAdapter {

    private Activity mContext;
    public ArrayList<BasketProduct> productList = new ArrayList<BasketProduct>();
    private LayoutInflater mLayoutInflater = null;
    private FragmentManager fragmentManager;

    public ProductCardAdapter(Activity context, ArrayList<BasketProduct> list, FragmentManager fm) {
        mContext = context;
        productList = list;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        fragmentManager = fm;
    }
    static class ProductCardViewHolder {
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
        ProductCardViewHolder vh;

        if (convertView == null) {

            convertView = mLayoutInflater.inflate(R.layout.product_card, parent, false);
            vh = new ProductCardViewHolder();

            vh.urunIsmi = (TextView) convertView.findViewById(R.id.receivable_card_urun_isim);
            vh.urunAciklamalar = (TextView) convertView.findViewById(R.id.text_card_aciklama);
            vh.adet = (TextView) convertView.findViewById(R.id.text_card_adet);
            vh.fiyat = (TextView) convertView.findViewById(R.id.receivable_card_amount);
            vh.sil = (Button) convertView.findViewById(R.id.button_delete_product);

            final BasketProduct product = productList.get(position);
            vh.urunIsmi.setText(product.getBasketProduct_name());
            vh.urunAciklamalar.setText(product.getBasketProduct_info());
            vh.adet.setText(Integer.toString(product.getBasketProduct_amount()));
            vh.fiyat.setText(Double.toString(product.getBasketProduct_price()*product.getBasketProduct_amount()) + " TL");
            vh.sil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                    builder1.setMessage("Silmek istediğine emin misin?");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("Sil",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    MainActivity.allLists.productBasketList.remove(product);
                                    refreshBasket();
                                    dialog.cancel();
                                }
                            });
                    builder1.setNegativeButton("Vazgeç",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            });
            System.out.println(product.getBasketProduct_name());
        }
        return convertView;
    }

    public void refreshBasket() {
        System.out.println("refreshBasket e girdi");

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.placeholder_basket, new ShoppingBasketFragment());
        ft.commit();

        FragmentTransaction ft2 = fragmentManager.beginTransaction();
        ft2.replace(R.id.placeholder_basket_price, new ShoppingBasketPriceFragment());
        ft2.commit();

   }
}
