package oracle;

import java.io.IOException;

class Sub {
	
	
	 void show() 
	 { System.out.println("parent"); }
	}

	public class Super extends Sub 
	{
	  void show() 		
	  { System.out.println("child"); } 

	  public static void main( String[] args )
	  {
	   // Super s = new Super();
	    //s.show();
	    String st="welcome to java string";
	   System.out.println( st.substring(7));
	    
	  }  
	}


