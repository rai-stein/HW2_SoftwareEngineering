public class DateTime extends Date {
    int hour; // between 00 and 23
    int min; // between 00 and 59
    public DateTime(int y, int m, int d, int h, int min) {
        super(y, m, d);
        this.hour = h;
        this.min = min;
    }

    public void setHour(int i) {
    }

    public void setMonth(int i) {
    }

    public void setMinute(int i) {
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

//    @Override
//    public boolean equals(DateTime otherDate){
//        boolean equals = true;
//
//        return equals;
//    }

}
