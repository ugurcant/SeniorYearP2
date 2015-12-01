package ofisesoyle.exp2;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import ofisesoyle_moduls.BasketProduct;
import ofisesoyle_moduls.Product;

public class AddToBasketMessageDialogFragment extends DialogFragment {
    public interface MessageDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
    }
    private String mBarcode;
    private MessageDialogListener mListener;
    public String productAmount;
    public BasketProduct product = new BasketProduct("","","",0,0);
    public String productName = "";
    public String productInfo = "";
    public double productPrice = 0;

    public void onCreate(Bundle state) {
        super.onCreate(state);
        setRetainInstance(true);
    }

    public static AddToBasketMessageDialogFragment newInstance(MessageDialogListener listener, String barcode) {
        AddToBasketMessageDialogFragment fragment = new AddToBasketMessageDialogFragment();
        fragment.mBarcode = barcode;
        fragment.mListener = listener;
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View rootView = inflater.inflate(R.layout.add_to_basket, null);
        builder.setView(rootView);

        final TextView product_barcode = (TextView) rootView.findViewById(R.id.addtobasket_product_barcode);
        product_barcode.setText(mBarcode);

        final TextView product_name = (TextView) rootView.findViewById(R.id.addtobasket_product_name);
        final TextView product_info = (TextView) rootView.findViewById(R.id.addtobasket_product_info);
        final Spinner product_amount = (Spinner) rootView.findViewById(R.id.addtobasket_amout);
        final TextView product_price = (TextView) rootView.findViewById(R.id.addtobasket_product_price);

        if(MainActivity.priceList.findFromPriceList(mBarcode) == true){
            productName = MainActivity.priceList.getFromPriceList(mBarcode).getProduct_name();
            productInfo = MainActivity.priceList.getFromPriceList(mBarcode).getProduct_info();
            productPrice = MainActivity.priceList.getFromPriceList(mBarcode).getProduct_price();

            product_name.setText(productName);
            product_info.setText(productInfo);
            product_price.setText(String.valueOf(productPrice)+ " TL");
        }else{
            productPrice = 1;
            product_name.setText("Unknown Product");
            product_info.setText("Unknown Product");
            product_price.setText(String.valueOf(productPrice)+ " TL");
        }

        builder.setPositiveButton("Sepete Ekle", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (mListener != null) {
                    productAmount = product_amount.getSelectedItem().toString();
                    product.setBasketBarcodeNo(product_barcode.getText().toString());
                    product.setBasketProduct_name(product_name.getText().toString());
                    product.setBasketProduct_info(product_info.getText().toString());
                    product.setBasketProduct_price(productPrice);
                    product.setBasketProduct_amount(Integer.parseInt(productAmount));
                    System.out.println(product.getBasketProduct_name());
                    MainActivity.allLists.addToProductBasketList(product);
                    mListener.onDialogPositiveClick(AddToBasketMessageDialogFragment.this);
                }
            }
        });
        builder.setNegativeButton("Yeniden Tara", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        return builder.create();
    }
}

