package us.opulo.p.simulator.modules.random;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.inject.Provider;
import javax.inject.Singleton;

/**
 * A provider configured to pick a random date +/- 10 years and then add one hour to subsequent invocations.
 * Ponder: Do zombies obey daylight savings time?
 * @author Jason Campos
 */
@Singleton
public class IncrementalDateProvider implements Provider<Date> {

	Calendar calendar;
	Random random;
	int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public IncrementalDateProvider() {
		super();
		random = new Random();
		calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_YEAR, random.nextInt(7300) - 3650);
	}
	
	@Override
	public synchronized Date get() {
		calendar.add(Calendar.HOUR, 1);
		return calendar.getTime();
	}

}
