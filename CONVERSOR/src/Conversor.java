import java.util.Scanner;

public class Conversor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        CurrencyService currencyService = new CurrencyService();

        System.out.println(
                "*************************************\nBienvenido al convertidor de divisas\n*************************************");

        while (true) {
            try {
                String originCurrency = menu.selectCurrency(scanner, "origen");
                String destinationCurrency = menu.selectCurrency(scanner, "destino", originCurrency);

                System.out.println("Ingresa la cantidad a convertir:");
                double amount = scanner.nextDouble();

                double rate = currencyService.getExchangeRate(originCurrency, destinationCurrency);
                double result = amount * rate;
                System.out.println(amount + " " + originCurrency + " = " + result + " " + destinationCurrency);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Limpiar la entrada si hay un error
            }

            System.out.println("¿Deseas realizar otra conversión? (si/no)");
            String repeat = scanner.next();
            if (!repeat.equalsIgnoreCase("si")) {
                break;
            }
        }

        System.out.println("Gracias por usar el conversor de divisas. ¡Hasta pronto!");
        scanner.close();
    }
}
