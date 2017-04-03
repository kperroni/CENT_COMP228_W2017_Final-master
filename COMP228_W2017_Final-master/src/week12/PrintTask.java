package week12;

import java.security.SecureRandom;

public class PrintTask implements Runnable{

	private final static SecureRandom generator = new SecureRandom();
	private final int sleepTime; //Random sleep time for a thread
	private final String taskName; //Name of the task being executed
	
	public PrintTask(String taskName){
		this.taskName = taskName;
		
		sleepTime = generator.nextInt(5000); //Set sleep time to a number between 0 and 5000ms
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			System.out.printf("%s going to sleep for %d millisecond.%n", taskName, sleepTime);
			Thread.sleep(sleepTime);
		}catch(InterruptedException e){
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
		System.out.printf("%s done sleeping%n", taskName);
	}

}
