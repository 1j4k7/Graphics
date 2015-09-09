import java.util.GregorianCalendar;

/**
 * @author Jason Kuo
 * 9/4/2015
 * Clock represents a clock that will be drawn
 */
public class Clock {
	private int seconds;
	private int minutes;
	private int hours;
	private int hour_of_day;
	
	/**
	 * Default constructor that makes all the values match the current time
	 */
	public Clock() {
		GregorianCalendar cal = new GregorianCalendar();
		seconds = cal.get(GregorianCalendar.SECOND);
		minutes = cal.get(GregorianCalendar.MINUTE);
		hours = cal.get(GregorianCalendar.HOUR);
		hour_of_day = cal.get(GregorianCalendar.HOUR_OF_DAY);
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getHour_of_day() {
		return hour_of_day;
	}

	public void setHour_of_day(int hour_of_day) {
		this.hour_of_day = hour_of_day;
	}
	
	
}
