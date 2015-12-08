package ofisesoyle_moduls;

public class Order {
    public String order_name = null;
    public String order_info = null;
    public double order_price;
    public int order_amount;

    public Order(String order_name, String order_info, double order_price, int order_amount){
        this.order_name = order_name;
        this.order_info = order_info;
        this.order_price = order_price;
        this.order_amount = order_amount;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_info() {
        return order_info;
    }

    public void setOrder_info(String order_info) {
        this.order_info = order_info;
    }

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public int getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(int order_amount) {
        this.order_amount = order_amount;
    }

}