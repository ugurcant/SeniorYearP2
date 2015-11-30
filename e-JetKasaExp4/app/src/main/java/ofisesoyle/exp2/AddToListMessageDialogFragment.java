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

    public Receivable receivable = new Receivable("","");

    public interface MessageDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
    }
    private MessageDialogListener mListListener;

    public void onCreate(Bundle state) {
        super.onCreate(state);
        setRetainInstance(true);
    }

    public static AddToListMessageDialogFragment newInstance(MessageDialogListener listener) {
        AddToListMessageDialogFragment fragment = new AddToListMessageDialogFragment();
        fragment.mListListener = listener;
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View rootView = inflater.inflate(R.layout.add_to_list_dialog, null);
        builder.setView(rootView);

        final EditText receivable_name_input = (EditText) rootView.findViewById(R.id.productname_dialog);
        final EditText receivable_amount_input = (EditText) rootView.findViewById(R.id.productamount_dialog);

        builder.setPositiveButton("Listeye Ekle", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                receivable.setReceivable_name(receivable_name_input.getText().toString());
                receivable.setAmount(receivable_amount_input.getText().toString());
                System.out.println(receivable.getReceivable_name());
                MainActivity.allLists.addToProductShoppingList(receivable);
                if (mListListener != null) {
                    mListListener.onDialogPositiveClick(AddToListMessageDialogFragment.this);
                }
            }
        });
        builder.setNegativeButton("Vazgeç", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        return builder.create();
    }

    @Override
    public void onDismiss(DialogInterface frag) {
        super.onDismiss(frag);
        System.out.println("onDismiss e girdi");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.placeholder_list, new ShoppingListFragment());
        ft.commit();
    }
}

