import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Management extends Fulltime{
    private double additionalCompensation;
    private int managementRole;
    private String managementRoleString;

    public Management(String name, String department, Date dateHired, double annualSalary, int managementRole){
        super(name,department,dateHired, annualSalary);
        this.managementRole  = managementRole;
        switch(managementRole) {
            case 1:
                managementRoleString = "Manager";
                this.additionalCompensation = 5000/26;

                break;
            case 2:
                managementRoleString = "Department Head";
                this.additionalCompensation = 9500/26;

                break;
            case 3:
                this.additionalCompensation = 12000/26;

                managementRoleString = "Director";
                break;
        }
    }
    public void setManagerRole() {

    }
    @Override
    public void calculatePayment(){
        switch(managementRole){

            case 1:
                
                super.setPayment(super.getannualSalary()/26+additionalCompensation);
                break;

            case 2:
               
                super.setPayment(super.getannualSalary()/26+additionalCompensation);
                break;

            case 3:
                
                super.setPayment(super.getannualSalary()/26+additionalCompensation);
                break;
        }
    }

    @Override
    public String toString(){
        this.setManagerRole();
        DecimalFormat priceString = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance());

        return super.toString() + "::" + managementRoleString + " Compensation $" +priceString.format(additionalCompensation);
    }
    @Override
    public boolean equals(Object obj){ // compare name, department and dateHired
        if(obj instanceof Management){
            return super.equals(obj);
        }else{
            return false;
        }

    }
}

