import java.io.IOException;
import java.util.*;

public class Main {
    private static final String DATA_FILE = "data/students.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRepository repo = new StudentRepository(DATA_FILE);

        while (true) {
            System.out.println("\n==== Student Grade Manager ====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Class Statistics");
            System.out.println("5. Sort Students by Mark (High -> Low)");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addStudent(scanner, repo);
                    break;
                case "2":
                    viewStudents(repo);
                    break;
                case "3":
                    searchByName(scanner, repo);
                    break;
                case "4":
                    showStatistics(repo);
                    break;
                case "5":
                    sortByMark(repo);
                    break;
                case "6":
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner, StudentRepository repo) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        int mark = readMark(scanner);
        String[] calc = GradeCalculator.calculate(mark);

        Student student = new Student(name, mark, calc[0], calc[1]);

        try {
            repo.save(student);
            System.out.println("Student saved: " + student);
        } catch (IOException e) {
            System.out.println("Error saving student: " + e.getMessage());
        }
    }

    private static void viewStudents(StudentRepository repo) {
        try {
            List<Student> students = repo.findAll();
            if (students.isEmpty()) {
                System.out.println("No student records found.");
                return;
            }
            System.out.println("\n--- Student Records ---");
            for (Student s : students) System.out.println(s);

        } catch (IOException e) {
            System.out.println("Error reading students: " + e.getMessage());
        }
    }

    private static void searchByName(Scanner scanner, StudentRepository repo) {
        System.out.print("Enter name to search: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        try {
            List<Student> students = repo.findAll();
            List<Student> matches = new ArrayList<>();

            for (Student s : students) {
                if (s.getName().toLowerCase().contains(keyword)) {
                    matches.add(s);
                }
            }

            if (matches.isEmpty()) {
                System.out.println("No matching students found.");
            } else {
                System.out.println("\n--- Search Results ---");
                for (Student s : matches) System.out.println(s);
            }

        } catch (IOException e) {
            System.out.println("Error searching students: " + e.getMessage());
        }
    }

    private static void showStatistics(StudentRepository repo) {
        try {
            List<Student> students = repo.findAll();
            if (students.isEmpty()) {
                System.out.println("No student data available for statistics.");
                return;
            }

            double avg = StudentStats.averageMark(students);
            double passRate = StudentStats.passRate(students);
            Map<String, Integer> gradeCounts = StudentStats.gradeCounts(students);

            System.out.println("\n--- Class Statistics ---");
            System.out.printf("Total Students: %d%n", students.size());
            System.out.printf("Average Mark: %.2f%n", avg);
            System.out.printf("Pass Rate: %.2f%%%n", passRate);

            System.out.println("Grade Distribution:");
            for (String g : Arrays.asList("A", "B", "C", "D", "F")) {
                System.out.printf("  %s: %d%n", g, gradeCounts.getOrDefault(g, 0));
            }

        } catch (IOException e) {
            System.out.println("Error computing statistics: " + e.getMessage());
        }
    }

    private static void sortByMark(StudentRepository repo) {
        try {
            List<Student> students = repo.findAll();
            if (students.isEmpty()) {
                System.out.println("No student records found.");
                return;
            }

            students.sort((a, b) -> Integer.compare(b.getMark(), a.getMark()));

            System.out.println("\n--- Students Sorted by Mark (High -> Low) ---");
            for (Student s : students) System.out.println(s);

        } catch (IOException e) {
            System.out.println("Error sorting students: " + e.getMessage());
        }
    }

    private static int readMark(Scanner scanner) {
        while (true) {
            System.out.print("Enter mark (0-100): ");
            String input = scanner.nextLine().trim();
            try {
                int mark = Integer.parseInt(input);
                if (mark < 0 || mark > 100) {
                    System.out.println("Mark must be between 0 and 100.");
                } else {
                    return mark;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
