// You are free to add any attributes or methods you need.
public class BurgerChef implements Runnable {
	private String name = "BurgerChef";
	private int WAIT_TIME = 1000; // Tread.sleep()
	private int MAKE_TIME = 3000; //

	@Override
	public void run() {
		while(true) {
			// check kitchen table
			if(KitchenTable.burgers < KitchenTable.limit) { // if room left for burgers
				try{
					Thread.sleep(MAKE_TIME); // make a burger
					KitchenTable.addBurger(name); // put it on the kitchen table
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// check ready table
				if(ReadyTable.combos < ReadyTable.limit){ // if room left for combos
					// check kitchen table
					if(KitchenTable.fries > 0) { // if there are fries
						ReadyTable.makeCombo(name); // make a combo and put it on the ready table
					}
				}
			} else { // if there is no room left on the kitchen table
				// check ready table
				if(ReadyTable.combos < ReadyTable.limit) { // if room left
					// check kitchen table
					if(KitchenTable.fries > 0) { // if there are fries
						ReadyTable.makeCombo(name); // make a combo and put it on the ready table
					} else { // if there are no fries
						try{
							Thread.sleep(WAIT_TIME); // wait
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else { // if there is no room on the ready table
					try{
						Thread.sleep(WAIT_TIME); // wait
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
