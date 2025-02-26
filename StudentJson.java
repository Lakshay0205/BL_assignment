import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJson {

    public static void main(String[] args) {
        JSONObject student = new JSONObject();

        // Add name and age
        student.put("name", "Akash Pandey");
        student.put("age", 20);

        // Create a JSONArray for subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Mathematics");
        subjects.put("Computer Science");
        subjects.put("Physics");

        // Add the subjects array to the student object
        student.put("subjects", subjects);

        // Print the JSON object
        System.out.println(student.toString(2)); // toString(2) formats the JSON with 2-space indentation.

        //Example of how to extract data from the JSONObject.
        String name = student.getString("name");
        int age = student.getInt("age");
        JSONArray subjectArray = student.getJSONArray("subjects");

        System.out.println("\nExtracted Data:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Subjects: " + subjectArray);

    }
}