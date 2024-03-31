package JavaTrainingPractice;

import org.testng.annotations.Test;

public class Static_nonStatic_Methods {
@Test
	public void NonStaticMethod()
	{
		System.out.println("This is part of non static method");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is part of static method");
		//To access nonstatic, we have to make object of the class 
		Static_nonStatic_Methods obj = new Static_nonStatic_Methods();
		obj.NonStaticMethod();
	}

}
