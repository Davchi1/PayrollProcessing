import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Employee {
    private Profile myProfile;
    private double payment;


    public Employee(String name, String department, Date dateHired){
        myProfile = new Profile(name,department,dateHired);
        payment = 0;
    }



    public void calculatePayment() {
        // TODO Auto-generated method stub

    }
    public double getPayment() {
        return payment;
    }
    public void setPayment(double payment) {
        this.payment = payment;
    }
    public Profile getMyProfile() {
        return myProfile;
    }
    public void setMyProfile(Profile myProfile) {
        this.myProfile = myProfile;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Employee){
            Profile isEmployeeProf = ((Employee) obj).getMyProfile();
            return(this.myProfile.equals(isEmployeeProf));
        }else{
            return false;
        }
    }

    @Override //Doe,Jane::CS::7/1/2020::Payment $0.00::
    public String toString(){
        DecimalFormat priceString = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance());
        return this.getMyProfile().toString() + "::Payment $" + priceString.format(payment);

    }


}
