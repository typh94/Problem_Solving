import java.text.*;

import java.util.*;
class GraderDriverV3
{
	//----- class variables --------------------------------------------------------------
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String [] arg)
	{
		//-------- variables -------------------------------------------------------------
 		String 	fName 		= "",
			 	lName		= "";
			 	
 		int 	numStudents = 0 ,
		 	 	numTests    = 0 ,
 		        idNum       = 0 ;
		
 		//-------- Welcomes Message  -----------------------------------------------------
		System.out.println("\n = = = = = Welcome to Grader = = = = = = \n");
		
		//--------- I/P : numStudents ---------------------------------------------------- 
		System.out.print("How many students : ");
		numStudents = keyboard.nextInt()        ;
		
		//---- instantiate array (size : num of students) -------------------------------- 
		Student[]   gradebook     = new Student[numStudents];
		
		//--------- I/P : numTests ------------------------------------------------------- 
		System.out.print("How many tests    : ");
		numTests = keyboard.nextInt()           ;

  		//---- ppopulate the array ------------------------------------------------------- 
 		for(int i = 0; i < gradebook.length; i++)
		{
			//--------- I/P : first name -------------------------------------------------  
			System.out.print("\nEnter student " + (i + 1) + "'s first Name: ");
			fName = keyboard.next();
			
			//--------- I/P : last name --------------------------------------------------
			System.out.print(  "Enter student " + (i + 1) + "'s last  Name: ");
			lName = keyboard.next();
			
			//--------- Populate arrays  -------------------------------------------------
			int[]    scores 		 = getScores  (numTests, fName , lName );
 			Student  currentStudent  = new Student(fName   , lName , scores);
 			gradebook[i] 			 = currentStudent                       ;
			  
 		}//end for loop

  		//----- Display O/P --------------------------------------------------------------
 		System.out.println(" \n===========================  GRADE BOOK REPORTS " +
 						   "==============================  \n"                 );
		
		displayDetails(numTests , numStudents, gradebook);
		displayLow    (gradebook, numTests              );
		
		System.out.println(" \n\n--- Grader Application ended ----- \n");
	}//end main

	//------------------------------------------------------------------------------------
	//                    METHODS: Functions
	//------------------------------------------------------------------------------------
	
	//------------------------------------------------------------------------------------
	// 						 getScores()	
	//------------------------------------------------------------------------------------
	public static int[] getScores(int numTests, String fName, String lName)
	{
		int[]  testArray = new int[numTests];
		int    grade     = 0                ;

		System.out.println("Enter test scores for   " + fName + " " + lName + ":");
		
		for(int i = 0; i < numTests; i++)
		{
			System.out.print("\t Test-" + (i + 1) + " : ");
			grade 		 = keyboard.nextInt()             ;
			testArray[i] = grade                          ;
		}
		return testArray;
	}//end getScores()

	//------------------------------------------------------------------------------------
	//					 displayDetails() 
	//------------------------------------------------------------------------------------
 	public static  void displayDetails(int numTests, int numStudents, Student[] gradebook)
	{
		DecimalFormat df1 = new DecimalFormat("#,###.0");  //decimal format
		
		//------ display header for : Gradebook ------------------------------------------
		System.out.println("Gradebook Detail:"                                                       );
   		System.out.printf ("%-5s %-20s %-5s %-10s %-6s     ", "ID", "Name", "Low", "Average", "Grade");
   		
   		//------- display "T #" for each test --------------------------------------------
    	for (int i = 0; i < numTests; i++) 
       		System.out.printf("%-7s", "T" + (i + 1));

		System.out.print("\n--------------------------------------------------------------" +
		       			 "-----------------\n"                                             );
		       			 
		//------ display rows : for each student, display info --------------------------- 
		for(int j = 0; j < numStudents; j++)
		{
       		 System.out.printf("%-5s %-20s %-5d %-10s %-6s     "     ,
             gradebook[j].getStudentID(), gradebook[j].getFrstName() + " " + 
             gradebook[j].getLstName  (), gradebook[j].getLoScore () , 
             df1.format(gradebook[j].getAverage())    ,getGrades(gradebook[j].getAverage()));

       		int[] scores = gradebook[j].getScores();

			//----- display each test from gradebook -------------------------------------
			for(int i = 0; i < scores.length; i++)
           		System.out.printf("%-7d", scores[i]);
            
			System.out.println("");
		 }//end column loop
	}//end displayDetails()
	
	//------------------------------------------------------------------------------------
	//					displayLow()
	//------------------------------------------------------------------------------------
	public static void displayLow(Student[] gradebook, int numTests) 
	{
		//------ display header for : Low Score ------------------------------------------
		System.out.println("\n\nLowest Test Scores:"                                );
		System.out.printf("%-7s %-15s %-15s %-15s\n", "Test", "Scores", "Name", "ID");
		System.out.println("--------------------------------------------------"     );

		for (int i = 0; i < numTests; i++) 
		{
			int 	loScore 	= gradebook[0].getScores   ()[i]; // Init. to first loScore  
			String 	studentName = gradebook[0].getFrstName ()   + " " + 
								  gradebook[0].getLstName  ()   ; // " fName lName "
			int 	studentID 	= gradebook[0].getStudentID()   ; // Init. to first student's ID

			for (int j = 1; j < gradebook.length; j++)
			{
				if (gradebook[j].getScores()[i] < loScore) 
				{
					loScore 	= gradebook[j].getScores   ()[i];  // Init. to first loScore  
					studentName = gradebook[j].getFrstName ()   + " " + 
								  gradebook[j].getLstName  ()   ; // " fName lName "
					studentID 	= gradebook[j].getStudentID()   ; // lower score found : Updt ID
					
				}//end if
			}//end inner loop
			
			System.out.printf("%-7d %-15d %-13s \t %-1d\n", (i + 1), loScore, studentName, studentID);
		}//end outer loop
	}//end displayLow()
 
	//------------------------------------------------------------------------------------
	//					 getGrades()	
	//------------------------------------------------------------------------------------
	public static String getGrades(double inNum)
	{
		String letterGrade = "" ;                  // declare var
		
  		if     ( (inNum >   0) && (inNum <= 59 ) ) // 0 - 59 %
			letterGrade  =  "F" ;

		else if( (inNum >= 60) && (inNum <= 69 ) ) //60 - 69 %
			letterGrade  =  "D" ;

		else if( (inNum >= 70) && (inNum <= 79 ) ) //70 - 79 %
			letterGrade  =  "C" ;

		else if( (inNum >= 80) && (inNum <= 89 ) ) //80 - 89 %
			letterGrade  =  "B" ;

		else if( (inNum >= 90) && (inNum <= 100) ) //90 - 100 %
			letterGrade  =  "A" ;

		return letterGrade;

	}//end getGrade()
}//end class