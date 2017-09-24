package foodOrderingSystem;

public class App {

	public static void main(String[] args) {	
		App app = new App();
		app.start();
	}
	
	// creates instance of users menu
	private void start(){
		Menu menu = new Menu();
		menu.start();
	}
}