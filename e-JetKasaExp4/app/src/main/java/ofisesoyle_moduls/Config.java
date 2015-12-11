package ofisesoyle_moduls;

/**
 * Created by ugurcant on 11.12.2015.
 */
public class Config {

    public static final String URL_GET_PRODUCT = "http://uctfastpay.esy.es/getProductInfo.php?product_barcode=";
    public static final String URL_GET_STOCK = "http://uctfastpay.esy.es/getStock.php?product_barcode=";
    public static final String URL_UPDATE_STOCK = "http://uctfastpay.esy.es/updateStock.php?product_barcode=";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_PRODUCT_BARCODE = "product_barcode";
    public static final String KEY_PRODUCT_NAME = "product_name";
    public static final String KEY_PRODUCT_INFO = "product_info";
    public static final String KEY_PRODUCT_PRICE = "product_price";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_BARCODE = "product_barcode";
    public static final String TAG_NAME = "product_name";
    public static final String TAG_INF = "product_info";
    public static final String TAG_PRICE = "product_price";

    //employee id to pass with intent
    public static final String PRODUCT_BARCODE = "prd_barcode";
}