public class Date {
    int day = 1; // between 1 and 31
    int month = 1; // between 1 and 12
    int year = 0; // between -3999 to 3999
    /* Constructor for the Class Date
     */
    public Date(int y, int m, int d) {
        setDay(d);
        setMonth(m);
        setYear(y);

    }
    /* Checks that the month is legal, and if so sets the object's month
     */
    public void setMonth(int i) {
        if((1 <= i) && (i <= 12)){
            this.month = i;
        }
    }
    /* Checks that the day is legal, and if so sets the object's day
     */
    public void setDay(int i){
        if((1 <= i) && (i <= 31)){
            this.day = i;
        }
    }
    /* Checks that the year is legal, and if so sets the object's year
     */
    public void setYear(int i){
        if((-3999 <= i) && (i <= 3999)){
            this.year = i;
        }
    }
    /* overriding the Object's toString function, returns our DateTime in the desired format
     * DD/MM/YYYY
     */
    @Override
    public String toString(){
        String toReturn;
        boolean minus = false;
        if(year < 0){
            year *= (-1);
            minus = true;
        }
        String day = Integer.toString(this.day);
        String month = Integer.toString(this.month);
        String year = Integer.toString(this.year);
        if(day.length() == 1) day = "0" + day;
        if(month.length() == 1) month = "0" + month;
        if(year.length() == 1) year = "000" + year;
        else if(year.length() == 2) year = "00" + year;
        else if(year.length() == 3) year = "0" + year;
        // DD/MM/YYYY
        if(minus) year = "-" + year;
        toReturn = day + "/" + month + "/" + year;
        return toReturn;
    }
    /* overriding the Object's equals function, returns whether two objects are the same, or have the same values!
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Date)){
            return false;
        }
        Date otherDate = (Date) o;
        if (otherDate == this) {
            return true;
        }
        return (this.hashCode() == otherDate.hashCode());
    }
    /* overriding the Object's hashCode function, returns a unique number for each of the objects
     * depending solely on its characteristics values
     */
    @Override
    public int hashCode(){
        boolean minus = false;
        if(year < 0){
            year *= (-1);
            minus = true;
        }
        String day = Integer.toString(this.day);
        String month = Integer.toString(this.month);
        String year = Integer.toString(this.year);

        String date = day + month + year;

        if(minus) return ((-1)*Integer.parseInt(date));

        return Integer.parseInt(date);
    }

}
