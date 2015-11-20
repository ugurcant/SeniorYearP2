package ofisesoyle.exp2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.etsy.android.grid.StaggeredGridView;

import ofisesoyle_moduls.AllLists;
import ofisesoyle_moduls.Receivable;

public class AddToListMessageDialogFragment extends DialogFragment {
    public interface MessageDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
    }
    String receivable_name = null;
    String receivable_amount = null;
    private MessageDialogListener mListener;
    Receivable receivable;

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
        builder.setView(inflater.inflate(R.layout.add_to_list_dialog, null));
        builder.setPositiveButton("Listeye Ekle", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                receivable_name = ((EditText) getView().findViewById(R.id.productname_dialog)).getText().toString();
                receivable_amount = ((EditText) getActivity().findViewById(R.id.productamount_dialog)).getText().toString();
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
}

