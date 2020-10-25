package exercise_1;

public class SimpleThread implements Runnable{

	Resource resource;
	
	public void run() {
		for(int i = 0; i<10; i++){
			try {
			System.out.println(resource.increment());
			
			Thread.sleep(1);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	SimpleThread(Resource resource){
		this.resource = resource;
	}

	public static void main(String args[]) throws InterruptedException {
		Resource resource = new Resource();
		Thread t = new Thread(new SimpleThread(resource));
		Thread s = new Thread(new SimpleThread(resource));
		Thread t1 = new Thread(new SimpleThread(resource));
		Thread s1 = new Thread(new SimpleThread(resource));
		Thread t2 = new Thread(new SimpleThread(resource));
		Thread s2 = new Thread(new SimpleThread(resource));
		
		
		
		
		
		t.start();
		t.join();
		s.start();
		s.join();
		t1.start();
		t1.join();
		s1.start();
		s1.join();
		t2.start();
		t2.join();
		s2.start();	

		s2.join();
	}

}
