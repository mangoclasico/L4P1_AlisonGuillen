/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4p1_alisonguillen;

import java.util.Scanner;
import java.util.Random;

public class Lab4P1_AlisonGuillen {

    public static void main(String[] args) {
        Scanner rd = new Scanner(System.in);
        Random random = new Random();

        int Respuesta = 1;

        while (Respuesta != 4) {
            System.out.println("\n Menu");
            System.out.println("1. Trapecio hueco");
            System.out.println("2. Juego de carreras ");
            System.out.println("3. Patrón de cuadrado ");
            System.out.println("4. Salir");
            int opcion = rd.nextInt();

            switch (opcion) {
                case 1:
                    int fila;
                    int ancho;

                    System.out.print("Ingrese altura: ");
                    fila = rd.nextInt();

                    System.out.print("Ingrese ancho: ");
                    ancho = rd.nextInt();

                    if (fila < 5 || ancho < 5) {
                        System.out.println("Ingrese un tamaño mayor o igual a 5 para altura y ancho.");
                    } else {
                        System.out.println("");

                        for (int i = 0; i < fila; i++) {
                            for (int j = fila - i; j > 0; j--) {
                                System.out.print(" ");
                            }
                            for (int j = 0; j < (ancho / 2) + (2 * i); j++) {
                                if (i == 0 || i == fila - 1 || j == 0 || j == (ancho / 2) + (2 * i) - 1) {
                                    System.out.print("*");
                                } else {
                                    System.out.print(" ");
                                }
                            }
                            System.out.println();
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("Bienvenido al juego de carreras!");

                    System.out.print("Nombre del jugador 1: ");
                    String jugador1 = rd.next();

                    System.out.print("Nombre del jugador 2: ");
                    String jugador2 = rd.next();

                    int esuerte1 = random.nextInt(37) + 1;
                    int esuerte2 = random.nextInt(37) + 1;
                    while (esuerte2 == esuerte1 || esuerte2 == 0 || esuerte2 == 39) {
                        esuerte2 = random.nextInt(37) + 1;
                    }
                    //posicion del jugador

                    int pj1 = 0;
                    int pj2 = 0;

                    while (true) {
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 39; j++) {
                                if (j == esuerte1 || j == esuerte2) {
                                    System.out.print("+");
                                } else {
                                    System.out.print("*");
                                }
                            }
                            System.out.println();
                        }

                        char[] pista1 = new char[40];
                        char[] pista2 = new char[40];
                        pista1[pj1] = '1';
                        pista2[pj2] = '2';

                        System.out.print(new String(pista1));
                        System.out.print(new String(pista2));

                        System.out.println("\naccion de" +jugador1+" \nPresiona \n1: para lanzar el dado \n2: para no hacer nada, o \n3: para salir: ");
                        int o1 = rd.nextInt();

                        if (o1 == 1) {
                            int dado = random.nextInt(6) + 1;
                            pj1 += dado;
                        } else if (o1 == 3) {
                            System.out.println(jugador1 + " salió del juego. El juego ha terminado.");
                            break;
                        }

                        System.out.println(jugador1 + " está en la posición " + pj1);

                        if (pj1 >= 39) {
                            System.out.println(jugador1 + " ha ganado la carrera!");
                            break;
                        }

                        System.out.println("\naccion de "+jugador1+" \nPresiona \n1: para lanzar el dado, \n2: para no hacer nada, o \n3: para salir: ");
                        int o2 = rd.nextInt();

                        if (o2 == 1) {
                            int dado = random.nextInt(6) + 1;
                            pj2 += dado;
                        } else if (o2 == 3) {
                            System.out.println(jugador2 + " ha decidido salir. El juego ha terminado.");
                            break;
                        }

                        System.out.println(jugador2 + " está en la posición " + pj2);

                        if (pj2 >= 39) {
                            System.out.println(jugador2 + " ha ganado la carrera!");
                            break;
                        }

                        if (pj1 == esuerte1) {
                            pj1 += 3;
                        }
                        if (pj2 == esuerte2) {
                            pj2 += 3;
                        }

                        if (pj1 < 0) {
                            pj1 = 0;
                        }
                        if (pj2 < 0) {
                            pj2 = 0;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el tamaño del cuadrado (Mayor a 3): ");
                    int tamano = rd.nextInt();
                    for (int a = 0; a < tamano; a++) {
                        for (int b = 0; b < tamano; b++) {
                            if (a == 0 || a == tamano - 1 || b == 0 || b == tamano - 1) {
                                System.out.print("* ");
                            } else {
                                System.out.print("- ");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    Respuesta = 4;
                    break;

                default:
                    System.out.println("Por favor, elija una opción válida");
            }
        }
    }
}
