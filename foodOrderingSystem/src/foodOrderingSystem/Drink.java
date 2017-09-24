package foodOrderingSystem;

import java.util.Scanner;

public class Drink {
	private Scanner scanner;
	private int price;
	private String name;

	public void start() {
		scanner = new Scanner(System.in);
		System.out.println("Please choose your drink\n" + "1. Water\n" + "2. Sprite\n" + "3. Ice Tea\n");
		try {
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				setPrice(4);
				setName("Water");
				askForLemon();
				askForIce();
				break;
			case 2:
				setPrice(6);
				setName("Sprite");
				askForLemon();
				askForIce();
				break;
			case 3:
				setPrice(7);
				setName("Ice Tea");
				askForLemon();
				askForIce();
				break;
			default:
				this.start();
			}
		} catch (Exception e) {
			this.start();
		}
	}

	public void askForLemon() {
		System.out.println("Do you want some lemon? (y/n)");
		String lemon = scanner.next();
		if (lemon.equals("y") || lemon.equals("Y")) {
			setName(name + " with lemon, ");
		} else if (!lemon.equals("n") && !lemon.equals("N")) {
			System.out.println("Sorry, I didn't get it.");
			askForLemon();
		}
	}

	public void askForIce() {
		System.out.println("Do you want some ice? (y/n)");
		String ice = scanner.next();
		if (ice.equals("y") || ice.equals("Y")) {
			setName(name + " with ice, ");
		} else if (!ice.equals("n") && !ice.equals("N")) {
			System.out.println("Sorry, I didn't get it.");
			askForIce();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
