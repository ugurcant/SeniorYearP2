package ofisesoyle.exp2;

/**
 * Created by Ugur.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;

import ofisesoyle_moduls.ShoppingList;
import ofisesoyle_moduls.Urun;

public class ShoppingBasketFragment extends Fragment{

    public StaggeredGridView gridView;
  //  public ListView listView;
    ArrayList<Urun> urunCards = new ArrayList<Urun>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.shopping_basket,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createSepet();

        Button btnSO =(Button) getView().findViewById(R.id.button_alisverisi_tamamla);
        btnSO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Tusa Basildi!! SO");
                Fragment newFragment = new SiparisFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
    }
    void createSepet(){
            System.out.println("Sepet Olustu");
            urunCards.addAll(ShoppingList.urunSiparisList);
            ProductCardAdapter uCAdapter = new ProductCardAdapter(getActivity(), urunCards, ShoppingBasketFragment.this.getFragmentManager());
           // listView = (ListView)getView().findViewById(R.id.list_view);
           // listView.setAdapter(uCAdapter);
            gridView = (StaggeredGridView) getView().findViewById(R.id.grid_view);
            gridView.setAdapter(uCAdapter);
    }
}