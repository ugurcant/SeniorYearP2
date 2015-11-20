package ofisesoyle_moduls;

public class Receivable {
    public String receivable_name;
    public String amount;

    public Receivable(String receivable_name, String amount){
        this.receivable_name = receivable_name;
        this.amount = amount;
    }

    public String getReceivable_name() {
        return receivable_name;
    }

    public void setReceivable_name(String receivable_name) {this.receivable_name = receivable_name;}

    public String getAmount() {return amount;}

    public void setAmount(String amount) {this.amount = amount;}
}