package com.pramati.problem.tax;

import com.pramati.problem.items.Item;

/**
 * Concrete implementation of import duty for the case of fix import duty rate.
 * 
 * @author Dinesh S Gupta
 * 
 */
public class FixedImportDutyRate implements ImportDutyStrategy {

	private float importDutyRate;

	public FixedImportDutyRate(int percentImportDuty) throws InvalidArgumentException {
		if (percentImportDuty >= 0 && percentImportDuty <= 100) {
			this.importDutyRate = percentImportDuty / 100.0f;
		} else {
			throw new InvalidArgumentException("% Import Duty should be between 0 & 100 inclusive.");
		}
	}

	@Override
	public boolean isImported() {
		return true;
	}

	@Override
	public float calculateImportDuty(Item item) {
		return item.getPrice() * importDutyRate;
	}

}
