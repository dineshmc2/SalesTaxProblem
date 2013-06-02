package com.pramati.problem;

import java.util.ArrayList;
import java.util.List;

import com.pramati.problem.items.Item;

/**
 * Implementation of Shopping cart
 * 
 * @author Dinesh S Gupta
 * 
 */
public class ShoppingCartImpl implements ShoppingCart {

	private class ItemWrapper {
		Item item;
		int quantity;
		float totalPrice;
		float basicSalesTax;
		float importDuty;
		float tax;

		public ItemWrapper(Item item, int quantity) {
			this.item = item;
			this.quantity = quantity;

			this.totalPrice = quantity * item.getPrice();
			this.basicSalesTax = item.getUnitSalesTax() * quantity;
			this.importDuty = item.getUnitImportDuty() * quantity;
			this.tax = Utils.roundOff2DigitsNearest05(basicSalesTax + importDuty);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder().append(quantity).append(" ")
					.append(item.getItemName()).append(": ")
					.append(Utils.appendZero(totalPrice + tax));

			return sb.toString();
		}
	};

	private List<ItemWrapper> itemsCart = new ArrayList<ShoppingCartImpl.ItemWrapper>();

	@Override
	public void putItem(Item item, int quantity) {
		ItemWrapper itm = new ItemWrapper(item, quantity);
		itemsCart.add(itm);
	}

	@Override
	public float getTotalPriceExclusiveTax() {
		float totalPrice = 0;
		for (ItemWrapper item : itemsCart) {
			totalPrice += item.totalPrice;
		}

		return Utils.roundOff2Digits(totalPrice);
	}

	@Override
	public float getTotalPriceInclusiveTax() {
		return Utils.roundOff2Digits(getTotalPriceExclusiveTax() + getTotalTax());
	}

	@Override
	public float getTotalBasicSalesTax() {
		float totalBasicSalesTax = 0;

		for (ItemWrapper item : itemsCart) {
			totalBasicSalesTax += item.basicSalesTax;
		}
		return Utils.roundOff2Digits(totalBasicSalesTax);
	}

	@Override
	public float getTotalImportDuty() {
		float totalImportDuty = 0;

		for (ItemWrapper item : itemsCart) {
			totalImportDuty += item.importDuty;
		}
		return Utils.roundOff2Digits(totalImportDuty);
	}

	@Override
	public float getTotalTax() {
		float totalTax = 0;

		for (ItemWrapper item : itemsCart) {
			totalTax += item.tax;
		}
		return Utils.roundOff2Digits(totalTax);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (ItemWrapper item : itemsCart) {
			sb = sb.append(item.toString()).append("\n");
		}

		sb = sb.append("Sales Taxes: ").append(Utils.appendZero(getTotalTax())).append("\n")
				.append("Total: ").append(Utils.appendZero(getTotalPriceInclusiveTax()));
		return sb.toString();
	}
}