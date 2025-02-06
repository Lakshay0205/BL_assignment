import java.util.ArrayList;

class Patient {
    private String name;
    private int patientId;
    private ArrayList<Doctor> consultedDoctors;

    public Patient(String name, int patientId) {
        this.name = name;
        this.patientId = patientId;
        this.consultedDoctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPatientId() {
        return patientId;
    }

    public ArrayList<Doctor> getConsultedDoctors() {
        return consultedDoctors;
    }

    public void addConsultedDoctor(Doctor doctor) {
        this.consultedDoctors.add(doctor);
    }

    @Override
    public String toString() {
        return "Patient: " + name + " (ID: " + patientId + ")";
    }
}

class Doctor {
    private String name;
    private String specialization;
    private ArrayList<Patient> patients;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void consult(Patient patient, String complaint) {
        System.out.println("Dr. " + name + " (" + specialization + ") is consulting " + patient.getName() +
                " (ID: " + patient.getPatientId() + "). Complaint: " + complaint);
        this.addPatient(patient);
        patient.addConsultedDoctor(this);
    }

    @Override
    public String toString() {
        return "Doctor: " + name + " (" + specialization + ")";
    }
}

class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void displayHospitalDetails() {
        System.out.println("Welcome to " + name + " Hospital!");
        System.out.println("\nDoctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
        System.out.println("\nPatients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    @Override
    public String toString() {
        return "Hospital: " + name;
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        Hospital cityHospital = new Hospital("City General Hospital");

        Doctor drSmith = new Doctor("Smith", "Cardiology");
        Doctor drJones = new Doctor("Jones", "Neurology");

        Patient john = new Patient("John Doe", 123);
        Patient jane = new Patient("Jane Smith", 456);
        Patient david = new Patient("David Lee", 789);


        cityHospital.addDoctor(drSmith);
        cityHospital.addDoctor(drJones);
        cityHospital.addPatient(john);
        cityHospital.addPatient(jane);
        cityHospital.addPatient(david);

        cityHospital.displayHospitalDetails();

        System.out.println("\n--- Consultations ---");
        drSmith.consult(john, "Chest pain");
        drJones.consult(jane, "Headache");
        drSmith.consult(jane, "Follow-up"); // Jane consults Dr. Smith again
        drJones.consult(david, "Dizziness");

        System.out.println("\n--- Doctor-Patient Relationships ---");
        System.out.println(drSmith.getName() + "'s patients: " + drSmith.getPatients());
        System.out.println(drJones.getName() + "'s patients: " + drJones.getPatients());
        System.out.println(john.getName() + "'s doctors: " + john.getConsultedDoctors());
        System.out.println(jane.getName() + "'s doctors: " + jane.getConsultedDoctors());
        System.out.println(david.getName() + "'s doctors: " + david.getConsultedDoctors());
    }
}