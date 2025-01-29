package data;

public class Datos_BlackJack { // Pablo García María

    private static String[] nombres = {
            "control", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q"
    };

    private static int[] valores = {
            0, 99, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10
    };

    public static String[] getNombres() {
        return nombres;
    }

    public static int[] getValores() {
        return valores;
    }

}
