package ofisesoyle.exp2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

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

    public static void setStringArrayPref(Context context, String products, String amounts, ArrayList<Receivable> values){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray p = new JSONArray();
        JSONArray a = new JSONArray();
        for (int i = 0; i< values.size(); i++){
            p.put(values.get(i).getReceivable_name());
            a.put(values.get(i).getAmount());
        }
        if(!values.isEmpty()){
            editor.putString(products,p.toString());
            editor.putString(amounts,a.toString());
        }else{
            editor.putString(products,null);
            editor.putString(amounts,null);
        }
        editor.commit();
    }

    public static ArrayList<Receivable> getStringArrayPref(Context context, String products, String amounts){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonP = prefs.getString(products, null);
        String jsonA = prefs.getString(amounts, null);
        ArrayList<Receivable> receivables = new ArrayList<Receivable>();
        if(jsonA != null && jsonP != null){
            try{
                JSONArray p = new JSONArray(jsonP);
                JSONArray a = new JSONArray(jsonA);

                for (int i = 0; i<p.length();i++){
                    String product = p.optString(i);
                    String amount = a.optString(i);
                    Receivable receivable = new Receivable(product,amount);
                    receivables.add(receivable);
                }

            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return receivables;
    }
}