import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final String filePath;

    public StudentRepository(String filePath) {
        this.filePath = filePath;
    }

    public void save(Student student) throws IOException {
        File file = new File(filePath);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) parent.mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(student.toCsv());
            writer.newLine();
        }
    }

    public List<Student> findAll() throws IOException {
        List<Student> students = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) return students;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                Student s = Student.fromCsv(line);
                if (s != null) students.add(s);
            }
        }
        return students;
    }
}
