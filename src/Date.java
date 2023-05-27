public class Date {
    int day; // between 1 and 31
    int month; // between 1 and 12
    int year; // between -3999 to 3999
    public Date(int y, int m, int d) {

    }
    public String toString(){
        String toReturn = " ";
        String day = Integer.toString(this.day);
        String month = Integer.toString(this.month);
        String year = Integer.toString(this.year);
        if(day.length() == 1) day = "0" + day;
        if(month.length() == 1) month = "0" + month;
        if(year.length() == 1) year = "000" + year;
        else if(year.length() == 2) year = "00" + year;
        else if(year.length() == 3) year = "0" + year;
        // DD/MM/YYYY
        toReturn = day + "/" + month + "/" + year;
        return toReturn;
    }

    @Override
    public boolean equals(Date o) {
        if(!(o instanceof this)){
            return false;
        }

    }


}
