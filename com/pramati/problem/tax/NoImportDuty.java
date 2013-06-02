package com.pramati.problem.tax;

import com.pramati.problem.items.Item;

/**
 * Concrete implementation of Import duty when import duty is not applicable
 * 
 * @author Dinesh S Gupta
 * 
 */
public class NoImportDuty implements ImportDutyStrategy {

	@Override
	public boolean isImported() {
		return false;
	}

	@Override
	public float calculateImportDuty(Item item) {
		return 0;
	}

}
