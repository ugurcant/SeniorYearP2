package ofisesoyle_moduls;

public class Receivable {

    public String receivable_name;
    public String receivable_amount;

    public Receivable(String name, String amount){
        this.receivable_name = name;
        this.receivable_amount = amount;
    }

    public String getReceivable_name() {
        return receivable_name;
    }

    public void setReceivable_name(String name) {
        this.receivable_name = name;
    }

    public String getAmount() {return receivable_amount;}

    public void setAmount(String amount) {
        this.receivable_amount = amount;
    }
}