import java.util.*;
import java.text.*;
public class CatalystV3
{
	public static void main(String [] args)
	{
		//-------------Variables----------------------------------------------------------
		String 			ctlstName			= "";

		int 			numTemp				= 0,
						numRange			= 0,
						numCalib			= 0,
						trshld				= 0;

		double 			crv 				= 0;

		Scanner 		keyboard 			= new Scanner(System.in);

		//----- Welcome msg --------------------------------------------------------------
		System.out.println("\n = = = = Welcome to Catalyst = = = =\n");

		//-------- I/P  ------------------------------------------------------------------

		System.out.print("Enter name of the catalyst:    ");
		ctlstName = keyboard.next();

		System.out.print("Enter start temperature:       ");
		numTemp = keyboard.nextInt();
		
		//----- I/P & Verify: Range -------------------------------------------------------
		
		System.out.print("Enter table degree range:      ");
		numRange = keyboard.nextInt();
		
		while(numRange % 2 != 0)
		{
			System.out.print(" ERROR: multiple of 2:   ");
			numRange = keyboard.nextInt();
			
		}// end validate range
		
		//----- I/P & Verify: Calibration ------------------------------------------------
		
		System.out.print("Enter number of calibrations:  ");
		numCalib = keyboard.nextInt();
		
		while(numCalib < 2 || numCalib > 4)
		{
			System.out.print(" ERROR: between 2-4:     ");
			numCalib = keyboard.nextInt();
			
		}// end validate calibration

		//----- HEADER ------------------------------------------------------------------
		
		System.out.println("\n\t" + numCalib + " Degree Catalyst Reactivity for:" 
						 + "\n\t\t   " + ctlstName);
						 
		System.out.println("\n\tTemp    Lvl     CRV     Treshold ");
		System.out.println("\n\t--------------------------------- ");

		//----  -----------------------------------------------------------------------

		for(int cntRange = 0; cntRange <= (numRange/2); cntRange ++)
		{
			for(int cntCalib = 1; cntCalib <= numCalib; cntCalib++)
			{

				//----- Calculations -----------------------------------------------------
				crv     = (double)(numTemp/2) * cntCalib;
				trshld  = numTemp + (cntCalib* cntCalib);
				
				//----- O/P -------------------------------------------------------------
				
				System.out.print("\n\t" + numTemp + "\t" + cntCalib + "\t" + crv + "\t" + trshld);
				
				//---- display blank space (separator line) -----------------------------
				if (cntCalib == numCalib)
				{
					System.out.println("");
				}
				
			}//end calibration FOR loop	
			
			//------- Decrement ----------------------------------------------------------
			numTemp = numTemp -2;
			
		}//end range FOR loop

		//-----End msg -------------------------------------------------------------------
		System.out.println("\nThank you for using catalyst.\n ");

    }
}// end pgm