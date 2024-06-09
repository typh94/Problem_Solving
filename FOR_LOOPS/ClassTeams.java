import java.util.*;
import java.text.*;
public class ClassTeamsVfinal
{
	public static void main(String [] args)
	{
		//-------------Variables----------------------------------------------------------

		int 			numSnr			= 0,
						numJnr			= 0,
						numSphmr		= 0,
						totCmbnatn		= 0;

		Scanner 		keyboard 		= new Scanner(System.in);

		//----- Welcome msg --------------------------------------------------------------
		System.out.println("\n * * * * Welcome to Team Choices * * * *\n");
		System.out.println("The number of students must be between 2-4, inclusive\n ");

		//====================== I/P & VALIDATIONS ========================================
		
		//------ I/P and Validate : SENIOR -----------------------------------------------

		System.out.print("Enter the number of seniors    : ");
		numSnr  	 = keyboard.nextInt();

		while(numSnr  < 2 || numSnr > 4)
		{
			System.out.print("\t---> Invalid entry. Please ReEnter a number 2-4: ");
			numSnr   = keyboard.nextInt();

		}//end SENIOR validation


		//------ I/P and Validate : JUNIOR -----------------------------------------------

		System.out.print("Enter the number of juniors    : ");
		numJnr   	 = keyboard.nextInt();

		while(numJnr  < 2 || numJnr > 4)
		{
			System.out.print("\t---> Invalid entry. Please ReEnter a number 2-4: ");
			numJnr   = keyboard.nextInt();

		}//end JUNIOR validation


		//------ I/P and Validate : SOPHOMORE --------------------------------------------

		System.out.print("Enter the number of sophomores : ");
		numSphmr 	   = keyboard.nextInt();

		while(numSphmr  < 2 || numSphmr > 4)
		{
			System.out.print("\t---> Invalid entry. Please ReEnter a number 2-4: ");
			numSphmr   = keyboard.nextInt();

		}//end SOPHOMORE validation

		//====================== END I/P & VALIDATIONS ===================================

		//------ O/P --------------------------------------------------------------------
		System.out.println("\n\tPossible team combinations:\n");

		
		//= = = = = = = = = = = = =  SENIOR LOOP = = = = = = = = = = = = = = = = = = = = =
		
		 for (int cntSnr = 1; cntSnr <= numSnr; cntSnr++) 						 
		 {
			// - - - - - - - - - Conditions - - - - - - - - -
		 	
			if(cntSnr >1)
				System.out.print("\n\n\t Sr-"  + cntSnr);
			else 
				System.out.print("\t Sr-"  + cntSnr);
				
			//= = = = = = = = = = = = =  JUNIOR LOOP = = = = = = = = = = = = = = = = = = =

			for (int cntJnr = 1; cntJnr <= numJnr; cntJnr++) 					
			{		
				// - - - - - - - - - Conditions - - - - - - - - -
				
				if (cntJnr > 1) 
					System.out.print("\n\t\tJr-" + cntJnr );
				else 
					System.out.print("\tJr-" + cntJnr);
					
					//= = = = = = = = = = = = =  SENIOR LOOP = = = = = = = = = = = = = = =
					
					for (int cntSphmr = 1; cntSphmr <= numSphmr; cntSphmr++)   //SOPHOMORE
					{
						// - - - - - - - - - Conditions - - - - - - - - -
						
						if(cntSphmr > 1) 
						{
							//----- O/P -------------------------------
							System.out.print("\n\t\t\tSo-" + cntSphmr);
							
							//----- Accumulate -------------------------
							totCmbnatn++;
						
						} //end if statement
						else 
						{   
							//----- O/P -------------------------
							System.out.print("\tSo-" + cntSphmr);
						
							//----- Accumulate ------------------
							totCmbnatn++;
						
						}//end else statement 
					
					}//end FOR loop SOPHOMORE
				}//end FOR loop JUNIOR
			}//end FOR loop SENIOR
  
		//= = = = = = = = = = = = =END FOR LOOP = = = = = = = = = = = = = = = = = = = = =
		
		
		//------ O/P ------------------------------------------------------------
		System.out.println("\n\nThere are " + totCmbnatn + " unique possible combinations. ");

		//-----End msg ------------------------------------------------------------------
		System.out.println("\n - - - - pgm ended successfully - - - -\n ");

    }
}// end pgm