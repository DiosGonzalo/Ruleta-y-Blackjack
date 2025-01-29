package main;

import utilities.Leer;
import controller.*;
import crud.*;
import models.*;
import view.*;

public class Principal { // Hecho principalmente por Hugo, con modificaciones y/o ajustes de Pablo y
                         // Ayudas de Gonzalo.

    public static void main(String[] args) throws InterruptedException {

        String juegosDisponiblesMenuOpciones[] = {
                "Abandonar",
                "Ruleta",
                "Blackjack",
                "Ayuda juegos",
                "Opciones usuario",
        }, juegosDisponiblesMenuTitulo = "Juegos";
        int juegosDisponiblesMenutam = 20, juegosDisponiblesMenuAbandonar = 0;
        int opcion;

        String menuInicioSesionOpciones[] = {
                "Abandonar",
                "Iniciar sesión",
                "Registrarse",
                "Ayuda",
        }, menuInicioSesionTitulo = "Menú de inicio";
        int menuInicioSesiontam = 20, menuInicioSesionAbandonar = 0, menuInicionSesionOpcionMinima = 0;

        String menuBlackjackOpciones[] = {
                "Pedir nueva carta",
                "Plantarse",
                "Doblar apuesta",
        }, menuBlackjackTitulo = "Menú de BlackJack";
        int menuBlackjacktam = 29, menuBlackjackMinima = 1;

        String menuAdminOpciones[] = {
                "Abandonar",
                "Añadir jugador",
                "Eliminar jugador",
                "Comprobar balance casino",
                "Comprobar balance jugadores",
                "Añadir saldo al casino",
                "Retirar saldo del casino",
                "Añadir saldo a jugador",
                "Retirar saldo a jugador",
        }, menuAdminTitulo = "Menú de administrador";
        int menuAdminTam = 28, menuAdminAbandonar = 0, menuAdminOpcionMinima = 0;

        String menuUsuarioOpciones[] = {
                "Abandonar",
                "Cambiar nombre de usuario",
                "Cambiar contraseña",
                "Añadir saldo",
                "Retirar saldo",
                "Comprobar saldo",
        }, menuUsuarioTitulo = "Menú de Usuario";
        int menuUsuarioTam = 28, menuUsuarioAbandonar = 0, menuUsuarioOpcionMinima = 0;

        int tamannoBarra = 100;

        String barraCarga = "█";

        String menuRuleta1Opciones[], menuRuleta1Titulo = "Menú de inicio";
        int menuRuleta1tam = 30, menuRuleta1Abandonar = 0, menuRuleta1OpcionMinima = 0;

        int menusRuletaDefaultTam = 20, menusRuletaDefaultAbandonar = 0;

        int cantidadActualApostada, cero = 0, numeroGanadro;

        String nombreLeer = "", contraseniaLeer = "";
        int annadir;
        double saldoInicialJugador = 1000, saldoInicialCasino = 10000;
        Jugador[] jugadoresBase;
        int generarInicialDealer = 1, generarInicialUsuario = 2, multiplicadorBlackjack = 2,
                limiteGanadorBlackJack = 21;
        int tam = 100, valorAjusteArrays = -1, ganancias, apostado;
        int[] cartasBase1, cartasBase2;
        boolean salir = false;
        boolean dealer = false, usuario = true, blackjackFin = false;
        Jugador jActual = new Jugador(nombreLeer, contraseniaLeer, saldoInicialJugador);
        Casino c;
        int tiempoCargaMedia = 5000;

        CrudCasino crudCasino;
        CrudJugador crudJugador;
        CrudBlackjack crudBlackjack;

        ControllerRuleta controllerRuleta;
        ControllerBlackjack controllerBlackjack;

        Blackjack juegoBlackjack;

        CrudJugador crudJugadorAdministracion;
        Jugador jugadorObjetivo;

        jugadoresBase = new Jugador[tam]; // Pablo García María
        jugadoresBase[0] = data.DatosPrincipal.getJugadorInicializado();
        c = new Casino(jugadoresBase, saldoInicialCasino); // Pablo García María
        crudCasino = new CrudCasino(c); // Pablo García María

        cartasBase1 = new int[tam];
        cartasBase2 = new int[tam];

        menuRuleta1Opciones = data.DatosRuleta.getMenuInicialSeleccion(); // Pablo García María

        VistaPrincipal.imprimirLogo();

        Thread.sleep(1000);

        for (int i = 0; i < tamannoBarra; i++) {
            System.out.print(barraCarga);
            Thread.sleep(35);
        } // Hugo Carmona
        System.out.println("");
        Thread.sleep(500);

        do {
            do {
                VistaPrincipal.imprimirMenu(menuInicioSesionTitulo, menuInicioSesionOpciones, menuInicioSesiontam,
                        menuInicioSesionAbandonar); // Pablo García María
                System.out.printf("¿Qué quieres hacer? ");// Pablo García María

                opcion = Leer.datoInt(); // Hugo Carmona

                while (opcion > menuInicioSesionOpciones.length + valorAjusteArrays
                        || opcion < menuInicionSesionOpcionMinima) { // Pablo García María
                    System.out.printf("Opción inválida escogida, introduzca una nueva: "); // Pablo García María

                    opcion = Leer.datoInt(); // Pablo García María
                } // Pablo García María

                switch (opcion) { // Hugo Carmona
                    case 1: // Hugo Carmona
                        System.out.print("Introduzca su nombre de usuario: "); // Hugo Carmona
                        nombreLeer = Leer.dato(); // Hugo Carmona
                        jActual = crudCasino.buscarJugadorNombre(nombreLeer); // Pablo García María
                        opcion = 99; // Hugo Carmona
                        if (jActual == null) { // Pablo García María
                            System.out.println("El nombre de usuario indicado no existe."); // Pablo García María
                        } else { // Pablo García María
                            System.out.print("Introduzca su contraseña: "); // Hugo Carmona
                            contraseniaLeer = Leer.dato(); // Hugo Carmona
                            if (jActual.getContrasenia().equals(contraseniaLeer)) { // Pablo García María
                                System.out.println("Inicio de sesión realizado con exito."); // Hugo Carmona
                                opcion = 1; // Pablo García María
                            } else { // Hugo Carmona
                                System.out.println("La contraseña indicada, no es correcta."); // Hugo Carmona
                            } // Hugo Carmona
                        } // Pablo García María
                        Thread.sleep(tiempoCargaMedia - 1500); // Para que tarde un poco menos que lo normal
                        break; // Hugo Carmona
                    case 2: // Hugo Carmona
                        if (crudCasino.comprobarDisponibilidad()) {
                            System.out.print("Introduzca el nombre de usuario que desea tener: "); // Hugo Carmona
                            nombreLeer = Leer.dato(); // Hugo Carmona
                            if (crudCasino.buscarJugadorNombre(nombreLeer) == null) {
                                System.out.print("Introduzca la contraseña que desea tener: "); // Hugo Carmona
                                contraseniaLeer = Leer.dato(); // Hugo Carmona
                                jActual = new Jugador(nombreLeer, contraseniaLeer, saldoInicialJugador); // Hugo Carmona
                                crudCasino.anadirJugador(jActual); // Hugo Carmona
                                System.out.println("Registro de usuario realizado con éxito."); // Hugo Carmona
                                System.out.printf("El casino le ha establecido un saldo de %.2f€ como regalo por crear la cuenta.\n",saldoInicialJugador);
                            } else {
                            	opcion = 99;
                            	System.out.println("Ya existe un usuario con ese nombre.");
                            }
                        } else {
                            System.out.println("El casino no dispone de más espacios de usuario.");
                        }
                        Thread.sleep(tiempoCargaMedia);
                        break; // Hugo Carmona
                    case 3:// Gonzalo Dios
                        System.out.println(
                                "En este casino se apuesta con fichas, por lo que no se pueden apostar numeros con decimales");
                        System.out.printf(
                                "Si es nuevo, cree un usuario donde se le guardarán todos los datos, el casino le establecerá un saldo de %.2f€ como regalo por crear la cuenta.\n ",
                                saldoInicialJugador); // Gonzalo Dios
                        System.out.println(
                                "Si ya tiene una cuenta creada, pulse iniciar sesión para poder acceder a su cuenta");
                        System.out.println(
                                "Si usted es un admin, pulse iniciar sesión e introduzca admin de nombre de usuario y admin de contraseña.\nCon este usuario accederá a todas las opciones de admin");
                        System.out.println("");
                        System.out.println("Datos de acceso para admin:\n\tUsuario: admin\n\tContraseña: admin");

                        System.out.println("Presione cualquier tecla para volver al menu."); // Pablo Garcia
                        Leer.dato(); // Pablo Garcia
                        opcion = 99;
                        break;
                    case 0: // Hugo Carmona
                        System.out.println("Muchísimas gracias por jugar a nuestro casino.\nCerrando el programa...."); // Hugo Carmona
                        salir = true;
                        break; // Hugo Carmona
                    default: // Hugo Carmona
                        System.out.println("Opción inexistente, inténtelo de nuevo."); // Hugo Carmona
                        Thread.sleep(tiempoCargaMedia);
                        break; // Hugo Carmona
                } // Hugo Carmona
            } while (opcion == 99); // Hugo Carmona

            while (opcion != 0) {
                crudJugador = new CrudJugador(jActual);

                VistaPrincipal.imprimirMenu(juegosDisponiblesMenuTitulo, juegosDisponiblesMenuOpciones,
                        juegosDisponiblesMenutam, juegosDisponiblesMenuAbandonar); // Pablo García María
                System.out.printf("¿Qué juego quieres jugar? ");
                opcion = Leer.datoInt();

                while (opcion > juegosDisponiblesMenuOpciones.length + valorAjusteArrays
                        || opcion < juegosDisponiblesMenuAbandonar) {
                    System.out.printf("Opción inexistente, inténtelo de nuevo: "); // Hugo Carmona
                    opcion = Leer.datoInt();
                }

                switch (juegosDisponiblesMenuOpciones[opcion]) {
                    case "Ruleta":
                        do {
                            controllerRuleta = new ControllerRuleta(jActual, crudCasino);
                            VistaPrincipal.imprimirMenu(menuRuleta1Titulo, menuRuleta1Opciones, menuRuleta1tam,
                                    menuRuleta1Abandonar); // Pablo García María
                            System.out.printf("¿A qué opción quieres apostarle? "); // Pablo García María

                            opcion = Leer.datoInt(); // Pablo García María
                            while (opcion > menuRuleta1Opciones.length + valorAjusteArrays
                                    || opcion < menuRuleta1OpcionMinima) { // Pablo García María
                                System.out.printf("Opción inválida escogida, introduzca una nueva: "); // Pablo Garcia Maria

                                opcion = Leer.datoInt(); // Pablo García María
                            }
                            System.out.println(menuRuleta1Opciones[opcion]);
                            switch (menuRuleta1Opciones[opcion]) {
                                case "Girar ruleta":// Gonzalo Dios
                                    controllerRuleta = new ControllerRuleta(jActual, crudCasino);
                                    apostado = 0;
                                    for (int i = 0; i < data.DatosRuleta.getOpcionesJugadas().length; i++) {
                                        apostado += data.DatosRuleta.getOpcionesJugadas()[i];
                                    }

                                    System.out.printf("Antes de girar la ruleta, el Jugador %s ha apostado: %d\n",
                                            jActual.getNombre(), apostado);
                                    numeroGanadro = controllerRuleta.generarPremiado();// Pablo García María

                                    VistaRuleta.mostrarRuletaCircular(numeroGanadro);
                                    Thread.sleep(tiempoCargaMedia);
                                    view.tools.Herramientas.limpiarPantalla();
                                    System.out.println(VistaRuleta.mostrarGanador(numeroGanadro));
                                    Thread.sleep(tiempoCargaMedia);

                                    ganancias = 0;
                                    for (int i = 0; i < data.DatosRuleta.getOpcionesJugadas().length; i++) {// Pablo Garcia Maria
                                        ganancias += data.DatosRuleta.getOpcionesJugadas()[i];// Pablo García María
                                    }

                                    jActual.setSaldo(ganancias + jActual.getSaldo());// Pablo García María
                                    crudCasino.annadirSaldo(-ganancias);

                                    view.tools.Herramientas.limpiarPantalla();
                                    VistaRuleta.imprimirTableroApuestas();
                                    System.out.println("");

                                    controllerRuleta.mostrarOpcionesGanadas();

                                    System.out.println("");
                                    System.out.println("Saldo actual del jugador: " + jActual.getSaldo());
                                    System.out.println("");
                                    System.out
                                            .println("Presione cualquier tecla para seguir participando en el casino.");
                                    Leer.dato();
                                    break;
                                case "Seleccionar color": // Pablo García María
                                    VistaPrincipal.imprimirMenu(data.DatosRuleta.getMenuColorTitulo(),
                                            data.DatosRuleta.getMenuColorSeleccion(), menusRuletaDefaultTam,
                                            menusRuletaDefaultAbandonar); // Pablo García María
                                    System.out.println("¿Qué color quieres jugar? (Selecciona su ID) "); // Pablo Garcia
                                                                                                         // Maria

                                    opcion = Leer.datoInt(); // Pablo García María

                                    while (opcion > data.DatosRuleta.getMenuColorSeleccion().length + valorAjusteArrays
                                            || opcion < menusRuletaDefaultAbandonar) {// Pablo García María
                                        System.out.printf("Opción invalida escogida, introduzca una nueva: "); // Pablo
                                                                                                               // Garcia
                                                                                                               // Maria

                                        opcion = Leer.datoInt(); // Pablo García María
                                    }

                                    if (opcion != menusRuletaDefaultAbandonar) {
                                        System.out.printf("¿Cuánto dinero quieres apostar al %s: ",
                                                data.DatosRuleta.getMenuColorSeleccion()[opcion]); // Pablo García María
                                        cantidadActualApostada = Leer.datoInt(); // Pablo García María
                                        while (cantidadActualApostada < cero) { // Hugo Carmona
                                            System.out.printf(
                                                    "No puedes apostar menos de %s€, introduzca una nueva cantidad: ",
                                                    cero); // Hugo Carmona
                                            cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                        }

                                        while (!crudJugador.comprobarApuesta(cantidadActualApostada)) {
                                            System.out.println(
                                                    "No es posible apostar esa cantidad, no dispones de tanto saldo.");
                                            System.out.printf("¿Cuánto dinero quieres apostar? (Tienes %.2f): ",
                                                    jActual.getSaldo());
                                            cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                            while (cantidadActualApostada < cero) { // Hugo Carmona
                                                System.out.printf(
                                                        "No puedes apostar menos de %s€, introduzca una nueva cantidad: ",
                                                        cero); // Hugo Carmona
                                                cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                            }
                                        }
                                        controllerRuleta.apostarRojoNegro(opcion, cantidadActualApostada); // Pablo
                                                                                                           // García //
                                                                                                           // Maria
                                    }

                                    opcion = 1;// Pablo García María
                                    break;

                                case "Seleccionar número específico":// Pablo García María
                                    VistaPrincipal.imprimirMenu(data.DatosRuleta.getMenuNúmeroTitulo(),
                                            data.DatosRuleta.getMenuNúmeroSeleccion(), menusRuletaDefaultTam);// Pablo
                                                                                                              // García
                                                                                                              // María
                                    System.out.println("¿Qué número quieres jugar? (Selecciona su ID) ");// Pablo Garcia
                                                                                                         // Maria

                                    opcion = Leer.datoInt();// Pablo García María
                                    while (opcion > data.DatosRuleta.getMenuNúmeroSeleccion().length + valorAjusteArrays
                                            || opcion < menusRuletaDefaultAbandonar) {// Pablo García María
                                        System.out.printf("Opción inválida escogida, introduzca una nueva: "); // Pablo
                                                                                                               // Garcia
                                                                                                               // Maria

                                        opcion = Leer.datoInt(); // Pablo García María
                                    }

                                    if (opcion != data.DatosRuleta.getMenuNúmeroSeleccion().length
                                            + valorAjusteArrays) {
                                        System.out.printf("¿Cuánto dinero quieres apostarle al %s: ",
                                                data.DatosRuleta.getMenuNúmeroSeleccion()[opcion]); // Pablo Garcia
                                                                                                    // Maria
                                        cantidadActualApostada = Leer.datoInt(); // Pablo García María
                                        while (cantidadActualApostada < 0) { // Hugo Carmona
                                            System.out.printf(
                                                    "No puedes apostar menos de %s€, introduzca una nueva cantidad: ",
                                                    cero); // Hugo Carmona
                                            cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                        }
                                        while (!crudJugador.comprobarApuesta(cantidadActualApostada)) {
                                            System.out.println(
                                                    "No es posible apostar esa cantidad, no dispones de tanto saldo.");
                                            System.out.printf("¿Cuánto dinero quieres apostar? (Tienes %.2f): ",
                                                    jActual.getSaldo());
                                            cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                            while (cantidadActualApostada < 0) { // Hugo Carmona
                                                System.out.printf(
                                                        "No puedes apostar menos de %s€, introduzca una nueva cantidad: ",
                                                        cero); // Hugo Carmona
                                                cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                            }
                                        }
                                        controllerRuleta.apostarNumero(opcion, cantidadActualApostada); // Pablo Garcia
                                    }
                                    opcion = 1;
                                    break;
                                case "Seleccionar tercios":// Pablo García María
                                    VistaPrincipal.imprimirMenu(data.DatosRuleta.getMenuTerciosTitulo(),
                                            data.DatosRuleta.getMenuTerciosSeleccion(), menusRuletaDefaultTam,
                                            menusRuletaDefaultAbandonar);// Pablo García María
                                    System.out.println("¿Qué tercio quieres jugar? (Selecciona su ID) ");// Pablo Garcia
                                                                                                         // Maria

                                    opcion = Leer.datoInt();// Pablo García María
                                    while (opcion > data.DatosRuleta.getMenuTerciosSeleccion().length
                                            + valorAjusteArrays || opcion < menusRuletaDefaultAbandonar) {// Pablo
                                                                                                          // Garcia
                                                                                                          // Maria
                                        System.out.printf("Opción invalida escogida, introduzca una nueva: "); // Pablo
                                                                                                               // Garcia

                                        // Maria
                                        opcion = Leer.datoInt(); // Pablo García María
                                    }

                                    if (opcion != menusRuletaDefaultAbandonar) {
                                        System.out.printf("¿Cuanto dinero quieres apostarle al %s: ",
                                                data.DatosRuleta.getMenuTerciosSeleccion()[opcion]); // Hugo Carmona
                                        cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                        while (cantidadActualApostada < 0) { // Hugo Carmona
                                            System.out.printf(
                                                    "No puedes apostar menos de %s€, introduzca una nueva cantidad: ",
                                                    cero); // Hugo Carmona
                                            cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                        }
                                        while (!crudJugador.comprobarApuesta(cantidadActualApostada)) {
                                            System.out.println(
                                                    "No es posible apostar esa cantidad, no dispones de tanto saldo.");
                                            System.out.printf("¿Cuánto dinero quieres apostar? (Tienes %.2f): ",
                                                    jActual.getSaldo());
                                            cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                            while (cantidadActualApostada < 0) { // Hugo Carmona
                                                System.out.printf(
                                                        "No puedes apostar menos de %s€, introduzca una nueva cantidad: ",
                                                        cero); // Hugo Carmona
                                                cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                            }
                                        }
                                        controllerRuleta.apostarTercios(opcion, cantidadActualApostada); // Hugo Carmona
                                    }
                                    break;
                                case "Seleccionar mitades":// Pablo García María
                                    VistaPrincipal.imprimirMenu(data.DatosRuleta.getMenuMitadesTitulo(),
                                            data.DatosRuleta.getMenuMitadesSeleccion(), menusRuletaDefaultTam,
                                            menusRuletaDefaultAbandonar);// Pablo García María
                                    System.out.println("¿Qué mitad quieres jugar? (Selecciona su ID) "); // Pablo Garcia Maria

                                    opcion = Leer.datoInt(); // Pablo García María
                                    while (opcion > data.DatosRuleta.getMenuMitadesSeleccion().length
                                            + valorAjusteArrays || opcion < menusRuletaDefaultAbandonar) {// Pablo Garcia  Maria
                                        System.out.printf("Opción inválida escogida, introduzca una nueva: "); // Pablo Garcia

                                        // Maria
                                        opcion = Leer.datoInt(); // Pablo García María
                                    }
                                    if (opcion != menusRuletaDefaultAbandonar) {
                                        System.out.printf("¿Cuánto dinero quieres apostarle al %s: ",
                                                data.DatosRuleta.getMenuMitadesSeleccion()[opcion]); // Hugo Carmona
                                        cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                        while (cantidadActualApostada < 0) { // Hugo Carmona
                                            System.out.printf(
                                                    "No puedes apostar menos de %s€, introduzca una nueva cantidad: ",
                                                    cero); // Hugo Carmona
                                            cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                        }
                                        while (!crudJugador.comprobarApuesta(cantidadActualApostada)) {
                                            System.out.println(
                                                    "No es posible apostar esa cantidad, no dispones de tanto saldo.");
                                            System.out.printf("¿Cuánto dinero quieres apostar? (Tienes %.2f): ",
                                                    jActual.getSaldo());
                                            cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                            while (cantidadActualApostada < 0) { // Hugo Carmona
                                                System.out.printf(
                                                        "No puedes apostar menos de %s€, introduzca una nueva cantidad: ",
                                                        cero); // Hugo Carmona
                                                cantidadActualApostada = Leer.datoInt(); // Hugo Carmona
                                            }
                                        }
                                        controllerRuleta.apostarMitades(opcion, cantidadActualApostada); // Hugo Carmona
                                    }
                                    opcion = 1;
                                    break;
                                case "Abandonar":
                                    System.out.println("Opción abandonar seleccionada, volviendo al menu de juegos.");// Pablo Garcia Maria
                                    break;
                                default:
                                    System.out.println("Opción invalida, volviendo a seleccionar");// Pablo García María
                                    break;
                            }
                        } while (!menuRuleta1Opciones[opcion].equals("Abandonar"));
                        opcion = 99;
                        break;
                    case "Ayuda juegos":
                        System.out.println(
                                "En este casino se apuesta con fichas, por lo que no se pueden apostar números con decimales");
                        System.out.println(
                                "Ruleta:\n La ruleta te permite apostar a números, colores, mitades o tercios.\nCada tipo de apuesta tiene un multiplicador según su probabilidad.\n Puedes hacer varias apuestas en una misma tirada.");
                        System.out.println(
                                "Blackjack:\n tanto tú como el dealer reciben dos cartas.\n Si no sumas 21, puedes pedir más cartas para acercarte a esa cifra, pero si te pasas de 21, pierdes.\nSi te quedas cerca de 21 sin pasarte, compites con el dealer para ver quién está más cerca.\n Si tienes una buena mano, puedes plantarte y esperar a ver qué hace el dealer.");
                        Leer.dato();
                        break;
                    case "Opciones usuario":
                        if (jActual.getNombre().equals("admin")) {
                            do {
                                VistaPrincipal.imprimirMenu(menuAdminTitulo, menuAdminOpciones, menuAdminTam,
                                        menuAdminAbandonar); // Hugo Carmona
                                System.out.printf("¿Qué quieres hacer? ");// Hugo Carmona

                                opcion = Leer.datoInt(); // Hugo Carmona

                                while (opcion > menuAdminOpciones.length + valorAjusteArrays
                                        || opcion < menuAdminOpcionMinima) { // Hugo Carmona
                                    System.out.printf("Opción invalida escogida, introduzca una nueva: "); // Hugo Carmona

                                    opcion = Leer.datoInt(); // Hugo Carmona
                                } // Hugo Carmona
                                switch (opcion) { // Hugo Carmona
                                    case 0:
                                        System.out
                                                .println("Opción abandonar seleccionada, volviendo al menu de juegos.");// Hugo Carmona
                                        break;
                                    case 1: // Hugo Carmona
                                        if (crudCasino.comprobarDisponibilidad()) { // Hugo Carmona
                                            System.out.print("Introduzca el nombre del usuario que va a crear: "); // Hugo Carmona
                                            nombreLeer = Leer.dato(); // Hugo Carmona
                                            System.out.print("Introduzca la contraseña que tendrá el usuario: "); // Hugo Carmona
                                            contraseniaLeer = Leer.dato(); // Hugo Carmona
                                            jugadorObjetivo = new Jugador(nombreLeer, contraseniaLeer,
                                                    saldoInicialJugador); // Hugo Carmona
                                            crudCasino.anadirJugador(jugadorObjetivo); // Hugo Carmona
                                            System.out.println("Registro de usuario realizado con éxito."); // Hugo Carmona
                                        } else { // Hugo Carmona
                                            System.out.println("El casino no dispone de más espacios de usuario."); // Hugo Carmona
                                        }
                                        break;
                                    case 2: // Hugo Carmona
                                        System.out.print("Diga el nombre del usuario que desea eliminar: "); // Hugo Carmona
                                        nombreLeer = Leer.dato(); // Hugo Carmona
                                        if (crudCasino.buscarJugadorNombre(nombreLeer) == null) { // Hugo Carmona
                                            System.out.println("El nombre de usuario indicado no existe."); // Hugo Carmona
                                        } else {
                                            crudCasino.eliminarUsuario(nombreLeer); // Hugo Carmona
                                            System.out.println("Jugador eliminado con exito."); // Hugo Carmona
                                        }
                                        break;
                                    case 3:
                                        System.out.printf("Este es el saldo del casino: %.2f€ \n", c.getSaldo()); // Hugo Carmona
                                        break;
                                    case 4:
                                        System.out.printf(
                                                "Dime el nombre del usuario del que quieres ver su balance: "); // Hugo Carmona
                                        nombreLeer = Leer.dato(); // Hugo Carmona
                                        if (crudCasino.buscarJugadorNombre(nombreLeer) == null) { // Hugo Carmona
                                            System.out.println("El nombre de usuario indicado no existe."); // Hugo Carmona
                                        } else {
                                            System.out.printf("El saldo de ese jugador es de %.2f€ \n",
                                                    crudCasino.buscarJugadorNombre(nombreLeer).getSaldo()); // Hugo Carmona
                                        }
                                        break;
                                    case 5:
                                        System.out.print("Indique la cantidad que desea añadir: "); // Hugo Carmona
                                        annadir = Leer.datoInt(); // Hugo Carmona
                                        crudCasino.annadirSaldo(annadir); // Hugo Carmona
                                        System.out.println("Cantidad añadida con éxito."); // Hugo Carmona
                                        System.out.printf("Saldo actual: %.2f€ \n", c.getSaldo()); // Hugo Carmona
                                        break;
                                    case 6:
                                        System.out.printf(
                                                "Indique la cantidad que desea retirar (Saldo actual: %.2f): ",
                                                c.getSaldo()); // Hugo Carmona
                                        annadir = Leer.datoInt(); // Hugo Carmona
                                        while (annadir > c.getSaldo()) {
                                            System.out.println("Saldo insuficiente, inténtelo de nuevo.");
                                            annadir = Leer.datoInt(); // Hugo Carmona
                                        }
                                        crudCasino.annadirSaldo(-annadir); // Hugo Carmona
                                        System.out.println("Cantidad retirada con éxito."); // Hugo Carmona
                                        System.out.printf("Saldo actual: %.2f€ \n", c.getSaldo()); // Hugo Carmona
                                        break;
                                    case 7:
                                        System.out.printf("Dime el nombre del usuario al que quieres añadir saldo: "); // Hugo Carmona
                                        nombreLeer = Leer.dato(); // Hugo Carmona
                                        if (crudCasino.buscarJugadorNombre(nombreLeer) == null) { // Hugo Carmona
                                            System.out.println("El nombre de usuario indicado no éxiste."); // Hugo Carmona
                                        } else {
                                            System.out.print("Indique la cantidad que desea añadir: "); // Hugo Carmona
                                            annadir = Leer.datoInt(); // Hugo Carmona
                                            if (annadir < 0) {
                                                annadir = -annadir;
                                            }
                                            jugadorObjetivo = crudCasino.buscarJugadorNombre(nombreLeer); // Hugo Carmona
                                            crudJugadorAdministracion = new CrudJugador(jugadorObjetivo);
                                            crudJugadorAdministracion.annadirSaldo(annadir);
                                            System.out.println("Cantidad añadida con éxito."); // Hugo Carmona
                                            System.out.printf("Saldo actual de %s: %.2f€\n", nombreLeer,
                                                    jugadorObjetivo.getSaldo()); // Hugo Carmona
                                        }
                                        break;
                                    case 8:
                                        System.out.printf("Dime el nombre del usuario al que quieres retirar saldo: "); // Hugo Carmona
                                        nombreLeer = Leer.dato(); // Hugo Carmona
                                        jugadorObjetivo = crudCasino.buscarJugadorNombre(nombreLeer); // Hugo Carmona
                                        if (jugadorObjetivo == null) { // Hugo Carmona
                                            System.out.println("El nombre de usuario indicado no existe."); // Hugo Carmona
                                        } else {
                                            crudJugadorAdministracion = new CrudJugador(jugadorObjetivo); // Hugo Carmona
                                            System.out.printf(
                                                    "Indique la cantidad que desea retirar (Saldo actual: %.2f): ",
                                                    jugadorObjetivo.getSaldo()); // Hugo Carmona
                                            annadir = Leer.datoInt(); // Hugo Carmona
                                            while (annadir > jugadorObjetivo.getSaldo()) { // Hugo Carmona
                                                System.out.println("Saldo insuficiente, intentelo de nuevo."); // Hugo Carmona
                                                annadir = Leer.datoInt(); // Hugo Carmona
                                            }
                                            crudJugadorAdministracion.annadirSaldo(-annadir); // Hugo Carmona
                                            System.out.println("Cantidad retirada con exito."); // Hugo Carmona
                                            System.out.printf("Saldo actual de %s: %.2f€\n", nombreLeer, jugadorObjetivo.getSaldo()); // Hugo Carmona
                                        }
                                        break;
                                    default:
                                        System.out.println("Opción inválida, volviendo a seleccionar"); // Hugo Carmona
                                        break;
                                }
                                Thread.sleep(tiempoCargaMedia);
                            } while (opcion != 0);
                        } else {
                            do {
                                VistaPrincipal.imprimirMenu(menuUsuarioTitulo, menuUsuarioOpciones, menuUsuarioTam,
                                        menuUsuarioAbandonar); // Hugo Carmona
                                System.out.printf("¿Qué quieres hacer? ");// Hugo Carmona
                                opcion = Leer.datoInt(); // Hugo Carmona

                                while (opcion > menuUsuarioOpciones.length + valorAjusteArrays
                                        || opcion < menuUsuarioOpcionMinima) { // Hugo Carmona
                                    System.out.printf("Opción inválida escogida, introduzca una nueva: "); // Hugo Carmona

                                    opcion = Leer.datoInt(); // Hugo Carmona
                                } // Hugo Carmona
                                switch (opcion) { // Hugo Carmona
                                    case 0:
                                        System.out
                                                .println("Opción abandonar seleccionada, volviendo al menu de juegos.");// Hugo Carmona
                                        break;
                                    case 1: // Hugo Carmona
                                        System.out.print("Introduzca su nuevo nombre de usuario: "); // Hugo Carmona
                                        nombreLeer = Leer.dato(); // Hugo Carmona
                                        crudJugador.modificarNombre(nombreLeer);
                                        System.out.println("Cambio de nombre realizado con exito."); // Hugo Carmona
                                        break;
                                    case 2: // Hugo Carmona
                                        System.out.print("Introduzca su nueva contraseña: "); // Hugo Carmona
                                        contraseniaLeer = Leer.dato(); // Hugo Carmona
                                        crudJugador.modificarContraseña(contraseniaLeer);
                                        System.out.println("Cambio de contraseña realizado con exito."); // Hugo Carmona
                                        break;
                                    case 3:
                                        System.out.printf("Diga cuanto desea añadir a su saldo (Saldo Actual: %.2f): ", jActual.getSaldo()); // Hugo Carmona
                                        annadir = Leer.datoInt(); // Hugo Carmona
                                        crudJugador.annadirSaldo(annadir); // Hugo Carmona
                                        System.out.println("Saldo añadido con exito."); // Hugo Carmona
                                        System.out.printf("Saldo actual: %.2f€ \n", jActual.getSaldo()); // Hugo Carmona
                                        break;
                                    case 4:
                                        System.out.printf(
                                                "Diga cuanto desea retirar de su saldo (Saldo Actual: %.2f): ",
                                                jActual.getSaldo()); // Hugo Carmona
                                        annadir = Leer.datoInt(); // Hugo Carmona
                                        while (annadir > jActual.getSaldo()) {
                                            System.out.println("Saldo insuficiente, inténtelo de nuevo.");
                                            annadir = Leer.datoInt(); // Hugo Carmona
                                        }
                                        crudJugador.annadirSaldo(-annadir); // Hugo Carmona
                                        System.out.println("Saldo retirado con exito."); // Hugo Carmona
                                        System.out.printf("Saldo actual: %.2f€ \n", jActual.getSaldo()); // Hugo Carmona
                                        break;
                                    case 5:
                                        System.out.printf("Su saldo actual es de %.2f€ \n", jActual.getSaldo()); // Hugo Carmona
                                        break;
                                    default:
                                        System.out.println("Opción inválida, volviendo a seleccionar"); // Hugo Carmona
                                        break;
                                }
                                Thread.sleep(tiempoCargaMedia);
                            } while (opcion != 0);
                        }
                        opcion = 99;
                        break;
                    case "Abandonar":
                        System.out.println("Cerrando sesión...");
                        break;
                    case "Blackjack":
                        blackjackFin = false;
                        cartasBase1 = new int[tam];// Pablo García María
                        cartasBase2 = new int[tam];// Pablo García María

                        juegoBlackjack = new Blackjack(cartasBase1, cartasBase2); // Pablo García María
                        controllerBlackjack = new ControllerBlackjack(juegoBlackjack);
                        crudBlackjack = new CrudBlackjack(juegoBlackjack);

                        System.out.println("¿Cuánto quieres apostar?");
                        cantidadActualApostada = Leer.datoInt();

                        while (!crudJugador.comprobarApuesta(cantidadActualApostada)) { // Pablo García María
                            System.out.printf(
                                    "No puedes apostar dinero que no tienes (tienes: %.2f), cuanto quieres apostar? ",
                                    jActual.getSaldo());
                            cantidadActualApostada = Leer.datoInt();
                        }

                        jActual.setSaldo(jActual.getSaldo() - cantidadActualApostada); // Hugo Carmona Jimenez
                        juegoBlackjack.setApostado(juegoBlackjack.getApostado() + cantidadActualApostada); // Hugo Carmona Jimenez

                        System.out.println("Comenzando el Blackjack: "); // Gonzalo Dios

                        System.out.println("El usuario tiene: "); // Gonzalo Dios
                        for (int i = 0; i < generarInicialUsuario; i++) { // Gonzalo Dios
                            controllerBlackjack.darCarta(usuario);
                        }
                        crudBlackjack.mostrarCartas(usuario); // Gonzalo Dios

                        System.out.println("\nEl dealer tiene: "); // Gonzalo Dios
                        for (int i = 0; i < generarInicialDealer; i++) { // Gonzalo Dios
                            controllerBlackjack.darCarta(dealer);
                        }
                        crudBlackjack.mostrarCartas(dealer); // Gonzalo Dios
                        System.out.println("");
                        do { // Pablo García María
                            VistaPrincipal.imprimirMenu(menuBlackjackTitulo, menuBlackjackOpciones,
                                    menuBlackjacktam);
                            System.out.println("¿Qué quieres hacer?");
                            opcion = Leer.datoInt();

                            while (opcion > menuBlackjackOpciones.length && opcion < menuBlackjackMinima) {
                                System.out.println("Opción inválida, introduzca una diferente: ");
                                opcion = Leer.datoInt();
                            }

                            switch (menuBlackjackOpciones[opcion]) {
                                case "Pedir nueva carta": // Gonzalo Dios
                                    System.out.println("El usuario ha pedido una nueva carta.");
                                    System.out.println("El usuario tiene: ");
                                    controllerBlackjack.darCarta(usuario);
                                    crudBlackjack.mostrarCartas(usuario);

                                    if (controllerBlackjack.calcularValor(usuario) > limiteGanadorBlackJack) {
                                        System.out.println("\nHa perdido el jugador.");
                                        blackjackFin = true;
                                    } else if (controllerBlackjack.calcularValor(usuario) == limiteGanadorBlackJack) {
                                        System.out.println("\nHa ganado el jugador.");
                                        jActual.setSaldo(jActual.getSaldo()
                                                + (juegoBlackjack.getApostado() * multiplicadorBlackjack));
                                        blackjackFin = true;
                                    } else {
                                        System.out.println("");
                                    }
                                    Thread.sleep(tiempoCargaMedia);
                                    break;
                                case "Plantarse":// Gonzalo Dios
                                    System.out.println("El jugador ha decidido no hacer nada mas");

                                    do {
                                        System.out.println("\nEl dealer tiene: ");
                                        controllerBlackjack.darCarta(dealer);
                                        crudBlackjack.mostrarCartas(dealer);

                                        if (controllerBlackjack.calcularValor(dealer) > limiteGanadorBlackJack) {
                                            System.out.println("\nHa ganado el jugador.");
                                            jActual.setSaldo(jActual.getSaldo()
                                                    + (juegoBlackjack.getApostado() * multiplicadorBlackjack));
                                            blackjackFin = true;
                                        } else if (controllerBlackjack.calcularValor(dealer) == limiteGanadorBlackJack
                                                || (controllerBlackjack.calcularValor(dealer) > controllerBlackjack
                                                        .calcularValor(usuario)
                                                        && controllerBlackjack
                                                                .calcularValor(dealer) < limiteGanadorBlackJack)) {
                                            System.out.println("\nHa ganado el dealer.");
                                            blackjackFin = true;
                                        }
                                    } while (!blackjackFin);
                                    Thread.sleep(tiempoCargaMedia);
                                    break;
                                case "Doblar apuesta": // Gonzalo Dios
                                    if (crudJugador.comprobarApuesta(cantidadActualApostada)) {
                                        System.out.println("El usuario va a doblar la apuesta: ");
                                        jActual.setSaldo(jActual.getSaldo() - cantidadActualApostada);
                                        juegoBlackjack
                                                .setApostado(juegoBlackjack.getApostado() + cantidadActualApostada);

                                        System.out.println("El usuario tiene: ");
                                        controllerBlackjack.darCarta(usuario);
                                        crudBlackjack.mostrarCartas(usuario);

                                        if (controllerBlackjack.calcularValor(usuario) > limiteGanadorBlackJack) {
                                            System.out.println("\nHa perdido el jugador.");
                                            blackjackFin = true;
                                        }
                                    } else {
                                        System.out.println(
                                                "El jugador no puede doblar la apuesta por que no dispone de dinero suficiente.");
                                    }
                                    System.out.println("");
                                    Thread.sleep(tiempoCargaMedia);
                                    break;
                                default: // Pablo García María
                                    System.out.println("Opción inválida, retornando al menu");
                                    Thread.sleep(tiempoCargaMedia);
                                    break;
                            }
                        } while (!blackjackFin);
                        opcion = 99;
                        break;
                }
            }
        } while (!salir);
    }
}
