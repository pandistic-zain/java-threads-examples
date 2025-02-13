package threads.example2;

/*
 * Instantiate a thread by using Runnable interface
 */

public class InstantiateUsingRunnable {
	
	public static void main(String[] args) {
		
		System.out.println("Thread main started");
		
		Thread thread1 = new Thread(new MyTask("any data that the thread may need to process"));	
		Thread thread2 = new Thread(new MyTask("any data that the thread may need to process"));	
		thread1.start();
		thread2.start();
		
	
	}
}

class MyTask implements Runnable {
	private String anyData;
	
	public MyTask(String anyData) {
		this.anyData = anyData;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("[" + Thread.currentThread().getName() + "] [data=" + this.anyData + "] Message " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			System.out.println("Thread main finished For " + Thread.currentThread().getName());
	}
}
