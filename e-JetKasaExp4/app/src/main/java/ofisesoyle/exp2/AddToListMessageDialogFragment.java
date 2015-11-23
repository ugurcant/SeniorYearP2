package ofisesoyle.exp2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import ofisesoyle_moduls.Receivable;

public class AddToListMessageDialogFragment extends DialogFragment {
    public interface MessageDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
    }
    String receivable_name = "";
    String receivable_amount = "";
    private MessageDialogListener mListener;
    Receivable receivable = null;

    public void onCreate(Bundle state) {
        super.onCreate(state);
        setRetainInstance(true);
    }

    public static AddToListMessageDialogFragment newInstance(MessageDialogListener listener) {
        AddToListMessageDialogFragment fragment = new AddToListMessageDialogFragment();
        fragment.mListener = listener;
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.add_to_list_dialog, null);
        builder.setView(rootView);
        final EditText receivable_name_input = (EditText) rootView.findViewById(R.id.productname_dialog);
        builder.setView(receivable_name_input);
        final EditText receivable_amount_input = (EditText) rootView.findViewById(R.id.productamount_dialog);
        builder.setView(receivable_amount_input);
        builder.setPositiveButton("Listeye Ekle", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                receivable_name = receivable_name_input.getText().toString();
                receivable_amount = receivable_amount_input.getText().toString();
                receivable.setReceivable_name(receivable_name);
                receivable.setAmount(receivable_amount);
                MainActivity.list.productShoppingList.add(receivable);
                if (mListener != null) {
                    mListener.onDialogPositiveClick(AddToListMessageDialogFragment.this);
                }
            }
        }).setNegativeButton("Vazgeç", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        return builder.create();
    }

    @Override
    public void onDismiss(DialogInterface frag) {
        super.onDismiss(frag);
        /*Fragment frg = null;
        frg = getFragmentManager().findFragmentById(R.id.your_placeholder3);
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(frg);
        ft.attach(frg);
        ft.commit();*/
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.placeholder_list, new ShoppingListFragment());
        ft.commit();
    }
}

