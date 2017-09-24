package foodOrderingSystem;

import java.util.Scanner;

public abstract class Cuisine {

	private Scanner scanner;
	private int price;
	private String name;
	
	protected String main1;
	protected int main1Price;
	protected String dessert1;
	protected int dessert1Price;
	protected String main2;
	protected int main2Price;
	protected String dessert2;
	protected int dessert2Price;
	protected String main3;
	protected int main3Price;
	protected String dessert3;
	protected int dessert3Price;

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
	
	private String getMainMenu() {
		return "1. " + main1 + "\n2. " + main2 + "\n3. " + main3;
	}

	private String getDessertMenu() {
		return "1. " + dessert1 + "\n2. " + dessert2 + "\n3. " + dessert3;
	}

	public void mainCourse() {
		System.out.println("Please choose main course\n" + getMainMenu());
		scanner = new Scanner(System.in);
		try {
			int lunchChoice = scanner.nextInt();
			switch (lunchChoice) {
			case 1:
				name = main1;
				price = main1Price;
				break;
			case 2:
				name = main2;
				price = main2Price;
				break;
			case 3:
				name = main3;
				price = main3Price;
				break;
			default:
				this.mainCourse();
			}
		} catch (Exception e) {
			this.mainCourse();
		}
	}

	public void dessert() {
		System.out.println("Please choose dessert\n" + getDessertMenu());
		scanner = new Scanner(System.in);
		try {
			int dessertChoice = scanner.nextInt();
			switch (dessertChoice) {
			case 1:
				name = name + " and " + dessert1;
				price = price + dessert1Price;
				break;
			case 2:
				name = name + " and " + dessert2;
				price = price + dessert2Price;
				break;
			case 3:
				name = name + " and " + dessert3;
				price = price + dessert3Price;
				break;
			default:
				this.dessert();
			}
		} catch (Exception e) {
			this.dessert();
		}
	}
}
