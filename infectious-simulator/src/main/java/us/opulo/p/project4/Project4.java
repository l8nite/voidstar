package us.opulo.p.project4;

import org.hibernate.Session;

import us.opulo.p.hibernate.SessionManager;

public class Project4 {

	/*
	Demonstrate the basic OLAP operations by generating two-dimensional reports from your dimensional model:
	
		o Select dimensions: Generate reports with each combination of two out of the three dimensions.

	
		o Drill up and drill down: Demonstrate with three reports. 
		  	- first report is a “base” report. 
			- second report is a drill down from the base report, 
	      	- third report is a drill up from the base report.
	
		o Slice and dice: Demonstrate with three reports. 
		  	- first report is a “base” report (which can be the same base report you used for drill up/down).
			- second report is a slice of the base report
			- third report is a dice of the base report. 
	
		o Pivot: Demonstrate with two reports, one which is a pivot of the other.
	*/
	
	public static void main(String[] args) {
		Session session = SessionManager.get();
		
		// Dimensions: Detail, Date, City

		// 1a. Detail + Date
		// How many infected by Epidemic by Year
		
		// 1b. City + Detail
		// How many infected in City by Vector
		
		// 1c. City + Date
		// How many infected in City by Year
		
		// Drill up & Down 
		// Base Report: How many infected by Strain within a single Epidemic by Year
		// Drill down: How many infected by Mutation within a Strain within a single Epidemic by Year
		// Drill up: How many infected by Epidemic by Year (re-use from 1a)
		
		// Slice & Dice
		// Base report: How many infected by Strain within a single Epidemic by Year
		// Slice: How many infected by Strain within a single Epidemic in 2013 (sliced by Year)
		// Dice: How many infected by Strain A or B within a single Epidemic by Years 2000 through 2013
		
		// Pivot
		// Normal: Infections by City and Vector (3rd dimension Year)
		// Pivot: Infections by Vector and Year
	}

}
