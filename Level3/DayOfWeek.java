package Level3;

public class DayOfWeek {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java DayOfWeek <month> <day> <year>");
            System.exit(1);
        }

        try {
            int month = Integer.parseInt(args[0]);
            int day = Integer.parseInt(args[1]);
            int year = Integer.parseInt(args[2]);

            if (!isValidDate(month, day, year)) {
                System.err.println("Invalid date.");
                System.exit(1);
            }

            int y0 = year - (14 - month) / 12;
            int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
            int m0 = month + 12 * ((14 - month) / 12) - 2;
            int d0 = (day + x + 31 * m0 / 12) % 7;

            System.out.println("Day of the week: " + d0); 

        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + e.getMessage());
            System.exit(1);
        }
    }

    private static boolean isValidDate(int month, int day, int year) {
        if (month < 1 || month > 12) {
            return false;
        }

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            daysInMonth[1] = 29; 
        }

        if (day < 1 || day > daysInMonth[month - 1]) {
            return false;
        }

        return true;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
