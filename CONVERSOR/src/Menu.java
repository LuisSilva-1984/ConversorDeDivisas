import java.util.Scanner;

public class Menu {

    private static final String[][] CURRENCIES = {
            {"ARS", "Peso Argentino"},
            {"BOB", "Boliviano"},
            {"BRL", "Real Brasileño"},
            {"CLP", "Peso Chileno"},
            {"COP", "Peso Colombiano"},
            {"USD", "Dólar Estadounidense"}
    };

    // Método para mostrar el menú de selección de divisa
    public String selectCurrency(Scanner scanner, String tipo) {
        return selectCurrency(scanner, tipo, null);
    }

    // Método sobrecargado para excluir una moneda en la selección (como el caso de origen/destino)
    public String selectCurrency(Scanner scanner, String tipo, String excludeCurrency) {
        int option = -1;

        while (option < 1 || option > CURRENCIES.length + 1) { // Ajustar el rango por la opción de salir
            System.out.println("Selecciona la moneda de " + tipo + ":");
            for (int i = 0; i < CURRENCIES.length; i++) {
                if (!CURRENCIES[i][0].equals(excludeCurrency)) {
                    System.out.println((i + 1) + ". " + CURRENCIES[i][1] + " (" + CURRENCIES[i][0] + ")");
                }
            }
            System.out.println((CURRENCIES.length + 1) + ". Salir"); // Opción adicional para salir

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option < 1 || option > CURRENCIES.length + 1 || (option <= CURRENCIES.length && CURRENCIES[option - 1][0].equals(excludeCurrency))) {
                    System.out.println("Opción inválida. Por favor selecciona una opción válida.");
                    option = -1; // Reinicia la opción si es inválida
                } else if (option == CURRENCIES.length + 1) {
                    System.out.println("Saliendo del programa...");
                    System.exit(0); // Finaliza el programa si elige salir
                }
            } else {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next(); // Limpiar entrada inválida
            }
        }

        return CURRENCIES[option - 1][0]; // Devuelve la moneda seleccionada
    }
}
