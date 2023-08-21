import java.util.ArrayList;
import java.util.List;

public class TestProgram {

    public static double originalProgram(double A, double B) {
        A = A - B;
        double C = A * 2;
        return C;
    }

    public static List<Double> incorrectPrograms(double A, double B) {
        List<Double> incorrectResults = new ArrayList<>();
        
        // For incorrect "-" operator
        incorrectResults.add((A + B) * 2);
        incorrectResults.add((A * B) * 2);
        incorrectResults.add((A / B) * 2);

        // For incorrect "*" operator
        incorrectResults.add(A - B + 2);
        incorrectResults.add(A - B - 2);
        incorrectResults.add((A - B) / 2);

        // For both incorrect
        incorrectResults.add((A + B) + 2);
        incorrectResults.add((A * B) + 2);
        incorrectResults.add((A / B) + 2);
        incorrectResults.add((A + B) - 2);
        incorrectResults.add((A * B) - 2);
        incorrectResults.add((A / B) - 2);
        incorrectResults.add((A + B) / 2);
        incorrectResults.add((A * B) / 2);
        incorrectResults.add((A / B) / 2);
        
        return incorrectResults;
    }

    public static void main(String[] args) {
        double B = 1;
        List<Double> correctValues = new ArrayList<>();

        for (double A = -10; A <= 10; A++) {
            double origResult = originalProgram(A, B);
            boolean isCorrectValues = true;
            
            for (double incorrectResult : incorrectPrograms(A, B)) {
                if (origResult == incorrectResult) {
                    isCorrectValues = false;
                    break;  // This A value gives the same result in incorrect program
                }
            }
            
            if (isCorrectValues) {
                correctValues.add(A);
            }
        }

        System.out.println("Correct test A values for B=1 are: " + correctValues);
    }
}
