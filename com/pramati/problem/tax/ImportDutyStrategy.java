package com.pramati.problem.tax;

import com.pramati.problem.items.Item;

/**
 * Contract for defining import duty calculation strategy
 * 
 * @author Dinesh S Gupta
 * 
 */
public interface ImportDutyStrategy {

	public boolean isImported();

	public float calculateImportDuty(Item item);

}
