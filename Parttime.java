import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Parttime extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public Parttime(String name, String department, Date dateHired, double hourlyRate){
        super(name,department,dateHired);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }


    @Override
    public void calculatePayment(){

        if(this.hoursWorked > 80){
            int extraHours = 80 - hoursWorked;
            double additionalRate = this.hourlyRate* 1.5;
            this.setPayment(this.hourlyRate* 80 + extraHours * additionalRate);
            return;
        }
        else {
            this.setPayment(this.hourlyRate* hoursWorked);
        }


    }

    public void setHoursWorked(int hours) {
        this.hoursWorked = hours;
    }

    @Override
    public String toString(){
        DecimalFormat priceString = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance());
        return super.toString() + "::PART TIME::Hourly Rate $" + priceString.format(hourlyRate) +
                "::Hours worked this period: " + hoursWorked;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Parttime){
            return super.equals(obj);
        }else{
            return false;
        }
    }
}

