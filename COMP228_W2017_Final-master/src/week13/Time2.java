package week13;

public class Time2 {

	private int hour, minute, second;
	
	public Time2(){
		this(0, 0, 0);
	}

	public Time2(int h){
		this(h, 0, 0);
	}
	
	public Time2(int h, int m){
		this(h, m, 0);
	}
	
	public Time2(int h, int m, int s){
		setTime(h, m, s);	
	}
	
	//Actual implementation
	public void setTime(int h, int m, int s){
		setHour(h);
		setMinute(m);
		setSecond(s);
	}
	
	public String toUniversalString(){
		return String.format("%02d:%02:%02d", getHour(), getMinute(), getSecond());
	}
	
	public String toString(){
		return String.format("%d:%02d:%02d %s", (getHour() == 0 || getHour() == 12 ? 12 : getHour() % 12),
				getMinute(),
				getSecond(), 
				getHour() < 12 ? "AM" : "PM");
	}
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {	
		if(hour >= 0 && hour < 24){
			this.hour = hour;
		}else {
			throw new IllegalArgumentException("Hour must be between 0 - 23");
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {	
		if(minute >= 0 && minute < 60){
			this.minute = minute;
		}else {
			throw new IllegalArgumentException("Minute must be between 0 - 59");
		}
	}

	public int getSecond() {
		return second;
	}
	
	public void setSecond(int second) {		
		if(second >= 0 && second < 60){
			this.second = second;
		}else {
			throw new IllegalArgumentException("Second must be between 0 - 59");
		}		
	}

}
