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

import ofisesoyle_moduls.BasketProduct;

public class PaymentFinishedFragment extends Fragment{

    public StaggeredGridView gridView;
    ArrayList<BasketProduct> aPproductCards = new ArrayList<BasketProduct>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.afterpayment_list,container,false);
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
        createAPSepet();
    }
    public void createAPSepet(){
        System.out.println("AP Sepet Olustu");
        aPproductCards.addAll(MainActivity.allLists.productOrderList);
        PaymentFinishedCardAdapter uCAdapter = new PaymentFinishedCardAdapter(getActivity(), aPproductCards, PaymentFinishedFragment.this.getFragmentManager());;
        gridView = (StaggeredGridView) getView().findViewById(R.id.grid_view);
        gridView.setAdapter(uCAdapter);
    }
}