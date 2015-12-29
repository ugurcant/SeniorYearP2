package ofisesoyle.exp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class PaymentFinishedActivity extends FragmentActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterpayment_mainpage);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.placeholder_ap, new PaymentFinishedFragment());
        ft.commit();

        Button backToMain = (Button) findViewById(R.id.button_backto_mainpage);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Back to Main Menu");
                Intent intent = new Intent(PaymentFinishedActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Button goToQR = (Button) findViewById(R.id.button_goToQR);
        goToQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Go to QR");
                Intent intent = new Intent(PaymentFinishedActivity.this,QRActivity.class);
                startActivity(intent);
            }
        });
    }
}