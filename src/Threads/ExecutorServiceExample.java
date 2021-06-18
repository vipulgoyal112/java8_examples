package Threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThreadProducer1 implements Runnable{
	
	@Override
	public void run() {
		System.out.println("print");
	}
}

public class ExecutorServiceExample {

	public static void main(String[] args) {
		ExecutorService exs = Executors.newFixedThreadPool(10);
		for (int i = 1; i <= 10; i++) {
			exs.execute(new MyThreadProducer1());
		}
		

	}

}
