package ofisesoyle.exp2;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;

import ofisesoyle_moduls.PriceList;
import ofisesoyle_moduls.Receivable;

public class ShoppingListFragment extends Fragment {

    ArrayList<Receivable> receivableCards = new ArrayList<Receivable>();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.shopping_list,container,false);
        v.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        return v;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnLE =(Button) getView().findViewById(R.id.button_listeye_urun_ekle);
        btnLE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Tusa Basildi!! LE");
                addingListDialogCaller();
            }
        });
        //createShoppingList();

    }

    public void addingListDialogCaller() {
        AddToListMessageDialogFragment newFragment = new AddToListMessageDialogFragment();
        newFragment.show(getFragmentManager(), "add_to_list_dialog");
    }
    public void closeMessageDialog() {
        closeDialog("add_to_list_dialog");
    }
    public void closeDialog(String dialogName) {
        FragmentManager fragmentManager = getFragmentManager();
        DialogFragment fragment = (DialogFragment) fragmentManager.findFragmentByTag(dialogName);
        if(fragment != null) {
            fragment.dismiss();
        }
    }
   /* void createShoppingList(){
        System.out.println("Sepet Olustu");
        receivableCards.addAll(MainActivity.list.productShoppingList);
        ReceivableCardAdapter uCAdapter = new ReceivableCardAdapter(getActivity(), receivableCards, ShoppingListFragment.this.getFragmentManager());
        // listView = (ListView)getView().findViewById(R.id.list_view);
        // listView.setAdapter(uCAdapter);
        StaggeredGridView gridView = (StaggeredGridView) getView().findViewById(R.id.grid_view_sl);
        gridView.setAdapter(uCAdapter);
    }*/
}
