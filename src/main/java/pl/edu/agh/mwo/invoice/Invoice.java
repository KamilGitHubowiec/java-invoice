package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	// Linked Hash Map adds new items in order they were added
    private Map<Product, Integer> products = new LinkedHashMap();
    
    public void addProduct(Product product) {
        this.products.put(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {    
    		if (quantity <= 0) {
    			throw new IllegalArgumentException("Quantity cannot be less or equal zero");
    		}
    	
        	this.products.put(product, quantity);
    }

    public BigDecimal getSubtotal() {
    	BigDecimal subtotal = BigDecimal.ZERO;
    	
    	for (Product product : this.products.keySet() ) {
    		Integer quantity = this.products.get(product);
    		subtotal = subtotal.add(product.getPrice().multiply(new BigDecimal(quantity)));
    	}
        return subtotal;
    }

    public BigDecimal getTax() {
        BigDecimal tax = BigDecimal.ZERO;
        
        for (Product product : this.products.keySet()) {
        	Integer quantity = this.products.get(product);
        	tax = tax.add(product.getPrice().multiply(product.getTaxPercent()).multiply(new BigDecimal(quantity)));
        }
        
        return tax;
    }

    public BigDecimal getTotal() {
    	BigDecimal total = BigDecimal.ZERO;
        
        for (Product product : this.products.keySet()) {
        	Integer quantity = this.products.get(product);
        	total = total.add(product.getPriceWithTax().multiply(new BigDecimal(quantity)));
        }
        
        return total;
    }
}
