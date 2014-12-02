package nachos.userprog;

import nachos.threads.*;
import nachos.machine.*;
import java.util.Scanner;

public class BTRconsole implements Runnable {
	public void run() {
		this.kernel = (UserKernel) Kernel.kernel;

		System.out.println("\n ----====Running Shell====---- ");

		while(running) {
			getCommands();
		}
	}

	public BTRconsole() {
		super();
	}

	public void getCommands() {
		System.out.print("BTR=-> ");
		
		Scanner in = new Scanner(System.in);
		String cmd = in.nextLine();
		runCommand(cmd);		
	}

	public void runCommand(String cmd) {
		if(cmd == "exit")
			running = false;
		else if (cmd == "help") {
			//help stuff
		}
		else if (cmd == "tCreate") {
			//ribin ish
		}
		else if (cmd == "tRun") {
			//ribin ish
		}
		else if (cmd == "tSleep") {
			//tilir ish
		}
		else if (cmd == "tJoin") {
			//tilir ish
		}
		else if (cmd == "tSpawn") {
			//barn ish
		}
		else if (cmd == "tAbort") {
			//barn ish 
		}
		else {
			System.out.println(cmd + " is not a recognized command");			
		}
	}

	private boolean running = true;
	//List<KThread> threadPool = new KThread();
	public UserKernel kernel = null;
}
