package automationProject;

abstract  class AbstractClass {

	abstract void method1();
	abstract void method2();
	
	public void method3() {
		System.out.println("Print method3");
		
	}
}

abstract  class AbstractClass2 extends AbstractClass {

	void method1() {
		System.out.println("Print method1");
	}
}

 public class AbstractClassImplementation extends AbstractClass2 {
	
	 void method2() {
		System.out.println("Print method2");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractClassImplementation obj = new AbstractClassImplementation();
		obj.method1();	
		obj.method2();
		obj.method3();
	}
}