//A work table which for chefs to place Burgers or Fries.
//You need to handle race condition here.
public class KitchenTable {
	public static int limit = 5;
	public static int burgers = 0;
	public static int fries = 0;

	public synchronized static void addBurger(String name) {
		burgers = burgers + 1;
		System.out.println("[Action] " + name + " adds a burger on the kitchen table");
		System.out.println("[Status] Burgers left: " + burgers);
	}

	public synchronized static void removeBurger() {
		burgers = burgers - 1;
	}

	public synchronized static void addFries(String name) {
		fries = fries + 1;
		System.out.println("[Action] " + name + " adds fries on the kitchen table");
		System.out.println("[Status] Fries left: " + fries);
	}

	public synchronized static void removeFries() {
		fries = fries - 1;
	}
}
