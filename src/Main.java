//Here is the driver class
public class Main {

	public static void main(String[] args) {
		Thread burgerChef = new Thread(new BurgerChef(), "Burger Chef");
		Thread friesChef = new Thread(new FriesChef(), "Fries Chef");
		Thread waitress = new Thread(new Waitress(), "Waitress");
		burgerChef.start();
		friesChef.start();
		waitress.start();
	}

}