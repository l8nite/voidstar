package us.opulo.p.simulator.modules.random;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.inject.Provider;
import javax.inject.Singleton;

/**
 * A provider configured to return a random date +/- 10 years
 * Ponder: Do zombies obey daylight savings time?
 * @author Jason Campos
 */
@Singleton
public class RandomDateProvider implements Provider<Date> {

	Calendar calendar;
	Random random;
	int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public RandomDateProvider() {
		super();
		calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		random = new Random();
	}
	
	@Override
	public Date get() {
		Calendar returnDate = Calendar.getInstance();
		
		// pick a random number of days (+/- 10 years)
		returnDate.add(Calendar.DAY_OF_YEAR, random.nextInt(7300) - 3650);

		return returnDate.getTime();
	}

}
