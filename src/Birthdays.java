// London Paris
// IT-CS-142-Assignment-02

import java.util.Scanner;

public class Birthdays {
    private static final Scanner input = new Scanner(System.in);
    private static int todaysMonth, todaysDate, person1Month, person1Day, person2Month, person2Day;

    public static void main(String[] args) {
        do {
            introduction();
            System.out.println("What is today's month and day?");
            todaysMonth = input.nextInt();
            todaysDate = input.nextInt();
            int todaysAbsoluteDay = calculateAbsoluteDay(todaysMonth, todaysDate);

            System.out.print("Today is " + todaysMonth + "/" + todaysDate + "/2020, ");
            System.out.println("day #" + todaysAbsoluteDay + " of the year.");

            int daysUntilBDay1 = person1(todaysAbsoluteDay);
            int daysUntilBDay2 = person2(todaysAbsoluteDay);

            comparison(todaysAbsoluteDay);

            System.out.println();
        } while (userWantsToRepeat());
        System.out.println("Thank you for using the program. Have a good day!");
    }

    public static void introduction() {
        System.out.println("This program compares two birthdays\nand displays which one is sooner.");
    }

    public static int person1(int todaysAbsoluteDay) {
        System.out.println("Person 1:");
        System.out.println("What month and day were you born?");
        person1Month = input.nextInt();
        person1Day = input.nextInt();

        return displayBirthdayInfo("Person 1", person1Month, person1Day, todaysAbsoluteDay);

    }

    public static int person2(int todaysAbsoluteDay) {
        System.out.println("Person 2:");
        System.out.println("What month and day were you born?");
        person2Month = input.nextInt();
        person2Day = input.nextInt();

        return displayBirthdayInfo("Person 2", person2Month, person2Day, todaysAbsoluteDay);
    }

    private static int displayBirthdayInfo(String person, int month, int day, int todaysAbsoluteDay) {
        int birthdayAbsolute = calculateAbsoluteDay(month, day);
        System.out.printf("%d/%d/2020 falls on day #%d of 366.\n", month, day, birthdayAbsolute);

        int daysUntilBDay = daysUntilBDay(todaysAbsoluteDay, birthdayAbsolute);
        System.out.println("Your next birthday is in " + daysUntilBDay + " day(s).");

        double percentage = percentageLeft(todaysAbsoluteDay, birthdayAbsolute);
        System.out.printf("That is %.1f%% of a year away.\n\n", percentage);

        return daysUntilBDay;
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

    public static int daysUntilBDay(int todaysAbsoluteDay, int birthdayAbsolute) {
        int yearDays = 366;
        if (birthdayAbsolute >= todaysAbsoluteDay) {
            return birthdayAbsolute - todaysAbsoluteDay;
        } else {
            return (yearDays - todaysAbsoluteDay) + birthdayAbsolute;
        }
    }

    public static double percentageLeft(int todaysAbsoluteDay, int birthdayAbsolute) {
        int daysUntilBDay = daysUntilBDay(todaysAbsoluteDay, birthdayAbsolute);
        return (double) daysUntilBDay / 366 * 100;
    }

    public static void comparison(int todaysAbsoluteDay) {
        int daysUntilBDay1 = daysUntilBDay(todaysAbsoluteDay, calculateAbsoluteDay(person1Month, person1Day));
        int daysUntilBDay2 = daysUntilBDay(todaysAbsoluteDay, calculateAbsoluteDay(person2Month, person2Day));

        if (daysUntilBDay1 < daysUntilBDay2) {
            System.out.println("Person 1's birthday is closer.\n");
            printFunFact(person1Month, person1Day); // Only call here for Person 1
        } else if (daysUntilBDay1 > daysUntilBDay2) {
            System.out.println("Person 2's birthday is closer.\n");
            printFunFact(person2Month, person2Day); // Only call here for Person 2
        } else {
            System.out.println("Wow, you share the same birthday!\n");
            printFunFact(person1Month, person1Day); // Called here for either, since it's the same birthday
        }
    }



    public static void printFunFact(int month, int day) {
        String funFact = "";
        // Example fun facts based on month and day
        if (month == 1 && day == 1) {
            funFact = "Did you know? January 1st is New Year's Day, celebrated worldwide.";
        } else if (month == 2 && day == 14) {
            funFact = "Did you know? February 14th is Valentine's Day, a day to celebrate love and affection.";
        } else if (month == 3 && day == 14) {
            funFact = "Did you know? March 14th is Pi Day, celebrating the mathematical constant π (pi).";
        } else if (month == 4 && day == 1) {
            funFact = "Did you know? April 1st is April Fool's Day, known for pranks and jokes.";
        } else if (month == 7 && day == 20) {
            funFact = "Did you know? July 20th, 1969, is the day Apollo 11 landed on the moon.";
        } else if (month == 10 && day == 31) {
            funFact = "Did you know? October 31st is Halloween, a day for costumes and trick-or-treating.";
        } else if (month == 12 && day == 25) {
            funFact = "Did you know? December 25th is Christmas Day, celebrated as the birth of Jesus Christ.";
        } else {
            funFact = "Every day is special. Today's a great day to learn something new!";
        }

        System.out.println(funFact);
    }


    public static boolean userWantsToRepeat() {
        System.out.println("Would you like to compare two more birthdays?");
        System.out.println("Type 1 for yes, 2 for no:");
        int choice = input.nextInt();
        return choice == 1;
    }
}
