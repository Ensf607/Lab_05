package exercise_2;

import java.util.ArrayList;
import java.util.Random;

public class Number {
private int x;
public synchronized void generateNumber() {
	Random r = new Random();
	x=r.nextInt(100);//task 1
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
@Override
public String toString() {
	return "Number [x=" + x + "]";
}


}
