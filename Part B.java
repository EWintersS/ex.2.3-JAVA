import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;
    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class PartB {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
            new Student("Ravi", 82),
            new Student("Anita", 74),
            new Student("Karan", 90),
            new Student("Meera", 67)
        );

        list.stream()
            .filter(s -> s.marks > 75)
            .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks))
            .map(s -> s.name)
            .forEach(System.out::println);
    }
}
