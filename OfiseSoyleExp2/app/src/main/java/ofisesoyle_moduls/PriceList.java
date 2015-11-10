package ofisesoyle_moduls;

import java.util.ArrayList;

/**
 * Created by Ugur
 *
 */
public class PriceList {
    ArrayList<PriceCons> prices = new ArrayList<PriceCons>();

    public void prices() {
       prices.add(new PriceCons("Latte","Tall",5.5));
       prices.add(new PriceCons("Latte", "Grande", 6.5));
       prices.add(new PriceCons("Latte", "Venti", 7.25));

        prices.add(new PriceCons("Mocha", "Tall", 7));
        prices.add(new PriceCons("Mocha", "Grande", 8));
        prices.add(new PriceCons("Mocha", "Venti", 9.5));

        prices.add(new PriceCons("Chai Latte", "Tall", 6.25));
        prices.add(new PriceCons("Chai Latte", "Grande", 7));
        prices.add(new PriceCons("Chai Latte", "Venti",8));

        prices.add(new PriceCons("Fiesta","",6.5));
        prices.add(new PriceCons("Brownie","",8.25));
        prices.add(new PriceCons("Mozzarella Sandwich","",7.25));
        prices.add(new PriceCons("Peynirli Simit","",5));
        prices.add(new PriceCons("Peynirli Croissant","",6.5));
        prices.add(new PriceCons("Zeytinli Açma","",4.25));
        prices.add(new PriceCons("Kepekli Puf","",5.5));
        prices.add(new PriceCons("Elmalı Cheesecake", "", 8.5));
        prices.add(new PriceCons("Balkabaklı Cheesecake", "", 8.5));
        prices.add(new PriceCons("Mozaik Pasta", "", 6.25));
        prices.add(new PriceCons("Havuçlu Kek", "", 7.75));
        prices.add(new PriceCons("Haşhaşlı-Üç Peynirli", "", 4.75));

        prices.add(new PriceCons("Ristretto Bianco", "Tall", 6.25));
        prices.add(new PriceCons("Ristretto Bianco", "Grande", 7));
        prices.add(new PriceCons("Ristretto Bianco", "Venti",8));

        prices.add(new PriceCons("White Mocha", "Tall", 6.25));
        prices.add(new PriceCons("White Mocha", "Grande", 7));
        prices.add(new PriceCons("White Mocha", "Venti",8));

        prices.add(new PriceCons("Americano", "Tall", 6.25));
        prices.add(new PriceCons("Americano", "Grande", 7));
        prices.add(new PriceCons("Americano", "Venti",8));

        prices.add(new PriceCons("Misto", "Tall", 6.25));
        prices.add(new PriceCons("Misto", "Grande", 7));
        prices.add(new PriceCons("Misto", "Venti",8));

        prices.add(new PriceCons("Filtered Coffee", "Tall", 6.25));
        prices.add(new PriceCons("Filtered Coffee", "Grande", 7));
        prices.add(new PriceCons("Filtered Coffee", "Venti",8));

        prices.add(new PriceCons("Cappuccino", "Tall", 6.25));
        prices.add(new PriceCons("Cappuccino", "Grande", 7));
        prices.add(new PriceCons("Cappuccino", "Venti",8));

        prices.add(new PriceCons("Caramel Macchiato", "Tall", 6.25));
        prices.add(new PriceCons("Caramel Macchiato", "Grande", 7));
        prices.add(new PriceCons("Caramel Macchiato", "Venti",8));

        prices.add(new PriceCons("Iced Americano", "Tall", 6.25));
        prices.add(new PriceCons("Iced Americano", "Grande", 7));
        prices.add(new PriceCons("Iced Americano", "Venti",8));

        prices.add(new PriceCons("Iced Latte", "Tall", 6.25));
        prices.add(new PriceCons("Iced Latte", "Grande", 7));
        prices.add(new PriceCons("Iced Latte", "Venti",8));

        prices.add(new PriceCons("Iced Mocha", "Tall", 6.25));
        prices.add(new PriceCons("Iced Mocha", "Grande", 7));
        prices.add(new PriceCons("Iced Mocha", "Venti",8));

        prices.add(new PriceCons("Iced White Mocha", "Tall", 6.25));
        prices.add(new PriceCons("Iced White Mocha", "Grande", 7));
        prices.add(new PriceCons("Iced White Mocha", "Venti",8));

        prices.add(new PriceCons("Iced Caramel Macchiato", "Tall", 6.25));
        prices.add(new PriceCons("Iced Caramel Macchiato", "Grande", 7));
        prices.add(new PriceCons("Iced Caramel Macchiato", "Venti",8));

        prices.add(new PriceCons("Iced Chai Latte", "Tall", 6.25));
        prices.add(new PriceCons("Iced Chai Latte", "Grande", 7));
        prices.add(new PriceCons("Iced Chai Latte", "Venti",8));
    }
    public ArrayList<PriceCons> getPrices(){
        return prices;
    }
}