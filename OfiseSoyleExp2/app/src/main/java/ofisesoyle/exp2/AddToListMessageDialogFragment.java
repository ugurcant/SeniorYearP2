package ofisesoyle.exp2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.etsy.android.grid.StaggeredGridView;

import ofisesoyle_moduls.AllLists;
import ofisesoyle_moduls.Receivable;

/**
 * Created by ugurcant on 16.11.2015.
 */
public class AddToListMessageDialogFragment extends DialogFragment {
    public interface MessageDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
    }
    private String receivable_name;
    private String receivable_amount;
    private MessageDialogListener mListener;
    private Receivable receivable;

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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.add_to_list_dialog, null))
                .setPositiveButton("Listeye Ekle", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        TextView twReceivableName = (TextView) getView().findViewById(R.id.productname_dialog);
                        receivable_name = (String) twReceivableName.getText();
                        TextView twReceivableAmount = (TextView) getView().findViewById(R.id.productamount_dialog);
                        receivable_amount = (String) twReceivableAmount.getText();
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

