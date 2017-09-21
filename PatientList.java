import java.util.ArrayList;
import java.util.Comparator;
public class PatientList {

    ArrayList<Patient> list = new ArrayList<>();

    public void addToList(Patient newPatient){
        list.add(newPatient);
    }
    public void sortByPriority(){
        list.sort(Comparator.comparing(Patient::getPriority).reversed());
    }
    public void sortByIDNumber(){
        list.sort(Comparator.comparing(Patient::getID));
    }
    public void removeFirstElement(){
        list.remove(0);
    }
    public Patient getNextPatient(){
        return list.get(0);
    }
    public void findPosition(String lName, String fName){
        int index = 0;
        for (Patient p : list){
            if (p.getLastName().equals(lName) && p.getFirstName().equals(fName)){
                p.findPositionOutPutString(p.getLastName(),p.getFirstName(),p.getID(),index);
            }
            index++;
        }
    }
    public void getPriorityList(){
        System.out.println();
        System.out.format("%-10s%-8s%-13s%-21s", "Priority", "ID", "ArrivalTime", "Last name, First Name");
        System.out.println();
        for (Patient p : list){
            System.out.format("%-10s%-8s%-13s%-21s", p.leadingZeroPriority(p.getPriority()),
                    p.leadingZeroID(p.getID()), p.getTime(), p.printFullName(p.getLastName(), p.getFirstName()));
            System.out.println();
        }
        System.out.println();
    }
    public void getIDList(){
        System.out.println();
        System.out.format("%-8s%-10s%-13s%-21s", "ID", "Priority", "ArrivalTime", "Last name, First Name");
        System.out.println();
        for (Patient p : list){
            System.out.format("%-8s%-10s%-13s%-21s", p.leadingZeroID(p.getID()), p.leadingZeroPriority(p.getPriority()),
                    p.getTime(), p.printFullName(p.getLastName(), p.getFirstName()));
            System.out.println();
        }
        System.out.println();
    }
    public boolean isEmpty(){
        if (list.isEmpty()){
            return true;
        }
        return false;
    }
}
