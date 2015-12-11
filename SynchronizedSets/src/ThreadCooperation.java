import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ThreadCooperation {

	private static MyHashSet set = new MyHashSet();

	public static void main(String[] args) {
		// Create a thread pool with two threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new UpdateTask());
		executor.execute(new ReadTask());
		executor.shutdown();
	}

	// A task for adding numbers to the set
	public static class UpdateTask implements Runnable {
		public void run() {
			try { // Purposely delay it to let the withdraw method proceed
				while (true) {
					set.add((int)(Math.random()*100));
					Thread.sleep(1000);
				}
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	// A task for reading the numbers in the set
	public static class ReadTask implements Runnable {
		public void run() {
			while (true) {
				set.read();
			}
		}
	}

	// An inner class for account
	private static class MyHashSet extends HashSet<Integer> {
		// Create a new lock
		private static Lock lock = new ReentrantLock();

		// Create a condition
		private static Condition isReading = lock.newCondition();

		public void add(int e) {
			lock.lock(); // Acquire the lock
			try {
				//System.out.println("Now Adding");
				super.add(e);
				//System.out.println("Waiting on Read");
				// Signal thread waiting on the condition
				isReading.signalAll();
			}
			finally {
				lock.unlock(); // Release the lock
			}
		}

		public void read() {
			lock.lock(); // Acquire the lock
			try {
				//System.out.println("Now Reading");
				Iterator<Integer> itr = super.iterator();
				while (itr.hasNext()) {
					System.out.print(itr.next() + " ");
				}
				System.out.println();
				//System.out.println("Finished Reading");
				isReading.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				lock.unlock(); // Release the lock
			}
		}
	}
}
