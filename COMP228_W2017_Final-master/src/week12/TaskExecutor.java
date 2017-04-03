package week12;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class TaskExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrintTask task1 = new PrintTask("Task 1");
		PrintTask task2 = new PrintTask("Task 2");
		PrintTask task3 = new PrintTask("Task 3");
		
		System.out.println("Starting executor");
		
		//Create executor service to manage threads
		ExecutorService exService = Executors.newCachedThreadPool();
		
		//Start the threads
		exService.execute(task1);
		exService.execute(task2);
		exService.execute(task3);
		
		exService.shutdown();
		System.out.printf("Tasks started, main ends%n");
	}

}
