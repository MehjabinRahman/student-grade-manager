public class GradeCalculator {

    // Returns String[] = {grade, result}
    public static String[] calculate(int mark) {
        if (mark >= 85) return new String[]{"A", "Pass"};
        if (mark >= 70) return new String[]{"B", "Pass"};
        if (mark >= 60) return new String[]{"C", "Pass"};
        if (mark >= 50) return new String[]{"D", "Pass"};
        return new String[]{"F", "Fail"};
    }
}
