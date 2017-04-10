package week12;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer{

	private final ArrayBlockingQueue<Integer> buffer;
	
	public BlockingBuffer() {
		// TODO Auto-generated constructor stub
		buffer = new ArrayBlockingQueue<Integer>(1);
	}
	
	@Override
	public void blockingPut(int value) throws InterruptedException {
		// TODO Auto-generated method stub
		buffer.put(value); //Place "value" into "buffer"
		System.out.printf("%s%2d\t%s%d%n", "Producer Writes ", value, "Buffer cells occupied", buffer.size());
	}

	@Override
	public int blockingGet() throws InterruptedException {
		// TODO Auto-generated method stub
		int readValue = buffer.take(); //Remove value from 
		System.out.printf("%s %2d\t%s%d%n", "Consumer Reads ", readValue, "Buffer cells occupied", buffer.size());
		return readValue;
	}

}
