package view.tools;

public class Herramientas { // Hecho por Pablo García
    public static String adaptarTamanno(String cadenaConvertir, int tam) { // Pablo García María 
        String temporalString = "";
        temporalString = cadenaConvertir;
        while (temporalString.length() < tam) {
            temporalString = temporalString + " ";
        }
        return temporalString;
    }

    public static String modificarMenu(int tamanoAmpliar) {
        int tamanoInicial = 13, tamanoFinal;
        String cadenaFinal = "═";

        tamanoFinal = tamanoInicial + tamanoAmpliar;

        while (cadenaFinal.length() < tamanoFinal) {
            cadenaFinal += "═";
        }

        return cadenaFinal;
    }

    public static void limpiarPantalla() {
        for (int i = 0; i < 500; i++) {
            System.out.println("");
        }
    }
}
