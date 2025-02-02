class Student {
    public int rN;
    protected String n;
    private double cGPA;

    public double gCGPA() {
        return cGPA;
    }

    public void sCGPA(double cGPA) {
        this.cGPA = cGPA;
    }
}

class PostgraduateStudent extends Student {
    void dD() {
        System.out.println("Roll Number: " + rN);
        System.out.println("Name: " + n);
    }
}

public class University {
    public static void main(String[] args) {
        PostgraduateStudent pgs = new PostgraduateStudent();
        
        pgs.rN = 101; 
        pgs.n = "John Doe"; 
        pgs.sCGPA(8.5);

        pgs.dD();
        System.out.println("CGPA: " + pgs.gCGPA());
    }
}
