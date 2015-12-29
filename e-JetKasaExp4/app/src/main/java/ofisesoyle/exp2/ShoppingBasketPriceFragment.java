package ofisesoyle.exp2;

/**
 * Created by Ugur.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShoppingBasketPriceFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.shopping_basket_price,container,false);
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
        calculateSepet();
    }
    public void calculateSepet(){
        System.out.println("Sepet Hesaplandı");
        final TextView totalPrice = (TextView) getView().findViewById(R.id.total_price_sb);
        totalPrice.setText(Double.toString(MainActivity.allLists.calculateTotalPrice()) + " TL");
    }
}