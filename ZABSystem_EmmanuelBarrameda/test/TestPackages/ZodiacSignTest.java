/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackages;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.text.DateFormat;
 
public class ZodiacSignTest {

	private static Scanner scanner = new Scanner(System.in);
 
	public static void main(String[] args) {
 
		System.out.println(dateFormat.format(calendar.getTime()));
 
		int day = 0;
		int month = 0;
		int year = 0;
                

 
		while (true) {
			
			System.out.print("Enter the Year: ");
			year = scanner.nextInt();
			
			while (true) {
				System.out.print("Enter the Month, January is 1, December is 12: ");
				month = scanner.nextInt();
 
				// Change month to zero-based and validate
				if (validMonth(--month))
 
					break;
			}
 
			while (true) {
				System.out.print("Enter the day in the Entered Month: ");
				day = scanner.nextInt();
				
				if (validDay(day, month, year))
					break;
			}
 
			// determine the sign
			calendar.set(year, month, day);
			// Match the year for the sign start dates
			for (int i = 0; i < signStartDates.length; ++i) {
				signStartDates[i].set(GregorianCalendar.YEAR, year);
			}
 
			for (int i = 0; i < signStartDates.length; ++i) {
				if (calendar.after(signStartDates[i]) && calendar.before(signStartDates[(i + 1) % signStartDates.length])) {
					System.out.println(dateFormat.format(calendar.getTime()) + " is in the sign of " + signs[i]);
					break;
                                        
                                } else if ((month == 12 && day >= 22 && day <= 31) || (month ==  1 && day >= 1 && day <= 19)) {
                                    System.out.println("Capricorn");
                                    break;
				}
			}
 
			// Try another date?
			System.out.println("Do you want to try another date(Enter Y or N)?");
			if (!yes()) {
				break;
			}
		}
	} // Main Methods End Here
	
 
	// Validate the month value
	private static boolean validMonth(int month) {
		if (month >= 0 && month <= 11)
			return true;
		else
			System.out.println("The month value must be from 1 to 12. Try again.");
		return false;
	}
 
	// Validate the day value for the month and year
	private static boolean validDay(int day, int month, int year) {
		/*
		 * A valid day must be: - between 1 and 31 - less than 31 when the month is
		 * April, June, September, or November - less than 29 when the month is February
		 * and it is not a leap year - less than 30 when the month is February and it is
		 * a leap year
		 */
		if (day < 0 || day > 31) {
			System.out.println("Day values must be between 1 and 31. Please Try again.");
			return false;
		}
 
		if (day > 30 && (month == 3 || month == 5 || month == 8 || month == 10)) {
			System.out.println(
					"Day values must be less than 31 when the month" + " is " 
			+ monthNames[month] + ". Please Try again.");
			return false;
		}
 
		if (day > 28 && month == 1 && !calendar.isLeapYear(year)) {
			System.out.println(year + " is not a leap year so day values must"
					+ " be less than 29. Try again.");
			return false;
		}
 
		if (day > 29 && month == 1 && calendar.isLeapYear(year)) {
			return false;
		}
 
		return true;
 
	}
 
 
	private static boolean yes() {
		String str = null;
		while (true) {
			try {
				str = in.readLine().trim();
			} catch (IOException e) {
				System.out.println("Error reading for the keyboard." + e.getMessage());
			}
 
			if (str.equalsIgnoreCase("Y")) {
				return true;
			} else if (str.equalsIgnoreCase("N")) {
				break;
			} else {
				System.out.print("Invalid input. Try again. Enter Y or N: ");
			}
		}
		return false;
	}
 
	// Keyboard input
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
	// Names for Zodiac signs and start dates. Remember - months start at zero.
	private static String[] signs = { "Aquarius", "Pisces", "Aries", "Taurus", 
			"Gemini", "Cancer", "Leo", "Virgo",
			"Libra", "Scorpio", "Sagittarius", "Capricorn" };
	
	// Aquarius start date
	private static GregorianCalendar[] signStartDates = { new GregorianCalendar(2002, 0, 20),
			new GregorianCalendar(2002, 1, 19), // Pisces start date
			new GregorianCalendar(2002, 2, 21), // Aries start date
			new GregorianCalendar(2002, 3, 20), // Taurus start date
			new GregorianCalendar(2002, 4, 21), // Gemini start date
			new GregorianCalendar(2002, 5, 21), // Cancer start date
			new GregorianCalendar(2002, 6, 23), // Leo start date
			new GregorianCalendar(2002, 7, 23), // Virgo start date
			new GregorianCalendar(2002, 8, 23), // Libra start date
			new GregorianCalendar(2002, 9, 23), // Scorpio start date
			new GregorianCalendar(2002, 10, 22), // Sagittarius start date
			new GregorianCalendar(2002, 11, 22), // Capricorn start date
	};
	
	private static GregorianCalendar calendar = new GregorianCalendar();
 
	public static final String[] monthNames = { "January", "February", "March", 
			"April", "May", "June", "July",
			"August", "September", "October", "November", "December" };
 
	// Date formatter for displaying dates
	public static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
}