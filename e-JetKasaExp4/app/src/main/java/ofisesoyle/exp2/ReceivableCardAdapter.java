package ofisesoyle.exp2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import ofisesoyle_moduls.Receivable;

public class ReceivableCardAdapter extends BaseAdapter {

    private Activity mContext;
    public ArrayList<Receivable> receivableList = new ArrayList<Receivable>();
    private LayoutInflater mLayoutInflater = null;
    private FragmentManager fragmentManager;

    public ReceivableCardAdapter(Activity context, ArrayList<Receivable> list, FragmentManager fm) {
        mContext = context;
        receivableList = list;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        fragmentManager = fm;
    }
    static class ReceivableCardViewHolder {
        TextView urunIsmi, adet;
        Button sil;
    }
    @Override
    public int getCount() {
        return receivableList.size();
    }

    @Override
    public Object getItem(int position) {
        return receivableList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ReceivableCardViewHolder vh;

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.receivable_card, parent, false);
            vh = new ReceivableCardViewHolder();
            vh.urunIsmi = (TextView) convertView.findViewById(R.id.receivable_card_urun_isim);
            vh.adet = (TextView) convertView.findViewById(R.id.receivable_card_amount);
            vh.sil = (Button) convertView.findViewById(R.id.button_delete);

            final Receivable receivable = receivableList.get(position);
            vh.urunIsmi.setText(receivable.getReceivable_name());
            vh.adet.setText(receivable.getAmount());
            vh.sil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                    builder1.setMessage("Silmek istediğine emin misin?");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("Sil",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    MainActivity.allLists.productShoppingList.remove(receivable);
                                    refreshList();
                                    dialog.cancel();
                                }
                            });
                    builder1.setNegativeButton("Vazgeç",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            });
            System.out.println(receivable.getReceivable_name());
        }
        return convertView;
    }

   public void refreshList() {
       System.out.println("refreshList e girdi");
       FragmentTransaction ft = fragmentManager.beginTransaction();
       ft.replace(R.id.placeholder_list, new ShoppingListFragment());
       ft.commit();
    }
}