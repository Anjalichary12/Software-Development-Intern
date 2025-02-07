import java.util.Scanner;

 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter the temperature value
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();
        
        // Prompt the user to enter the original unit (C, F, or K)
        System.out.print("Enter the original unit (C for Celsius, F for Fahrenheit, K for Kelvin): ");
        char unit = scanner.next().toUpperCase().charAt(0);
        
        // Variables to store converted values
        double celsius, fahrenheit, kelvin;
        
        // Convert based on the original unit
        switch (unit) {
            case 'C':
                celsius = temperature;
                fahrenheit = celsiusToFahrenheit(celsius);
                kelvin = celsiusToKelvin(celsius);
                break;
            case 'F':
                fahrenheit = temperature;
                celsius = fahrenheitToCelsius(fahrenheit);
                kelvin = celsiusToKelvin(celsius);
                break;
            case 'K':
                kelvin = temperature;
                celsius = kelvinToCelsius(kelvin);
                fahrenheit = celsiusToFahrenheit(celsius);
                break;
            default:
                System.out.println("Invalid unit! Please enter C, F, or K.");
                scanner.close();
                return;
        }
        
        // Display the converted temperatures
        System.out.printf("Celsius: %.2f°C\n", celsius);
        System.out.printf("Fahrenheit: %.2f°F\n", fahrenheit);
        System.out.printf("Kelvin: %.2fK\n", kelvin);
        
        scanner.close();
    }
    
    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
    
    // Method to convert Celsius to Kelvin
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
    
    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
    
    // Method to convert Kelvin to Celsius
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
}
