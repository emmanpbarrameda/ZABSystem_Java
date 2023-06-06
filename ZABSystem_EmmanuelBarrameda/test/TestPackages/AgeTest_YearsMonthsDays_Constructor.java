/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackages;

class AgeTest_YearsMonthsDays_Constructor
{
   private int days;
   private int months;
   private int years;

   private AgeTest_YearsMonthsDays_Constructor()
   {
      //Prevent default constructor
   }

   public AgeTest_YearsMonthsDays_Constructor(int days, int months, int years)
   {
      this.days = days;
      this.months = months;
      this.years = years;
   }

   public int getDays()
   {
      return this.days;
   }

   public int getMonths()
   {
      return this.months;
   }

   public int getYears()
   {
      return this.years;
   }

   @Override
   public String toString()
   {
      return years + " yrs, " + months + " mon., & " + days + " days Alive";
   }
}