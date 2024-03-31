package automationProject;

public class Method_Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method_Overloading mo = new Method_Overloading();
		System.out.println(mo.Multiple(10, 20)); 
		System.out.println(mo.Multiple(6.8, 4.6));
	}

	 int Multiple (int a, int b) {
		return a*b; 
	}

	 double Multiple (double a, double b) {
		return a*b;
		
	}
}
