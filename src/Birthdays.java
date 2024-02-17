// London Paris
// IT-CS-142-Assignment-02
import java.util.*;

public class Birthdays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int todaysMonth, todaysDate, person1Month, person1Day, person2Month, person2Day;
        do {
            // Here are some lines that might save you a bit of time as you write your code:
            System.out.println("This program compares two birthdays");
            System.out.println("and displays which one is sooner.");
            System.out.println("What is today's month and day?");
            todaysMonth = input.nextInt();
            todaysDate = input.nextInt();
            calculateAbsoluteDay(todaysMonth, todaysDate);
            // System.out.println("Today is //2020, day # of the year.");

            System.out.println("Person 1:");
            System.out.print("What month and day were you born? "); // 10 17
            person1Month = input.nextInt();
            person1Day = input.nextInt();

            // 10/17/2020 falls on day #291 of 366.
            // Your next birthday is in 262 day(s).
            // That is 71.6 percent of a year away.
        } while (userWantsToRepeat(3));
    }
    public static int calculateAbsoluteDay(int month, int day) {
        int absoluteDay = 0;

        // cumulative sum algorithm
        for (int i = 1; i <= month; i++) {
            int days;
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 12) {
                days = 31;
            } else if (i == 2) {
                days = 29;
            } else {
                days = 30;
            }
            absoluteDay += days;
        }
        // Add the day of the given month
        absoluteDay += day;
        return absoluteDay;
    }

    public static int getDaysInMonth(int month) {
        // Return days based on month
        int days;
        if (month == 2) {
            days = 29;
        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            days = 31;
        } else {
            days = 30;
        }
        return days;
    }

    public static boolean userWantsToRepeat(int input) {
        boolean userWantsToRepeat;
        if (input == 1) {
            userWantsToRepeat = true;
        } else {
            userWantsToRepeat = false;
        }
        return userWantsToRepeat;
    }
}
