public class DateTime extends Date {
    int hour = 0; // between 00 and 23
    int min = 0; // between 00 and 59
    public DateTime(int y, int m, int d, int h, int min) {
        super(y, m, d);
        setHour(h);
        setMinute(min);
    }
    public void setHour(int i) {
        if((0 <= i) && (i <= 23)){
            this.hour = i;
        }
    }
    public void setMinute(int i) {
        if((0 <= i) && (i <= 59)){
            this.min = i;
        }
    }
    @Override
    public String toString(){
        String toReturn = " ";
        // DD/MM/YYYY hh:mm
        toReturn = super.toString() + " ";
        // here we have to use the toString in the Super Class to get the data format
        // and then add to it the part of "hh:mm"
        String hour = Integer.toString(this.hour);
        String minute = Integer.toString(this.min);
        if(hour.length() == 1) hour = "0" + hour;
        if(minute.length() ==1) minute = "0" + minute;
        toReturn = toReturn + hour + ":" + minute;
        return toReturn;
    }
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

    @Override
    public int hashCode(){
        int hashNumDate = super.hashCode();
        String date = Integer.toString(hashNumDate);
        String hour = Integer.toString(this.hour);
        String minute = Integer.toString(this.min);

        String dateTime = date + hour + minute;

        return Integer.parseInt(dateTime);

    }

}
