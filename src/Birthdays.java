// London Paris
// IT-CS-142-Assignment-02

import java.util.Scanner;

public class Birthdays {
    // Global variables
    private static final Scanner input = new Scanner(System.in);
    private static int todaysMonth, todaysDate, person1Month, person1Day, person2Month, person2Day;

    public static void main(String[] args) {
        do {
            // preliminary information gather
            introduction();
            System.out.println("What is today's month and day?");
            todaysMonth = input.nextInt();
            todaysDate = input.nextInt();
            int todaysAbsoluteDay = calculateAbsoluteDay(todaysMonth, todaysDate);

            // absolute date display
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

    // displaying information (adaptable to either person)
    private static int displayBirthdayInfo(String person, int month, int day, int todaysAbsoluteDay) {
        int birthdayAbsolute = calculateAbsoluteDay(month, day);
        System.out.printf("%d/%d/2020 falls on day #%d of 366.\n", month, day, birthdayAbsolute);

        int daysUntilBDay = daysUntilBDay(todaysAbsoluteDay, birthdayAbsolute);
        System.out.println("Your next birthday is in " + daysUntilBDay + " day(s).");

        double percentage = percentageLeft(todaysAbsoluteDay, birthdayAbsolute);
        System.out.printf("That is %.1f%% of a year away.\n\n", percentage);

        return daysUntilBDay;
    }

    // day, in the year, out of 366
    public static int calculateAbsoluteDay(int month, int day) {
        int absoluteDay = 0;
        for (int i = 1; i < month; i++) {
            // months with 31 days
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                absoluteDay += 31;
            } else if (i == 2) {
                absoluteDay += 29; // leap year february
            } else {
                absoluteDay += 30;
            }
        }
        absoluteDay += day;
        return absoluteDay;
    }

    // days until next birthday calculation
    public static int daysUntilBDay(int todaysAbsoluteDay, int birthdayAbsolute) {
        int yearDays = 366; // assuming leap year
        if (birthdayAbsolute >= todaysAbsoluteDay) {
            return birthdayAbsolute - todaysAbsoluteDay;
        } else {
            return (yearDays - todaysAbsoluteDay) + birthdayAbsolute;
        }
    }

    // percentage calculation
    public static double percentageLeft(int todaysAbsoluteDay, int birthdayAbsolute) {
        int daysUntilBDay = daysUntilBDay(todaysAbsoluteDay, birthdayAbsolute);
        return (double) daysUntilBDay / 366 * 100;
    }

    public static void comparison(int todaysAbsoluteDay) {
        // using absolute day method to calculate days until next birthday
        int daysUntilBDay1 = daysUntilBDay(todaysAbsoluteDay, calculateAbsoluteDay(person1Month, person1Day));
        int daysUntilBDay2 = daysUntilBDay(todaysAbsoluteDay, calculateAbsoluteDay(person2Month, person2Day));

        // comparison of birthdays logic
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
        // January
        if (month == 1 && day == 1) {
            funFact = "Did you know? January 1st is New Year's Day, celebrated worldwide.";
        } else if (month == 1 && day == 24) {
            funFact = "Did you know? January 24th is the International Day of Education.";
        }
        // February
        else if (month == 2 && day == 14) {
            funFact = "Did you know? February 14th is Valentine's Day, a day to celebrate love and affection.";
        } else if (month == 2 && day == 29) {
            funFact = "Did you know? February 29th is Leap Day, occurring only in leap years.";
        }
        // March
        else if (month == 3 && day == 8) {
            funFact = "Did you know? March 8th is International Women's Day.";
        } else if (month == 3 && day == 14) {
            funFact = "Did you know? March 14th is Pi Day, celebrating the mathematical constant π (pi).";
        }
        // April
        else if (month == 4 && day == 1) {
            funFact = "Did you know? April 1st is April Fool's Day, known for pranks and jokes.";
        } else if (month == 4 && day == 22) {
            funFact = "Did you know? April 22nd is Earth Day, promoting environmental protection.";
        }
        // May
        else if (month == 5 && day == 4) {
            funFact = "Did you know? May the 4th is considered Star Wars Day. May the Fourth be with you!";
        } else if (month == 5 && day == 31) {
            funFact = "Did you know? May 31st is World No Tobacco Day, promoting the cessation of tobacco use.";
        }
        // June
        else if (month == 6 && day == 5) {
            funFact = "Did you know? June 5th is World Environment Day, encouraging awareness and action for the protection of our environment.";
        } else if (month == 6 && day == 21) {
            funFact = "Did you know? June 21st is the Summer Solstice in the Northern Hemisphere, the longest day of the year.";
        }
        // July
        else if (month == 7 && day == 4) {
            funFact = "Did you know? July 4th is Independence Day in the United States, commemorating the Declaration of Independence.";
        } else if (month == 7 && day == 20) {
            funFact = "Did you know? July 20th, 1969, is the day Apollo 11 landed on the moon, marking the first human moon landing.";
        }
        // August
        else if (month == 8 && day == 12) {
            funFact = "Did you know? August 12th is International Youth Day, celebrating young peoples' voices, actions, and initiatives.";
        } else if (month == 8 && day == 26) {
            funFact = "Did you know? August 26th is Women's Equality Day in the United States, commemorating the 1920 adoption of the Nineteenth Amendment.";
        }
        // September
        else if (month == 9 && day == 5) {
            funFact = "Did you know? September 5th is International Day of Charity, recognized by the United Nations.";
        } else if (month == 9 && day == 21) {
            funFact = "Did you know? September 21st is the International Day of Peace, dedicated to world peace.";
        }
        // October
        else if (month == 10 && day == 1) {
            funFact = "Did you know? October 1st is International Coffee Day, a day to celebrate and enjoy coffee.";
        } else if (month == 10 && day == 31) {
            funFact = "Did you know? October 31st is Halloween, a day for costumes, trick-or-treating, and spooky festivities.";
        }
        // November
        else if (month == 11 && day == 11) {
            funFact = "Did you know? November 11th is Remembrance Day (also known as Armistice Day) in many countries, commemorating the end of World War I.";
        } else if (month == 11 && day == 30) {
            funFact = "Did you know? November 30th is St. Andrew's Day, celebrating the patron saint of Scotland.";
        }
        // December
        else if (month == 12 && day == 25) {
            funFact = "Did you know? December 25th is Christmas Day, celebrated as the birth of Jesus Christ.";
        } else if (month == 12 && day == 31) {
            funFact = "Did you know? December 31st is New Year's Eve, marking the final day of the Gregorian year.";
        }
        // Default message for dates not covered
        else {
            funFact = "Every day is special. Today's a great day to learn something new!";
        }

        System.out.println(funFact);
    }


    public static boolean userWantsToRepeat() {
        System.out.println("Would you like to compare two more birthdays?");
        System.out.println("Type 1 and then <enter/return> to compare two more birthdays\nType 2<enter/return> to end the program");
        int choice = input.nextInt();
        return choice == 1;
    }
}
