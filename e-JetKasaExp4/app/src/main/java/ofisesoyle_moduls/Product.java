package ofisesoyle_moduls;

/**
 * Created by Ugur.
 */
public class Product {

    public String barcodeNo;
    public String product_name = null;
    public String product_info = null;
    public double product_price;

    public Product(String barcodeNo, String product_name, String product_info, double product_price){
        this.barcodeNo = barcodeNo;
        this.product_name = product_name;
        this.product_info = product_info;
        this.product_price = product_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBarcodeNo() {
        return barcodeNo;
    }

    public void setBarcodeNo(String barcodeNo) {
        this.barcodeNo = barcodeNo;
    }

    public String getProduct_info() {return product_info;}

    public void setProduct_info(String product_info) {this.product_info = product_info;}

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }
}
