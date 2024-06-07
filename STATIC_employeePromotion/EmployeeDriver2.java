//==============================================================================================
//  Author:   Typhene Benfriha                              csc-111   A
//  Date Due: April. 09, 2024
//  Assign:                                                 assign-17: Static
//  Program: EmployeeDriver2
//  Purpose:
//
//===============================================================================================
public class EmployeeDriver2
{
	public static void main(String [] args)
	{
		// ------------- Welcome and start ------------------------------------------------
		System.out.println("\n * * *  Welcome to Static * * * ");
		
		System.out.println("\n--------------------------------------------------------------"
						 + "\n\t * * * Display Class Vars * * *  \n" 
						 + "--------------------------------------------------------------  ");
						 
		System.out.println("\nValue in nextIdNum: " + Employee2.nextIdNum +
					       "\nData in lastHire  : " + Employee2.lastHire );
		
		System.out.println("\n--------------------------------------------------------------" 
			             + "\n\t * * * Display Employee Information * * *  \n" 
		                 + "--------------------------------------------------------------  ");

		Employee2 emp5 = new Employee2("Mary", "Smith" ); //instantiate emp5
		emp5.setDept   ("HR");			                  //adjust      dpt
		emp5.setPayCode(350 );			                  //adjust      payCode

		Employee2 emp6 = new Employee2("Fred" , "Jones" , "Marketing", 450);//instantiate emp6
		Employee2 emp7 = new Employee2("Sally", "Wilson", "Sales"    , 550);//instantiate emp7

		Employee2 emp8 = new Employee2(emp7); //instantiate emp8
		emp8.setFrstName("Susie");		      //adjust      firstName
		emp8.setPayCode (500    );            //adjust      payCode
		
		Employee2 emp9 = emp7.copy(); //instantiate emp9
 		emp9.setPayCode(620);         //adjust      payCode 

	//	Employee2 empPotential = new Employee2("Charlie", "Checker", 425 );//instantiate potential emp

 		//---- O/P : Display Employee Information ------------------------------------------ 
		System.out.print  ("\nData in emp-5: ");
 		System.out.println(emp5.toString()    );

		System.out.print  ("\nData in emp-6: ");
 		System.out.println(emp6.toString()    );

		System.out.print  ("\nData in emp-7: ");
 		System.out.println(emp7.toString()    );

		System.out.print  ("\nData in emp-8: ");
 		System.out.println(emp8.toString()    );

		System.out.print  ("\nData in emp-9: ");
 		System.out.println(emp9.toString()    );

 		//---- O/P : Display Potential Employee Information --------------------------------
		System.out.println("\nCharlie Checker: "    + 
						   "\n\t Potential Bonus: " + Employee2.bonusInfo(425));

		//--- display O/P for Last Hire -------------------------------------------------
		System.out.print("\nLast hired employee : " + Employee2.lastHire);

 		//----------------------  END -----------------------------------------------------
		System.out.println("\n\n .... pgm ended successfully ..... ");
		
	} // end main
}  //end pgm


