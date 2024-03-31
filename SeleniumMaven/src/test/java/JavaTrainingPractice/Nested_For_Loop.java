package JavaTrainingPractice;

public class Nested_For_Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Nested For Loop
//		for(int i=1;i<=3;i++) {
//			
//			for (int j=1;j<=3;j++) {
//				System.out.println(i+" " + j);
//			}
//			
//		}
		//Nester For Loop ended
		int row=7;
		for(int i=0; i<row; i++)   
		{   
		for(int j=0; j<=i; j++)   
		{   
		System.out.print("* ");   
		}   
		System.out.println();   
		}
		
	}
	
	

}
