package ofisesoyle.exp2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Ugur.
 */
public class MainPageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.main_page,container,false);
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
        Button buttonToShoppingList =(Button) getView().findViewById(R.id.button_SList);
        buttonToShoppingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Tusa Basildi!! To Shopping List");
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.your_placeholder,new ShoppingListFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
       /* Button buttonToBasket =(Button) getView().findViewById(R.id.button_GoToBasket);
        buttonToBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Tusa Basildi!! To Basket");
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.your_placeholder, new ShoppingBasketFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });*/
}
}
