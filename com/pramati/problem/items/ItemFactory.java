package com.pramati.problem.items;

import com.pramati.problem.tax.BasicSalesTaxStrategy;
import com.pramati.problem.tax.FixedImportDutyRate;
import com.pramati.problem.tax.FixedBasicSalesTaxRate;
import com.pramati.problem.tax.ImportDutyStrategy;
import com.pramati.problem.tax.InvalidArgumentException;
import com.pramati.problem.tax.NoImportDuty;
import com.pramati.problem.tax.BasicSalesTaxExemption;
import com.sun.org.apache.bcel.internal.generic.SALOAD;

/**
 * This class is an item factory and based on passed item name, it will pattern match and
 * instantiate specific subclass specific to that item.
 * 
 * Specific sales Tax strategy is injected here.
 * 
 * For current implementation if item name contains <b>imported</b> than it will be assumed imported
 * else its not imported. We inject fixed sales tax strategy here based on if its imported and it
 * belongs to a category for which sales tax is applicable.
 * 
 * @author Dinesh S Gupta
 * 
 */
public class ItemFactory {

	public static Item getItem(String name, float price) throws InvalidArgumentException {
		boolean imported = false;

		if (name.contains("imported")) {
			imported = true;
		}

		BasicSalesTaxStrategy exemptedSalesTax = new BasicSalesTaxExemption();
		BasicSalesTaxStrategy fixedRateSalesTax = new FixedBasicSalesTaxRate(10);
		ImportDutyStrategy noImportDuty = new NoImportDuty();
		ImportDutyStrategy fixedRateImportDuty = new FixedImportDutyRate(5);

		Item item = null;
		if (name.contains("book")) {
			item = new Book(name, price);
			item.setBasicSalesTaxStrategy(exemptedSalesTax);
		} else if (name.contains("chocolate")) {
			item = new Food(name, price);
			item.setBasicSalesTaxStrategy(exemptedSalesTax);
		} else if (name.contains("headache")) {
			item = new Medicine(name, price);
			item.setBasicSalesTaxStrategy(exemptedSalesTax);
		} else {
			item = new OtherItem(name, price);
			item.setBasicSalesTaxStrategy(fixedRateSalesTax);
		}

		if (imported) {
			item.setImportDutyStrategy(fixedRateImportDuty);
		} else {
			item.setImportDutyStrategy(noImportDuty);
		}
		return item;

	}
}
