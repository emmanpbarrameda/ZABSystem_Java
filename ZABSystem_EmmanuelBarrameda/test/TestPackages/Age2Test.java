/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackages;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
class Age2Test {
public static void main(String... args){
    
    Scanner sc = new Scanner(System.in);
    
      System.out.println("Enter your birth month (1-12): ");
      int bmonth = sc.nextInt();
      
      System.out.println("Enter your birth date (1-31): ");
      int bdate = sc.nextInt();    
      
      System.out.println("Enter your birth year: ");
      int byear = sc.nextInt(); 
    
    Calendar birthday = Calendar.getInstance();
    birthday.set(byear, bmonth, bdate);
    System.out.println("age: " + getAge(birthday.getTime()));  // prints "age: 26"
}

public static int getAge(Date dateOfBirth) {
    Calendar today = Calendar.getInstance();
    Calendar birthDate = Calendar.getInstance();
    birthDate.setTime(dateOfBirth);
    if (birthDate.after(today)) {
        throw new IllegalArgumentException("You don't exist yet");
    }
    int todayYear = today.get(Calendar.YEAR);
    int birthDateYear = birthDate.get(Calendar.YEAR);
    int todayDayOfYear = today.get(Calendar.DAY_OF_YEAR);
    int birthDateDayOfYear = birthDate.get(Calendar.DAY_OF_YEAR);
    int todayMonth = today.get(Calendar.MONTH);
    int birthDateMonth = birthDate.get(Calendar.MONTH);
    int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
    int birthDateDayOfMonth = birthDate.get(Calendar.DAY_OF_MONTH);
    int age = todayYear - birthDateYear;

    // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year
    if ((birthDateDayOfYear - todayDayOfYear > 3) || (birthDateMonth > todayMonth)){
        age--;
    
    // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
    } else if ((birthDateMonth == todayMonth) && (birthDateDayOfMonth > todayDayOfMonth)){
        age--;
    }
    return age;
}
}