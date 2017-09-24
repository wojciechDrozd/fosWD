package foodOrderingSystem;

public class App {

	public static void main(String[] args) {	
		App app = new App();
		app.start();
	}
	
	private void start(){
		Menu menu = new Menu();
		menu.start();
	}
}