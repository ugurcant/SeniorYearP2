package ofisesoyle.exp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ofisesoyle_moduls.Config;
import ofisesoyle_moduls.Receivable;

public class ShoppingListActivity extends FragmentActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list_mainpage);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.placeholder_list, new ShoppingListFragment());
        ft.commit();

        Button addtoList = (Button) findViewById(R.id.button_add_to_list);
        addtoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Add to List");
                addingListDialogCaller();
            }
        });

        Button backToMainP = (Button) findViewById(R.id.button_backTo_MainPage);
        backToMainP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        saveReceivables(this, MainActivity.allLists.productShoppingList);
        MainActivity.allLists.productShoppingList = getReceivables(this);
    }
    public void addingListDialogCaller() {
        AddToListMessageDialogFragment newFragment = new AddToListMessageDialogFragment();
        newFragment.show(getSupportFragmentManager(), "add_to_list_dialog");
    }
    public void closeMessageDialog() {
        closeDialog("add_to_list_dialog");
    }
    public void closeDialog(String dialogName) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment fragment = (DialogFragment) fragmentManager.findFragmentByTag(dialogName);
        if(fragment != null) {
            fragment.dismiss();
        }
    }

    public void saveReceivables(Context context, ArrayList<Receivable> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(Config.PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(Config.RECEIVABLES_SHARED_PREF, jsonFavorites);
        editor.commit();
    }

    public ArrayList<Receivable> getReceivables(Context context) {
        SharedPreferences settings;
        List<Receivable> favorites;

        settings = context.getSharedPreferences(Config.PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(Config.RECEIVABLES_SHARED_PREF)) {
            String jsonFavorites = settings.getString(Config.RECEIVABLES_SHARED_PREF, null);
            Gson gson = new Gson();
            Receivable[] favoriteItems = gson.fromJson(jsonFavorites,
                    Receivable[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<Receivable>(favorites);
        } else
            return null;
        return (ArrayList<Receivable>) favorites;
    }
}