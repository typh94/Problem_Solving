
import java.util.*;
import java.text.*;
public class FleetCosts
{
	public static void main(String [] args)
	{
		//-------------Variables----------------------------------------------------------

		final double		PRICE_OIL_FILTER 	= 3.15;
		final int			QT_OIL_PER_CASE  	= 16,
							OIL_LIFE_MI     	= 5000;

		double 				initGalCst 			= 0,
						    mpg    				= 0,
							subGasGal			= 0,
							subGasCost 			= 0,
							numOilChng			= 0,
							subqtsOil   		= 0,
							carInfOil    		= 0,
							mlsDrivn			= 0,
							totGasCost			= 0,
							oilFilter			= 0,
							ozonCost			= 0,
							oilCases			= 0,
							totOilFilter		= 0,
							totOilChg			= 0,
							totGasGal 			= 0,
							xtraOil				= 0,
							xtraQuarts			= 0;

		int 				cntCar				= 0,
							numCar 				= 0,
							year 				= 0,
							cases 				= 0;

		String 				area	 			= "",
							msg 				= "";

		boolean  			areaError			= false;
		
		DecimalFormat 		dfGas				= new DecimalFormat("#,###.#");
		DecimalFormat 		dfOil				= new DecimalFormat("#,###.0");
		DecimalFormat 		dfMoney				= new DecimalFormat("$#,###.00");

		Scanner 			keyboard    		= new Scanner(System.in);

		//----- Welcome msg --------------------------------------------------------------
		System.out.println("-----Fuel Costs Estimator -------\n");

		//----- I/P ----------------------------------------------------------------------
		System.out.println("Enter the following:  ");
		System.out.print  ("	Num Cars:  ");
		numCar 	       = keyboard.nextInt() ;
		System.out.print  ("	Price Gal Gas:  ");
		initGalCst 	   = keyboard.nextDouble() ;
		System.out.println("===========================\n ");


//------ Conditions ----------------------------------------------------------------------
		//------------- Start loop ----------------------
		while(cntCar < numCar)
		{
			System.out.println("Enter car details: ");
			System.out.print  ("	Area:  ");
			area 	  		= keyboard.next() ;
			System.out.print  ("	Year:  ");
			year 	   		= keyboard.nextInt() ;
			
			//---- Validation Routine : Year ---------------
			while(year < 2017 || year >2023)
			{
				System.out.println("\t    Invalid yr: " + year);
				System.out.print  ("\t      Year    : ");
				year = keyboard.nextInt();
			}
			
			//------ Set Flag for Area----------------------------
			if (area.equalsIgnoreCase("ah"))
			{ 				
				mlsDrivn = 15000;
 				areaError = false;
			}
 			else if (area.equalsIgnoreCase("b1"))
			{ 				
				mlsDrivn = 23000;
 				areaError = false;
			}
 			else
				areaError = true;

			//-----Validate year between 2017-2023----------------
			if (!areaError)
			{
				if (year == 2017 || year == 2018 || year == 2019)
				{
					mpg 		= 20;
					carInfOil 	= 5;
				}
				else if (year == 2020 || year == 2021)
				{
					mpg 		= 23;
					carInfOil 	= 6;
				}
				else  
				{
					mpg 		= 17;
					carInfOil 	= 3;
				}
				 
				//----- Calculate: subtotal ---------------------
				subGasGal 		= mlsDrivn / mpg;
				subGasCost 		= subGasGal * initGalCst;
				numOilChng 		= (int)(mlsDrivn / OIL_LIFE_MI);
				subqtsOil     	= numOilChng * carInfOil;
			}
			//------Reset values if No Estimate -------
			else
			{
				subGasGal  	= 0;
				subGasCost  = 0;
				numOilChng  = 0;
				subqtsOil	= 0;
			}
			
			//-------------- Accumulate -----------------------
			cntCar++;

			//----- Calculate: Total ----------------------------

			totOilChg       =totOilChg+ numOilChng;
			totGasCost 		=totGasCost+ subGasCost;
			totGasGal		= totGasGal +subGasGal;
			totOilFilter	= totOilChg * PRICE_OIL_FILTER;
			ozonCost		= totGasGal * 0.003;
			oilCases		= oilCases + subqtsOil;
			xtraOil			= oilCases /QT_OIL_PER_CASE;


			//------ Set Flag and display subtotal Estimates -----------------------------

			if (areaError)
				 System.out.println("\nNo estimate: NO service area" 
				 				  + "\n------------------------------------\n " );
			else
			{
				System.out.println("\nCar Estimates: "); 
				System.out.println("	gal gas	     : " + dfOil.format(subGasGal));
				System.out.println("	gas cost     : " + dfMoney.format(subGasCost));
				System.out.println("	num oil chg  : " + (int)numOilChng);
				System.out.println("	qts oil	     : " + (int)subqtsOil);
				System.out.println("------------------------------------\n ");

				//----- Extra Quart --------------------------------------
				xtraQuarts 		= oilCases % QT_OIL_PER_CASE;
   			}
			
		}//- - - - - - END LOOP - - - - - - - - - -

		//----- O/P: FLEET Estimates -----------------------------------------------------
		System.out.println("=========== FLEET Estimates =========");

		System.out.println("num of cars         : " + cntCar);
 		System.out.println("gal gas             : " + dfOil.format(totGasGal));

 		System.out.println("gas cost            : " + dfMoney.format(totGasCost));
		System.out.println("oil filters         : " + dfMoney.format(totOilFilter));
		System.out.println("ozone tax           : " + dfMoney.format(ozonCost));
		System.out.println("cases of oil        : " + (int) xtraOil);
		System.out.println(msg);
 
		//----- Extra Quart --------------------------------------

		if (xtraQuarts < 8) 
    		System.out.println("Buy " + (int)xtraQuarts + " QUART(s) of oil");
		else 
   			System.out.println("Buy one more case of oil");

		//-----End msg -------------------------------------------------------------------
		System.out.println("\n -------- PGM ENDED ----------");
    }
}// end pgm