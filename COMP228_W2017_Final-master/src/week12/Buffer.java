package week12;

public interface Buffer {
	//Place int value into buffer
	public void blockingPut(int value) throws InterruptedException;
	
	//Obtains an in value from buffer
	public int blockingGet() throws InterruptedException;
}