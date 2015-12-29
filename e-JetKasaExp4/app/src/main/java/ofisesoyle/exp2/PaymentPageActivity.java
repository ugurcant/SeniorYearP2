    package ofisesoyle.exp2;

    import android.app.Activity;
    import android.content.Context;
    import android.content.Intent;
    import android.content.SharedPreferences;
    import android.os.AsyncTask;
    import android.os.Bundle;
    import android.support.v4.app.FragmentActivity;
    import android.support.v4.app.FragmentTransaction;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.Toast;

    import com.paypal.android.sdk.payments.PayPalAuthorization;
    import com.paypal.android.sdk.payments.PayPalConfiguration;
    import com.paypal.android.sdk.payments.PayPalOAuthScopes;
    import com.paypal.android.sdk.payments.PayPalPayment;
    import com.paypal.android.sdk.payments.PayPalService;
    import com.paypal.android.sdk.payments.PaymentActivity;
    import com.paypal.android.sdk.payments.PaymentConfirmation;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;

    import java.math.BigDecimal;
    import java.text.SimpleDateFormat;
    import java.util.Arrays;
    import java.util.Calendar;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.Random;
    import java.util.Set;

    import ofisesoyle_moduls.BasketProduct;
    import ofisesoyle_moduls.Config;

    public class PaymentPageActivity extends FragmentActivity {

        private static final int REQUEST_CODE_PAYMENT = 1;
        private static final String TAG = "paymentExample";
        private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_NO_NETWORK;
        private static final String CONFIG_CLIENT_ID = "credential from developer.paypal.com";

        public static int orderNumber = 0;
        public static String eMailBody = "";
        Activity context = this;

        private static PayPalConfiguration config = new PayPalConfiguration()
                .environment(CONFIG_ENVIRONMENT).clientId(CONFIG_CLIENT_ID);
        // Start with mock environment.  When ready, switch to sandbox (ENVIRONMENT_SANDBOX)
        // or live (ENVIRONMENT_PRODUCTION)

        //private Context mContext;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.shopping_basket_mainpage);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.placeholder_basket, new ShoppingBasketFragment());
            ft.commit();

            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            ft2.add(R.id.placeholder_basket_price, new ShoppingBasketPriceFragment());
            ft2.commit();

            Button finishShopping = (Button) findViewById(R.id.button_finish_shopping);
            finishShopping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("PAYPAL");
                    onBuyPressed();
                }
            });

            Button backToMainP = (Button) findViewById(R.id.button_backTo_mainPage);
            backToMainP.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PaymentPageActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            Intent intent = new Intent(this, PayPalService.class);
            intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
            startService(intent);
        }

        public void onBuyPressed() {

            // PAYMENT_INTENT_SALE will cause the payment to complete immediately.
            // Change PAYMENT_INTENT_SALE to
            //   - PAYMENT_INTENT_AUTHORIZE to only authorize payment and capture funds later.
            //   - PAYMENT_INTENT_ORDER to create a payment for authorization and capture
            //     later via calls from your server.

            //PayPalPayment finalShoppingBasket = getStuffToBuy(PayPalPayment.PAYMENT_INTENT_SALE);
            PayPalPayment finalShoppingBasket = getThingToBuy(PayPalPayment.PAYMENT_INTENT_SALE);

            Intent intent = new Intent(this, PaymentActivity.class);

            // send the same configuration for restart resiliency
            intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);

            intent.putExtra(PaymentActivity.EXTRA_PAYMENT, finalShoppingBasket);

            startActivityForResult(intent, REQUEST_CODE_PAYMENT);
        }

        private PayPalPayment getThingToBuy(String paymentIntent) {
            return new PayPalPayment(new BigDecimal(MainActivity.allLists.calculateTotalPrice()), "TRY", "TOPLAM",
                    paymentIntent);
        }
/*
        private PayPalPayment getStuffToBuy(String paymentIntent) {

            ArrayList<PayPalItem> ite = new ArrayList<>();
            //--- include an item list, payment amount details
            PayPalItem[] items = {
                    new PayPalItem("sample item #1", 2, new BigDecimal("87.50"), "TRY",
                            "sku-12345678"),
                    new PayPalItem("free sample item #2", 1, new BigDecimal("0.00"),
                            "TRY", "sku-zero-price"),
                    new PayPalItem("sample item #3 with a longer name", 6, new BigDecimal("37.99"),
                            "TRY", "sku-33333")
            };

            BigDecimal subtotal = PayPalItem.getItemTotal(items);
            // BigDecimal shipping = new BigDecimal("7.21");
            // BigDecimal tax = new BigDecimal("4.67");
            // PayPalPaymentDetails paymentDetails = new PayPalPaymentDetails(shipping, subtotal, tax);
            // BigDecimal amount = subtotal.add(shipping).add(tax);
            PayPalPayment payment = new PayPalPayment(subtotal, "TRY", "TOPLAM", paymentIntent);
            payment.items(items);

            //--- set other optional fields like invoice_number, custom field, and soft_descriptor
            payment.custom("This is text that will be associated with the payment that the app can use.");

            return payment;
        }
*/
        private PayPalOAuthScopes getOauthScopes() {
            /* create the set of required scopes
             * Note: see https://developer.paypal.com/docs/integration/direct/identity/attributes/ for mapping between the
             * attributes you select for this app in the PayPal developer portal and the scopes required here.
             */
            Set<String> scopes = new HashSet<String>(
                    Arrays.asList(PayPalOAuthScopes.PAYPAL_SCOPE_EMAIL, PayPalOAuthScopes.PAYPAL_SCOPE_ADDRESS));
            return new PayPalOAuthScopes(scopes);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == REQUEST_CODE_PAYMENT) {
                if (resultCode == Activity.RESULT_OK) {
                    PaymentConfirmation confirm =
                            data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                    if (confirm != null) {
                        try {
                            Log.i(TAG, confirm.toJSONObject().toString(4));
                            Log.i(TAG, confirm.getPayment().toJSONObject().toString(4));

                            int START = 1000000;
                            int END = 100000;
                            Random randomGenerator = new Random();
                            long range = (long)START - (long)END + 1;
                            long fraction = (long)(range * randomGenerator.nextDouble());
                            orderNumber =  (int)(fraction + START);

                            MainActivity.allLists.productOrderList.addAll(MainActivity.allLists.productBasketList);

                            for(int i = 1; i <= MainActivity.allLists.productOrderList.size(); i++){

                                getProductStock(MainActivity.allLists.productOrderList.get(i - 1).getBasketBarcodeNo()
                                        , MainActivity.allLists.productOrderList.get(i - 1).getBasketProduct_amount());

                                writeOrder(MainActivity.allLists.productOrderList.get(i - 1), orderNumber);

                                eMailBody = eMailBody + prodDescCreator(MainActivity.allLists.productOrderList.get(i - 1));
                            }

                            Calendar c = Calendar.getInstance();
                            System.out.println("Current time => " + c.getTime());
                            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                            String formattedDate = df.format(c.getTime());
                            String eMailSubject = formattedDate + " tarihli, " + Integer.toString(orderNumber) + " numaralı alışverişinizin bilgileri. ";

                            String totalOrderPrice = "\nToplam Tutar : " + Double.toString(MainActivity.allLists.calculateTotalPrice()) + " TL";
                            eMailBody = eMailBody + totalOrderPrice;

                            sendBillwithEmail(eMailSubject, eMailBody);

                            MainActivity.allLists.productBasketList.clear();
                            Intent intentAP = new Intent(PaymentPageActivity.this, PaymentFinishedActivity.class);
                            startActivity(intentAP);

                            System.out.println("Online kullanıcı: " + getSPValue(context));

                        } catch (JSONException e) {
                            Log.e(TAG, "an extremely unlikely failure occurred: ", e);
                        }
                    }
                } else if (resultCode == Activity.RESULT_CANCELED) {
                    Log.i(TAG, "Kullanıcı iptal etti");
                } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                    Log.i(
                            TAG,
                            "An invalid Payment or PayPalConfiguration was submitted. Please see the docs.");
                }
            }
        }

        private void sendAuthorizationToServer(PayPalAuthorization authorization) {

            /**
             * TODO: Send the authorization response to your server, where it can
             * exchange the authorization code for OAuth access and refresh tokens.
             *
             * Your server must then store these tokens, so that your server code
             * can execute payments for this user in the future.
             *
             * A more complete example that includes the required app-server to
             * PayPal-server integration is available from
             * https://github.com/paypal/rest-api-sdk-python/tree/master/samples/mobile_backend
             */

        }

        @Override
        public void onDestroy() {
            stopService(new Intent(this, PayPalService.class));
            super.onDestroy();
        }

        private void getProductStock(final String barcodeS, final int intAmount) {
            class getProductStock extends AsyncTask<Void, Void, String> {
                @Override
                protected String doInBackground(Void... params) {
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequestParam(Config.URL_GET_STOCK, barcodeS);
                    System.out.println("doInBackgroundgPS Barcode: " + barcodeS);
                    return s;
                }
                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    calculateProductStock(s, intAmount, barcodeS);
                    System.out.println("onPostExecutegPS: " + s);
                }
            }
            getProductStock gp = new getProductStock();
            gp.execute();
        }

        private void calculateProductStock(final String json, int intAmount, final String barcodeS) {
            String stringAmount = null;
            try {
                JSONObject jsonObject = new JSONObject(json);
                JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
                JSONObject c = result.getJSONObject(0);

                String pAmount = c.getString(Config.TAG_AMOUNT);
                stringAmount = Integer.toString(Integer.parseInt(pAmount) - intAmount);
                System.out.println("ProductAmountPS: " + pAmount);

                setProductStock(barcodeS,stringAmount);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        private void setProductStock(final String barcodeS, final String stringAmount) {

            class setProductStock extends AsyncTask<Void, Void, String> {
                @Override
                protected String doInBackground(Void... params) {

                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put(Config.KEY_PRODUCT_BARCODE,barcodeS);
                    hashMap.put(Config.KEY_PRODUCT_AMOUNT,stringAmount);
                    RequestHandler rh = new RequestHandler();

                    String s = rh.sendPostRequest(Config.URL_UPDATE_STOCK,hashMap);
                    return s;
                }
                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                }
            }
            setProductStock sp = new setProductStock();
            sp.execute();
        }

        private void writeOrder(final BasketProduct product, final int orderNo) {

            class writeOrder extends AsyncTask<Void, Void, String> {
                @Override
                protected String doInBackground(Void... params) {

                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put(Config.KEY_ORDER_ID,Integer.toString(orderNo));
                    hashMap.put(Config.KEY_USERNAME,getSPValue(context));
                    hashMap.put(Config.KEY_PRODUCT_BARCODE,product.getBasketBarcodeNo());
                    hashMap.put(Config.KEY_PRODUCT_NAME,product.getBasketProduct_name());
                    hashMap.put(Config.KEY_PRODUCT_AMOUNT,Integer.toString(product.getBasketProduct_amount()));
                    hashMap.put(Config.KEY_PRODUCT_PRICE,Double.toString(product.getBasketProduct_amount()*product.getBasketProduct_price()));
                    RequestHandler rh = new RequestHandler();

                    String s = rh.sendPostRequest(Config.URL_WRITE_ORDER,hashMap);
                    return s;
                }
                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                }
            }
            writeOrder wo = new writeOrder();
            wo.execute();
        }

        public String getSPValue(Context context) {
            SharedPreferences settings;
            String text;
            settings = context.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE); //1
            text = settings.getString(Config.USERNAME_SHARED_PREF, null); //2
            return text;
        }

        private void sendBillwithEmail(final String subject, final String body) {
            class sendBillwithEmail extends AsyncTask<Void, Void, String> {
                @Override
                protected String doInBackground(Void... params) {
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequestParam(Config.URL_GET_USER_EMAIL, getSPValue(context));
                    return s;
                }
                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    eMailSender(subject, body, s);
                    System.out.println("onSendBillwithEmail: " + s);
                }
            }
            sendBillwithEmail sbwe = new sendBillwithEmail();
            sbwe.execute();
        }

        private void eMailSender(final String subject, final String body, final String eMail) {
            String userEmail;
            try {
                JSONObject jsonObject = new JSONObject(eMail);
                JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
                JSONObject c = result.getJSONObject(0);

                userEmail = c.getString(Config.TAG_USER_EMAIL);
                System.out.println("UserEmail: " + userEmail);

                Mail m = new Mail("ejetkasa@gmail.com", "23ugur08");
                String[] toArr = {userEmail};
                m.set_to(toArr);
                m.set_from("ejetkasa@gmail.com");
                m.set_subject(subject);
                m.set_body(body);
                try {
                    if (m.send()) {
                        Toast.makeText(PaymentPageActivity.this, "Alışveriş detayları e-mailinize gönderildi.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(PaymentPageActivity.this, "Email was not sent.", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Log.e("MailApp", "Could not send email", e);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public String prodDescCreator(BasketProduct product){
            String productDesc =
                    "\nÜrün Barkodu : " +  product.getBasketBarcodeNo() +
                    "\nÜrün Adı : " +  product.getBasketProduct_name() +
                    "\nÜrün Miktarı : " + Integer.toString(product.getBasketProduct_amount()) +
                    "\nTutar : " + Double.toString(product.getBasketProduct_price()*product.getBasketProduct_amount()) + " TL" +
                    "\n---------------------------------------------------------";
            return productDesc;
        }
    }
