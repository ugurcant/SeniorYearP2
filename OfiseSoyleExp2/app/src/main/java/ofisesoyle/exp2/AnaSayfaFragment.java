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
public class AnaSayfaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.ana_sayfa,container,false);
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
        Button btnAIG =(Button) getView().findViewById(R.id.button_icecekler);
        btnAIG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Tusa Basildi!! AIG");
                Fragment newFragment = new IceceklerFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        Button btnYIG =(Button)getView().findViewById(R.id.button_yiyecekler);
        btnYIG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Tusa Basildi!! YIG");
                Fragment newFragment = new YiyeceklerFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        Button btnTIG =(Button)getView().findViewById(R.id.button_tatlilar);
        btnTIG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Tusa Basildi!! TIG");
                Fragment newFragment = new TatlilarFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
    }

    public void refreshSepet() {
        Fragment newFragment = new SepetFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
