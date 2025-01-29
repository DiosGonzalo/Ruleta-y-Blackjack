package data;

public class DatosRuleta { // Hecho por Pablo García, con modificaciones de Gonzalo Dios
    private static String menuInicialTitulo = "Opciones Ruleta";
    private static String[] menuInicialSeleccion = { // Pablo García María
            "Abandonar",
            "Girar ruleta",
            "Seleccionar color",
            "Seleccionar número específico",
            "Seleccionar tercios",
            "Seleccionar mitades"
    };

    private static String menuColorTitulo = "Colores";
    private static String[] menuColorSeleccion = { // Pablo García María
            "Volver",
            "Negros",
            "Rojos",
    };

    private static String menuMitadesTitulo = "Mitades";
    private static String[] menuMitadesSeleccion = { // Pablo García María
            "Volver",
            "Primera mitad",
            "Segunda mitad",
    };

    private static String menuTerciosTitulo = "Tercios";
    private static String[] menuTerciosSeleccion = { // Pablo García María
            "Volver",
            "Primer tercio",
            "Segundo tercio",
            "Tercer tercio",
    };

    private static String menuNúmeroTitulo = "Números";
    private static String[] menuNúmeroSeleccion = { // Pablo García María
            "Número 00",
            "Número 1",
            "Número 2",
            "Número 3",
            "Número 4",
            "Número 5",
            "Número 6",
            "Número 7",
            "Número 8",
            "Número 9",
            "Número 10",
            "Número 11",
            "Número 12",
            "Número 13",
            "Número 14",
            "Número 15",
            "Número 16",
            "Número 17",
            "Número 18",
            "Número 19",
            "Número 20",
            "Número 21",
            "Número 22",
            "Número 23",
            "Número 24",
            "Número 25",
            "Número 26",
            "Número 27",
            "Número 28",
            "Número 29",
            "Número 30",
            "Número 31",
            "Número 32",
            "Número 33",
            "Número 34",
            "Número 35",
            "Número 36",
            "Número 37",
            "Volver",
    };

    private static int[] multiplicadores = { // Gonzalo
            2, // Negros
            2, // Rojos
            3, // Primer tercio
            3, // Segundo tercio
            3, // Tercer tercio
            16, // 0
            6, // 1
            6, // 2
            6, // 3
            6, // 4
            6, // 5
            6, // 6
            6, // 7
            6, // 8
            6, // 9
            6, // 10
            6, // 11
            6, // 12
            6, // 13
            6, // 14
            6, // 15
            6, // 16
            6, // 17
            6, // 18
            6, // 19
            6, // 20
            6, // 21
            6, // 22
            6, // 23
            6, // 24
            6, // 25
            6, // 26
            6, // 27
            6, // 28
            6, // 29
            6, // 30
            6, // 31
            6, // 32
            6, // 33
            6, // 34
            6, // 35
            6, // 36
            6, // 37
            2, // Primera Mitad
            2, // Segunda Mitad
    };

    private static int[] opcionesJugadas = { // Pablo García María // EL DINERO QUE LE METE EL JUGADOR
            0, // Negros
            0, // Rojos
            0, // Primera tercio
            0, // Segundo tercio
            0, // Tercer tercio
            0, // 0
            0, // 1
            0, // 2
            0, // 3
            0, // 4
            0, // 5
            0, // 6
            0, // 7
            0, // 8
            0, // 9
            0, // 10
            0, // 11
            0, // 12
            0, // 13
            0, // 14
            0, // 15
            0, // 16
            0, // 17
            0, // 18
            0, // 19
            0, // 20
            0, // 21
            0, // 22
            0, // 23
            0, // 24
            0, // 25
            0, // 26
            0, // 27
            0, // 28
            0, // 29
            0, // 30
            0, // 31
            0, // 32
            0, // 33
            0, // 34
            0, // 35
            0, // 36
            0, // 37
            0, // Primera mitad
            0, // Segunda mitad
    };

    private static String[] opcionesJugadasNombre = { // Pablo García María // EL DINERO QUE LE METE EL JUGADOR
            "Negros", // Negros
            "Rojos", // Rojos
            "Primer tercio", // Primer tercio
            "Segundo tercio", // Segundo tercio
            "Tercer tercio", // Tercer tercio
            "0", // 0
            "1", // 1
            "2", // 2
            "3", // 3
            "4", // 4
            "5", // 5
            "6", // 6
            "7", // 7
            "8", // 8
            "9", // 9
            "10", // 10
            "11", // 11
            "12", // 12
            "13", // 13
            "14", // 14
            "15", // 15
            "16", // 16
            "17", // 17
            "18", // 18
            "19", // 19
            "20", // 20
            "21", // 21
            "22", // 22
            "23", // 23
            "24", // 24
            "25", // 25
            "26", // 26
            "27", // 27
            "28", // 28
            "29", // 29
            "30", // 30
            "31", // 31
            "32", // 32
            "33", // 33
            "34", // 34
            "35", // 35
            "36", // 36
            "37", // 37
            "Primera mitad", // Primera mitad
            "Segunda mitad", // Segunda mitad
    };

    private static int[] opcionesJugadasAntiguas = { // Pablo García María // EL DINERO QUE LE METE EL JUGADOR
            0, // Negros
            0, // Rojos
            0, // Primer tercio
            0, // Segundo tercio
            0, // Tercer tercio
            0, // 0
            0, // 1
            0, // 2
            0, // 3
            0, // 4
            0, // 5
            0, // 6
            0, // 7
            0, // 8
            0, // 9
            0, // 10
            0, // 11
            0, // 12
            0, // 13
            0, // 14
            0, // 15
            0, // 16
            0, // 17
            0, // 18
            0, // 19
            0, // 20
            0, // 21
            0, // 22
            0, // 23
            0, // 24
            0, // 25
            0, // 26
            0, // 27
            0, // 28
            0, // 29
            0, // 30
            0, // 31
            0, // 32
            0, // 33
            0, // 34
            0, // 35
            0, // 36
            0, // 37
            0, // Primera mitad
            0, // Segunda mitad
    };

    public static String[] getOpcionesJugadasNombre() {
        return opcionesJugadasNombre;
    }

    public static int[] getOpcionesJugadasAntiguas() {
        return opcionesJugadasAntiguas;
    }

    public static void insertarOpcionJugada(int indice, int valor) {
        almacenarPasado(indice, opcionesJugadas[indice]);
        if (valor == 0) {
            opcionesJugadas[indice] = valor;
        } else {
            opcionesJugadas[indice] += valor;
        }
    }

    public static void almacenarPasado(int indice, int valor) {
        opcionesJugadasAntiguas[indice] = valor;
    };

    public static int[] getMultiplicadores() { // Pablo García María
        return multiplicadores;
    }

    public static String[] getMenuNúmeroSeleccion() { // Pablo García María
        return menuNúmeroSeleccion;
    }

    public static String[] getMenuTerciosSeleccion() { // Pablo García María
        return menuTerciosSeleccion;
    }

    public static String[] getMenuInicialSeleccion() { // Pablo García María
        return menuInicialSeleccion;
    }

    public static String[] getMenuColorSeleccion() { // Pablo García María
        return menuColorSeleccion;
    }

    public static int[] getOpcionesJugadas() { // Pablo García María
        return opcionesJugadas;
    }

    public static String[] getMenuMitadesSeleccion() { // Pablo García María
        return menuMitadesSeleccion;
    }

    public static String getMenuInicialTitulo() {
        return menuInicialTitulo;
    };

    public static String getMenuColorTitulo() {
        return menuColorTitulo;
    };

    public static String getMenuMitadesTitulo() {
        return menuMitadesTitulo;
    };

    public static String getMenuTerciosTitulo() {
        return menuTerciosTitulo;
    };

    public static String getMenuNúmeroTitulo() {
        return menuNúmeroTitulo;
    };
}
