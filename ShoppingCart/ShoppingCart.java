package ShoppingCart;

import java.math.BigDecimal;

/**
 * Created by Jonas on 2015-06-18.
 */

public class ShoppingCart {

    static Item[] input1 = new Item[3];
    static Item[] input2 = new Item[2];
    static Item[] input3 = new Item[4];

    public static void main(String[] args) {

        input1[0] = new Item(new BigDecimal("1"), "book", new BigDecimal("12.49"), false, false);
        input1[1] = new Item(new BigDecimal("1"), "music CD", new BigDecimal("14.99"), true, false);
        input1[2] = new Item(new BigDecimal("1"), "chocolate bar", new BigDecimal("0.85"), false, false);

        input2[0] = new Item(new BigDecimal("1"), "imported box of chocolates", new BigDecimal("10.00"), false, true);
        input2[1] = new Item(new BigDecimal("1"), "imported bottle of perfume", new BigDecimal("47.50"), true, true);

        input3[0] = new Item(new BigDecimal("1"), "imported bottle of perfume", new BigDecimal("27.99"), true, true);
        input3[1] = new Item(new BigDecimal("1"), "bottle of perfume", new BigDecimal("18.99"), true, false);
        input3[2] = new Item(new BigDecimal("1"), "headache pills", new BigDecimal("9.75"), false, false);
        input3[3] = new Item(new BigDecimal("1"), "box of imported chocolates", new BigDecimal("11.25"), false, true);

        output(input1);
        output(input2);
        output(input3);
    }

    static void output(Item[] carts) {
        for (int i = 0; i < carts.length; i++) {
            System.out.println(carts[i].quantities + " " + carts[i].items + " : " + TotalCalc.priceTotal(carts)[i]);
        }
        System.out.println("Sales Tax: " + TotalCalc.taxesTotal(carts));
        System.out.println("Total: " + TotalCalc.total(carts));
    }

}
