// London Paris
// IT-CS-142-Assignment-02
//import java.util.*;
import java.util.*;

public class Birthdays {
    private static final Scanner input = new Scanner(System.in);
    private static int todaysMonth, todaysDate;

    public static void main(String[] args) {

        do {
            introduction();

            System.out.println("What is today's month and day?");
            todaysMonth = input.nextInt();
            todaysDate = input.nextInt();
            int todaysAbsoluteDay = calculateAbsoluteDay(todaysMonth, todaysDate);

            System.out.print("Today is " + todaysMonth + "/" + todaysDate + "/2020, ");
            System.out.println("day " + todaysAbsoluteDay + " of the year.");

            person1(todaysAbsoluteDay);
            person2(todaysAbsoluteDay);

            System.out.println();
        } while (userWantsToRepeat());
    }

    public static void introduction() {
        System.out.println("This program compares two birthdays");
        System.out.println("and displays which one is sooner.");
    }

    public static int getDate(int month, int day) {
        return calculateAbsoluteDay(month, day); // This seems redundant; consider using calculateAbsoluteDay directly.
    }

    public static void person1(int todaysAbsoluteDay) {
        System.out.println("Person 1:");
        int person1Month = input.nextInt();
        int person1Day = input.nextInt();

        displayBirthdayInfo("Person 1", person1Month, person1Day, todaysAbsoluteDay);
    }

    public static void person2(int todaysAbsoluteDay) {
        System.out.println("Person 2:");
        int person2Month = input.nextInt();
        int person2Day = input.nextInt();

        displayBirthdayInfo("Person 2", person2Month, person2Day, todaysAbsoluteDay);
    }

    // Consolidated the display logic for both persons into a single method to avoid redundancy
    private static void displayBirthdayInfo(String person, int month, int day, int todaysAbsoluteDay) {
        int birthdayAbsolute = calculateAbsoluteDay(month, day);
        System.out.printf("%s's birthday on %d/%d/2020 falls on day #%d of 366.\n", person, month, day, birthdayAbsolute);

        int daysUntilBDay = daysUntilBDay(todaysAbsoluteDay, month, day);
        System.out.println("Their next birthday is in " + daysUntilBDay + " day(s).");

        double percentage = percentageLeft(todaysAbsoluteDay, month, day);
        System.out.printf("That is %.1f%% of a year away.\n", percentage);
    }

    public static int calculateAbsoluteDay(int month, int day) {
        int absoluteDay = 0;
        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                absoluteDay += 31;
            } else if (i == 2) {
                absoluteDay += 29;
            } else {
                absoluteDay += 30;
            }
        }
        absoluteDay += day;
        return absoluteDay;
    }

    public static int daysUntilBDay(int todaysAbsoluteDay, int month, int day) {
        int birthdayAbsolute = calculateAbsoluteDay(month, day);
        int yearDays = 366; // Assuming leap year

        if (birthdayAbsolute >= todaysAbsoluteDay) {
            return birthdayAbsolute - todaysAbsoluteDay;
        } else {
            return (yearDays - todaysAbsoluteDay) + birthdayAbsolute;
        }
    }

    public static double percentageLeft(int todaysAbsoluteDay, int month, int day) {
        int daysUntilBDay = daysUntilBDay(todaysAbsoluteDay, month, day);
        return (double) daysUntilBDay / 366 * 100;
    }

    public static boolean userWantsToRepeat() {
        System.out.println("Would you like to compare two more birthdays?");
        System.out.println("Type 1 and then <enter/return> to compare two more birthdays");
        System.out.println("Type 2 <enter/return> to end the program");
        int choice = input.nextInt();
        return choice == 1;
    }
}

