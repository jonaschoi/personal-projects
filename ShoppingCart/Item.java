package ShoppingCart;

import java.math.BigDecimal;

/**
 * Created by Jonas on 2015-06-18.
 */
public class Item {

    protected boolean imported;
    protected String items;
    protected BigDecimal prices;
    protected BigDecimal quantities;
    protected boolean taxable;

    protected Item(BigDecimal qua, String ite, BigDecimal pri, boolean tax, boolean imp) {
        quantities = qua;
        items = ite;
        prices = pri;
        taxable = tax;
        imported = imp;
    }
}
