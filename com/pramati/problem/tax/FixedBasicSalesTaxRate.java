package com.pramati.problem.tax;

import com.pramati.problem.items.Item;

/**
 * Concrete Basic Sales Tax implementation for fixed rate of sales Tax.
 * 
 * @author Dinesh S Gupta
 * 
 */
public class FixedBasicSalesTaxRate implements BasicSalesTaxStrategy {
	private float salesTaxRate;

	public FixedBasicSalesTaxRate(int salesTaxRate) throws InvalidArgumentException {
		if (salesTaxRate >= 0 && salesTaxRate <= 100) {
			this.salesTaxRate = salesTaxRate / 100.0f;
		} else {
			throw new InvalidArgumentException("Sales Tax Rate should be between 0 & 100 inclusive");
		}
	}

	@Override
	public boolean isSalesTaxApplicable() {
		return true;
	}

	@Override
	public float calculateSalesTax(Item item) {
		return item.getPrice() * salesTaxRate;
	}

}
