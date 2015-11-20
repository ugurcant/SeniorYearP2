package ofisesoyle.exp2;

/**
 * Created by Ugur.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;

import ofisesoyle_moduls.Product;

public class ShoppingBasketFragment extends Fragment{

    public StaggeredGridView gridView;
  //  public ListView listView;
    ArrayList<Product> productCards = new ArrayList<Product>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.shopping_basket,container,false);
        v.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createSepet();
        Intent myIntent = new Intent(getActivity(), PaymentPageActivity.class);
        getActivity().startActivity(myIntent);
    }
    void createSepet(){
            System.out.println("Sepet Olustu");
            //productCards.addAll(MainActivity.productShoppingList);
            ProductCardAdapter uCAdapter = new ProductCardAdapter(getActivity(), productCards, ShoppingBasketFragment.this.getFragmentManager());
           // listView = (ListView)getView().findViewById(R.id.list_view);
           // listView.setAdapter(uCAdapter);
            gridView = (StaggeredGridView) getView().findViewById(R.id.grid_view);
            gridView.setAdapter(uCAdapter);
    }
}