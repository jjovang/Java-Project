import java.util.HashMap;
import java.util.ArrayList;
public class Project {
    public static void main(String[] args) {
        //Create a list for patients, nurses and hospital records
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Nurse> nurses = new ArrayList<>();
        ArrayList<HospitalRecord> records = new ArrayList<>();

        //Create a hashmap to store nurse shift (ID, shift)
        HashMap<Integer, String> nurseShift = new HashMap<>() ;

        //Create a hashamp to store patient look (id, room)
        HashMap<Integer, String> patientRoom = new HashMap<>();

        //Create some data for patients 
        patients.add(new Patient("John", "Doe", 55, 101, "Flu", "501"));
        patients.add(new Patient("Jane", "Smith", 85, 102, "Cold", "502"));
        patients.add(new Patient("Robert", "Brown", 130, 103, "Cough", "503"));        
        System.out.println(patients.get(0));
        System.out.println(patients.get(1));
        System.out.println(patients.get(2));
        System.out.println(" ");
        
        //Add the hashmap for patientRoom
        for(Patient patient : patients) {
            patientRoom.put(patient.getID(), patient.getRoomNumber()) ;
        }
        
        //Create some data for nurses
        nurses.add(new Nurse("Kunari", "Lamu", 53, 201, "Morning")) ;
        nurses.add(new Nurse("John", "Sina", 90, 202, "Afternoon")) ;
        nurses.add(new Nurse("Fanny", "Darat", 140, 203, "Night")) ;
        System.out.println(nurses.get(0));
        System.out.println(nurses.get(1));
        System.out.println(nurses.get(2));
        System.out.println(" ");



        //Add the hashmap for nurseShift
        for (Nurse nurse : nurses) {
            nurseShift.put(nurse.getID(), nurse.getShift());
        }

        //Create hospital records
        records.add(new HospitalRecord(patients.get(0), nurses.get(0)));
        records.add(new HospitalRecord(patients.get(1), nurses.get(1)));
        records.add(new HospitalRecord(patients.get(2), nurses.get(2)));

 
        //Making choice variable to initiate the loop
        int choice = 10 ;

        //Menu
        while(choice != 0) {
        System.out.println("Hi, can I help you?");
        System.out.println("1. Find Nurse Shift");
        System.out.println("2. Find Patient");
        System.out.println("3. Print all patients");
        System.out.println("4. Print all nurses shift");
        System.out.println("5. Print hospital records");
        System.out.println("0. Exit");
        System.out.println("Choice : ");
        choice = In.nextInt();

        if (choice == 1) {
            System.out.println("Enter nurse's ID : ");
            int nurseID = In.nextInt();
            String shift = nurseShift.get(nurseID) ;

            if(shift != null) {
                System.out.println("Nurse with ID : " + nurseID + " is working at " + shift);
            } else {
                System.out.println("Nurse not found");
            }
        } else if (choice == 2) {
            System.out.println("Enter patient's ID : ");
            int patientID = In.nextInt();
            String roomNumber = patientRoom.get(patientID) ;

            if(roomNumber != null) {
                System.out.println("Patient ID : " + patientID + " is in room : " + roomNumber);
            } else {
                System.out.println("Patient not found");
            }
        } else if (choice == 3) {
            System.out.println("Patients list : ");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        } else if (choice == 4) {
            System.out.println("Nurses shift : ");
            for(HashMap.Entry<Integer, String> printShifts : nurseShift.entrySet()) {
                System.out.println("Nurse's ID : " + printShifts.getKey() + " shift : " + printShifts.getValue());
            }
        } else if(choice == 5) {
            System.out.println("Hospital Records : ");
            for(HospitalRecord record : records) {
                System.out.println(record);
            }
        }else if (choice == 0) {
            break;
        }else {
            System.out.println("Invalid code, try again");
        }
    }
}
}

class StakeHolder {
    protected String firstName, lastName ;
    protected int id;
    protected double heartBeat ;

    public StakeHolder(String firstName, String lastName, double heartBeat, int id) {
        setFirstName(firstName) ;
        setLastName(lastName); 
        setID(id);
        setHeartBeat(heartBeat);
        
    }
    public String toString() {
        return "Name : " + firstName + " " + lastName +  " ID : " + id + " ,heartBeat : " + heartBeat;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName ;
    }
    public String getFirstName() {
        return firstName ;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName ;
    }
    public String getLastName() {
        return lastName ;
    }

    public void setID(int id) {
        this.id = id ;
    }
    public int getID() {
        return id;
    }
    public void setHeartBeat(double heartBeat) {
        this.heartBeat = heartBeat;
    }
    public double getHeartBeat() {
        return heartBeat; 
    }

}

class Patient extends StakeHolder {
    private String disease, roomNumber;


    public Patient(String firstName, String lastName, double heartBeat, int id, String disease, String roomNumber) {
        super(firstName, lastName, heartBeat, id);
        setDisease(disease); 
        setRoomNumber(roomNumber);
    }
    public String condition() {
        if(heartBeat < 60) {
            return "Heart Beat too low" ;
        } else if(heartBeat >= 60 && heartBeat <=100) {
            return "Heart Beat normal" ;
        } else {
            return "Heart Beat too high" ;
        }
    }
    @Override
    public String toString() {
        return super.toString() + " ,condition : " + condition() + " ,disease : " + disease + " ,room number : " + roomNumber ;
    }

    public void setDisease(String disease) {
        this.disease = disease ;
    }
    public String getDisease() {
        return disease ;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber ;
    }
    public String getRoomNumber() {
        return roomNumber ;
    }
}

class Nurse extends StakeHolder {
    private String shift ;

    public Nurse (String firstName, String lastName, double heartBeat, int id, String shift) {
        super(firstName, lastName, heartBeat, id);
        this.shift = shift ;
    }

    public boolean goodToWork() {
        if(heartBeat < 60 || heartBeat > 100) {
            return false ;
        } else {
            return true ;
       }
    }
    @Override
    public String toString() {
        return super.toString() + " ,Is nurse good to work? " + goodToWork() ;
    }
    public void setShift(String shift) {
        this.shift = shift;
    } 
    public String getShift() {
        return shift;
    }
}

class HospitalRecord{
    private Patient patient ;
    private Nurse nurse;

    public HospitalRecord(Patient patient, Nurse nurse) {
        setNurse(nurse);
        setPatient(patient);
    }

    public String toString() {
        return "Patient : " + patient.getFirstName() + " " + patient.getLastName() + " | Room : " + patient.getRoomNumber() + " | " + " is with nurse " + nurse.getFirstName() + " " + nurse.getLastName() ;
    }
    public Patient getPatient() {
        return patient ;
    }
    public void setPatient(Patient patient) {
        this.patient = patient ;
    }

    public Nurse getNurse() {
        return nurse;
    }
    public void setNurse(Nurse nurse) {
        this.nurse = nurse ;
    }
}


