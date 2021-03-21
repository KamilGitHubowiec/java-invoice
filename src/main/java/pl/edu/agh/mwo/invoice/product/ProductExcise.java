package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class ProductExcise extends Product{
	 private final BigDecimal excise;
	
	public ProductExcise(String name, BigDecimal price, BigDecimal tax, BigDecimal excise) {
		super(name, price, tax);
		this.excise = excise;
	}

	public BigDecimal getExcise() {
        return excise;
    }
	
	public BigDecimal getPriceWithTax() {
        return getPrice().multiply(getTaxPercent()).add(getPrice());
    }
}
