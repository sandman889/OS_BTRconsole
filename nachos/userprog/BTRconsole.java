package nachos.userprog;

import nachos.threads.*;
import nachos.machine.*;

public class BTRconsole implements Runnable {
	public void run() {
		this.kernel = (UserKernel) Kernel.kernel;
		running = true;
		System.out.println("\n ----====Running Shell====---- ");

		while(running) {
			getCommands();
		}
		kernel.terminate();
	}

	public BTRconsole() {
		super();
	}

	public void getCommands() {
		System.out.print("BTR=-> ");

		String cmd = kernel.getLine();
		cmd.trim();
		runCommand(cmd);	
	}

	public void runCommand(String cmd) {
		if(cmd.equals("exit")) {
			System.out.println("Exiting nachOS");
			running = false;
		}
		else if (cmd.equals("help")) {
			System.out.println("\n====Available Commands==== \n" + 
								"tCreate <name> : creates a thread with specified name \n" +
								"tRun <name> : runs a thread with specified name \n" +
								"tSleep <name> : sleeps the specified thread \n" +
								"tJoin <name> : joins the specified thread\n" +
								"tSpawn <name> : spawns specified thread \n" +
								"tAbort <name> : aborts the specified thread\n");
		}
		else if (cmd.equals("tCreate")) {
			//ribin ish
		}
		else if (cmd.equals("tRun")) {
			//ribin ish
		}
		else if (cmd.equals("tSleep")) {
			//tilir ish
		}
		else if (cmd.equals("tJoin")) {
			//tilir ish
		}
		else if (cmd.equals("tSpawn")) {
			//barn ish
		}
		else if (cmd.equals("tAbort")) {
			//barn ish 
		}
		else {
			System.out.println(cmd + " is not a recognized command");			
		}
	}

	private boolean running;
	//List<KThread> threadPool = new KThread();
	public UserKernel kernel = null;
}
