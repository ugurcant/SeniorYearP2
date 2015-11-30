package ofisesoyle.exp2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;

import ofisesoyle_moduls.AllLists;
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
        createShoppingList();
    }

   void createShoppingList(){
        System.out.println("Sepet Olustu");
        receivableCards.addAll(MainActivity.allLists.productShoppingList);
        ReceivableCardAdapter uCAdapter = new ReceivableCardAdapter(getActivity(), receivableCards, ShoppingListFragment.this.getFragmentManager());
        StaggeredGridView gridView = (StaggeredGridView) getView().findViewById(R.id.grid_view_sl);
        gridView.setAdapter(uCAdapter);
    }
}
