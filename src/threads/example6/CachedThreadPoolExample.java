package threads.example6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CachedThreadPoolExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("Thread main started");

        // Using a custom thread factory
        ThreadFactory threadFactory = new MyThreadFactory();
        ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);

        executorService.execute(new MyTask());
        executorService.execute(new MyTask());
        executorService.execute(new MyTask());
        executorService.execute(new MyTask());
        executorService.execute(new MyTask());

        executorService.shutdown();

		while(!executorService.isTerminated())
		{
			
		}
		
			System.out.println("Thread main finished");

    }
}

class MyTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] " + "Message " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
}

// Custom thread factory class
class MyThreadFactory implements ThreadFactory {
    private static int count = 1;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, "Thread-" + count++);
        return thread;
    }
}
