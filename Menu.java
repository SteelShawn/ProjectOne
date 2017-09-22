import java.io.*;
import java.util.Scanner;

/**
 * Menu Class, This class is the class that handles all of the user interaction
 * This class is connects the user to the patient and patientlist class
 * @author Shawn
 */
public class Menu {
    Scanner k = new Scanner(System.in);
    private int currentID;
    private PatientList list;

    /**
     * Constructor
     * Gets the ID that was left off from last use of the program
     * Creates a new list of patients to be seen
     */
    public Menu(){
        currentID = getIDFromPrevious();
        list = new PatientList();
    }

    /**
     * Creates a new patient class, adds them to the list of patients to be seen, and updates ID
     */
    private void enterNewPatient(){
        Patient newPatient = new Patient(getUserInputPatientFirstName(), getUserInputPatientLastName(),
                getUserInputPatientPriority(), currentID);
        currentID++;
        list.addToList(newPatient);

    }

    /**
     * Method to find the next patient on the list, and remove them from the list
     * If the list is empty then there will be a special message
     */
    private void findNextPatient(){
        if (list.isEmpty()){
            System.out.println("There are no more patients to be seen");
        }
        if (!list.isEmpty()) {
            list.sortByPriority();
            list.getNextPatient().nextPatientOutputString();
            list.removeFirstElement();
        }

    }

    /**
     * Method to find the position of a specific patient, prompts for last name and then first name, and then
     * searches the list for matches
     */
    private void findPosition(){
        list.sortByPriority();
        String positionLName = getUserInputPatientLastName();
        String positionFName = getUserInputPatientFirstName();
        list.findPosition(positionLName, positionFName);
    }

    /**
     * Method that displays the list in a formatted chart using the priority number
     * First sorts the list and then gets the list to display
     */
    private void displayPriorityList(){
        list.sortByPriority();
        list.getPriorityList();
    }

    /**
     * Method to display the list in a formatted chart using the ID number
     * First sorts the list and then gets the list to display
     */
    private void displayIDlist(){
        list.sortByIDNumber();
        list.getIDList();
    }

    /**
     * Method to allow the user to exit the program
     * First saves the current ID to know where to start when the program starts again and then exits program
     */
    private void quit(){
        saveID();
        System.exit(0);
    }

    /**
     * Method to open a file and get the ID that was left off in the previous time the program was used
     * @return int of the next ID to be used
     */
    private int getIDFromPrevious(){
        int IDFromFile = 0;
        File file = new File("CurrentIDFile.txt");
        try {
            Scanner read = new Scanner(file);
            IDFromFile = Integer.parseInt(read.nextLine());
        } catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        return IDFromFile; //Read file for Input
    }

    /**
     * Method to save the ID so that the next time the program is used it knows where to start
     */
    private void saveID(){
        try{
            PrintWriter writer = new PrintWriter("CurrentIDFile.txt", "UTF-8");
                writer.println(currentID);
            writer.close();
        } catch (IOException e) {
            System.out.println("file error!");
            e.printStackTrace();
        }

    }
    /**
     * Method to get the user's input
     * @return action a String of the user's input
     */
    private String getAction(){
        Scanner k = new Scanner(System.in);
        String action = k.next();
        return action;
    }
    /**
     * Method to display the menu options
     */
    private void displayOptions(){
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
     * @param action String of the user's input
     */
    private void processAction(String action){
        if (action.equals("E")){
            enterNewPatient();
            menuInteraction();
        }
        if (action.equals("N")){
            findNextPatient();
            menuInteraction();
        }
        if (action.equals("F")){
            findPosition();
            menuInteraction();
        }
        if (action.equals("S")){
            displayPriorityList();
            menuInteraction();
        }
        if (action.equals("P")){
            displayIDlist();
            menuInteraction();
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

    /**
     * Method to prompt the user for first name of the patient being added or searched for
     * @return String of the patient's first name
     */
    private String getUserInputPatientFirstName() {
        System.out.println("Enter first name");
        return k.next();
    }

    /**
     * Method to prompt the user for the first name of the patient being added or searched for
     * @return String of the patient's last Name
     */
    private String getUserInputPatientLastName() {
        System.out.println("Enter Last Name");
        return k.next();
    }

    /**
     * Method to prompt the user for the patient's priority number
     * @return int of the patient's priority number
     */
    private int getUserInputPatientPriority(){
        System.out.println("Enter priority");
        return k.nextInt();
    }
}
