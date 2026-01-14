import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentStats {

    public static double averageMark(List<Student> students) {
        if (students == null || students.isEmpty()) return 0.0;

        int sum = 0;
        for (Student s : students) sum += s.getMark();
        return (double) sum / students.size();
    }

    public static double passRate(List<Student> students) {
        if (students == null || students.isEmpty()) return 0.0;

        int passCount = 0;
        for (Student s : students) {
            if ("Pass".equalsIgnoreCase(s.getResult())) passCount++;
        }
        return (passCount * 100.0) / students.size();
    }

    public static Map<String, Integer> gradeCounts(List<Student> students) {
        Map<String, Integer> counts = new HashMap<>();
        if (students == null) return counts;

        for (Student s : students) {
            String grade = s.getGrade().toUpperCase();
            counts.put(grade, counts.getOrDefault(grade, 0) + 1);
        }
        return counts;
    }
}
