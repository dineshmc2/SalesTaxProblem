package com.pramati.problem.tax;

import com.pramati.problem.items.Item;

/**
 * Contract to define strategy for Basic Sales tax calculation
 * 
 * @author Dinesh S Gupta
 * 
 */
public interface BasicSalesTaxStrategy {
	public boolean isSalesTaxApplicable();

	public float calculateSalesTax(Item item);
}
