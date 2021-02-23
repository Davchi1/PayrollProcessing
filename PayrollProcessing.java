import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PayrollProcessing {
    public boolean isManagementValid(int managementCode){
        if(managementCode<1||managementCode>3){
            return false;
        }
        return true;

    }

    public boolean isDepartmentValid(String department){
        if(department.equals("ECE") || department.equals("CS") || department.equals("IT")){
            return true;
        }
        return false;
    }
    public void run(){
        System.out.println("Payroll processing starts.");
        Company Apple = new Company();
        Scanner in = new Scanner(System.in);
            /*
            A(Specified type) - add
            AF
            AP
            AM
            R - remove
            Q - quit
            C - Calculate
            pa - print all
            pd - print by date
            ph - print by hiring date

            */
        while(1==1){
            String s = in.nextLine();
            StringTokenizer stk = new StringTokenizer(s," ");
            String command = stk.nextToken();

            if(command.equals("AF")){

                String name = stk.nextToken();
                String department = stk.nextToken();
                String hiringDate = stk.nextToken();
                Date hDate = new Date(hiringDate);
                String annualSalary = stk.nextToken();
                double annualSalaryDouble = Double.parseDouble(annualSalary);
                if(annualSalaryDouble < 0) {
                	System.out.println("salary cannot be negative.");
                	continue;
                }
                if(hDate.isValid() == false){
                    System.out.print("'" + hiringDate + "'" + " is not a valid date!");
                    continue;
                }
                try{
                    if(isDepartmentValid(department)==false){
                        System.out.println("'"+department+"'"+" is not a valid department code.");
                        continue;
                    }
                    //TODO remove the "exception caught"
                }catch(InputMismatchException e){
                    System.out.println("Exception Caught"+ "'"+department+"'"+" is not a valid department code.");
                    continue;
                }
                Employee temp = new Fulltime(name,department,hDate,annualSalaryDouble);
                if(Apple.findEmployee(name, department, hDate) != null) {
                	System.out.println("Employee is already on the list");
                	continue;
                }
                Apple.add(temp);
                System.out.println("Employee added");
                continue;
            }
            else if (command.equals("AP")){
                String name = stk.nextToken();
                String department = stk.nextToken();
                String hiringDate = stk.nextToken();
                Date hDate = new Date(hiringDate);
                String hourlySalary = stk.nextToken();
                Double hourlySalaryDouble = Double.parseDouble(hourlySalary);
                if(hourlySalaryDouble < 0.0) {
                	System.out.println("Pay rate cannot be negative.");
                	continue;
                }
                if(hDate.isValid() == false){
                    System.out.print("'" + hiringDate + "'" +" is not a valid date!");
                    continue;
                };
               
                try{
                    if(isDepartmentValid(department)==false){
                        System.out.println("'"+department+"'"+" is not a valid department code.");
                        continue;
                    }
                    //TODO remove the "exception caught"
                }catch(InputMismatchException e){
                    System.out.println("Exception Caught"+ "'"+department+"'"+" is not a valid department code.");
                    continue;
                }
                Employee temp = new Parttime(name,department,hDate,Double.parseDouble(hourlySalary));
                if(Apple.findEmployee(name, department, hDate) != null) {
                	System.out.println("Employee is already on the list");
                	continue;
                }
                Apple.add(temp);
                System.out.println("Employee added");
                continue;
            }
            else if (command.equals("AM")) {
                String name = stk.nextToken();
                String department = stk.nextToken();
                String hiringDate = stk.nextToken();
                Date hDate = new Date((hiringDate));
                String annualSalary = stk.nextToken();
                String managementRole = stk.nextToken();
                int managementRoleInt = Integer.parseInt(managementRole);
                Double annualSalaryDouble = Double.parseDouble(annualSalary);
                if(annualSalaryDouble < 0.0) {
                	System.out.println("salary cannot be negative.");
                	continue;
                }
                if(hDate.isValid() == false){
                    System.out.print("'" + hiringDate + "'" +" is not a valid date!");
                    continue;
                };
                try{
                    if(isManagementValid(managementRoleInt)==false){
                        System.out.println("Invalid management code.");
                        continue;
                    }
                    //TODO remove the "exception caught"
                } catch(NumberFormatException e){
                    System.out.println("Exception caught, invalid management code.");
                    continue;
                }
                try{
                    if(isDepartmentValid(department)==false){
                        System.out.println("'"+department+"'"+" is not a valid department code.");
                        continue;
                    }
                    //TODO remove the "exception caught"
                }catch(InputMismatchException e){
                    System.out.println("Exception Caught"+ "'"+department+"'"+" is not a valid department code.");
                    continue;
                }
                
                Employee temp = new Management(name,department,hDate, annualSalaryDouble ,managementRoleInt);
                if(Apple.findEmployee(name, department, hDate) != null) {
                	System.out.println("Employee is already on the list");
                	continue;
                }
                Apple.add(temp);
                System.out.println("Employee added");
            }
            else if( command.equals("S")){
                if(Apple.isEmpty()){
                    System.out.println("Employee database is empty!");
                    continue;
                }
                String name = stk.nextToken();
                String department = stk.nextToken();
                String hiringDate = stk.nextToken();
                Date hDate = new Date((hiringDate));
                String hours = stk.nextToken();
                int hoursInt = Integer.parseInt(hours);


                if(hoursInt > 100){
                    System.out.println("Invalid Hours: Over 100!");
                    break;
                }
                if(hoursInt < 0) {
                    System.out.println("Invalid Hours: Negative Value!");
                    break;

                }
                Employee temp = Apple.findEmployee(name, department, hDate);
                if(temp == null) {
                    System.out.println("hours could not be added, Employee doesn't exist");
                }
                else if(!Apple.setHours(temp)){
                    System.out.println("hours could not be added, Employee isn't Parttime");

                }
                else{
                    Parttime parttimeEmployee = (Parttime) temp;
                    parttimeEmployee.setHoursWorked(hoursInt);
                    System.out.println("Working hours set");

                }

            }
            else if (command.equals("R")){
                if(Apple.isEmpty()){
                    System.out.println("Employee database is empty!");
                    continue;
                }
                String name = stk.nextToken();
                String department = stk.nextToken();
                String hiringDate = stk.nextToken();
                Date hDate = new Date((hiringDate));
                Employee targetEmployee = new Employee(name, department, hDate);

                boolean removed = Apple.remove(targetEmployee);
                if(removed){
                    System.out.println("Employee removed.");
                } else {
                    System.out.println("Employee doesn't exist.");  //TODO Exception
                }

                continue;
            }

            else if (command.equals("Q")){

                break;
            }

            else if (command.equals("C")){
                if(Apple.isEmpty()){
                    System.out.println("Employee database is empty!");
                    continue;
                }
                Apple.processPayments();
                System.out.println("Calculations of employee payments is done.");
                continue;
            }

            else if (command.equals("PA") ) {
                if(Apple.isEmpty()){
                    System.out.println("Employee database is empty!");
                    continue;
                }
                System.out.println("--Printing earning statements for all employees--");
                Apple.print();
                continue;
            }
            else if (command.equals("PH") ) {
                if(Apple.isEmpty()){
                    System.out.println("Employee database is empty!");
                    continue;
                }
                System.out.println("--Printing earning statements for all employees--");
                Apple.printByDate();
                continue;
            }
            else if (command.equals("PD") ) {
                if(Apple.isEmpty()){
                    System.out.println("Employee database is empty!");
                    continue;
                }
                System.out.println("--Printing earning statements for all employees--");
                Apple.printByDepartment();
                continue;
            }

            else if (command.equals("Q")){

                System.out.println("Payroll Processing completed");
                break;
            }
            else{

                System.out.println("Command "+ "'"+command+"'" + " not supported!");
            }


        }


    }
}
