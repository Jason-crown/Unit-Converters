package java_converter.src;
import java.util.Scanner;

public class UnitConverter {

    private final Scanner scanner;
    private final InputHelper inputHelper;

    public UnitConverter() {
        scanner = new Scanner(System.in);
        inputHelper = new InputHelper(scanner);
    }

    public void start() {

        System.out.println("=================================");
        System.out.println("         JAVA UNIT CONVERTER");
        System.out.println("=================================");

        boolean running = true;

        while (running) {

            displayMainMenu();

            int choice = inputHelper.readInt(
                    "\nSelect a conversion category: ",
                    1,
                    6
            );

            System.out.println();

            switch (choice) {
                case 1:
                    convertLength();
                    break;

                case 2:
                    convertWeight();
                    break;

                case 3:
                    convertTemperature();
                    break;

                case 4:
                    convertTime();
                    break;

                case 5:
                    convertVolume();
                    break;

                case 6:
                    running = false;
                    continue;

                default:
                    System.out.println("Invalid option.");
            }

            if (!inputHelper.askToContinue()) {
                running = false;
            }

            System.out.println();
        }

        System.out.println("\nThank you for using the Unit Converter!");
        scanner.close();
    }

    private void displayMainMenu() {

        System.out.println("\n---------- MAIN MENU ----------");
        System.out.println("1. Length");
        System.out.println("2. Weight");
        System.out.println("3. Temperature");
        System.out.println("4. Time");
        System.out.println("5. Volume");
        System.out.println("6. Exit");
    }

    // =========================================================
    // LENGTH
    // =========================================================

    private void convertLength() {

        System.out.println("---------- LENGTH ----------");
        System.out.println("1. Millimeters");
        System.out.println("2. Centimeters");
        System.out.println("3. Meters");
        System.out.println("4. Kilometers");
        System.out.println("5. Inches");
        System.out.println("6. Feet");
        System.out.println("7. Yards");
        System.out.println("8. Miles");

        int fromUnit = inputHelper.readInt(
                "\nConvert FROM: ",
                1,
                8
        );

        int toUnit = inputHelper.readInt(
                "Convert TO: ",
                1,
                8
        );

        double value = inputHelper.readDouble(
                "Enter value: "
        );

        double meters = lengthToMeters(value, fromUnit);

        double result = metersToLength(meters, toUnit);

        printResult(
                value,
                getLengthUnitName(fromUnit),
                result,
                getLengthUnitName(toUnit)
        );
    }

    private double lengthToMeters(double value, int unit) {

        switch (unit) {

            case 1:
                return value / 1000.0;

            case 2:
                return value / 100.0;

            case 3:
                return value;

            case 4:
                return value * 1000.0;

            case 5:
                return value * 0.0254;

            case 6:
                return value * 0.3048;

            case 7:
                return value * 0.9144;

            case 8:
                return value * 1609.344;

            default:
                return value;
        }
    }

    private double metersToLength(double meters, int unit) {

        switch (unit) {

            case 1:
                return meters * 1000.0;

            case 2:
                return meters * 100.0;

            case 3:
                return meters;

            case 4:
                return meters / 1000.0;

            case 5:
                return meters / 0.0254;

            case 6:
                return meters / 0.3048;

            case 7:
                return meters / 0.9144;

            case 8:
                return meters / 1609.344;

            default:
                return meters;
        }
    }

    private String getLengthUnitName(int unit) {

        switch (unit) {

            case 1:
                return "millimeters";

            case 2:
                return "centimeters";

            case 3:
                return "meters";

            case 4:
                return "kilometers";

            case 5:
                return "inches";

            case 6:
                return "feet";

            case 7:
                return "yards";

            case 8:
                return "miles";

            default:
                return "";
        }
    }

    // =========================================================
    // WEIGHT
    // =========================================================

    private void convertWeight() {

        System.out.println("---------- WEIGHT ----------");
        System.out.println("1. Milligrams");
        System.out.println("2. Grams");
        System.out.println("3. Kilograms");
        System.out.println("4. Ounces");
        System.out.println("5. Pounds");

        int fromUnit = inputHelper.readInt(
                "\nConvert FROM: ",
                1,
                5
        );

        int toUnit = inputHelper.readInt(
                "Convert TO: ",
                1,
                5
        );

        double value = inputHelper.readDouble(
                "Enter value: "
        );

        double kilograms = weightToKilograms(value, fromUnit);

        double result = kilogramsToWeight(kilograms, toUnit);

        printResult(
                value,
                getWeightUnitName(fromUnit),
                result,
                getWeightUnitName(toUnit)
        );
    }

    private double weightToKilograms(double value, int unit) {

        switch (unit) {

            case 1:
                return value / 1_000_000.0;

            case 2:
                return value / 1000.0;

            case 3:
                return value;

            case 4:
                return value * 0.028349523125;

            case 5:
                return value * 0.45359237;

            default:
                return value;
        }
    }

    private double kilogramsToWeight(double kilograms, int unit) {

        switch (unit) {

            case 1:
                return kilograms * 1_000_000.0;

            case 2:
                return kilograms * 1000.0;

            case 3:
                return kilograms;

            case 4:
                return kilograms / 0.028349523125;

            case 5:
                return kilograms / 0.45359237;

            default:
                return kilograms;
        }
    }

    private String getWeightUnitName(int unit) {

        switch (unit) {

            case 1:
                return "milligrams";

            case 2:
                return "grams";

            case 3:
                return "kilograms";

            case 4:
                return "ounces";

            case 5:
                return "pounds";

            default:
                return "";
        }
    }

    // =========================================================
    // TEMPERATURE
    // =========================================================

    private void convertTemperature() {

        System.out.println("---------- TEMPERATURE ----------");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");

        int fromUnit = inputHelper.readInt(
                "\nConvert FROM: ",
                1,
                3
        );

        int toUnit = inputHelper.readInt(
                "Convert TO: ",
                1,
                3
        );

        double value = inputHelper.readDouble(
                "Enter temperature: "
        );

        double celsius = temperatureToCelsius(value, fromUnit);

        double result = celsiusToTemperature(celsius, toUnit);

        printResult(
                value,
                getTemperatureUnitName(fromUnit),
                result,
                getTemperatureUnitName(toUnit)
        );
    }

    private double temperatureToCelsius(double value, int unit) {

        switch (unit) {

            case 1:
                return value;

            case 2:
                return (value - 32) * 5.0 / 9.0;

            case 3:
                return value - 273.15;

            default:
                return value;
        }
    }

    private double celsiusToTemperature(double celsius, int unit) {

        switch (unit) {

            case 1:
                return celsius;

            case 2:
                return (celsius * 9.0 / 5.0) + 32;

            case 3:
                return celsius + 273.15;

            default:
                return celsius;
        }
    }

    private String getTemperatureUnitName(int unit) {

        switch (unit) {

            case 1:
                return "Celsius";

            case 2:
                return "Fahrenheit";

            case 3:
                return "Kelvin";

            default:
                return "";
        }
    }

    // =========================================================
    // TIME
    // =========================================================

    private void convertTime() {

        System.out.println("---------- TIME ----------");
        System.out.println("1. Seconds");
        System.out.println("2. Minutes");
        System.out.println("3. Hours");
        System.out.println("4. Days");

        int fromUnit = inputHelper.readInt(
                "\nConvert FROM: ",
                1,
                4
        );

        int toUnit = inputHelper.readInt(
                "Convert TO: ",
                1,
                4
        );

        double value = inputHelper.readDouble(
                "Enter value: "
        );

        double seconds = timeToSeconds(value, fromUnit);

        double result = secondsToTime(seconds, toUnit);

        printResult(
                value,
                getTimeUnitName(fromUnit),
                result,
                getTimeUnitName(toUnit)
        );
    }

    private double timeToSeconds(double value, int unit) {

        switch (unit) {

            case 1:
                return value;

            case 2:
                return value * 60;

            case 3:
                return value * 3600;

            case 4:
                return value * 86400;

            default:
                return value;
        }
    }

    private double secondsToTime(double seconds, int unit) {

        switch (unit) {

            case 1:
                return seconds;

            case 2:
                return seconds / 60;

            case 3:
                return seconds / 3600;

            case 4:
                return seconds / 86400;

            default:
                return seconds;
        }
    }

    private String getTimeUnitName(int unit) {

        switch (unit) {

            case 1:
                return "seconds";

            case 2:
                return "minutes";

            case 3:
                return "hours";

            case 4:
                return "days";

            default:
                return "";
        }
    }

    // =========================================================
    // VOLUME
    // =========================================================

    private void convertVolume() {

        System.out.println("---------- VOLUME ----------");
        System.out.println("1. Milliliters");
        System.out.println("2. Liters");
        System.out.println("3. US Cups");
        System.out.println("4. US Fluid Ounces");
        System.out.println("5. US Gallons");

        int fromUnit = inputHelper.readInt(
                "\nConvert FROM: ",
                1,
                5
        );

        int toUnit = inputHelper.readInt(
                "Convert TO: ",
                1,
                5
        );

        double value = inputHelper.readDouble(
                "Enter value: "
        );

        double liters = volumeToLiters(value, fromUnit);

        double result = litersToVolume(liters, toUnit);

        printResult(
                value,
                getVolumeUnitName(fromUnit),
                result,
                getVolumeUnitName(toUnit)
        );
    }

    private double volumeToLiters(double value, int unit) {

        switch (unit) {

            case 1:
                return value / 1000.0;

            case 2:
                return value;

            case 3:
                return value * 0.2365882365;

            case 4:
                return value * 0.0295735295625;

            case 5:
                return value * 3.785411784;

            default:
                return value;
        }
    }

    private double litersToVolume(double liters, int unit) {

        switch (unit) {

            case 1:
                return liters * 1000.0;

            case 2:
                return liters;

            case 3:
                return liters / 0.2365882365;

            case 4:
                return liters / 0.0295735295625;

            case 5:
                return liters / 3.785411784;

            default:
                return liters;
        }
    }

    private String getVolumeUnitName(int unit) {

        switch (unit) {

            case 1:
                return "milliliters";

            case 2:
                return "liters";

            case 3:
                return "US cups";

            case 4:
                return "US fluid ounces";

            case 5:
                return "US gallons";

            default:
                return "";
        }
    }

    // =========================================================
    // OUTPUT
    // =========================================================

    private void printResult(
            double originalValue,
            String originalUnit,
            double result,
            String resultUnit
    ) {

        System.out.println("\n---------- RESULT ----------");

        System.out.printf(
                "%.4f %s = %.4f %s%n",
                originalValue,
                originalUnit,
                result,
                resultUnit
        );
    }
}