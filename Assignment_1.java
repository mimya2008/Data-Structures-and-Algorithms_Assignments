import java.util.Arrays;
import java.util.Scanner;

public class Assignment_1 {
    public static void main(String[] args) {
        System.out.print("Enter number of days for temperature: ");
        Scanner scanner = new Scanner(System.in);
        //Declaring the days I want to take
        int numDays = scanner.nextInt();

        //initializing sum of temperature
        double sum = 0;

        //putting exact values into array
        double[] temps = new double[numDays];

        // taking the number and adding up
        for (int i = 0; i < numDays; i++) {
            System.out.print("Enter temperature " + (i + 1) + ": ");
            temps[i] = scanner.nextDouble();
            sum += temps[i];
        }

        System.out.println("All temperatures: " + Arrays.toString(temps));

        // calculating avg temp
        double avg = sum / numDays;
        System.out.println("Average temperature: " + avg);

        //initializing countAboveAvg
        int countAboveAvg = 0;
        // above avg temp
        for (double temp : temps) {
            if (temp > avg) {
                countAboveAvg++;
            }
        }

        System.out.println("Num days above average temperature: " + countAboveAvg);

    }
}
