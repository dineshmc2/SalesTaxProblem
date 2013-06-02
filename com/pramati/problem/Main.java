package com.pramati.problem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.pramati.problem.items.Item;
import com.pramati.problem.items.ItemFactory;
import com.pramati.problem.tax.InvalidArgumentException;

/**
 * Program entry point. It assumes input file containing all required input
 * 
 * @author Dinesh S Gupta
 * 
 */
public class Main {
	private static final String fileName = "D:\\input.txt";

	public static void main(String[] args) throws InvalidArgumentException {
		BufferedReader bf = null;
		ShoppingCart cart = new ShoppingCartImpl();
		try {
			bf = new BufferedReader(new FileReader(new File(fileName)));
			String currentLine = bf.readLine();

			while (currentLine != null) {
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
				currentLine = bf.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bf != null) {
					bf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println(cart);
	}

}
