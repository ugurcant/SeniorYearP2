package ofisesoyle.exp2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
//import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class QRActivity extends Activity {
    ImageLoader imgLoader;
    ImageView qrImg;
    TextView qrTxt;
    String clipboard;

    String BASE_QR_URL = "http://chart.apis.google.com/chart?cht=qr&chs=400x400&chld=M&choe=UTF-8&chl=";
    String fullUrl = BASE_QR_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        imgLoader = ImageLoader.getInstance();
        imgLoader.init(config);

        qrImg = (ImageView)findViewById(R.id.qrImg);
        qrTxt = (TextView)findViewById(R.id.qrTxt);

        Button backToAP = (Button) findViewById(R.id.button_back_to_AP);
        backToAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QRActivity.this,PaymentFinishedActivity.class);
                startActivity(intent);
            }
        });

        clipboard = Integer.toString(PaymentPageActivity.orderNumber);

        if((null != clipboard) && (clipboard.length() > 0)){
            try {
                qrTxt.setText(clipboard);
                fullUrl += URLEncoder.encode(clipboard, "UTF-8");
                imgLoader.displayImage(fullUrl, qrImg);

            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }else{ //If no text display a dialog.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("QRMaker")
                    .setCancelable(true)
                    .setMessage("OrderId'ye Ulaşılamıyor")
                    .setNeutralButton("Okay", new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            finish();
                        }
                    });
            AlertDialog diag = builder.create();
            diag.show();
        }
    }
}