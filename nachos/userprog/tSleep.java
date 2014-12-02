package nachos.userprog;

import nachos.threads.*;
import nachos.machine.*;

public class tSleep implements Runnable {
	KThread arg;

	public tSleep(KThread arg){
		this.arg = arg;
	}

	public void run() {
		arg.sleep();
	}
}