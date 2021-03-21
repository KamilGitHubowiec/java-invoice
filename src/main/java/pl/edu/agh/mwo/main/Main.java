package pl.edu.agh.mwo.main;

import java.math.BigDecimal;

import pl.edu.agh.mwo.invoice.Invoice;
import pl.edu.agh.mwo.invoice.product.DairyProduct;
import pl.edu.agh.mwo.invoice.product.OtherProduct;
import pl.edu.agh.mwo.invoice.product.Product;
import pl.edu.agh.mwo.invoice.product.TaxFreeProduct;

public class Main {
	
	public static void main (String[] args) {
		Invoice invoice = new Invoice();
		
		invoice.addProduct(new TaxFreeProduct("Owoce", new BigDecimal("200")));
		invoice.addProduct(new DairyProduct("Maslanka", new BigDecimal("100")));
		invoice.addProduct(new OtherProduct("Wino", new BigDecimal("10")));
		invoice.addProduct(new OtherProduct("Wino", new BigDecimal("10")));
        invoice.addProduct(new OtherProduct("Wino", new BigDecimal("10")));
        invoice.addProduct(new OtherProduct("Wino", new BigDecimal("10")));
        
        invoice.printInvoiceInfo();
	}
	
}
