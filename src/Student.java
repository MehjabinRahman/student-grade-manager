public class Student {
    private final String name;
    private final int mark;
    private final String grade;
    private final String result;

    public Student(String name, int mark, String grade, String result) {
        this.name = name;
        this.mark = mark;
        this.grade = grade;
        this.result = result;
    }

    public String getName() { return name; }
    public int getMark() { return mark; }
    public String getGrade() { return grade; }
    public String getResult() { return result; }

    public String toCsv() {
        return name + "," + mark + "," + grade + "," + result;
    }

    public static Student fromCsv(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) return null;

        String name = parts[0].trim();
        int mark = Integer.parseInt(parts[1].trim());
        String grade = parts[2].trim();
        String result = parts[3].trim();

        return new Student(name, mark, grade, result);
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Mark: " + mark + " | Grade: " + grade + " | Result: " + result;
    }
}
