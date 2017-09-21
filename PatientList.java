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
    public void printList(){
        int i = 0;
        while (i < list.size()){
            System.out.println(list.get(i));
            i++;
        }
    }
    public Patient getNextPatient(){
        return list.get(0);
    }
}
