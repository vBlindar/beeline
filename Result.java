import java.util.ArrayList;
import java.util.List;

public class Result {

    private Student student;

    private List<NewPlace> newPlaceList = new ArrayList<>();

    public Result(Student student, List<NewPlace> newPlaceList) {
        this.student = student;
        this.newPlaceList = newPlaceList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<NewPlace> getNewPlaceList() {
        return newPlaceList;
    }

    public void setNewPlaceList(List<NewPlace> newPlaceList) {
        this.newPlaceList = newPlaceList;
    }

    @Override
    public String toString() {
        return "Result{" +
                "student=" + student +
                ", newPlaceList=" + newPlaceList +
                '}';
    }
}
