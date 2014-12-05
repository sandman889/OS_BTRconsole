package nachos.userprog;

import nachos.threads.*;
import nachos.machine.*;

import java.util.ArrayList;

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
	
	//Uses the group built getLine() function of the nachOS kernel to 
	//get input from the console to run as commands. Trims all the whitespace out
	//then parses the command string out and runs the necessary code
	public void getCommands() {
		System.out.print("BTR=-> ");
		String line = kernel.getLine();
		line.trim();
		parseCommands(line);
		runCommand(cmd, name, file);	
	}

	//parses the command string input by spaces
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

	//Runs the commands using simple if else statements to 
	//run the proper command and show it working properly
	public void runCommand(String cmd, String name, String file) {

		if(cmd.equals("exit")) {
			System.out.println("Exiting nachOS");
			running = false;
		}

		else if (cmd.equals("help")) {
			System.out.println("\n====Available Commands==== \n" + 
								"tCreate <name> : creates a thread with specified name \n" +
								"tRun <name>: runs a thread with specified name \n" +
								"tSleep <name> <time>: sleeps the specified thread \n" +
								"tJoin <name> : joins the specified thread\n" +
								"tSpawn: spawns specified thread \n" +
								"tAbort <name> : aborts the specified thread\n" +
								"tList : lists all of the threads in the pool\n");
		}	

		else if (cmd.equals("tCreate")) {
			KThread temp = new KThread();
			temp.setName(name);
			threadPool.add(temp);

			if (threadPool.contains(temp))
				System.out.println(temp + " created successfully");
			else
				System.out.println("could not create thread...");
		}

		else if (cmd.equals("tRun")) {
			//ribin ish
		}

		else if (cmd.equals("tSleep")) {

			for(KThread t : threadPool)
				if((t.getName()).equals(name)) {
					System.out.println(name + " is sleeping for " + 100 + " cycles. Zzzzz.");
					t.sleepTime(100);
				}
				else 
					System.out.println(name + " not found, cannot sleep");
		}
		
		else if (cmd.equals("tJoin")) {
			for(KThread t : threadPool){
				if((t.getName()).equals(name)) 
					t.join();
				
			}
			System.out.println(name + " has been joined successfully. \n");
		}

		else if (cmd.equals("tSpawn")) {
			KThread temp = new KThread();
			threadPool.add(temp);
			System.out.println("Default thread has been spawned, named '" + temp.getName() + "'" + '\n');

		}

		else if (cmd.equals("tAbort")) {
			//barn ish 
		}

		else if (cmd.equals("tList"))
			System.out.println(threadPool);

		else {
			System.out.println(cmd + " is not a recognized command");			
		}
	}

	private boolean running;
	private UserKernel kernel;
	private String cmd;
	private String name;
	private String file;
	private ArrayList<KThread> threadPool = new ArrayList();
}