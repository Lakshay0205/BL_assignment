import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String title;

    public JobRole(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Job Role: " + title;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;
    private List<String> skills;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
        this.skills = new ArrayList<>();
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Candidate: " + candidateName + ", " + jobRole + ", Skills: " + skills;
    }
}

class ScreeningPipeline {
    public void processResumes(List<? extends Resume<?>> resumes) {
        System.out.println("Processing Resumes...");
        for (Resume<?> resume : resumes) {
            System.out.println(resume);
            // AI-driven screening logic would go here
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice", new SoftwareEngineer());
        resume1.addSkill("Java");
        resume1.addSkill("Spring");

        Resume<DataScientist> resume2 = new Resume<>("Bob", new DataScientist());
        resume2.addSkill("Python");
        resume2.addSkill("Machine Learning");

        Resume<ProductManager> resume3 = new Resume<>("Charlie", new ProductManager());
        resume3.addSkill("Communication");
        resume3.addSkill("Market Analysis");

        List<Resume<?>> resumes = new ArrayList<>();
        resumes.add(resume1);
        resumes.add(resume2);
        resumes.add(resume3);

        ScreeningPipeline pipeline = new ScreeningPipeline();
        pipeline.processResumes(resumes);
    }
}