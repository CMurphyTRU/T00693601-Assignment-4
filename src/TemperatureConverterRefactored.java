import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperatureConverterRefactored {

    // =========== Constants ==============
    private static final double FAHRENHEIT_SCALE = 9.0 / 5.0;
    private static final double KELVIN_OFFSET = 273.15;
    private static final int MIN_MENU_OPTION = 1;
    private static final int MAX_MENU_OPTION = 4;

    // ============ Conversion Methods  ==========
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * FAHRENHEIT_SCALE + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) / FAHRENHEIT_SCALE;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + KELVIN_OFFSET;
    }

    //============== Menu Display ===============================
    public static void displayMenu()
    {
        System.out.println("\nTemperature Converter Menu");
        System.out.println("1. Convert Celsius to Fahrenheit");
        System.out.println("2. Convert Fahrenheit to Celsius");
        System.out.println("3. Convert Celsius to Kelvin");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1–4): ");
    }

    // =================== Safe Input Helpers ===================================================
    private static int getValidMenuChoice(Scanner scanner)
    {
        while (true)
        {
            try
            {
                int choice = scanner.nextInt();

                if (choice >= MIN_MENU_OPTION && choice <= MAX_MENU_OPTION)
                {
                    return choice;
                }

                System.out.println("Invalid choice. Please Enter a Number Between 1 and 4: ");
            }

            catch (InputMismatchException e)
            {
                System.out.println("Invalid Input. Please Enter a Whole Number (1-4): ");
                scanner.nextLine(); // clear bad input
            }
        }
    }

    private static double getValidTemperature(Scanner scanner, String prompt)
    {
        while (true)
        {
            System.out.print(prompt);

            try
            {
                return scanner.nextDouble();
            }

            catch (InputMismatchException e)
            {
                System.out.println("Invalid Temperature. Please Enter a Valid number");
                scanner.nextLine(); // clear bad input
            }
        }
    }

    // ================== Main Program ==========================================================
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter V2");

        while (true)
        {
            displayMenu();

            int choice = getValidMenuChoice(scanner);

            if (choice == 4)
            {
                System.out.println("Goodbye!");
                break;
            }

            double inputTemp = getValidTemperature(scanner, "Enter Temperature: ");
            double result;

            switch (choice)
            {
                case 1:
                    result = celsiusToFahrenheit(inputTemp);
                    System.out.println("Result: " + result + " °F");
                    break;

                case 2:
                    result = fahrenheitToCelsius(inputTemp);
                    System.out.println("Result: " + result + " °C");
                    break;

                case 3:
                    result = celsiusToKelvin(inputTemp);
                    System.out.println("Result: " + result + " K");
                    break;

                default:
                    // Should never happen
                    System.out.println("Unexpected Error.");
                    break;
            }
        }

        scanner.close();
    }

}