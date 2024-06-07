//==============================================================================================
//  Author:   Typhene Benfriha                              csc-111   A
//  Date Due: April. 09, 2024
//  Assign:                                                 assign-17: Static
//  Program: Employee2
//  Purpose:
//
//===============================================================================================
public class Employee2
{
	// -------- instance vars ------------------------------------------------------------
	private     	int		    idNum   ;
	private   		String	    fName   ;
	private   		String	    lName   ;
	private   		String	    dept    ;
	private   		int		    payCode ;
	
	//----------   Class vars  -----------------------------------------------------------
	public static 	int         nextIdNum = 101;
	public static 	Employee2   lastHire  	;

	//====================================================================================
	//               CONSTRUCTORs
	//====================================================================================
	//-------------no arg constructor ----------------------------------------------------
	public Employee2()
	{
		this.idNum      = 0  ;
		this.fName      = "" ;
		this.lName      = "" ;
		this.dept       = "" ;
		this.payCode    = 0  ;
	//	lastHire = this;
 	}
	
	//------------- Defined constructor 1 - New Hire -------------------------------------
	public Employee2(String fName, String lName, String dept, int payCode)
	{
		this.idNum    	= assignIdNum() ;
		this.fName    	= fName 		;
		this.lName    	= lName  		;	
		this.dept     	= dept  		;
		this.payCode  	= payCode		;
		this.nextIdNum 	= assignIdNum() ;
		lastHire 		= this		    ;
	}
	
	public Employee2( int payCode)
	{
 		this.payCode  	= payCode		;
 	}
	
	//------------- Defined constructor 2 - New Hire -------------------------------------
	public Employee2( String fName, String lName )
	{
		this.idNum      = assignIdNum() ;
		this.fName      = fName  		;
		this.lName      = lName  		;
		this.dept       = dept   		;
		this.payCode    = payCode		;
		this.nextIdNum  = assignIdNum() ;
		lastHire        = this			;
	}
	
	//------------- COPY constructor -----------------------------------------------------
	public Employee2(Employee2 inEmp)
	{
		this.idNum      = assignIdNum()      ;
		this.fName      = inEmp.getFrstName();
		this.lName      = inEmp.getLstName ();
		this.dept       = inEmp.getDept    ();
		this.payCode    = inEmp.getPayCode ();
		this.nextIdNum  = assignIdNum()      ;
		lastHire        = this               ;
	}
	
	//------------- POTENTIAL HIRE ------------------------------------------------------- 
	public Employee2(String fName, String lName, int payCode)
	{
		this.idNum      = assignIdNum()  ;
		this.fName      = fName   		 ;
		this.lName      = lName 		 ;
		this.dept       = "not assigned" ;
		this.payCode    = payCode 		 ;
		this.nextIdNum  = assignIdNum()  ;
	}
	//=====================================================================================
	//               SETs
	//=====================================================================================
  	public void setIdNum (int idNum)
  	{
		this.idNum    = idNum;
	}

  	public void setFrstName (String fName)
  	{
		this.fName    = fName;
	}

  	public void setLstName (String lName)
  	{
		this.lName    = lName;
	}

  	public void setDept (String dept)
  	{
		this.dept     = dept;
	}

  	public void setPayCode (int payCode)
  	{
		this.payCode  = payCode;
	}

	//=====================================================================================
	//               GETs
	//=====================================================================================
  	public int getIdNum()
  	{
		return idNum;
	}
	
  	public String getFrstName()
  	{
		return fName;
	}
	
  	public String getLstName()
  	{
		return lName;
	}
	
  	public String getDept()
  	{
		return dept;
	}
	
  	public int getPayCode()
  	{
		return payCode;
	}
	//====================================================================================
	//        Functions
	//====================================================================================

 	public boolean equals(Employee2 inEmp)
	{
		boolean isEqual = false;
		
		//check equality: firstName, lastName and idNum
		if(idNum   == inEmp.getIdNum   () &&
		   fName   == inEmp.getFrstName() &&
		   lName   == inEmp.getLstName ()   )

			isEqual = true;  //inEmp and emp are equal
		else
			isEqual = false; //inEmp and emp are different 

		return isEqual;
	}//end equals()

	public Employee2 copy()
	{
		Employee2 employeeCopy = new Employee2();

		employeeCopy.setIdNum   (idNum  );
		employeeCopy.setFrstName(fName  );
		employeeCopy.setLstName (lName  );
		employeeCopy.setDept    (dept   );
		employeeCopy.setPayCode (payCode);

		return employeeCopy;
	}//end copy()

	public String toString()
	{
		String msg    = "",		//declare vars
		       bonus  = "";     
		       
 		bonus = bonusInfo(payCode);  
		msg   = "\n\tidNum   : " + idNum + "\n\tfName   : " + fName   + "\n\tlName   : " + lName +
			    "\n\tdept    : " + dept  + "\n\tpayCode : " + payCode + "\n\tbonus   : " + bonus;
		return msg;
	}//end toString()

	public static String bonusInfo(int payCode)
	{
		String msg = "";
		
		if     (payCode <= 399 )
			msg = "Standard Employee - no bonus";
		
		else if(payCode <= 599)
			msg = "Management - Yearly bonus applicable";
		
		else // paycode >= 600
			msg = "SR. MGMNT - Monthly bonus applicable";
			
		return msg;
    }//end bonusInfo() 
	
    private static int assignIdNum() 
    {
   		int assignedId = 0; //declare vars
   		
        assignedId = nextIdNum;
        nextIdNum++;		//increment to next IdNum
        
        return assignedId;
    }//end assignIdNum() 
}//end pgm