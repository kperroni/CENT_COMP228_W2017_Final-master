package week12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		ExecutorService exService = Executors.newCachedThreadPool();
		
		//Creates blockingbuffer to store ints
		Buffer sharedLocation = new SynchronizedBuffer2();
		
		exService.execute(new Producer(sharedLocation));
		exService.execute(new Consumer(sharedLocation));
		
		exService.shutdown();
		exService.awaitTermination(1, TimeUnit.MINUTES);
	}

}
