import java.util.Scanner;
public class Menu {
    Scanner k = new Scanner(System.in);
    int currentID;
    List list;
    public Menu(){
        currentID = getIDFromPrevious();
        list = new List();
    }
    public void enterNewPatient(){
        Patient newPatient = new Patient(getNewPatientFirstName(),getNewPatientLastName(),
                getNewPatientPriority(), currentID);
        list.addToList(newPatient);
        menuInteraction();

    }
    public String findNextPatient(){
        return "";
    }
    public int findPosition(){
        return 0;
    }
    public String displayPriorityList(){
        return "";
    }
    public String displayIIDlist(){
        return "";
    }
    public void quit(){
        saveID();
    }
    public int getIDFromPrevious(){
        return 0; //Read file for Input
    }
    public void saveID(){
        //save the current ID as a file output
    }

    /**
     * Method to get the user's input
     * @return action a String of the user's input
     */
    public String getAction(){
        Scanner k = new Scanner(System.in);
        String action = k.next();
        return action;
    }
    /**
     * Method to display the menu options
     */
    public void displayOptions(){
        System.out.println("Please select your option from the following menu:");
        System.out.println("E: Enter a new patient");
        System.out.println("N: Find next patient & remove him/her from the list");
        System.out.println("F: find the position of a specific patient");
        System.out.println("S: Display the list of patients sorted by priority");
        System.out.println("P: Print the list of patients sorted by patient ID");
        System.out.println("Q: Quit");
        System.out.print("Enter your choice");
    }
    /**
     * method to process the user's action
     * @param action The user's input
     */
    public void processAction(String action){
        if (action.equals("E")){
            enterNewPatient();
        }
        if (action.equals("N")){
            findNextPatient();
        }
        if (action.equals("F")){
            findPosition();
        }
        if (action.equals("S")){
            displayPriorityList();
        }
        if (action.equals("P")){
            displayIIDlist();
        }
        if (action.equals("Q")){
            quit();
        }

    }

    /**
     * Method combinging displayOptions, getActions, ProcessActions
     */
    public void menuInteraction(){
        displayOptions();
        processAction(getAction());
    }
    public String getNewPatientFirstName() {
        System.out.println("Enter first name");
        return k.next();
    }
    public String getNewPatientLastName() {
        System.out.println("Enter Last Name");
        return k.next();
    }
    public int getNewPatientPriority(){
        System.out.println("Enter priority");
        return k.nextInt();
    }



}
