package ofisesoyle_moduls;

public class Config {
    public static final String URL_GET_PRODUCT = "http://uctfastpay.esy.es/getProductInfo.php?barcode=";
    public static final String URL_GET_STOCK = "http://uctfastpay.esy.es/getStock.php?barcode=";
    public static final String URL_UPDATE_STOCK = "http://uctfastpay.esy.es/updateStock.php?barcode=";
    public static final String URL_LOGIN = "http://uctfastpay.esy.es/login.php";
    public static final String URL_REGISTER = "http://uctfastpay.esy.es/register.php";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_PRODUCT_BARCODE = "barcode";
    public static final String KEY_PRODUCT_AMOUNT = "amount";

    public static final String KEY_USERFNAME = "user_fname";
    public static final String KEY_USERLNAME = "user_lname";
    public static final String KEY_USERNAME = "user_name";
    public static final String KEY_USEREMAIL = "user_email";
    public static final String KEY_PASSWORD = "user_password";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_NAME = "product_name";
    public static final String TAG_INF = "product_info";
    public static final String TAG_PRICE = "product_price";
    public static final String TAG_AMOUNT = "product_amount";
    public static final String TAG_REQUEST = "request_result";

    public static final String PRODUCT_BARCODE = "prd_barcode";
    public static final String USERNAME_SHARED_PREF = "user_name";

    public static final String LOGIN_SUCCESS = "success";
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
    public static final String SHARED_PREF_NAME = "myloginapp";
}