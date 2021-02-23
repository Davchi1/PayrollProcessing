import java.util.Calendar;

/**
 * @author David Okechukwu Sajan Thornhill
 * This class defines the properties of a Date object.
 */
public class Date implements Comparable<Date> {
    Calendar calendar = Calendar.getInstance();
    private int year;
    private int month;
    private int day;


    @Override
    public int compareTo(Date date) {
        if(this.year < date.year) {
            return -1;
        }
        else if(this.year > date.year) {
            return 1;
        }
        if(this.year == date.year) {
            if(this.month < date.month) {
                return -1;
            }
            else if( this.month > date.month) {
                return 1;
            }
        }
        if(this.year == date.year && this.month == date.month) {
            if(this.day < date.day) {
                return -1;
            }
            else if(this.day > date.day) {
                return 1;
            }
        }
        return 0;


    }


    /**
     * Paramerterized Constructor for date object
     * @param date
     */
    public Date( String date ) {
        String holder = date;
        String[] vals = holder.split("/");
        day = Integer.parseInt(vals[1]);
        month = Integer.parseInt(vals[0]);
        year = Integer.parseInt(vals[2]);

    }

    /**
     * Create an object with today's date
     */
    public Date() {
        day = calendar.get(Calendar.DATE);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
    }

    /**
     * Getter method for year
     * @return year
     */
    public int getYear(){
        return this.year;

    }
    /**
     *Getter method for month
     */
    public int getMonth(){
        return this.month;
    }
    /**
     *Getter method for day
     */
    public int getDay(){
        return this.day;
    }

    /**
     * Checks if date is in a valid format
     * @return
     */

    public boolean isValid(){

        if(year<1900||year>calendar.get(Calendar.YEAR)){
            return false;
        }

        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            if(day>31||day<0){
                return false;
            }
        }

        if(month == 4 || month == 6 ||month ==  9||month == 11)
        {
            if(day > 30 || day < 0){
                return false;
            }

        }

        if( month == 2 ) {
            Boolean leapyear;
            if (year % 4 == 0) {
                if(year % 100 == 0) {
                    if(year % 400 == 0) {
                        leapyear = true;
                    }
                    else {
                        leapyear = false;
                    }

                }
                else {
                    leapyear = true;
                }

            }
            else {
                leapyear = false;
            }
            if(leapyear == false && day > 28) {
                return false;
            }
            else if(leapyear == true && day > 29) {
                return false;
            }

        }
        /**
         *
         */
        return true;
    }
    public String getDateinOrder() {
        return(this.month + "/"+ this.day + "/" + this.year);
    }

}

