import java.util.Arrays;


public class MovieTheatreImplementation {
    int[][] seats;

    public MovieTheatreImplementation(int rows, int cols) {
        seats = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(seats[i], Integer.MIN_VALUE);  // All seats available
        }
    }

    public void reserveSeat(int row, int col) {
        try {
            if (seats[row][col] == Integer.MIN_VALUE) {
                seats[row][col] = 1;
                System.out.println("Seat (" + row + "," + col + ") successfully reserved.");
            } else {
                System.out.println("Seat is taken. Suggesting next available seat...");
                suggestAvailableSeat();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat position.");
        }
    }

    public void cancelSeat(int row, int col) {
        try {
            if (seats[row][col] == 1) {
                seats[row][col] = Integer.MIN_VALUE;
                System.out.println("Reservation at (" + row + "," + col + ") canceled.");
            } else {
                System.out.println("Seat is already available.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat position.");
        }
    }

    public void printSeatingChart() {
        System.out.println("Current Seating Chart:");
        for (int[] row : seats) {
            for (int seat : row) {
                System.out.print(seat == Integer.MIN_VALUE ? "[O]" : "[X]");
            }
            System.out.println();
        }
    }

    public void suggestAvailableSeat() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                if (seats[i][j] == Integer.MIN_VALUE) {
                    System.out.println("Try seat (" + i + "," + j + ")");
                    return;
                }
            }
        }
        System.out.println("Sorry, no available seats.");
    }

    public static void main(String[] args) {
        MovieTheatreImplementation theatre = new MovieTheatreImplementation(5, 5);
        theatre.printSeatingChart();

        theatre.reserveSeat(2, 3);
        theatre.reserveSeat(3, 3);
        theatre.reserveSeat(1, 2);
        theatre.reserveSeat(2, 3); // Already taken, should suggest
        theatre.cancelSeat(3, 3);
        theatre.printSeatingChart();
    }
}

