import jdk.jshell.execution.JdiExecutionControlProvider;

import java.util.ArrayList;

abstract class Employee{
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name,String department){
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public abstract double calculateSalaray();

    @Override
    public String toString(){
        return "Employee [ name = "+name+", id = " + id+", department = "+ department+", salary =" +calculateSalaray()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(int id,String name,String department,double monthlySalary){
        super(id,name,department);
        this.monthlySalary = monthlySalary;
    }
    public double calculateSalaray(){
        return monthlySalary;
    }
}
class PartTimeEmployee extends Employee{
    private int hourlyWorked;
    private double hourlyRate;
    public PartTimeEmployee(int id,String name, String department,int hourlyWorked,double hourlyRate){
        super(id, name,department);
        this.hourlyWorked = hourlyWorked;
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalaray(){
        return hourlyWorked * hourlyRate;
    }

}
class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
            System.out.println("Employee Removed Successfully where id "+id);
        }else{
            System.out.println("Unable to remove Employee | Emp Id not found");
        }
    }

    public void displayEmployee(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}



public class Main {
    public static void main(String[] args) {
        System.out.println("Employee Payroll System");
        PayrollSystem prSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee(1001,"Amit Singh","Marketing",38000);
        FullTimeEmployee emp2 = new FullTimeEmployee(1002,"Anjali Verma","HR",8000);
        PartTimeEmployee emp3 = new PartTimeEmployee(1003,"Bhavesh","Development",40,800);

        prSystem.addEmployee(emp1);
        prSystem.addEmployee(emp2);
        prSystem.addEmployee(emp3);

        System.out.println("Enitial Employee Details");
        prSystem.displayEmployee();

        System.out.println("Removing any Employee Details");
        prSystem.removeEmployee(1003);

    }
}
