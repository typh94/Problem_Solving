import java.util.*;		
public class TestSummary
{
	public static void main(String [] args)
	{
//---------------------------------- Problem 1 Starts Below-------------------------------
		//-------------Variables----------------------------------------------------------
		
		final int  	 		A_CUTOFF 	= 90,
         					B_CUTOFF 	= 80,
       						C_CUTOFF 	= 70,
       						D_CUTOFF 	= 60,
       				 		F_CUTOFF 	= 0 ;
       				 						
		int 				testScore1 	= 0,
							testScore2 	= 0,
							testScore3 	= 0,
							testAvg    	= 0,
							hiTest		= 0,
							loTest		= 0;
						
		final   String   	TEST1		= "Test-1, ",
							TEST2		= "Test-2, ",
							TEST3		= "Test-3, ";
						
		String 				hiMsg 	  	= "",
					 		loMsg    	= "",		
							name 		= "",
							testGrade	= "",
							gradeLttr   = "";
						
		boolean 			earnedPts	= false;
		
		Scanner 			keyboard    = new Scanner(System.in);
	
		//----- Welcome msg --------------------------------------------------------------
		System.out.println("Welcome to Grader ");
		
		//----- I/P ----------------------------------------------------------------------
		
		System.out.print("Enter your name: ");
			name 	       = keyboard.next() ;
			
		System.out.println(name + " enter your scores for");
		System.out.print("\t Test-1: ");
			testScore1 	   = keyboard.nextInt();
		System.out.print("\t Test-2: ");
			testScore2 	   = keyboard.nextInt();
		System.out.print("\t Test-3: ");
			testScore3	   = keyboard.nextInt();

		//------ Calculations ------------------------------------------------------------
		testAvg = (testScore1 + testScore2 + testScore3)/3;
		
//------ Conditions ----------------------------------------------------------------------
	
		if      (testAvg >= A_CUTOFF) 
	    {	
	    	earnedPts = true;
            gradeLttr = "A" ;
        }
        else if (testAvg >= B_CUTOFF) 
	    {	
	    	earnedPts = true;
            gradeLttr = "B" ;
        } 
        else if (testAvg >= C_CUTOFF) 
        {
        	earnedPts = false;
            gradeLttr = "C"  ;
        } 
        else if (testAvg >= D_CUTOFF) 
        {
        	earnedPts = false;
            gradeLttr = "D"  ;
        } 
        else 
        {
        	earnedPts = false;
            gradeLttr = "F"  ;
        }
		//----- Priming & Finding High Score ---------------------------------------------
		
		hiTest 	   = testScore1;
		hiMsg  	   = TEST1;

		if (testScore2 >hiTest)
		{
			hiTest = testScore2;
			hiMsg  = TEST2;
		}
		if (testScore3> hiTest)
		{
			hiTest = testScore3;
			hiMsg  = TEST3 ;
		}
		//----- Priming & Finding Low Score ----------------------------------------------
		
		loTest 	   = testScore1;
		loMsg      = TEST1;

		if (testScore2 < loTest)
		{
			loTest = testScore2;
			loMsg  = TEST2;
		}
		
		if (testScore3 < loTest)
		{
			loTest = testScore3;
			loMsg  = TEST3;
		}
		//----- O/P-----------------------------------------------------------------------
		
		System.out.println("\n  - - - - -"     + name + "'s Test Summary - - - - ");
		System.out.println("\t Test Average:		" + testAvg)  ;
		System.out.println("\t Grade (for avg):	"     + gradeLttr);
		System.out.println("\t Low test was:		" + loMsg + loTest);
		System.out.println("\t High test was:		" + hiMsg + hiTest);
		
		//----- Determine if reward ------------------------------------------------------
		
		if(earnedPts)
			System.out.println("Points were earned toward High Success Reward");
	
		//-----End msg -------------------------------------------------------------------
		System.out.println("\nThanks for using converter!\n ");
    }
}// end pgm