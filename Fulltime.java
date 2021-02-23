import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Fulltime extends Employee {
    private double annualSalary;
    private int payPeriods = 26;

    public Fulltime(String name, String department, Date dateHired, double annualSalary){
        super(name,department,dateHired);
        this.annualSalary = annualSalary;
    }


    public double getannualSalary(){
        return this.annualSalary;
    }
    public void setannualSalary(double salary){
        this.setannualSalary(salary);

    }
    @Override
    public void calculatePayment() {
        super.setPayment(this.annualSalary/this.payPeriods);
    }
    @Override
    public String toString(){
        DecimalFormat priceString = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance());
        return super.toString() + "::FULL TIME::Annual Salary $" + priceString.format(annualSalary);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Fulltime){
            return super.equals(obj);
        }else{
            return false;
        }
    }

}

