package PaySlipGen;

import java.text.DecimalFormat;     //Utility for decimal format

//Class that handles data specific to commission employees
public class CommissionEmployee extends Employee    
{
    public float salary;            // variable for salary
    public float commission;        // variable for commission

    //Method for generating the commission employee example
    public void createWithValues(int id, Title title, String firstname, String lastname, String dob, 
                                String nino, JobTitle jTitle, Department dep, EmployeeType empType, 
                                float salary, float commission) 
    {
        this.id = id;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.nino = nino;
        this.jTitle = jTitle;
        this.dep = dep;

        this.salary = salary;
        this.commission = commission;
        this.empType = EmployeeType.Commission;
    }

    // Method for taking user input for commission employee specific variables
    @Override
    public void createFromInput(int newId) 
    {
        super.createFromInput(newId);
        
        //The empType variable takes the enum value Commissioned
        this.empType = EmployeeType.Commission;

        System.out.print("     Anual gross salary: ");
        this.salary = super.input.nextFloat();

        System.out.print("     Commission rate ('%'):");
        this.commission = super.input.nextFloat();
    }

    //Method for displaying commission employee specific data
    @Override
    public void view() 
    {
        super.view();
        System.out.print("      Salary: " + dec.format(salary));
        System.out.print("      Commission: " + dec.format(commission));
        System.out.println("");
    }

    // Method for taking user input and printing commission employee specific payslip data
    @Override
    public void getPayslip() 
    {
        System.out.println(" Enter sales amount for " + this.firstname + " " + this.lastname + ": ");
        float salesValue = PayslipGenerator.readIntOption();

        super.getPayslip();

        float commissionValue;
        commissionValue = salesValue * (commission / 100);

        System.out.println("Total sales: " + dec.format(salesValue));
        System.out.println("Commission: " + dec.format(commission));
        System.out.println("Gross monthly fixed salary:  " + dec.format((salary / 12)));
        System.out.println("Commissionn for month:  " + commissionValue);
        System.out.println("===============================================");
        System.out.println("Total gross salary for month: " + dec.format(((salary / 12) + commissionValue)));
        System.out.println("Tax for month: " + dec.format(0.2 * ((salary / 12 + commissionValue))));
        System.out.println("Net salary for month: " + dec.format(0.8 * ((salary / 12 + commissionValue))));
        System.out.println("");
    }
}
