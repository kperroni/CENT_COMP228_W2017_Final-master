package week12;

import javax.swing.SwingWorker;
import javax.swing.JLabel;
import java.util.concurrent.ExecutionException;

public class BackgroundCalculator extends SwingWorker<Long, Object>{

	private final int n; //Fibonacci number to calculate
	private final JLabel resultLabel; //Displays result
	
	public BackgroundCalculator(int n, JLabel resultJLabel){
		this.n = n;
		this.resultLabel = resultJLabel;
	}
	
	@Override
	protected Long doInBackground() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Recursive method
	public long fibonacci(long number){
		if(number == 0 || number == 1){
			return number;
		}
		else{
			return fibonacci(number - 1) + fibonacci(number -2);
		}
	}

}
