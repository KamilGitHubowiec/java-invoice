package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax) {
    	if (name == null || name == "" || price == null || tax == null) {
    		throw new IllegalArgumentException("This field cannot be null nor empty");
    	}
    	
    	if (price.signum() < 0) {
    		throw new IllegalArgumentException("Price cannot be less than zero");
    	}
    	
        this.name = name;
        this.price = price;
        this.taxPercent = tax;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTaxPercent() {
        return this.taxPercent;
    }
    
    public BigDecimal getPriceWithTax() {
        return this.price.multiply(this.taxPercent).add(this.price);
    }
}
