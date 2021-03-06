package exercise_2;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NumberGenerator implements Runnable {
	Number num;
	NumberGenerator ng1,ng2,ng3,ng4,ng5;
	int sum;
	ArrayList<Number> n ;

	public NumberGenerator(Number num) {
		this.num = num;

	}

	public NumberGenerator() {

	}

	@Override
	public void run() {
		num.generateNumber();
		System.out.println("Random num generated by " + Thread.currentThread().getName() + " is: " + num.getX());

	}
	public  void  task1() throws InterruptedException {
		System.out.println("-----Task 1-----");
				ng1=new NumberGenerator(new Number());
				ng2=new NumberGenerator(new Number());
				ng3=new NumberGenerator(new Number());
				ng4=new NumberGenerator(new Number());
				ng5=new NumberGenerator(new Number());
				Thread t1=new Thread(ng1);
				Thread t2=new Thread(ng2);
				Thread t3=new Thread(ng3);
				Thread t4=new Thread(ng4);
				Thread t5=new Thread(ng5);
				t1.start();
				t1.join();
				t2.start();
				t2.join();
				t3.start();
				t3.join();
				t4.start();
				t4.join();
				t5.start();
				t5.join();
				sum = 0;
				
				sum=ng1.num.getX()+ng2.num.getX()+ng3.num.getX()+ng4.num.getX()+ng5.num.getX();
				System.out.println("Sum is=" + sum+"\n");
	}
	public void task2() throws InterruptedException {
		System.out.println("-----Task 2-----");
		n=new ArrayList<Number>();
		n.add(new Number());
		n.add(new Number());
		n.add(new Number());
		n.add(new Number());
		n.add(new Number());
		ng1 = new NumberGenerator(n.get(0));
		ng2 = new NumberGenerator(n.get(1));
		ng3 = new NumberGenerator(n.get(2));
		ng4 = new NumberGenerator(n.get(3));
		ng5 = new NumberGenerator(n.get(4));
		Thread t1=new Thread(ng1);
		Thread t2=new Thread(ng2);
		Thread t3=new Thread(ng3);
		Thread t4=new Thread(ng4);
		Thread t5=new Thread(ng5);
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		t4.start();
		t4.join();
		t5.start();
		t5.join();
		
	print();
	}
	public void task3() throws InterruptedException {
		System.out.println("-----Task 3-----");
		n  = new ArrayList<Number>();
		n.add(new Number());
		n.add(new Number());
		n.add(new Number());
		n.add(new Number());
		n.add(new Number());
		ng1 = new NumberGenerator(n.get(0));
		ng2 = new NumberGenerator(n.get(1));
		ng3 = new NumberGenerator(n.get(2));
		ng4 = new NumberGenerator(n.get(3));
		ng5 = new NumberGenerator(n.get(4));
	
		ExecutorService pool = Executors.newFixedThreadPool(5);
		pool.execute(ng1);
		pool.execute(ng2);
		pool.execute(ng3);
		pool.execute(ng4);
		pool.execute(ng5);
		pool.shutdown();
		pool.awaitTermination(10, TimeUnit.SECONDS);
		print();
		
	}
	public void print() {
		sum=0;
		for (int i = 0; i < n.size(); i++) {
			sum += n.get(i).getX();
		}

		System.out.println("Sum is=" + sum+"\n");
	
	
	}
	
	public static void main(String[] args) throws InterruptedException {
		NumberGenerator ng =new NumberGenerator();
		ng.task1();
		ng.task2();
		ng.task3();
	}
}
