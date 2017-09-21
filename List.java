import java.util.ArrayList;
import java.util.Comparator;
public class List {

    ArrayList<Patient> Patientlist = new ArrayList<>();

    public void addToList(Patient newPatient){
        Patientlist.add(newPatient);
    }
    public void sortByPriority(){
        Patientlist.sort(Comparator.comparing(Patient::getPriority).reversed());
    }
    public void sortByIDNumber(){
        Patientlist.sort(Comparator.comparing(Patient::getID));
    }
    public void removeFirstElement(){
        Patientlist.remove(0);
    }
    public void printList(){
        int i = 0;
        while (i < Patientlist.size()){
            System.out.println(Patientlist.get(i));
            i++;
        }

    }
}
