package com.pramati.problem.items;

import com.pramati.problem.Utils;
import com.pramati.problem.tax.ImportDutyStrategy;
import com.pramati.problem.tax.BasicSalesTaxStrategy;

/**
 * Item is an abstract class that contains all common fields and properties
 * 
 * @author Dinesh S Gupta
 * 
 */
public abstract class Item {
	private String itemName;
	private float price;
	private boolean imported;

	private BasicSalesTaxStrategy basicSalesTaxStrategy;
	private ImportDutyStrategy importDutyStrategy;

	public Item(String name, float price) {
		this.setItemName(name);
		this.price = price;
	}

	public boolean isImported() {
		return imported;
	}

	public void setBasicSalesTaxStrategy(BasicSalesTaxStrategy strategy) {
		this.basicSalesTaxStrategy = strategy;
	}

	public float getUnitSalesTax() {
		return basicSalesTaxStrategy.calculateSalesTax(this);
	}

	public void setImportDutyStrategy(ImportDutyStrategy strategy) {
		this.importDutyStrategy = strategy;
	}

	public float getUnitImportDuty() {
		return importDutyStrategy.calculateImportDuty(this);
	}

	public float getPrice() {
		return Utils.roundOff2Digits(price);
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
