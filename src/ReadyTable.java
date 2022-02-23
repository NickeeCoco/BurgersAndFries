import javax.sound.midi.Soundbank;

//A table which the meals are put as soon as they become ready
//You need to handle race condition here.
public class ReadyTable {
	public static int limit = 3;
	public static int combos = 0;

	public synchronized static void makeCombo(String name) {
		KitchenTable.removeBurger();
		KitchenTable.removeFries();
		combos = combos + 1;
		System.out.println("[Action] " + name + " makes Burger and Fries and places it on the ready table");
		System.out.println("[Status] Burgers left: " + KitchenTable.burgers + ", fries left: " + KitchenTable.fries + ", meals left: " + combos);
		System.out.println("===================================================================================");
	}

	public synchronized static void serveCombo(String name) {
		combos = combos - 1;
		System.out.println("[Action] " + name + " serve a meal");
		System.out.println("[Status] Meals left: " + combos);
		System.out.println("-----------------------------------------------------------------------------------");
	}
}
