// ©  M A D E		B Y		E M M A N		B A R R A M E D A  © //

package Main_ZAB_Packages;

/**
 *
 * @author Emmanuel Peñaflorida Barrameda
 */
class AgeYearsMonthsDays_Constructor {

    private int days;
    private int months;
    private int years;

    private AgeYearsMonthsDays_Constructor() {
        //Prevent default constructor
    }

    public AgeYearsMonthsDays_Constructor(int days, int months, int years) {
        this.days = days;
        this.months = months;
        this.years = years;
    }

    public int getDays() {
        return this.days;
    }

    public int getMonths() {
        return this.months;
    }

    public int getYears() {
        return this.years;
    }

    @Override
    public String toString() {
        return years + " yrs, " + months + " mon., & " + days + " days Alive";
    }
}
