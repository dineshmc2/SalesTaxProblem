package com.pramati.problem;

import com.pramati.problem.items.Item;

/**
 * Shopping Cart contract
 * 
 * @author Dinesh S Gupta
 * 
 */
public interface ShoppingCart {
	/**
	 * Put item in shopping cart
	 * 
	 * @param item
	 *            item to put
	 * @param quantity
	 *            of item in shopping cart
	 */
	public void putItem(Item item, int quantity);

	/**
	 * 
	 * @return total Price of shopping cart exclusive of any taxes
	 */
	public float getTotalPriceExclusiveTax();

	/**
	 * 
	 * @return total Price of shopping cart including all taxes
	 */
	public float getTotalPriceInclusiveTax();

	/**
	 * 
	 * @return total basic sales Tax on all items in shopping cart rounded to 2 decimal places
	 */
	public float getTotalBasicSalesTax();

	/**
	 * 
	 * @return total import duty on all items in shopping cart rounded to 2 decimal places
	 */
	public float getTotalImportDuty();

	/**
	 * 
	 * @return total Tax on all items in shopping cart rounded to 2 decimal places and nearest to
	 *         0.05
	 */
	public float getTotalTax();
}
