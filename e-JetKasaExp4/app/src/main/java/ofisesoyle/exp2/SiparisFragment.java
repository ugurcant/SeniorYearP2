package ofisesoyle.exp2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


import ofisesoyle_moduls.Order;

/**
 * Created by Ugur.
 */
public class SiparisFragment extends Fragment {

    public static Order yeniOrder;
    public double toplamFiyat;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.shopping_basket_mainpage,container,false);
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

}


}
