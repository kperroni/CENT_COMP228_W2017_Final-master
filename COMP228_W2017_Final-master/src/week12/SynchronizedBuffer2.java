package week12;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class SynchronizedBuffer2 implements Buffer{

	//Used to control synchronization with the buffer
	private final Lock accessLock = new ReentrantLock();
	
	//Conditions to control reading and writing
	private final Condition canWrite = accessLock.newCondition();
	private final Condition canRead = accessLock.newCondition();
	
	private int buffer = -1;
	private boolean occupied = false;
	
	@Override
	public void blockingPut(int value) throws InterruptedException {
		// TODO Auto-generated method stub
		accessLock.lock(); //Unless you have the key, you are locked OUT!
		
		try{
			while(occupied){
				System.out.println("Producer tries to write");
				displayState("Buffer full. Producer waits");
				canWrite.await();
			}
			
			buffer = value;
			occupied = true;
			displayState("Producer writes "+buffer);
			canRead.signalAll();
		}finally{
			accessLock.unlock(); //Unlock this object
		}
	}

	@Override
	public int blockingGet() throws InterruptedException {
		// TODO Auto-generated method stub
		int readValue = 0;
		accessLock.lock();
		
		try{
			while(!occupied){
				System.out.println("Consumer tries to read");
				displayState("Buffer empty. Consumer waits");
				canRead.await();
			}
			
			occupied = false;
			
			readValue = buffer;
			displayState("Consumer reads "+readValue);
			
			canWrite.signalAll();
		}
		finally{
			accessLock.unlock();
		}
		return readValue;
	}
	
	private synchronized void displayState(String operation){
		
		try{
			accessLock.lock();
			System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
		}
		finally{
			accessLock.unlock();
		}
		
		
	}

}
