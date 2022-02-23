// You are free to add any attributes or methods you need.
public class FriesChef implements Runnable{
	private String name = "FriesChef";
	private int WAIT_TIME = 1000;
	private int MAKE_TIME = 2000;
	
	@Override
	public void run() {
		while(true) {
			// check kitchen table
			if(KitchenTable.fries < KitchenTable.limit) { // if room left for fries
				try{
					Thread.sleep(MAKE_TIME); // make fries
					KitchenTable.addFries(name); // put them on the kitchen table
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// check ready table
				if(ReadyTable.combos < ReadyTable.limit){ // if room left for combos
					// check kitchen table
					if(KitchenTable.burgers > 0) { // if there are burgers
						ReadyTable.makeCombo(name); // make a combo and put it on the ready table
					}
				}
			} else { // if there is no room left on the kitchen table
				// check ready table
				if(ReadyTable.combos < ReadyTable.limit) { // if room left for combos
					// check kitchen table
					if(KitchenTable.burgers > 0) { // if there are burgers
						ReadyTable.makeCombo(name); // make a combo and put it on the ready table
					} else { // if there are no burgers
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
