
public class Company {
    private Employee[] emplist;
    private int numEmployee;

    public Company(){
        numEmployee = 0;
        emplist = new Employee[4];
    }
    public Employee findEmployee(String name, String department, Date dateHired){
        Employee finder = new Employee(name, department, dateHired);
        Employee found;
        int index = find(finder);
        if(index == -1)
        {
            found = null;
        }else{
            found = emplist[index];
        }
        return found;
    }
    private int find(Employee employee) {
    	for(int index = 0; index < numEmployee; index++){
            if(employee.equals(emplist[index])){

                return index;
            }
        }
        return -1;
    }
    private void grow() {
        if (numEmployee % 4 == 0 && numEmployee != 0) {
            Employee[] tempBooks = new Employee[emplist.length + 4];
            for (int x = 0; x < emplist.length; x++) {
                tempBooks[x] =emplist[x];
            }
            emplist = tempBooks;
        }
    }

    public boolean add(Employee employee) {

        if(employee == null){
            return false;
        }

        for(int index = 0; index < emplist.length; index++){
            if(emplist[index] == null){
                continue;
            }
            if(employee.equals(emplist[index])){
                return false;
            }
        }


        grow();


        //add the employee
        for(int index = 0; index < emplist.length; index++) {
            if (emplist[index] == null) {
                emplist[index] = employee;
                numEmployee++;
                return true;
            }
        }

        return false;
    } //check the profile before adding
    public boolean isEmpty(){
       if(emplist[0]== null){
           return true;
       }
       return false;
    }
    public boolean remove(Employee employee) {
        int position = find(employee);

        if (position == -1) {
            return false;
        } else {
            emplist[position] = null;
            //Move everything back one poFsition in the array to maintain the current order
            for (int x = position; x < emplist.length && x != emplist.length - 1; x++) {
                emplist[x] = emplist[x + 1];
            }


            //TODO check over this
            Employee[] tempEmp = new Employee[emplist.length - 1];
            for (int x = 0; x < tempEmp.length; x++) {
                tempEmp[x] = emplist[x];
            }
            emplist = tempEmp;
        }
        numEmployee--;


        return true;
    } //maintain the original sequence


    public boolean setHours(Employee employee) {
        int index = 0;
        index = find(employee);

        //Check if it was found or not
        if(index == emplist.length) return false;

        //Change the working hours (Change later)
        Employee currEmp = emplist[index];
        if(currEmp instanceof Parttime) {
            return true;
        } else {
            return false;
        }
    }

    public void processPayments() {
        for (int x = 0; x < numEmployee; x++) {
            if(emplist[x] instanceof Parttime){
                emplist[x].calculatePayment();
            }
            if(emplist[x] instanceof Fulltime){
                if(emplist[x] instanceof Management) {
                    emplist[x].calculatePayment();
                }
                else {
                    emplist[x].calculatePayment();
                }
            }
        }
    } //process payments for all employees

    public void print() {
        for (int x = 0; x < numEmployee; x++) {
            if(emplist[x] instanceof Parttime){
                System.out.println(emplist[x].toString());
            }
            if(emplist[x] instanceof Fulltime){
                if(emplist[x] instanceof Management) {
                    System.out.println(emplist[x].toString());
                }
                else {
                    System.out.println(emplist[x].toString());
                }
            }
        }
    }

    //print earning statements for all employees
    public void printByDepartment() {
        Employee empTemp;

        for (int i = 0; i < numEmployee - 1; i++) {
            for (int j = i + 1; j < numEmployee; j++) {
                if (emplist[i].getMyProfile().getDepartment().compareTo(emplist[j].getMyProfile().getDepartment()) > 0) {
                    empTemp = emplist[i];
                    emplist[i] = emplist[j];
                    emplist[j] = empTemp;
                }
            }
        }

        for (int x = 0; x < numEmployee; x++) {
            if(emplist[x] instanceof Parttime){
                System.out.println(emplist[x].toString());
            }
            if(emplist[x] instanceof Fulltime){
                if(emplist[x] instanceof Management) {
                    System.out.println(emplist[x].toString());
                }
                else {
                    System.out.println(emplist[x].toString());
                }
            }
        }

    } //print earning statements by department
    public void printByDate() {
        Employee empTemp;

        for (int i = 0; i < numEmployee - 1; i++) {
            for (int j = i + 1; j < numEmployee; j++) {
                if (emplist[i].getMyProfile().getDateHired().compareTo(emplist[j].getMyProfile().getDateHired()) == 1) {
                    empTemp = emplist[i];
                    emplist[i] = emplist[j];
                    emplist[j] = empTemp;
                }
            }
        }

        for (int x = 0; x < numEmployee; x++) {
            if(emplist[x] instanceof Parttime){
                System.out.println(emplist[x].toString());
            }
            if(emplist[x] instanceof Fulltime){
                if(emplist[x] instanceof Management) {
                    System.out.println(emplist[x].toString());
                }
                else {
                    System.out.println(emplist[x].toString());
                }
            }
        }
    } //print earning statements by date hired
}
