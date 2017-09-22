import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * Class to store information about the patient. It includes the First Name, Last Name, Priority, Patient ID,
 * and the Arrival Time of the patient
 * @author Shawn Harrington
 */
public class Patient {

    private String firstName;
    private String lastName;
    private int priority;
    private int ID;
    private String time;

    /**
     * Default Constructor
     */
    public Patient(){
        firstName = null;
        lastName = null;
        priority = 0;
        ID = 0;
        time = "0";
    }

    /**
     * Main constructor that is used
     *
     * @param fName String of the patient's first name
     * @param lName String of the patient's last name
     * @param priority int of the severity of the injury 999 highest, 000 lowest
     * @param currentID int of software generated unique number for the patient
     */
    public Patient(String fName, String lName, int priority, int currentID){
        firstName = fName;
        lastName = lName;
        this.priority = priority;
        ID = currentID;
        time = initializeTime();

    }

    /**
     * Method to initialize the time of patient's arriavl
     * @return String of the formated time in Hours:Minutes
     */
    private String initializeTime(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(cal.getTime());
    }

    /**
     * Method to get the time of arrival
     * @return String of the time of the patient's arrival
     */
    public String getTime(){
        return time;
    }

    /**
     * Method to get the patient's first name
     * @return String of only the First name of the patient
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Method to get the patient's last name
     * @return String of only the Last Name of the patient
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * Method to format a Full name, to be Last Name, First Name
     * @param lName String of the patient's last name
     * @param fName String of the patient's first name
     * @return String of the patient's full name
     */
    public String printFullName(String lName, String fName){
        return lName + ", " + fName;
    }

    /**
     * Method to return the unique patient ID
     * @return int of the patient's ID
     */
    public int getID(){
        return this.ID;
    }

    /**
     * Method to get the priority of a Patient
     * @return int of the patient's priority number
     */
    public int getPriority(){
        return this.priority;
    }

    /**
     * Method to set the priority for a patient
     * @param newPriority int of the new priority of the patient
     */
    public void setPriority(int newPriority){
        priority = newPriority;
    }

    /**
     * Method to print a patient out as a string
     * @return String of all of the patients information
     */
    public String toString() {
        return (getLastName() + " " + getFirstName() +" " + leadingZeroPriority(getPriority()) +" "+
                leadingZeroID(getID()) + " " +getTime());
    }

    /**
     * Formats the patient ID to be 6 digits
     * @param ID int of the ID being formatted
     * @return String of the formatted ID
     */
    public String leadingZeroID(int ID){
        return String.format("%06d", ID);
    }

    /**
     * Formats the Priority number to be 3 digits
     * @param priority The priority number being formatted
     * @return String of the formatted priority number
     */
    public String leadingZeroPriority(int priority){
        return String.format("%03d", priority);
    }

    /**
     * Method of special  output string for when getting the next patient
     * Print's out the next patient to be seen
     */
    public void nextPatientOutputString(){
        System.out.println("Patient " + getFirstName() + " " + getLastName() + " with ID " + leadingZeroID(getID())
                + " is ready to be seen.");
    }

    /**
     * Method of special output string for when finding the position of a patient
     * @param lName The last name of the patient finding their position
     * @param fName The first name of the patient finding their position
     * @param ID The patient ID fo the patient finding their position
     * @param index The index of their positon in the list
     */
    public void findPositionOutPutString(String lName, String fName, int ID, int index){
        System.out.println("There are " + index + " people ahead of " + fName + " " + lName +
                " (ID: " + leadingZeroID(ID) + ").");
    }
}
