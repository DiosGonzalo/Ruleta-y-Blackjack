package view;

import view.tools.Herramientas;

public class VistaPrincipal { //

    public static void imprimirLogo() { // Hugo Carmona
        System.out.println("""
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,'''',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,;ll:,',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,''ckkl,',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,''''',,,',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,''',,'.',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,''',,'.'',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,'',,,'..',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,',,,'',,,,,,,,'',''',,''.',,,'',,,,,,''''',,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,;ll:,;:clllllc:;,'.',,''..',,;:cclcc::,,col;,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,lkkl;;;;;;:cooolc;',,'''..;:lolc:;,,,,';okd:',,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,',;;,',,,,,',:oool:,''.''':oolc:,'',,,,,,,;,'',,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,',codo:,,'''',colc:,',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,';cll;,,'''.';:;;,'',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,',:ccc:cc:;,'..   .',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,',cdO0kO0000kdoc:,.',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,;;,,oKNX0KNNWNKkO0ko,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,;okdoONXxlkNNWNOldXXOooxo;',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,cxkOKNNXKNNNXXXXXNNXOxxc,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,lxkOKKKK0OOO0KKK0kxl,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,cddkKNNNNNNXXKkddc,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,',cokKNWWWWWXko:;,',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,',;cldxxxdl:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,',,,,,,,,,,;,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,coccccoo;,,,,colccccccccccoc,:llccclccccloo;collcccccccccol;,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,;ol;;;,ld:,,,;dl;;;;;;;;;;;oo;oOdc:::;;;;,ldcoo;;;;;;;;;;;lo:,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,;oo;;;;od:,,,;dl;;;;::;;;;;od;lOd:;;;;:cccoxloo;;;;:::;;;;cdc',,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,;do::::od;,,,;dl;::ldodl:::ld:lOd::::lxollll:oo:::cdodo:::cdl,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,;do::::dd,,,,:do:::do:dd:::lxllOdc:::dd;'',',od:::od:oxc::cdo,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,':ddccccxo,',':docccdo;oxccclxolOxlcccdd;',,,;ddcccod:lxlcccdo;,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,':ddllllxxlllodxdlllxxlxxllllxooOxllllxxlcclllxdllldkodkollldd;',,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,:xxlllloddddk0OdlllodddollllxddOxollloxddddkkkxllloddddollldx:',,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,:xxooooooooox0OdooooooooooookdoOxooooooooooxkkxooooooooooooxd;,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,':xkxxxxxxxxxkkxdddxxxxxxdddxxccxxxdddxxxxxxkkdxdddxxxxdddddxl,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,;:::::::cccc;,;;;:::::::;;;;,,;;;;::::::ccc:,,;;;::::::;;;;,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,;:;,,,,,;::;,,,,;::,,,;::;,,,;::,,,,,,,::;,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,l0K0d;,;d0KKkc,,cOKKxodOKKk:;o0KKkc,,,:xKKOc,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,dNWNKl,oXWNWNk:;kNNNKOKXWWXo:ONWWN0o,,cKWNXd,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,l0NWNxcONNNNNXolKWNNxxKXWWXocONNWNNXx;cKWWXd,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,;xNNNKOXNNNNNN00NNN0ldXNWWXocONWWNNWNOxKWWNd,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,l0WNNNNNXO0NNNNNNNx;dXNWWXo:OWNNKKNWNXNWWXd,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,;xNNNNNNOcdXWNNNN0c,dXNNWXocONNNklkXNNWWNNd,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,lKWWNNXo,:ONNNWNx;,dXNWWXocONNNk;;dKNWWNXd,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,;dXWWNk:,,oKNWN0c,,o0XWNKl:kNWNx;,,l0NWWXo,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,;lxxo:,,,,cdxd:,,,;:lxxl;,cdxo:,,,,:oxxl;,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,',,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                """); // Hugo Carmona
    }

    public static void imprimirMenu(String titulo, String[] opciones, int tamanno, int opcionAbandonar) { // Pablo
                                                                                                          // García
                                                                                                          // María
        view.tools.Herramientas.limpiarPantalla();
        int tamMinTitulo = 10;
        String cadena = "═══════════════════════", convertido;

        switch (tamanno) {
            case 30:
                cadena = "═══════════════════════════════════════";
                titulo = "\t" + titulo + "\t";
                break;
            case 28:
                cadena = "═══════════════════════════════";
                titulo = "" + titulo + "";
            default:
                break;
        }

        convertido = Herramientas.adaptarTamanno(titulo, tamMinTitulo);

        System.out.printf("""
                ╔════════════════%s╗
                ║	 %s	                ║
                ╠═══════════════╦%s╣
                """, cadena, convertido, cadena);

        for (int i = 0; i < opciones.length; i++) {
            convertido = Herramientas.adaptarTamanno(opciones[i], tamanno);
            if (i != 0) {
                System.out.printf("""
                        ║	%d	║ %s	║
                        """, i, convertido);
            }
        }

        convertido = Herramientas.adaptarTamanno(opciones[opcionAbandonar], tamanno);
        System.out.printf("""
                ║	%d	║ %s	║
                ╚═══════════════╩%s╝
                """, opcionAbandonar, convertido, cadena);
    }

    public static void imprimirMenu(String titulo, String[] opciones, int tamanno) { // Pablo García María - Mover a
                                                                                     // Views/VistaPrincipal
        int tamMinTitulo = 10;
        String cadena = "═══════════════════════", convertido;

        switch (tamanno) {
            case 30:
                cadena = "═══════════════════════════════════════";
                titulo = "\t" + titulo + "\t";
                break;
            case 29:
                cadena = "═══════════════════════════════";
                titulo = "" + titulo + "";
            default:
                break;
        }

        convertido = Herramientas.adaptarTamanno(titulo, tamMinTitulo);

        System.out.printf("""
                ╔════════════════%s╗
                ║	 %s	                ║
                ╠═══════════════╦%s╣
                """, cadena, convertido, cadena);

        for (int i = 0; i < opciones.length; i++) {
            convertido = Herramientas.adaptarTamanno(opciones[i], tamanno);
            System.out.printf("""
                    ║	%d	║ %s	║
                    """, i, convertido);
        }

        System.out.printf("""
                ╚═══════════════╩%s╝
                """, cadena);
    }

}
