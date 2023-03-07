//VINCENT BANDA BED-COM-04-20

import java.util.* ;
import java.io.* ;
import java.time.LocalDate ;


public class Dzungu {
    private static String name ;
    static String mobNum ;
    private String cafeName ;
    private static String gymNumber ;
    private static int choice ;
    static Scanner apt = new Scanner(System.in) ;
    static Scanner sc = new Scanner(System.in) ;
    static ArrayList<String> nam = new ArrayList<String>() ;
    static ArrayList<String> mem = new ArrayList<String>() ;
    static ArrayList<String> Ate = new ArrayList<String>() ;
    
    //constructor
    Dzungu() {

    }
    //constructor
    Dzungu(String name, String mobNum, String cafeName, String gymNumber, String choice) {

    }
    //method for class name
    public static void myCafeName() {
        System.out.print("                  Dzungu kukoma cafeteria") ;  

    }
    //method for line
    public static void setLine() {
        System.out.println("\n______________________________________________________________") ;
        System.out.println() ;

    }
    //method for getting mobile number
    public static void myMobNum() {
        System.out.println("Enter Mobile number starting with 265: ") ;
        mobNum = apt.nextLine() ;

    }
    //method for validating number
    public static boolean isValid() {
        if (mobNum.length() == 12 && mobNum.charAt(0) == '2' && mobNum.charAt(1) == '6' && mobNum.charAt(2) == '5' ) {
            return true;

        }
        return false ;

    }
    //method for choices
    public static void myChoices() {
        System.out.println("Welcome to dzungu cafeteria!");
        System.out.println();

        System.out.println("What do you want to do?");
        System.out.println("1. Add new gym members");
        System.out.println("2. Delete gym members");
        System.out.println("3. Issue meal cards");
        System.out.println("4. Print report");
        System.out.println("4. Print report");
        System.out.println("5. Logout");

    }
    //method for selcting choice
    public static int myChoice() {
        System.out.println("Enter choice: ") ;
        choice = apt.nextInt() ;

        return choice;
   
    }
    //method for adding gym members
    public static String addGymMembers() {
            System.out.print("Enter name: ") ; 
            name = sc.nextLine() ;
      
            System.out.print("Enter gum number: ") ;
            gymNumber = apt.next() ;

            return gymNumber;
              
    }
    //method for validating gym number
    public static boolean isValidGymNum(String gymNumber) {
        if (gymNumber.length() == 6) {
            return true;
            

        }
        return false;
        
    }
    //method for deleting gym members
    public static void deleteGymMembers() {
        name = apt.nextLine() ;

    }
    //method for issuing meal cards
    public static void IssueMealCard() {
        System.out.println ("Enter gym number: ") ;
        gymNumber = sc.nextLine() ;

        //checking with binary search
        int index = mem.indexOf(gymNumber) ;
        int indx = Collections.binarySearch(mem, gymNumber) ;
        if (indx >- 1) {
            if (Ate.contains(gymNumber)) {
                System.out.println("Denied " + nam.get(index) + " has arleady been issued free meal card") ;
            }
            else {
                System.out.println("Take out the meal card on the printer\n") ;
                Ate.add(gymNumber) ;
            } 

        }
        else {
            System.out.println("Invalid! gym number") ;
        }
    }
    //method for printing report
    public static void printReport() {
        System.out.println("report exported to csv file\n") ;

    }
    //method for logging out
    public static void Logout() {
        System.out.println("Bye! Bye!");
 
        
    }
    //main method
    public static void main(String[] args) throws IOException {

        //creating scanner
        Scanner input = new Scanner(System.in) ;

        //class object
        Dzungu dzungu = new Dzungu() ;

        //objects
        //with csv file extension
        File file = new File("gym members.csv") ;
        File Authorised = new File("Authorised members.csv") ;
        File report = new File("Template report.cvs") ;
        LocalDate myObj = LocalDate.now() ;

        //write to gym members
        FileWriter wrt = new FileWriter(file) ;
        wrt.write("gym members") ;

        //write to authorised users 
        FileWriter auth = new FileWriter(Authorised) ;
        auth.write("Authorised users") ;

        //write to report Template
        FileWriter rep = new FileWriter(report) ;

        //classname method caller
        myCafeName() ;

        //line method caller
        setLine() ;
        
        //checking for phone number validity

        //mobile number
        myMobNum();
            while (isValid() == false ) {
                System.out.println("Invalid! number") ;
                myMobNum();       
            }
            int i = -1 ;
            while (i != 0) {
                myChoices() ;
                myChoice() ;

                //choice number 1
                if (choice == 1) {
                    addGymMembers();
                    if (isValidGymNum(gymNumber) == true ) {
                        nam.add(name) ;
                        mem.add(gymNumber) ;
                        //storing name in array
                        for (String name : nam ) {
                            wrt.write("\n " + name) ;
                        }
                        //storing gym numberin array
                        for (String gymNumber : mem) {
                             wrt.write("\n " + gymNumber ) ;
                            }
                            //display result
                            System.out.println("You have successfully added " + name + " with gym number " + gymNumber + "\n") ;
                        }
                        //choices method caller
                        myChoices() ;
                        
                       
                    }
                    else {

                    }
                //choice number 3
                if (choice == 3) {
                IssueMealCard();

                }

                //choice number 4
                if (choice == 4) {
                printReport() ;
                rep.write("\n " + myObj + "\n ") ;
                rep.write("\nlogin by " + mobNum + "\n ") ;
                rep.write("\nthis gym members added " + gymNumber + "\n ") ;
                rep.write("\n " + name + "\n ") ;
                //storing reported name in array
                for (int k = 0 ; k < nam.size() ;  k++) {
                    rep.write("\n " + nam.get(k)) ;


                }
                //rstoring gym number in array
                rep.write("\n " + gymNumber + "\n ") ;
                for (int v = 0 ; v < mem.size() ; v++) {
                    rep.write("\n " + mem.get(v)) ;
                }
                //storing data for those issued meal cards
                rep.write("\nThese users were issued meal card " + "\n " + name + "\n " + gymNumber) ;
                for (int j = 0 ; j < Ate.size() ; j++) {
                    rep.write("\n " + Ate.get(j)) ;
                    
                }
                //closing file writers 
                rep.close();
                auth.write("\n " + mobNum) ;
                auth.close() ;
                wrt.close() ;
                }
                //choice number 5
                if (choice == 5){
                Logout(); 
                
                //terminating loop
                i = 1 ;
                return ;
                
            } 

        }             
        
    }

}
