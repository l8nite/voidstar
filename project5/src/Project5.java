import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cs.jdbc.driver.CompositeConnection;


public class Project5 {

	private static final String DATASOURCE = "infectionsWithInfantMortalityService";
	private static final String HOST       = "cs08.cs.sjsu.edu";     
	private static final String USERNAME   = "voidstar";
	private static final String PASSWORD   = "S13voidstar";
	private static final String DOMAIN     = "composite";
	private static final int    PORT       = 9401;  
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Project5();
	}
	
	public Project5() {
		try {
			Connection c = connect();
			String sql = "SELECT * FROM queryTable WHERE City='Boston'";
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				String city = rs.getString("City");
				String country = rs.getString("Country");
				String date = rs.getString("Date");
				Integer infected = rs.getInt("Infected");
				Integer population = rs.getInt("Actual Population");
				Float mortality = rs.getFloat("Infant Mortality");
				System.out.println(city + ", " + country + " @ " + date + ": " + "population: " + population + ", infected: " + infected + ", mortality: " + mortality);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection connect() throws ClassNotFoundException, SQLException
	{
	    Class.forName("cs.jdbc.driver.CompositeDriver");
	    String url = "jdbc:compositesw:dbapi@" + HOST + ":" + PORT + 
	                 "?domain=" + DOMAIN + "&dataSource=" + DATASOURCE;
	    Connection conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
	    CompositeConnection compConn = (CompositeConnection) conn;
	    compConn.clearAllDataSourceCredentials();
	    compConn.setDataSourceCredentials(DATASOURCE, USERNAME, PASSWORD);
	    return conn;
	}
}
