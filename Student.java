


public class Student {
  private String name;
  private int number;
  private String git;

    public Student(String name, int number, String git) {
        this.name = name;
        this.number = number;
        this.git = git;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", git='" + git + '\'' +
                '}';
    }
}
