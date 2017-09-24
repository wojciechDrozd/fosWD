package foodOrderingSystem;

import java.util.Scanner;

/*
 * provides implementation of main user menu,
 * enables choosing between drink, lunch and lunch cuisine,
 * creates instances of Drink and Cuisine objects,
 * asks for first and following orders, 
 * summarizes cost for all orders,
 * ends the program when user finished ordering
 */
public class Menu {

	private Scanner scanner;
	private int cuisineChoice; // stores user's cuisine choice
	private int totalCost; // stores total cost of orders
	private int count = 1; //counter of orders

	// welcomes user and offers choice between drink and lunch
	public void start() {
		if (count != 1) {
			System.out.println("Hello, what do you want to order?\n" + "1. drink\n" + "2. lunch\n");
		} else
			System.out.println("What is your next order?\n" + "1. drink\n" + "2. lunch\n");
		scanner = new Scanner(System.in);
		try {
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				this.orderDrink();
				count += 1;
				break;
			case 2:
				this.orderLunch();
				count += 1;
				break;
			default:
				System.out.println("Please choose option 1 or 2");
				this.start();
			}
		} catch (Exception e) {
			System.out.println("Please choose option 1 or 2");
			this.start();
		}
	}
	
	/*
	 * creates instance of Drink object,
	 * informs user about the cost of his order
	 * adds cost of drink to total cost of all orders
	 */
	private void orderDrink() {
		try {
			Drink drink = new Drink();
			drink.start();
			System.out.println("You chose: ");
			System.out.println(drink.getName() + " cost: " + drink.getPrice());
			totalCost += drink.getPrice();
		} catch (Exception e) {
			this.orderDrink();
		}
		askForOrder();
	}
	
	/*
	 * provides choice of cuisines
	 * informs about price of lunch
	 * adds cost of lunch to total cost of all orders
	 */
	private void orderLunch() {
		System.out.println("Please choose cuisine\n" + "1. Polish\n" + "2. Mexican\n" + "3. Italian\n");
		try {
			scanner = new Scanner(System.in);
			cuisineChoice = scanner.nextInt();
			if (cuisineChoice == 1 || cuisineChoice == 2 || cuisineChoice == 3) {
				Cuisine lunch = getCuisine(cuisineChoice);
				lunch.mainCourse();
				lunch.dessert();
				System.out.println("You chose: ");
				System.out.println(lunch.getName() + ", cost: " + lunch.getPrice());
				totalCost += lunch.getPrice();
			} else
				this.orderLunch();
		} catch (Exception e) {
			this.orderLunch();
		}
		askForOrder();
	}
	
	// creates object of couisine depending on user's choice
	public Cuisine getCuisine(int cuisineChoice) {

		switch (cuisineChoice) {
		case 1:
			System.out.println("You chose Polish cuisine");
			return new PolishCuisine();

		case 2:
			System.out.println("You chose Mexican cuisine");
			return new MexicanCuisine();

		case 3:
			System.out.println("You chose Italian cuisine");
			return new ItalianCuisine();

		default:
			System.out.println("You chose Polish cuisine");
			return new PolishCuisine();
		}
	}
	
	/*
	 *  asks for another order and enables program to finish
	 *  informs about total cost of orders
	 */
	public void askForOrder() {
		try {
			System.out.println("Do you want to place another order? (y/n)");
			String choice = scanner.next();
			if (choice.equals("y")||(choice.equals("Y"))) {
				this.start();
			} else if (choice.equals("n")||(choice.equals("N"))) {
				System.out.println("Total cost of your order is: " + totalCost + "\nThank you for visiting us!");
			} else
				this.askForOrder();
		} catch (Exception e) {
			System.out.println("Please choose option 1, 2 or 3\n");
			this.start();
		}
	}

}
