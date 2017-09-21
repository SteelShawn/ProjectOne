import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Patient {

    private String firstName;
    private String lastName;
    private int priority;
    private int ID;
    private String time;

    public Patient(){
        firstName = null;
        lastName = null;
        priority = 0;
        ID = 0;
        time = "0";
    }
    public Patient(String fName, String lName, int priority, int currentID){
        firstName = fName;
        lastName = lName;
        this.priority = priority;
        ID = currentID;
        time = initializeTime();

    }
    private String initializeTime(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(cal.getTime());
    }
    public String getTime(){
        return time;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public int getID(){
        return this.ID;
    }
    public int getPriority(){
        return this.priority;
    }
    public void setPriority(int newPriority){
        priority = newPriority;
    }
    public String toString() {
        return (getLastName() + " " + getFirstName() +" " + leadingZeroPriority(getPriority()) +" "+
                leadingZeroID(getID()) + " " +getTime());
    }
    public String leadingZeroID(int ID){
        return String.format("%06d", ID);
    }
    public String leadingZeroPriority(int priority){
        return String.format("%03d", priority);
    }
}
