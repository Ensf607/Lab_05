package exercise_1;

public class Resource {

	int counter;
	
	public synchronized int increment() {
		return counter++;
	}
	
}
