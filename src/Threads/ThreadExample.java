package Threads;

class P {
	synchronized void print(int noc, String name) {
		for (int i = 1; i <= noc; i++) {
			System.out.println("print " + name + " " + i);
		}
	}
}

class A extends Thread {
	
	P p;
	
	A(P p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.print(10, "A");
	}
}

class B implements Runnable {
	
	P p;
	
	B(P p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.print(10, "B");
	}
}

public class ThreadExample {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("======== Main Thead start =======");
		
		P p = new P();
		p.print(10, "P");
		
		Thread myThread = new Thread(new B(p));
		myThread.start();
		//myThread.join();
		
		
		A a = new A(p);
		a.start();
		
		
		System.out.println("======== Main Thead end =======");
		
		
	}

}
