package week12;

public class SynchronizedBuffer implements Buffer{

	private int buffer = -1;
	private boolean occupied = false; //Traffic light
	
	@Override
	public synchronized void blockingPut(int value) throws InterruptedException {
		// TODO Auto-generated method stub
		//Buffer is full. Producer must wait
		while(occupied){
			System.out.println("Producer tries to write"); //Demo purposes only
			displayState("Buffer full. Producer waits."); //Demo purposes only
			wait();
		}
		
		//Places value into buffer
		buffer = value;
		occupied = true;
		displayState("Producer writes "+buffer);
		notifyAll();
	}

	@Override
	public synchronized int blockingGet() throws InterruptedException {
		// TODO Auto-generated method stub
		while(!occupied){
			System.out.println("Consumer tries to read"); //Demo purposes only
			displayState("Buffer empty. Consumer waits."); //Demo purposes only
			wait();
		}
		
		//Something in our buffer
		occupied = false;
		displayState("Consumer reads "+buffer);
		notifyAll();
		return buffer;
	}
	
	private synchronized void displayState(String operation){
		System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
	}

}
