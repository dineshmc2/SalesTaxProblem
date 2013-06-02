package com.pramati.problem.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pramati.problem.ShoppingCart;
import com.pramati.problem.ShoppingCartImpl;
import com.pramati.problem.items.Item;
import com.pramati.problem.items.ItemFactory;
import com.pramati.problem.tax.InvalidArgumentException;

public class ShoppingCartTest {

	@Test
	public void shoppingCartTest1() throws InvalidArgumentException {
		String[] items = { "1 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85" };
		ShoppingCart cart = getCart(items);

		assertTrue("Shopping cart Total Tax", cart.getTotalTax() == 1.50f);
		assertTrue("Shopping Cart Total Value", cart.getTotalPriceInclusiveTax() == 29.83f);
	}

	@Test
	public void shoppingCartTest2() throws InvalidArgumentException {
		String[] items = { "1 imported box of chocolates at 10.00",
				"1 imported bottle of perfume at 47.50" };
		ShoppingCart cart = getCart(items);

		assertTrue("Shopping cart Total Tax", cart.getTotalTax() == 7.65f);
		assertTrue("Shopping Cart Total Value", cart.getTotalPriceInclusiveTax() == 65.15f);
	}

	@Test
	public void shoppingCartTest3() throws InvalidArgumentException {
		String[] items = { "1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99",
				"1 packet of headache pills at 9.75", "1 box of imported chocolates at 11.25" };

		ShoppingCart cart = getCart(items);

		assertTrue("Shopping cart Total Tax", cart.getTotalTax() == 6.70f);
		assertTrue("Shopping Cart Total Value", cart.getTotalPriceInclusiveTax() == 74.68f);
	}

	public ShoppingCart getCart(String[] items) throws InvalidArgumentException {
		ShoppingCart cart = new ShoppingCartImpl();

		for (String currentLine : items) {
			if (!currentLine.trim().equals("")) {
				String input[] = currentLine.split("\\s+");

				StringBuilder name = new StringBuilder();
				for (int i = 1; i < input.length - 2; i++) {
					name = name.append(input[i]).append(" ");
				}
				float price = Float.parseFloat(input[input.length - 1]);
				int quantity = Integer.parseInt(input[0].trim());
				Item item = ItemFactory.getItem(name.toString(), price);
				cart.putItem(item, quantity);
			}
		}

		return cart;
	}
}
