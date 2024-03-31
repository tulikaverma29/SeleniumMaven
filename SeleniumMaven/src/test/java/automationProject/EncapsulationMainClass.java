package automationProject;

 class EncapsulationTestClass {
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name){
		this.name =name;
	}
	public void setAge(int age){
		this.age =age;
	}
}
public class EncapsulationMainClass{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EncapsulationTestClass obj = new EncapsulationTestClass();
		obj.setName("Tulika");
		obj.setAge(40);
		System.out.println("My name is ="+ obj.getName() );
		System.out.println("My name is ="+ obj.getAge() );
	}	
}