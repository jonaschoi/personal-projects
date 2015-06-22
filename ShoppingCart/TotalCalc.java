package ShoppingCart;

import java.math.BigDecimal;

/**
 * Created by Jonas on 2015-06-18.
 */
public class TotalCalc {

    protected static BigDecimal[] priceTotal(Item[] items) {
        BigDecimal[] priceTotal = new BigDecimal[items.length];
        BigDecimal[] taxes = taxesAdded(items);

        for (int i = 0; i < items.length; i++) {
            priceTotal[i] = BigDecimal.ZERO;
            priceTotal[i] = items[i].prices.add(taxes[i]);
            priceTotal[i] = priceTotal[i].multiply(items[i].quantities);
        }
        return priceTotal;
    }

    protected static BigDecimal[] taxesAdded(Item[] items) {
        BigDecimal[] taxesAdded = new BigDecimal[items.length];
        BigDecimal[] salesTaxes = TaxCalc.salesTax(items);
        BigDecimal[] importTaxes = TaxCalc.importTax(items);

        for (int i = 0; i < items.length; i++) {
            taxesAdded[i] = BigDecimal.ZERO;
            taxesAdded[i] = salesTaxes[i].add(importTaxes[i]);
        }

        return taxesAdded;
    }

    protected static BigDecimal taxesTotal(Item[] items) {

        BigDecimal totalTaxes = BigDecimal.ZERO;
        BigDecimal[] taxes = taxesAdded(items);

        for (BigDecimal i : taxes) {
            totalTaxes = totalTaxes.add(i);
        }
        return totalTaxes;
    }

    protected static BigDecimal total(Item[] items) {
        BigDecimal total = BigDecimal.ZERO;

        BigDecimal[] priceTaxed = priceTotal(items);

        for (int i = 0; i < items.length; i++) {
            total = total.add(priceTaxed[i]);
        }

        return total;
    }
}
