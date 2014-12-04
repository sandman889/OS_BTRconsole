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
	
	public void parseCommands(String line){
		String param[] = line.split("\\s+");
		cmd = param[0];
		if (param.length > 1){
			name = param[1].replace("<", "");
			name = name.replace(">", "");
		}
		if (param.length > 2){
			file = param[2].replace("<", "");
			file = file.replace(">", "");
		}
	}
	
	public void getCommands() {
		System.out.print("BTR=-> ");
		String line = kernel.getLine();
		line.trim();
		parseCommands(line);
		runCommand(cmd, name, file);	
	}

	public void runCommand(String cmd, String name, String file) {
		if(cmd.equals("exit")) {
			System.out.println("Exiting nachOS");
			running = false;
		}
		else if (cmd.equals("help")) {
			System.out.println("\n====Available Commands==== \n" + 
								"tCreate <name> : creates a thread with specified name \n" +
								"tRun <name>: runs a thread with specified name \n" +
								"tSleep <name> : sleeps the specified thread \n" +
								"tJoin <name> : joins the specified thread\n" +
								"tSpawn <name> : spawns specified thread \n" +
								"tAbort <name> : aborts the specified thread\n");
		}	
		else if (cmd.equals("tCreate")) {
			createThread custom = new createThread(name);
			Thread t = new Thread(custom);
			t.start();
		}
		else if (cmd.equals("tRun")) {
			//ribin ish
		}
		else if (cmd.equals("tSleep")) {
		//	name.sleep();
			System.out.println(name + " is sleeping. Zzzzz. \n");
		}
		else if (cmd.equals("tJoin")) {
		//	name.join();
			System.out.println(name + " has been joined successfully. \n");
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
	public UserKernel kernel;
	public String cmd;
	public String name;
	public String file;
}
