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
        priority = 000;
        ID = 000000;
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
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
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
}
