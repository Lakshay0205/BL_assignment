class Course {
    String courseName;
    int duration;

    void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}

public class Main {
    public static void main(String[] args) {
        PaidOnlineCourse paidCourse = new PaidOnlineCourse();
        paidCourse.courseName = "Java Programming";
        paidCourse.duration = 40;
        paidCourse.platform = "Udemy";
        paidCourse.isRecorded = true;
        paidCourse.fee = 199.99;
        paidCourse.discount = 20;

        paidCourse.displayCourseInfo();
    }
}

