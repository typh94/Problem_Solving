import java.util.*;
import java.text.*;
public class CDCalculatorV3
{
	public static void main(String [] args)
	{
		//-------------Variables----------------------------------------------------------

		int 			dpstAmnt			= 0,
						numMnths			= 0;

		double 			mnthlPct			= 0,
						anualPct			= 0,
						cdValue 			= 0,
						mnthlyEarnng 		= 0,
						totErndIntrst		= 0;
						
		Scanner 		keyboard 			= new Scanner(System.in);
		
		DecimalFormat	dfCd				= new DecimalFormat("#,###.00");
		DecimalFormat	df2					= new DecimalFormat("#,###.000");
		DecimalFormat	df3					= new DecimalFormat("$#,###.00");



		//----- Welcome msg --------------------------------------------------------------
		System.out.println("\n = = Welcome to CD Calculator = =\n");

		//-------- I/P ------------------------------------------------------------------

		System.out.print("Enter the initial deposit amount:           ");
		dpstAmnt = keyboard.nextInt();

		System.out.print("Enter the annual percent yield (eg 5.25):   ");
		anualPct = keyboard.nextDouble();

		System.out.print("Enter maturity in months:                   ");
		numMnths = keyboard.nextInt();

		//----- O/P : header ------------------------------------------------------------

		System.out.println("\n Month     CD Valcue    Monthly    Total Earned");
		System.out.println("                        Earnings   Interest "     );
		System.out.println("------     ---------    --------   ------------"  );
		
		//----------  Initialize CD value ------------------
        cdValue = dpstAmnt; 
		
		//============== FOR loop Starts ===============================================
		
		for(int cntMnths = 0; cntMnths < numMnths; cntMnths++)
		{
  			//----- Calculations ----------------------------------------------------------
  			
            mnthlPct 	    = anualPct / 12;
            mnthlyEarnng    = (mnthlPct * cdValue) / 100;
            
            //----- Accumulate ----------------------------------------------------------
            
            totErndIntrst  += mnthlyEarnng;
            cdValue        += mnthlyEarnng;

			
			//----- fix O/P : extra space when digit > 9 --------------------------------------
			
			if(cntMnths <= 9)
			{
				System.out.println("   "    + (cntMnths + 1) + "       " + dfCd.format(cdValue)
								 + "      " + df2.format(mnthlyEarnng) + "     "
							     + df2.format(totErndIntrst) + "    ") ;
							     
			}//end if statement
			
			else 
			{
				System.out.println("   "    + (cntMnths + 1) +  "      " + dfCd.format(cdValue) 
							     + "      " + df2.format(mnthlyEarnng) + "     "
							     + df2.format(totErndIntrst) + "    ") ;
							     
			}//end else statement
		}//end FOR loop
		
		//-------- O/P --------------------------------------------------------------------
		
		System.out.println("\nA " + numMnths + " month CD with an initial deposit of: " + df3.format(dpstAmnt));
		System.out.println("At a " + anualPct + "% rate, yeilds:");
		
		System.out.printf("\tTotal interest  :     $%,12.2f%n   " , totErndIntrst);
		System.out.printf("\tNew CD value of :     $%,12.2f%n   " , cdValue);

		//-----End msg -------------------------------------------------------------------
		System.out.println("\n- - - Pgm ended Successfully - - -\n ");

    }
}// end pgm