package ofisesoyle.exp2;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class AddToBasketMessageDialogFragment extends DialogFragment {
    public interface MessageDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
    }
    private String mBarcode;
    private MessageDialogListener mListener;

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

        builder.setPositiveButton("Sepete Ekle", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (mListener != null) {
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

    @Override
    public void onDismiss(DialogInterface frag) {
        super.onDismiss(frag);
        /*System.out.println("onDismiss e girdi");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.placeholder_list, new ShoppingListFragment());
        ft.commit();*/
    }
}

