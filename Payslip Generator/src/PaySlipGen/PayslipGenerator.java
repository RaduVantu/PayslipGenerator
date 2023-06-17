package PaySlipGen;

import java.io.IOException;         //Utility for exception handling
import java.util.ArrayList;         //Utility for array lists
import java.util.List;              //Utility for lists
import java.util.Scanner;           //Utility for recognising keyboard input
import static PaySlipGen.Menu.*;    //Import for Menu class

public class PayslipGenerator   //Main class
{

    private static Scanner input = new Scanner(System.in);
    
    // generated Lists for every employee type and one for id validation
    
    private static List<CommissionEmployee> commisionedEmployees = new ArrayList<CommissionEmployee>();
    private static List<HourlyEmployee> hourlyEmployees = new ArrayList<HourlyEmployee>();
    private static List<SalaryEmployee> salaryEmployees = new ArrayList<SalaryEmployee>();
    private static List<Integer> existingIds = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException 
    {
        int menuOption;
        populateData();     //Initializing the populateData options

        while (true)    //while loop for main menu 
        {      
            MainMenu();
            menuOption = readIntOption();
            
            switch (menuOption) //switch operator for main menu options
            {
                case 1:  //Register employees menu
                    char subOption;
                    RegisterMenu(); 

                    subOption = input.next().charAt(0);
                    switch (subOption) //switch operator for submenu options
                    {
                        case 'a':   //add new salaried employee

                            SalaryEmployee newSalEmployee = readAndCreateNewSalaryEmployee();
                            salaryEmployees.add(newSalEmployee);
                            System.out.println("");
                            System.out.println("New ID added.Press enter to continue...");
                            System.in.read();
                            continue;

                        case 'b':   //add new hourly employee

                            HourlyEmployee newHourlyEmployee = readAndCreateNewHourlyEmployee();
                            hourlyEmployees.add(newHourlyEmployee);
                            System.out.println("");
                            System.out.println("New ID added.Press enter to continue...");
                            System.in.read();
                            continue;

                        case 'c':   //add new commissioned employee

                            CommissionEmployee newCommissionedEmployee = readAndCreateNewCommissionEmployee();
                            commisionedEmployees.add(newCommissionedEmployee);
                            System.out.println("");
                            System.out.println("New ID added.Press enter to continue...");
                            System.in.read();
                            continue;

                        case 'd':   // Return to main menu

                            continue;

                        default:
                            System.out.print("Wrong input. Press Enter to continue...");
                            System.in.read();

                            continue;
                    }

                case 2: //View employees menu

                    ViewMenu(); 

                    subOption = input.next().charAt(0);

                    switch (subOption) 
                    {
                        case 'a':     //View all  employees

                            if (commisionedEmployees.isEmpty() && hourlyEmployees.isEmpty() && salaryEmployees.isEmpty()) 
                            {
                                System.out.print("No employees found. Press enter to return to main menu...");

                                continue;
                            }

                            printAllCommisionedEmployees();
                            printAllSalaryEmployees();
                            printAllHourlyEmployees();

                            System.out.println("");
                            System.out.println("All employees listed. Press enter to continue...");
                            System.in.read();

                            continue;

                        case 'b':    //View all salaried employees

                            if (salaryEmployees.isEmpty()) 
                            {
                                System.out.print("No Salaried employees found. Press enter to return to main menu...");

                                continue;
                            }

                            printAllSalaryEmployees();

                            System.out.println("");
                            System.out.println("Salaried employees listed. Press enter to continue...");
                            System.in.read();

                            continue;

                        case 'c':     //View all hourly employees

                            if (hourlyEmployees.isEmpty()) 
                            {
                                System.out.print("No Hourly employees found. Press enter to return to main menu...");

                                continue;
                            }

                            printAllHourlyEmployees();

                            System.out.println("");
                            System.out.println("Hourly employees listed. Press enter to continue...");
                            System.in.read();

                            continue;

                        case 'd':     //View all commissioned employees

                            if (commisionedEmployees.isEmpty()) 
                            {
                                System.out.print("No Commissioned employees exist. Press enter to return to main menu...");

                                continue;
                            }

                            printAllCommisionedEmployees();

                            System.out.println("");
                            System.out.println("Commission employees listed. Press enter to continue...");
                            System.in.read();

                            continue;

                        case 'e':       //Return to main menu

                            continue;

                        default:
                            System.out.print("Wrong input. Press Enter to continue...");
                            System.in.read();

                            continue;
                    }

                case 3:    //Remove employee menu

                    RemoveMenu();   

                    subOption = input.next().charAt(0);
                    switch (subOption) 
                    {
                        case 'a':   //Remove employee by ID

                            int removeId;
                            System.out.print("Enter ID to be removed: ");
                            removeId = input.nextInt();

                            //Check if id exists
                            if (!existingIds.contains(removeId)) 
                            {
                                System.out.print("ID not found. Press Enter to return to main menu...");
                                System.in.read();
                            } 
                            else 
                            { 
                                //Check the lists one by one for the id and remove when found
                                CommissionEmployee foundCommisioned = searchCommissionEmployees(removeId);
                                if (foundCommisioned != null) 
                                {
                                    commisionedEmployees.remove(foundCommisioned);
                                    existingIds.remove(Integer.valueOf(removeId));
                                    System.out.println("Id " + removeId + " removed. Press enter to continue...");
                                    System.in.read();
                                    continue;
                                }

                                HourlyEmployee foundHourly = searchHourlyEmployees(removeId);
                                if (foundHourly != null) 
                                {
                                    hourlyEmployees.remove(foundHourly);
                                    existingIds.remove(Integer.valueOf(removeId));
                                    System.out.println("Id " + removeId + " removed. Press enter to continue...");
                                    System.in.read();
                                    continue;
                                }

                                SalaryEmployee foundSalary = searchSalaryEmployees(removeId);
                                if (foundSalary != null) 
                                {
                                    salaryEmployees.remove(foundSalary);
                                    existingIds.remove(Integer.valueOf(removeId));
                                    System.out.println("Id " + removeId + " removed. Press enter to continue...");
                                    System.in.read();
                                    continue;
                                }
                            }

                        case 'b':  // Return to main menu
                            continue;

                        default:
                            System.out.print("Wrong input. Press Enter to continue...");
                            System.in.read();

                            continue;
                    }

                case 4:   //Payslip generation menu

                    PayslipMenu(); 

                    subOption = input.next().charAt(0);

                    switch (subOption) 
                    {
                        case 'a':  //Generate payslip for employee by ID
                        {
                            int payId;

                            System.out.print("Enter ID to generate: ");
                            payId = readIntOption();
                            
                            //Check if id exists
                            if (!existingIds.contains(payId)) 
                            {
                                System.out.print("Sorry not found, press enter to continue... ");
                                System.in.read();

                                continue;
                            } 
                            else 
                            {

                                //Check the lists one by one for the id and generate payslip when found
                                CommissionEmployee foundCommisioned = searchCommissionEmployees(payId);
                                if (foundCommisioned != null) 
                                {
                                    foundCommisioned.getPayslip();
                                    System.out.println("");
                                    System.out.println("Press enter to continue...");
                                    System.in.read();
                                    continue;
                                }

                                HourlyEmployee foundHourly = searchHourlyEmployees(payId);
                                if (foundHourly != null) 
                                {
                                    foundHourly.getPayslip();
                                    System.out.println("");
                                    System.out.println("Press enter to continue...");
                                    System.in.read();
                                    continue;
                                }

                                SalaryEmployee foundSalary = searchSalaryEmployees(payId);
                                if (foundSalary != null) 
                                {
                                    foundSalary.getPayslip();
                                    System.out.println("");
                                    System.out.println("Press enter to continue...");
                                    System.in.read();
                                    continue;
                                }
                            }

                            System.out.print("Press enter to continue... ");
                            System.in.read();

                            continue;
                        }
                        case 'b':   //Generate payslip for all employees
                        {
                            System.out.println("    All employees payslip list");
                            
                            for (int i = 0; i < salaryEmployees.size(); i++) {
                                salaryEmployees.get(i).getPayslip();
                            }
 
                            for (int i = 0; i < commisionedEmployees.size(); i++) {
                                commisionedEmployees.get(i).getPayslip();
                            }
                            
                            for (int i = 0; i < hourlyEmployees.size(); i++) {
                                hourlyEmployees.get(i).getPayslip();
                            }

                            System.out.println("");
                            System.out.println("Press enter to continue...");
                            System.in.read();

                            continue;
                        }

                        case 'c':

                            continue;  //Return to main menu

                        default:
                            System.out.print("Wrong input. Press Enter to continue...");
                            System.out.print("");
                            System.in.read();

                            continue;
                    }
                    
                case 5:   //Stop proccess

                    System.exit(0);

                default:
                    System.out.println("Wrong input. Press Enter to continue...");
                    System.in.read();

                    continue;

            }

            // end of while statement
        }
    }

    //Functions for searching employees by employment type
    
    private static CommissionEmployee searchCommissionEmployees(int id) {
        if (!existingIds.contains(id)) {
            return null;
        }

        for (int i = 0; i < commisionedEmployees.size(); i++) {
            CommissionEmployee current = commisionedEmployees.get(i);

            if (current.id == id) {
                return current;
            }
        }

        return null;
    }

    private static HourlyEmployee searchHourlyEmployees(int id) {
        if (!existingIds.contains(id)) {
            return null;
        }

        for (int i = 0; i < hourlyEmployees.size(); i++) {
            HourlyEmployee current = hourlyEmployees.get(i);

            if (current.id == id) {
                return current;
            }
        }

        return null;
    }

    private static SalaryEmployee searchSalaryEmployees(int id) {
        if (!existingIds.contains(id)) {
            return null;
        }

        for (int i = 0; i < salaryEmployees.size(); i++) {
            SalaryEmployee current = salaryEmployees.get(i);

            if (current.id == id) {
                return current;
            }
        }

        return null;
    }

    //Function that populates the Lists with pre-defined examples of employees
    
    private static void populateData() {   //Function for generation of employee examples
        SalaryEmployee salaried = new SalaryEmployee();
        salaried.createWithValues(1, Title.Mr, "Radu", "Vantu", "19.02.1983", "SR195263A", JobTitle.FloorWorker, Department.Production, EmployeeType.Salaried, 18000, "Fulltime");
        salaryEmployees.add(salaried);
        existingIds.add(1);

        CommissionEmployee commissioned = new CommissionEmployee();
        commissioned.createWithValues(4, Title.Miss, "Diana", "Hirtan", "07.10.1987", "SR148363B", JobTitle.Supervisor, Department.Sales, EmployeeType.Commission, 19000, 5);
        commisionedEmployees.add(commissioned);
        existingIds.add(4);

        HourlyEmployee hourly = new HourlyEmployee();
        hourly.createWithValues(11, Title.Mr, "Jonny", "Amzoi", "28.11.1991", "SR481363A", JobTitle.OfficeWorker, Department.Supply, EmployeeType.Hourly, 21);
        hourlyEmployees.add(hourly);
        existingIds.add(11);
    }

    //Functions for id validation for each type of employee
    
    private static SalaryEmployee readAndCreateNewSalaryEmployee() {

        int id;
        System.out.println("=== New Salary Employee ===");

        while (true) {

            System.out.print(" Enter new ID: ");

            //Read Id & Validate
            id = readIntOption();
            if (existingIds.contains(id)) {

                System.out.println("ID already in use. Try another.");
                continue;
            }
            break;
        }

        input.nextLine();
        
        SalaryEmployee newSalaryEmployee = new SalaryEmployee();
        newSalaryEmployee.createFromInput(id);
        
        existingIds.add(id);
        
        return newSalaryEmployee;
    }
    
    private static HourlyEmployee readAndCreateNewHourlyEmployee() {

        int id;
        System.out.println("=== New Hourly Employee ===");

        while (true) {

            System.out.print(" Enter new ID: ");

            //Read Id & Validate
            id = readIntOption();
            if (existingIds.contains(id)) {

                System.out.println("ID already in use. Try another.");
                continue;
            }
            break;
        }

        input.nextLine();
        
        HourlyEmployee newHourlyEmployee = new HourlyEmployee();
        newHourlyEmployee.createFromInput(id);
        
        existingIds.add(id);
        
        return newHourlyEmployee;
    }

    private static CommissionEmployee readAndCreateNewCommissionEmployee() 
    {

        int id;
        System.out.println("=== New Commission Employee ===");

        while (true) 
        {

            System.out.print(" Enter new ID: ");
            id = readIntOption();
            
            if (existingIds.contains(id)) 
            {

                System.out.println("ID already in use. Try another.");
                continue;
            }
            break;
        }

        input.nextLine();
        
        CommissionEmployee newCommisionedEmployee = new CommissionEmployee();
        newCommisionedEmployee.createFromInput(id);
        
        existingIds.add(id);
        
        return newCommisionedEmployee;
    }

    //Functions for viewing existing employees by type of employment
    
    private static void printAllSalaryEmployees() 
    {
        System.out.println("SALARY EMPLOYEES:");
        System.out.println("");
        
        for (int i = 0; i < salaryEmployees.size(); i++) 
        {
            salaryEmployees.get(i).view();
        }
        
        System.out.println("");
    }

    private static void printAllHourlyEmployees() 
    {
        System.out.println("HOURLY EMPLOYEES:");
        System.out.println("");
        
        for (int i = 0; i < hourlyEmployees.size(); i++) 
        {
            hourlyEmployees.get(i).view();
        }
        
        System.out.println("");
    }
    
    private static void printAllCommisionedEmployees() 
    {
        System.out.println("COMMISIONED EMPLOYEES:");
        System.out.println("");
        
        for (int i = 0; i < commisionedEmployees.size(); i++) 
        {
            commisionedEmployees.get(i).view();
        }
        
        System.out.println("");
    }

    //Functions for validation of menu switch input and id input 
    //(program doesn't throw exception if input is char instead of int)
    
    public static int readIntOption()
    {
        int menuOptionOrId;
        while(true)
        {
            
            if(input.hasNextInt())
            {
                menuOptionOrId = input.nextInt();
                break;
            }
            
            System.out.println("Wrong input! Try again.");
            input.next();
        }
        
        return menuOptionOrId;
    }
}
