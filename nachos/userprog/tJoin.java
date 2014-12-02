package nachos.userprog;

import nachos.threads.*;
import nachos.machine.*;

public class tJoin implements Runnable {
	KThread arg; 

	public tJoin(Kthread arg) {
		this.arg = arg;
	}

	public void run() {
		arg.join();
	}
}