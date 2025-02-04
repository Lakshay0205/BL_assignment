public class Patient {

    private static String hospitalName = "City General Hospital"; // Static variable
    private static int totalPatients = 0; // Static variable

    private final int patientID; // Final variable
    private String name;
    private int age;
    private String ailment;

    private static int nextPatientId = 1; // To generate unique patient IDs

    // Constructor using 'this'
    public Patient(String name, int age, String ailment) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = nextPatientId++; // Assign unique ID and increment
        totalPatients++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAilment() {
        return ailment;
    }

    public void setAilment(String ailment) {
        this.ailment = ailment;
    }

    public int getPatientID() {
        return patientID;
    }

    public static String getHospitalName() {
        return hospitalName;
    }

    public static void setHospitalName(String hospitalName) {
        Patient.hospitalName = hospitalName;
    }

    public static int getTotalPatients() { // Static method
        return totalPatients;
    }

    public void displayPatientDetails() {
        if (this instanceof Patient) { // Using instanceof
            System.out.println("Patient ID: " + patientID); // Accessing final variable
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        } else {
            System.out.println("Not a Patient instance.");
        }
    }

    public static void main(String[] args) {
        Patient patient1 = new Patient("Akash Pandey", 30, "Flu");
        Patient patient2 = new Patient("Aditya Singh", 65, "Heart Condition");
        Patient patient3 = new Patient("Jatin Chawla", 25, "Broken Arm");

        System.out.println("Hospital Name: " + Patient.getHospitalName()); // Accessing static variable
        System.out.println("Total Patients: " + Patient.getTotalPatients()); // Calling static method

        patient1.displayPatientDetails();
        System.out.println("--------------------");
        patient2.displayPatientDetails();
        System.out.println("--------------------");
        patient3.displayPatientDetails();


        Patient.setHospitalName("New City Hospital");
        System.out.println("Hospital Name: " + Patient.getHospitalName()); // Accessing static variable

    
    }
}