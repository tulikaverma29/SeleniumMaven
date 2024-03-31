package JavaTrainingPractice;


class animal {

	void carnivorous() {
		System.out.println("I eat meat and flesh......");
	}
	 void omnivores() {
		 System.out.println("I eat plants and animals........");
	 }
	
	 void herbivores() {
		 System.out.println("I eat only plants.........");
	 }
}
 class carnivorous extends animal {
	 void Lion() {
		 System.out.println("King of the jungle.....");
	 }
 }
 
 class cub extends carnivorous{
	 void Lion_Cub() {
		 System.out.println("I am a baby......");
		 
	 }
	 
 }

 //When there is a chain of inheritance, it is known as multilevel inheritance. 
 //As you can see in the example here, 
 //cub class inherits the carnivorous class which again inherits the animal class, 
 //so there is a multilevel inheritance.
public class Inheritance_Multilevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cub cu = new cub();
		cu.Lion_Cub();
		cu.Lion();
		cu.carnivorous();
		
	}

}
