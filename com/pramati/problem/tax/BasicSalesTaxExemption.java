package com.pramati.problem.tax;

import com.pramati.problem.items.Item;

/**
 * Concrete implementation of Sales Tax strategy for exemption case where no sales tax is applicable
 * 
 * @author Dinesh S Gupta
 * 
 */
public class BasicSalesTaxExemption implements BasicSalesTaxStrategy {

	@Override
	public boolean isSalesTaxApplicable() {
		return false;
	}

	@Override
	public float calculateSalesTax(Item item) {
		return 0;
	}

}
