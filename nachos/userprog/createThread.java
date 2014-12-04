package nachos.userprog;


import java.lang.Object;
import java.util.Vector;
import java.lang.String;

public class createThread implements Runnable {

	public createThread(){
		
		Thread t = new Thread();
		
	};
	
	public createThread(String threadName){
		
		
		
	}
	
	
	public void start() {
		
	}
	
	public void run() {
		System.out.println("The name of this thread is " + this.threadName);
		
		//place holder for program
	}
	
    private String threadName = "Unnamed";
    private int threadID = IDnum++;
    private static int IDnum = 0;

}
