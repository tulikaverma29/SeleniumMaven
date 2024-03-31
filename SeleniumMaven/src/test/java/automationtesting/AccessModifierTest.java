package automationtesting;

import org.testng.annotations.Test;

public class AccessModifierTest {

		 @Test
		 public void publicdisplay() 
		    { 
		        System.out.println("public Class display"); 
		        AccessModifierTest obj =new AccessModifierTest();
		        obj.privatedisplay();
		        obj.defaultdisplay();
		        obj.protecteddisplay();
		    } 
		 
		  void defaultdisplay() 
		    { 
		        System.out.println("default Class display"); 
		    } 
		 
		 protected void protecteddisplay() 
		    { 
		        System.out.println("Protected Class display"); 
		    } 
		 
		 private void privatedisplay() 
		    { 
		        System.out.println("private Class display"); 
		    } 

}


