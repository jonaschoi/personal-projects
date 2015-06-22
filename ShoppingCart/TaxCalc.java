package ShoppingCart;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Jonas on 2015-06-18.
 */
public class TaxCalc{

    protected static BigDecimal[] importTax(Item[] items) {

        //Calculates import taxes of each item, if applicable
        // All imported items are taxed.

        BigDecimal[] importTax = new BigDecimal[items.length];
        BigDecimal importTaxRate = new BigDecimal("0.05");

        for (int i = 0; i < items.length; i++) {
            if (items[i].imported) {
                importTax[i] = items[i].prices.multiply(importTaxRate);
                importTax[i] = rounding(importTax[i]);
            } else {
                importTax[i] = BigDecimal.ZERO;
            }
        }
        return importTax;
    }

    protected static BigDecimal[] salesTax(Item[] items) {

        //Calculates sales tax.
        // Non-taxable items are books, food, medicine.

        BigDecimal[] salesTax = new BigDecimal[items.length];
        BigDecimal salesTaxRate = new BigDecimal("0.10");

        for (int i = 0; i < items.length; i++) {
            if (items[i].taxable) {
                salesTax[i] = items[i].prices.multiply(salesTaxRate);
                salesTax[i] = rounding(salesTax[i]);
            } else {
                salesTax[i] = BigDecimal.ZERO;
            }
        }
        return salesTax;
    }

    private static BigDecimal rounding(BigDecimal round) {

        // Rounding of Taxes

        BigDecimal rounding;
        BigDecimal rounder = new BigDecimal("20");

        rounding = round.multiply(rounder);
        rounding = rounding.setScale(0, RoundingMode.CEILING);
        rounding = rounding.divide(rounder);
        rounding = rounding.setScale(2, RoundingMode.CEILING);

        return rounding;
    }
}
