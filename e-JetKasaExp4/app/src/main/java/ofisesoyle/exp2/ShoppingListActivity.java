package ofisesoyle.exp2;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

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
}