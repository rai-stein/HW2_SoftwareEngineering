public class Date {
    int day = 1; // between 1 and 31
    int month = 1; // between 1 and 12
    int year = 0; // between -3999 to 3999
    public Date(int y, int m, int d) {
        setDay(d);
        setMonth(m);
        setYear(y);

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
    public void setMonth(int i) {
        if((1 <= i) && (i <= 12)){
            this.month = i;
        }
    }
    public void setDay(int i){
        if((1 <= i) && (i <= 31)){
            this.day = i;
        }
    }
    public void setYear(int i){
        if((-3999 <= i) && (i <= 3999)){
            this.year = i;
        }
    }
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

    @Override
    public int hashCode(){
        String day = Integer.toString(this.day);
        String month = Integer.toString(this.month);
        String year = Integer.toString(this.year);

        String date = day + month + year;

        return Integer.parseInt(date);
    }

}
