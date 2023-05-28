public class DateTime extends Date {
    int hour = 0; // between 00 and 23
    int min = 0; // between 00 and 59
    /* Constructor for the subClass DateTime
     * utilizes the constructor in the superClass Date
     */
    public DateTime(int y, int m, int d, int h, int min) {
        super(y, m, d);
        setHour(h);
        setMinute(min);
    }
    /* Checks that the hour is legal, and if so sets the object's hour
     */
    public void setHour(int i) {
        if((0 <= i) && (i <= 23)){
            this.hour = i;
        }
    }
    /* Checks that the minute is legal, and if so sets the object's minute
     */
    public void setMinute(int i) {
        if((0 <= i) && (i <= 59)){
            this.min = i;
        }
    }
    /* overriding the Object's toString function, returns our DateTime in the desired format
     * DD/MM/YYYY hh:mm
     */
    @Override
    public String toString(){
        String toReturn = super.toString() + " ";
        // DD/MM/YYYY hh:mm
        // here we have to use the toString in the Super Class to get the data format
        // and then add to it the part of "hh:mm"
        String hour = Integer.toString(this.hour);
        String minute = Integer.toString(this.min);
        if(hour.length() == 1) hour = "0" + hour;
        if(minute.length() ==1) minute = "0" + minute;
        toReturn = toReturn + hour + ":" + minute;
        return toReturn;
    }
    /* overriding the Object's equals function, returns whether two objects are the same, or have the same values!
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof DateTime)){
            return false;
        }
        DateTime otherDate = (DateTime) o;
        if (otherDate == this) {
            return true;
        }

        return (this.hashCode() == otherDate.hashCode());
    }
    /* overriding the Object's hashCode function, returns a unique number for each of the objects
     * depending solely on its characteristics values
     * also overrides the superClass's function hashCode / utilizes it
     */
    @Override
    public int hashCode(){
        int hashNumDate = super.hashCode();
        boolean minus = false;
        if(hashNumDate < 0){
            hashNumDate *= (-1);
            minus = true;
        }
        String date = Integer.toString(hashNumDate);
        String hour = Integer.toString(this.hour);
        String minute = Integer.toString(this.min);

        String dateTime = date + hour + minute;

        if(minus) return((-1) * Integer.parseInt(dateTime));

        return Integer.parseInt(dateTime);

    }

}
