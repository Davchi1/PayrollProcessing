public class Profile {
    private String name; //employee’s name in the form “lastname,firstname”
    private String department; //department code: CS, ECE, IT
    private Date dateHired;

    public Profile(String name, String department, Date dateHired){
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return (getName() + "::" + getDepartment() + "::" + getDateHired().getDateinOrder());
    }
    //Doe,Jane::CS::7/1/2020::Payment $0.00::PART TIME::Hourly Rate $45.90::Hours worked this period: 0
    @Override
    public boolean equals(Object obj) {
        if ( obj == null )
            return false;
        if ( obj == this )
            return true;
        if(!this.getName().equals(((Profile) obj).getName())){
            return false;
        }
        if(!this.getDepartment().equals(((Profile) obj).getDepartment())){
            return false;
        }
        if(this.getDateHired().compareTo(((Profile) obj).getDateHired()) != 0){
            return false;
        }
        return true;


    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public Date getDateHired() {
        return dateHired;
    }
    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }


}
