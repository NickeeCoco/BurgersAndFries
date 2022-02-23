// You are free to add any attributes or methods you need.
public class Waitress implements Runnable{
	private String name = "Waitress";
	private int WAIT_TIME = 1000;
	private int SERVE_TIME = 10000; // 10 second

	@Override
	public void run() {
		while(true) {
			// check ready table
			if(ReadyTable.combos > 0) { // if there are combos ready
				try {
					ReadyTable.serveCombo(name); // take combo from the table
					Thread.sleep(SERVE_TIME); // serve combo
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else { // if there are no combos ready
				try {
					Thread.sleep(WAIT_TIME); // wait
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
