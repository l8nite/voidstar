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
//		Session session = SessionManager.get();
		
		// Dimensions: Detail, Date, City

		// 1a. Detail + Date
		// How many infected by Epidemic by Year
		//   SELECT InfectionEventDetail.Epidemic, InfectionEventDate.Year, SUM(InfectionEvent.Infected) FROM InfectionEvent INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID GROUP BY InfectionEventDetail.Epidemic, InfectionEventDate.Year ORDER BY InfectionEventDate.Year, InfectionEventDetail.Epidemic;
		
		// 1b. City + Detail
		// How many infected in City by Vector
		//   SELECT CONCAT(City.Name, CONCAT(", ", Country.Name)) as CityCountry, InfectionEventDetail.Vector, SUM(InfectionEvent.Infected) FROM InfectionEvent INNER JOIN City ON InfectionEvent.CityID = City.ID INNER JOIN Country ON City.CountryCode = Country.Code INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID GROUP BY CityCountry, InfectionEventDetail.Vector;
		
		// 1c. City + Date
		// How many infected in City by Year
		//   SELECT CONCAT(City.Name, CONCAT(", ", Country.Name)) as CityCountry, InfectionEventDate.Year, SUM(InfectionEvent.Infected) FROM InfectionEvent INNER JOIN City ON InfectionEvent.CityID = City.ID INNER JOIN Country ON City.CountryCode = Country.Code INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID GROUP BY CityCountry, InfectionEventDate.Year ORDER BY InfectionEventDate.Year;
		
		// 2. Drill up & Down 
		//
		// 2a. Base Report: How many infected by Strain within a single Epidemic by Year
		//   SELECT InfectionEventDetail.Strain, InfectionEventDetail.Epidemic, InfectionEventDate.Year, SUM(InfectionEvent.Infected) FROM InfectionEvent INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID WHERE InfectionEventDetail.Epidemic = '209efbc0-6900-4b8f-a296-9b1129654722' GROUP BY InfectionEventDetail.Strain, InfectionEventDate.Year ORDER BY InfectionEventDate.Year, InfectionEventDetail.Strain; 
		// 
		// 2b. Drill down: How many infected by Mutation within "Alpha Zero" Strain within a single Epidemic by Year
		//   SELECT InfectionEventDetail.Mutation, InfectionEventDetail.Strain, InfectionEventDetail.Epidemic, InfectionEventDate.Year, SUM(InfectionEvent.Infected) FROM InfectionEvent INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID WHERE InfectionEventDetail.Epidemic = '209efbc0-6900-4b8f-a296-9b1129654722' AND InfectionEventDetail.Strain = 'Alpha Zero' GROUP BY InfectionEventDetail.Mutation, InfectionEventDate.Year ORDER BY InfectionEventDate.Year, InfectionEventDetail.Mutation;
		//
		// 2c. Drill up: How many infected by Epidemic by Year (re-use from 1a)
		//   SELECT InfectionEventDetail.Epidemic, InfectionEventDate.Year, SUM(InfectionEvent.Infected) FROM InfectionEvent INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID GROUP BY InfectionEventDetail.Epidemic, InfectionEventDate.Year ORDER BY InfectionEventDate.Year, InfectionEventDetail.Epidemic;
		
		// 3. Slice & Dice
		// 3a. Base report: How many infected by Strain within a single Epidemic by Year
		// 3b. Slice: How many infected by Strain within a single Epidemic in 2013 (sliced by Year)
		// 3c. Dice: How many infected by Strain A or B within a single Epidemic by Years 2000 through 2013
		
		// 4. Pivot
		// 4a. Normal: Infections by City and Vector (3rd dimension Year)
		// 4b. Pivot: Infections by Vector and Year
	}

}
