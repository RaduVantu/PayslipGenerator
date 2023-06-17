package PaySlipGen;

import java.util.Scanner;

public class Menu  //Class for the text-based menu
{
    static Scanner input = new Scanner(System.in);
    
    static void MainMenu() 
    {  
        System.out.println("");
        System.out.println("**------------------------------------------**");
        System.out.println("**--------       Main Menu          --------**");
        System.out.println("**------------------------------------------**");
        System.out.println("**       1. Register an employee            **");
        System.out.println("**       2.   View an employee              **");
        System.out.println("**       3.  Remove an employee             **");
        System.out.println("**       4.   Generate payslips             **");
        System.out.println("**       5.         Exit                    **");
        System.out.println("Please enter a choice (1 through 5):   ");
    }

    static void RegisterMenu() 
    {
        System.out.println("");
        System.out.println("**------------------------------------------**");
        System.out.println("**---------  Register new employee  --------**");
        System.out.println("**------------------------------------------**");
        System.out.println("**    a. Register new Salaried employee     **");
        System.out.println("**    b. Register new Hourly employee       **");
        System.out.println("**    c. Register new Commission employee   **");
        System.out.println("**    d. Back to main menu                  **");
        System.out.println("**------------------------------------------**");
        System.out.println("");
        System.out.println("Please enter a choice (a through d):   ");
    }

    static void ViewMenu() 
    {
        System.out.println("");
        System.out.println("**------------------------------------------**");
        System.out.println("**--------------View employees--------------**");
        System.out.println("**------------------------------------------**");
        System.out.println("**    a. View All employees                 **");
        System.out.println("**    b. View All Salaried employees        **");
        System.out.println("**    c. View All Hourly employees          **");
        System.out.println("**    d. View All Commission employees      **");
        System.out.println("**    e. Back to main menu                  **");
        System.out.println("**------------------------------------------**");
        System.out.println("");
        System.out.println("Please enter a choice (a through e):  ");
    }

    static void RemoveMenu() 
    {
        System.out.println("");
        System.out.println("**------------------------------------------**");
        System.out.println("**-------------Remove employee--------------**");
        System.out.println("**------------------------------------------**");
        System.out.println("**        a. Remove employee                **");
        System.out.println("**        b. Back to main menu              **");
        System.out.println("**------------------------------------------**");
        System.out.println("");
        System.out.println("Please enter a choice (a or b):  ");
    }

    static void PayslipMenu() 
    {
        System.out.println("");
        System.out.println("**---------------------------------------------**");
        System.out.println("**--------------Generate payslip---------------**");
        System.out.println("**---------------------------------------------**");
        System.out.println("**    a. Generate employee payslip by ID       **");
        System.out.println("**    b. Generate payslip for all employees    **");
        System.out.println("**    c. Back to main menu                     **");
        System.out.println("**---------------------------------------------**");
        System.out.println("");
        System.out.println("Please enter a choice (a through c):  ");
    }
}