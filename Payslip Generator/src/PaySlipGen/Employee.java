package PaySlipGen;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

//This is an abstract class that holds the data and methods common to all employee types
//It is super class for CommissionEmployee, HourlyEmployee and SalaryEmployee subclasses
public abstract class Employee  
{

    public int id;
    public Title title;
    public String firstname, lastname, dob, nino;
    public JobTitle jTitle;
    public Department dep;
    public EmployeeType empType;
    
    protected static Scanner input = new Scanner(System.in);
    protected static DecimalFormat dec = new DecimalFormat("0.00");
   
    // Method for taking user input for variables common to all employees
    public void createFromInput(int newId)
    {
        
        this.id = newId;
        String availableTitles = Arrays.toString(Title.values());
        System.out.println("     Title " + availableTitles + ": ");
        String inputTitle;
        
        //While loop for validation of user input for title 
        while (true) 
        {
            try 
            {
                inputTitle = input.nextLine();
                //Will only accept values defined in the enum Title
                this.title = Title.valueOf(inputTitle);

                break;   
            }
            catch (Exception ex) 
            {
                System.out.println("Wrong input. Try again.");
                System.out.println("Title" + availableTitles + ": ");
            }
        }

        System.out.print("     First name: ");
        this.firstname = input.nextLine();

        System.out.print("     Last name: ");
        this.lastname = input.nextLine();

        System.out.print("     Date of birth: ");
        this.dob = input.nextLine();
        
        System.out.print("     National Insurance Number: ");
        this.nino = input.nextLine();

        String availableJobTitles = Arrays.toString(JobTitle.values());
        System.out.print("     Job title " + availableJobTitles + ": ");
        String inputJobTitle;

        while (true) //While loop for validation of user input for job title
        {
            try 
            {
                inputJobTitle = input.nextLine();
                //Will only accept values defined in the enum JobTitle
                this.jTitle = JobTitle.valueOf(inputJobTitle);

                break;
            } catch (Exception ex) {
                System.out.println("Wrong input. Try again.");
            }
        }

        String availableDepartments = Arrays.toString(Department.values());
        System.out.print("     Department(" + availableDepartments + "): ");
        String inputDepartment;

        while (true) //WWhile loop for validation of user input for department
        {
            try 
            {
                inputDepartment = input.nextLine();
                //Will only accept values defined in the enum Department
                this.dep = Department.valueOf(inputDepartment);

                break;
            } 
            catch (Exception ex) 
            {
                System.out.println("Wrong input. Try again.");
                System.out.print("Department " + availableDepartments + ": ");
            }
        }
    }

    //Method for displaying general employee data
    public void view() 
    {
        System.out.println("");
        System.out.println(" ID no: " + id + "    " + "Name: " + title + " " + firstname + " " + lastname);
        System.out.print("    Date of birth: " + dob);
        System.out.print("    NINo: " + nino);
        System.out.print("    Job title: " + jTitle);
        System.out.print("    Department: " + dep);
        System.out.println("");
    }

    //Method for displaying general employee payslip data
    public void getPayslip() 
    {
        System.out.println("===============   Payslip for   ===============");
        System.out.println("  ID: " + id + "  " + firstname + " " + lastname + " from " + dep + " department");
        System.out.println("===============================================");
    }
}
