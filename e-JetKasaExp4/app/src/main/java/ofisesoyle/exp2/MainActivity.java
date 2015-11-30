package ofisesoyle.exp2;


import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import ofisesoyle_moduls.AllLists;
import ofisesoyle_moduls.PriceList;

public class MainActivity extends ActionBarActivity {

    // Declaring Your View and Variables

    Toolbar toolbar;
    public static AllLists allLists = new AllLists();
    public static PriceList priceList = new PriceList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.placeholder_main, new MainPageFragment());
        ft.commit();
        priceList.prices();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_profile) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
    public void launchScannerActivity(View v) {
        Intent intent = new Intent(this, ScannerActivity.class);
        startActivity(intent);
    }

    public void launchBasketActivity(View v) {
        Intent intent = new Intent(this, PaymentPageActivity.class);
        startActivity(intent);
    }

    public void launchListActivity(View v) {
        Intent intent = new Intent(this, ShoppingListActivity.class);
        startActivity(intent);
    }
    

    public void refreshSepet() {
    }
}