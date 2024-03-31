package JavaTrainingPractice;


public class Synchronization extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Synchronization thread1 = new Synchronization(); 
		thread1.start(); 
		System.out.println("This is running outside of Thread");
	}
	
	public void run() {
		System.out.println("This is running in a Thread");
	}

}
