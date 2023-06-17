package PaySlipGen;

import java.text.DecimalFormat;     //Utility for decimal format

//Class that handles data specific to hourly employees 
public class HourlyEmployee extends Employee    
{

    public float hourRate; // variable for hourly pay rate   

    //Method for generating the hourly employee example
    public void createWithValues(int id, Title title, String firstname, String lastname, String dob, String nino, JobTitle jTitle, Department dep, EmployeeType empType, float hourRate) 
    {
        this.id = id;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.nino = nino;
        this.jTitle = jTitle;
        this.dep = dep;

        this.hourRate = hourRate;
        this.empType = EmployeeType.Hourly;
    }

    // Method for taking user input for hourly employee specific variables
    @Override
    public void createFromInput(int newId) 
    {
        super.createFromInput(newId);

        //The empType variable takes the enum value Hourly
        this.empType = EmployeeType.Hourly;
        
        System.out.print("     Hourly rate: ");
        this.hourRate = super.input.nextFloat();
    }

    //Method for displaying hourly employee specific data
    @Override
    public void view() 
    {
        super.view();
        System.out.print("      Hourly rate: " + dec.format(hourRate));
        System.out.println("");
    }
    
    // Method for taking user input and printing hourly employee specific 
    //payslip data
    @Override
    public void getPayslip() {
        System.out.println("Enter number of hours worked by " + this.firstname + " " + this.lastname + ": ");
        int hoursWorked = PayslipGenerator.readIntOption();

        super.getPayslip();

        System.out.println("Hourly rate: " + hourRate);
        System.out.println("No of hours: " + hoursWorked);
        System.out.println("===============================================");
        System.out.println("Gross salary for month: " + dec.format(hoursWorked * hourRate));
        System.out.println("Tax for month: " + dec.format(0.2 * (hourRate * hoursWorked)));
        System.out.println("Net salary for month: " + dec.format(0.8 * (hourRate * hoursWorked)));
        System.out.println("");
    }
}
