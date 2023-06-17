package PaySlipGen;

import java.text.DecimalFormat;     //Utility for decimal format

//Class that handles data specific to salary employees 
public class SalaryEmployee extends Employee    
{

    public String salariedType; // variable for type of salaried employee
    public float salary; // variable for salary

    //Method for generating the salaried employee example
    public void createWithValues(int id, Title title, String firstname, String lastname, String dob, String nino, JobTitle jTitle, Department dep, EmployeeType empType, float salary, String salariedType) 
    {
        this.id = id;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.nino = nino;
        this.jTitle = jTitle;
        this.dep = dep;

        this.salariedType = salariedType;
        this.salary = salary;
        this.empType = EmployeeType.Salaried;
    }

    // Method for taking user input for salaried employee specific variables
    @Override
    public void createFromInput(int newId) 
    {
        super.createFromInput(newId);

       //The empType variable takes the enum value Salaried
        this.empType = EmployeeType.Salaried;

        //While loop for the user input of salaried employee type
        while (true) 
        {
            System.out.print("     Enployment type (1 for Full-time or 2 for Part-time): ");
            int inputValue = super.input.nextInt();

            if (inputValue == 1) {
                this.salariedType = "Fulltime";
                System.out.println("         Full-time selected ");
                break;
            } else if (inputValue == 2) {
                this.salariedType = "Parttime";
                System.out.println("         Part-time selected ");
                break;

            } else {
                System.out.println("Wrong value. Try again.");
                System.out.println("");
            }
        }

        System.out.println("     Anual gross salary: ");
        this.salary = super.input.nextFloat();
    }

    //Method for displaying salaried employee specific data
    @Override
    public void view() {
        super.view();
        System.out.print("      Employment: " + salariedType);
        System.out.print("      Salary: " + dec.format(salary));
        System.out.println("");
    }

    // Method for printing salaried employee specific payslip data 
    @Override
    public void getPayslip() {
        super.getPayslip();

        System.out.println("Gross salary for month: " + dec.format(salary / 12));
        System.out.println("Tax for month: " + dec.format(0.2 * (salary / 12)));
        System.out.println("Net salary for month: " + dec.format(0.8 * (salary / 12)));
        System.out.println("");
    }
}
