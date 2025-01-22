public class pens{
    public static void main(String[] args) {
        int pens = 14;
        int students = 3;
        int quantity = pens / students;
        int remainder = pens % students;
        System.out.println("Each student will get " + quantity + " pens");
        System.out.println("There are " + remainder + " pens left");
        }
}