import java.io.*;
import java.util.Scanner;

public class Menu {
    Scanner k = new Scanner(System.in);
    int currentID;
    PatientList list;
    public Menu(){
        currentID = getIDFromPrevious();
        list = new PatientList();
    }
    public void enterNewPatient(){
        Patient newPatient = new Patient(getUserInputPatientFirstName(), getUserInputPatientLastName(),
                getUserInputPatientPriority(), currentID);
        currentID++;
        list.addToList(newPatient);

    }
    public void findNextPatient(){
        if (list.isEmpty()){
            System.out.println("There are no more patients to be seen");
        }
        if (!list.isEmpty()) {
            list.sortByPriority();
            list.getNextPatient().nextPatientOutputString();
            list.removeFirstElement();
        }

    }
    public void findPosition(){
        list.sortByPriority();
        String positionLName = getUserInputPatientLastName();
        String positionFName = getUserInputPatientFirstName();
        list.findPosition(positionLName, positionFName);
    }
    public void displayPriorityList(){
        list.sortByPriority();
        list.getPriorityList();
    }
    public void displayIDlist(){
        list.sortByIDNumber();
        list.getIDList();
    }
    public void quit(){
        saveID();
        System.exit(0);
    }
    public int getIDFromPrevious(){
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
    public void saveID(){
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
    public String getUserInputPatientFirstName() {
        System.out.println("Enter first name");
        return k.next();
    }
    public String getUserInputPatientLastName() {
        System.out.println("Enter Last Name");
        return k.next();
    }
    public int getUserInputPatientPriority(){
        System.out.println("Enter priority");
        return k.nextInt();
    }
}
