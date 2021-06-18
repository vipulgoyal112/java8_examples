package Threads;

class ProducerConsumer {
	
	int i;
	boolean flag = false;
	
	synchronized void setProducer(int i) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.i = i;
		System.out.println("Produced " + i);
		flag = true;
		notify();
	}
	
 	synchronized void getConsumer(int i) {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Consumed " + i);
		flag = false;
		notify();
	}
}

class MyThreadProducer implements Runnable{
	
	ProducerConsumer pc;
	
	public MyThreadProducer(ProducerConsumer pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			pc.setProducer(i);
		}
	}
}

class MyThreadConsumer implements Runnable{
	
	ProducerConsumer pc;
	
	public MyThreadConsumer(ProducerConsumer pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pc.getConsumer(i);
		}
	}
}

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();
		MyThreadProducer mtp = new MyThreadProducer(pc);
		MyThreadConsumer mtc = new MyThreadConsumer(pc);
		
		Thread t1 = new Thread(mtp);
		Thread t2 = new Thread(mtc);
		t1.start();
		t2.start();
	}

}
