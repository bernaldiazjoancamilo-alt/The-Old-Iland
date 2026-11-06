
import java.util.Scanner;
import java.util.Random;

public class Oldiland {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        //  Estos son los codigos ANSI para los colores usados en las tablas y los menasjes.
        final String RESET = "\u001B[0m";
        final String VERDE = "\u001B[32m";
        final String ROJO = "\u001B[31m";
        final String AZUL = "\u001B[34m";
        final String AMARILLO = "\u001B[33m";
        final String CIAN = "\u001B[36m";
        final String NEGRITA = "\u001B[1m";

        // Esto es lo que tiene inicialmente el jugador al empezar la partida.
        int salud = 100;
        int energia = 100;
        int comida = 2;
        int agua = 2;
        int madera = 0;
        int cuerda = 0;

        boolean jugando = true;

        System.out.println(CIAN + NEGRITA);
        System.out.println("========================================");
        System.out.println("              THE OLD ILAND             ");
        System.out.println("========================================");
        System.out.println(RESET);

        System.out.println("Has naufragado en una isla.");
        System.out.println("Ahora debes hacer todo lo posible para sobrevivir, estas preparado guerrero?.");
        System.out.println();

        while (jugando && salud > 0) {

            // Esta sera la tabla que contiene los datos del jugador 
            System.out.println(CIAN + NEGRITA);
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║       ESTADO DEL JUGADOR         ║");
            System.out.println("╠════════════════╦═════════════════╣");
            System.out.println("║    RECURSO     ║    CANTIDAD     ║");
            System.out.println("╠════════════════╬═════════════════╣");

            System.out.printf(ROJO + "║ %-14s ║ %15d ║%n", "Salud", salud);
            System.out.printf(AMARILLO + "║ %-14s ║ %15d ║%n", "Energia", energia);
            System.out.printf(VERDE + "║ %-14s ║ %15d ║%n", "Comida", comida);
            System.out.printf(AZUL + "║ %-14s ║ %15d ║%n", "Agua", agua);
            System.out.printf(CIAN + "║ %-14s ║ %15d ║%n", "Madera", madera);
            System.out.printf(CIAN + "║ %-14s ║ %15d ║%n", "Cuerda", cuerda);

            System.out.println(RESET + "╚════════════════╩═════════════════╝");

            // Este sera el menu de acciones que puede realizar el jugador por cada turno que juegue.
            System.out.println(AMARILLO + NEGRITA);
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║          MENU DE ACCIONES        ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println(VERDE + "║  [1] Buscar comida               ║");
            System.out.println(AZUL + "║  [2] Buscar agua                 ║");
            System.out.println(CIAN + "║  [3] Explorar la isla            ║");
            System.out.println(AMARILLO + "║  [4] Descansar                   ║");
            System.out.println(VERDE + "║  [5] Construir una balsa         ║");
            System.out.println(ROJO + "║  [6] Salir del juego             ║");
            System.out.println(RESET + "╚══════════════════════════════════╝");

            System.out.print("Escoge una opcion: ");
            int opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    if (energia >= 10) {
                        int encontrada = random.nextInt(3) + 1;
                        comida += encontrada;
                        energia -= 10;

                        System.out.println(VERDE
                                + "Has encontrado " + encontrada
                                + "comida." + RESET);
                    } else {
                        System.out.println(ROJO
                                + "No tienes la energia suficiente." + RESET);
                    }
                    break;

                case 2:
                    if (energia >= 10) {
                        int encontrada = random.nextInt(3) + 1;
                        agua += encontrada;
                        energia -= 10;

                        System.out.println(AZUL
                                + "Has encontrado " + encontrada
                                + " agua." + RESET);
                    } else {
                        System.out.println(ROJO
                                + "No tienes la energia suficiente." + RESET);
                    }
                    break;

                case 3:
                    if (energia >= 20) {
                        energia -= 20;

                        int resultado = random.nextInt(3);

                        if (resultado == 0) {
                            madera += 2;
                            System.out.println(VERDE
                                    + "Has encontrado 2 trozos de madera."
                                    + RESET);
                        } else if (resultado == 1) {
                            cuerda += 1;
                            System.out.println(VERDE
                                    + "Has encontrado una cuerda." + RESET);
                        } else {
                            salud -= 10;
                            System.out.println(ROJO
                                    + "Te has lastimado. Pierdes 10 de salud."
                                    + RESET);
                        }
                    } else {
                        System.out.println(ROJO
                                + "No tienes energia suficiente." + RESET);
                    }
                    break;

                case 4:
                    energia += 30;

                    if (energia > 100) {
                        energia = 100;
                    }

                    System.out.println(AMARILLO
                            + "Has descansado y recuperado energia."
                            + RESET);
                    break;

                case 5:
                    if (madera >= 5 && cuerda >= 3) {
                        madera -= 5;
                        cuerda -= 3;

                        System.out.println(VERDE + NEGRITA
                                + "¡Has construido una balsa!"
                                + RESET);
                        System.out.println(VERDE
                                + "¡En horabuena has conseguido escapar de la isla!"
                                + RESET);

                        jugando = false;
                    } else {
                        System.out.println(ROJO
                                + "No tienes suficientes materiales."
                                + RESET);
                        System.out.println("Necesitas 5 de madera y 3 de cuerda.");
                    }
                    break;

                case 6:
                    jugando = false;
                    System.out.println(AMARILLO
                            + "Has abandonado el juego." + RESET);
                    break;

                default:
                    System.out.println(ROJO
                            + "Opcion no valida." + RESET);
            }

            // Este sera el consumo de agua y comida y la perdida de salud si no tiene ninguno de estos recursos.
            if (jugando) {

                if (comida > 0) {
                    comida--;
                } else {
                    salud -= 15;
                    System.out.println(ROJO
                            + "No tienes comida. Pierdes salud." + RESET);
                }

                if (agua > 0) {
                    agua--;
                } else {
                    salud -= 20;
                    System.out.println(ROJO
                            + "No tienes agua. Pierdes salud." + RESET);
                }

                if (salud > 0) {
                    System.out.println(CIAN + "Fin del turno." + RESET);
                }
            }
        }

        // resultado final del juego, mensaje que avisa si el jugador ha perdido o ganado.
        if (salud <= 0) {
            System.out.println(ROJO + NEGRITA);
            System.out.println("========================================");
            System.out.println("       HAS PERDIDO LA PARTIDA");
            System.out.println("========================================");
            System.out.println(RESET);
            System.out.println("No has sobrevivido a la isla.");
        }

        teclado.close();
    }
}
