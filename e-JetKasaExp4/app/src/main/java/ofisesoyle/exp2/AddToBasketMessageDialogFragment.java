package ofisesoyle.exp2;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ofisesoyle_moduls.BasketProduct;
import ofisesoyle_moduls.Config;
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

    private TextView product_name;
    private TextView product_info;
    private Spinner product_amount;
    private TextView product_price;

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

        product_name = (TextView) rootView.findViewById(R.id.addtobasket_product_name);
        product_info = (TextView) rootView.findViewById(R.id.addtobasket_product_info);
        product_price = (TextView) rootView.findViewById(R.id.addtobasket_product_price);
        product_amount = (Spinner) rootView.findViewById(R.id.addtobasket_amout);

/*
       // Array List Control
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
*/
        // Database Control
        getProduct(mBarcode);

        builder.setPositiveButton("Sepete Ekle", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (mListener != null) {
                    productAmount = product_amount.getSelectedItem().toString();
                    product.setBasketBarcodeNo(product_barcode.getText().toString());
                    product.setBasketProduct_name(product_name.getText().toString());
                    product.setBasketProduct_info(product_info.getText().toString());
                    product.setBasketProduct_price(Double.parseDouble(product_price.getText().toString()));
                    product.setBasketProduct_amount(Integer.parseInt(productAmount));
                    System.out.println(product.getBasketProduct_name());
                    System.out.println(Double.parseDouble(product_price.getText().toString())*2);
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

    private void getProduct(final String barcodeS){
        class GetProduct extends AsyncTask<Void,Void,String> {
            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Config.URL_GET_PRODUCT,barcodeS);
                System.out.println("doInBackground Barcode: " + barcodeS);
                return s;
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                createProduct(s);
                System.out.println("onPostExecute: " + s);
            }

        }
        GetProduct gp = new GetProduct();
        gp.execute();
    }

    private void createProduct(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);

            String pName = c.getString(Config.TAG_NAME);
            String pInfo = c.getString(Config.TAG_INF);
            String pPriceS = c.getString(Config.TAG_PRICE);

            product_name.setText(pName);
            product_info.setText(pInfo);
            product_price.setText(pPriceS);

            System.out.println("ProductName: " + pName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

