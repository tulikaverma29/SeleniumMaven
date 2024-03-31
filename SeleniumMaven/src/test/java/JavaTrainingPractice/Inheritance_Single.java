package JavaTrainingPractice;

  class Vehicle {
	 
	 void honk() {
		 System.out.println("Vroom Vroom......."); 
	 }	
}
//When a class inherits another class, it is known as a single inheritance.
 class Inheritance_Single  extends Vehicle {

	public static void main(String[] args) {
		Inheritance_Single obj = new Inheritance_Single();
				obj.honk();
	}

}
