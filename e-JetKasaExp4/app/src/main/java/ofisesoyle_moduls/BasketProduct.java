package ofisesoyle_moduls;

public class BasketProduct {

    public String product_barcodeNo;
    public String product_name = null;
    public String product_info = null;
    public double product_price;
    public int product_amount;

    public BasketProduct(String product_barcodeNo, String product_name, String product_info, double product_price, int product_amount){
        this.product_barcodeNo = product_barcodeNo;
        this.product_name = product_name;
        this.product_info = product_info;
        this.product_price = product_price;
        this.product_amount = product_amount;
    }

    public int getBasketProduct_amount() {return product_amount;}

    public void setBasketProduct_amount(int product_amount) {this.product_amount = product_amount;}

    public String getBasketProduct_name() {
        return product_name;
    }

    public void setBasketProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBasketBarcodeNo() {
        return product_barcodeNo;
    }

    public void setBasketBarcodeNo(String barcodeNo) {
        this.product_barcodeNo = barcodeNo;
    }

    public String getBasketProduct_info() {return product_info;}

    public void setBasketProduct_info(String product_info) {this.product_info = product_info;}

    public double getBasketProduct_price() {
        return product_price;
    }

    public void setBasketProduct_price(double product_price) {
        this.product_price = product_price;
    }
}
