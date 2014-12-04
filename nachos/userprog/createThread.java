package nachos.userprog;


import java.lang.Object;
import java.util.Vector;
import java.lang.String;

public class createThread implements Runnable {

	public createThread(){
				
	};
	
	public createThread(String nameParam){
		
		this.threadName = nameParam;
		this.threadID = IDnum;
		++IDnum;
		
	}
	
	
	public void start() {
		
		System.out.println("The name of this thread is " + this.threadName + '\n');
		System.out.println("The ID of this thread is " + this.threadName + '\n');
		
	}
	
	public void run() {
		System.out.println(this.threadName + " is currently running.");
		this.idle = false;
		
		//place holder for program
	}
	
    private String threadName = "Unnamed";
    private int threadID = IDnum;
    private static int IDnum = 0;
    private boolean idle = true;
    
}
