package JavaTrainingPractice;

class Animals{
	void eat() {
		System.out.println("eating......");
	}
	
}

class Dog extends Animals {
	void bark() {
		System.out.println("Barking.......");
	}
}

class Cat extends Animals{
	void meow() {
		System.out.println("Meowing........");
		
	}
	
}

public class Inheritance_Hierarchical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cat c = new Cat();
		c.meow();
		c.eat();
		System.out.println("--------------------------------------------------");
		Dog d = new Dog();
		d.bark();
		d.eat();
	}

}
