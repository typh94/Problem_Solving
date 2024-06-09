class Student
{
    //===============================================================
    //               Variables
    //===============================================================
	//--- class fields ----
	public static int  		idNum = 100 ;

	//---- instance fields -----
	private 	  String    fName	    ;
	private 	  String    lname	 	;
	private 	  int       studentID   ;
	private  	  int[]     scores      ;   // GRADE ARRAY  (test grades)
	private 	  Student[] grades		;	// STUDENT INFO (iD, first & lastName)
	private 	  int       lowScore	;
 
    //===============================================================
    //               Constructors
    //===============================================================
	//------ default constructor -----------------------------
	public Student()
	{
		this.fName     = fName   ;
		this.lname     = lname   ;
		this.scores    = scores  ;
 	}
 	
	//------ defined constructor -----------------------------
 	public Student(String fName, String lname, int[] scores )
	{
		this.fName     = fName   ;
		this.lname     = lname   ;
		this.scores    = scores  ;
		this.studentID = idNum++ ;
	}

	//==============================================================
	//            SETs
    //==============================================================

	public void setFrstName(String fName)
	{
		this.fName = fName;
	}

	public void setLstName(String lname)
	{
		this.lname = lname;
	}

	public void setScores(int[] scores)
	{
		this.scores = scores;
	}
	
	public void setIdNum(int  studentID)
	{
		this.studentID = studentID;
	}
 
	//==============================================
	//            GETs
    //=============================================

	public String getFrstName()
	{
		return fName;
	}
	
	public String getLstName()
	{
		return lname;
	}
	
	public int[] getScores()
	{
		return scores;
	}
	
	public int getStudentID()
	{
		return studentID;
	}

	//====================================================================================
	//         					  Functions
    //====================================================================================

	//------------------------------------------------------------------------------------
	//					 getScore()	
	//------------------------------------------------------------------------------------
	public void getScore(int tstNum)
	{

	}//end getScore
	
	//------------------------------------------------------------------------------------
	//					 getAverage()	
	//------------------------------------------------------------------------------------
 	public double getAverage()
	{
 		double total = 0;   //init. var

 		for(int i = 0; i < scores.length; i ++)
			total   += scores[i];

		return (total / scores.length);
	}//end getScore
	
	//------------------------------------------------------------------------------------
	//					 getLoScore()	
	//------------------------------------------------------------------------------------
 	public int getLoScore()
	{
	 	//----- init. var-------
		int  pctGrade    = 0 ;
		int  loScore     = 0 ;
		
		loScore 		 = scores[0];  // set low score to first grade

		for(int i = 0; i < scores.length; i++)
		{
			pctGrade 	 = scores[i] ; // set initial grade to test at [i]
			
 			if(pctGrade  < loScore)
				loScore  = pctGrade  ;

		}//end for loop
		
		return loScore;
	}//end getScore
	
	//------------------------------------------------------------------------------------
	//					 getHiScore()	
	//------------------------------------------------------------------------------------
	public void getHiScore( )
	{

	}//end getScore
 
}//end class