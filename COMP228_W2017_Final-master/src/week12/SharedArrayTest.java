package week12;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public class SharedArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleArray sharedSimpleArray = new SimpleArray(6);
		
		ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
		ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);
		
		ExecutorService exService = Executors.newCachedThreadPool();
		exService.execute(writer1);
		exService.execute(writer2);
		
		exService.shutdown();
		
		try{
			//Waits 1 minute for threads to finish executing. If not, terminate them
			boolean tasksEnded = exService.awaitTermination(1, TimeUnit.MINUTES);
			
			//If threads are done, print contents of the shared array
			if(tasksEnded){
				System.out.printf("%nContents of Simple Array:%n");
				System.out.println(sharedSimpleArray);
			}
			else{
				System.out.println("Timed out while waiting for tasks to finish");
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
