package us.opulo.p.modules.random;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.inject.Provider;
import javax.inject.Singleton;

/**
 * A provider configured to return a random date +/- 1 year. Zombies sleep on leap year.
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
		
		int year = calendar.get(Calendar.YEAR) + (random.nextInt(1) - random.nextInt(1));
		int month = random.nextInt(12) % 12;
		int date = random.nextInt(31) % daysInMonth[month];
		
		returnDate.set(Calendar.YEAR, year);
		returnDate.set(Calendar.MONTH, month);
		returnDate.set(Calendar.DATE, date);
		
		return returnDate.getTime();
	}

}
