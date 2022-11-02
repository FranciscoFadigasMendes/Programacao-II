package util;

import java.util.Scanner;

/**
 * Classe que disponibiliza um conjunto de metodos para ler dados a partir da
 * consola.
 *
 * @author Anabela
 */
public class Consola {

    /**
     * Representa a consola.
     */
    public static Scanner sc = new Scanner(System.in);

    /**
     * Permite ler do teclado um valor inteiro compreendido entre um mnimo e um
     * mÃ¡ximo.
     *
     * @param texto texto a apresentar no ecrÃ£.
     * @param min valor mÃ¡nimo que poderÃ¡ ser introduzido.
     * @param max valor mÃ¡ximo que poderÃ¡ ser introduzido.
     * @return Valor inteiro.
     */
    public static int lerInt(String texto, int min, int max) {
        int num = -1;

        do {
            System.out.print(texto);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                if (num < min || num > max) {
                    System.out.println("NÃºmero invÃ¡lido. NÃºmero deve estar compreendido entre " + min + " e " + max + ".");
                }
            } else {
                System.out.println("Tem de introduzir um nÃºmero inteiro!");
            }
            sc.nextLine();
        } while (num < min || num > max);
        return num;
    }

    /**
     * Permite ler do teclado um valor inteiro longo compreendido entre um
     * mÃ­nimo e um mÃ¡ximo.
     *
     * @param texto texto a apresentar no ecrÃ£.
     * @param min valor mÃ­nimo que poderÃ¡ ser introduzido.
     * @param max valor mÃ¡ximo que poderÃ¡ ser introduzido.
     * @return Valor inteiro longo.
     */
    public static long lerLong(String texto, long min, long max) {
        long num = -1;

        do {
            System.out.print(texto);
            if (sc.hasNextLong()) {
                num = sc.nextLong();
                if (num < min || num > max) {
                    System.out.println("NÃºmero invalido. NÃºmero deve estar compreendido entre " + min + " e " + max + ".");
                }
            } else {
                System.out.println("Tem de introduzir um nÃºmero inteiro!");
            }
            sc.nextLine();
        } while (num < min || num > max);
        return num;
    }

    /**
     * Permite ler do teclado um valor real compreendido entre um mÃ­nimo e um
     * mÃ¡ximo.
     *
     * @param texto texto a apresentar no ecrÃ£.
     * @param min valor mÃ­nimo que poderÃ¡ ser introduzido.
     * @param max valor mÃ¡ximo que poderÃ¡ ser introduzido.
     * @return Valor real.
     */
    public static float lerFloat(String texto, float min, float max) {
        float num = -1;

        do {
            System.out.print(texto);
            if (sc.hasNextFloat()) {
                num = sc.nextFloat();
                if (num < min || num > max) {
                    System.out.println("NÃºmero invalido. NÃºmero deve estar compreendido entre " + min + " e " + max + ".");
                }
            } else {
                System.out.println("Tem de introduzir um nÃºmero real!");
            }
            sc.nextLine();
        } while (num < min || num > max);
        return num;
    }

    /**
     * Permite ler do teclado um valor real (double) compreendido entre um
     * mÃ­nimo e um mÃ¡ximo.
     *
     * @param texto texto a apresentar no ecrÃ£.
     * @param min valor mÃ­nimo que poderÃ¡ ser introduzido.
     * @param max valor mÃ¡ximo que poderÃ¡ ser introduzido.
     * @return Valor real (double).
     */
    public static double lerDouble(String texto, double min, double max) {
        double num = -1;

        do {
            System.out.print(texto);
            if (sc.hasNextDouble()) {
                num = sc.nextDouble();
                if (num < min || num > max) {
                    System.out.println("NÃºmero invalido. NÃºmero deve estar compreendido entre " + min + " e " + max + ".");
                }
            } else {
                System.out.println("Tem de introduzir um nÃºmero real!");
            }
            sc.nextLine();
        } while (num < min || num > max);
        return num;
    }

    /**
     * Permite ler do teclado um caracter dentro de um conjunto de valores
     * (opcoes) possÃ­veis.
     *
     * @param texto texto a apresentar no ecrÃ£.
     * @param opcoes valores possÃ­veis de entrada.
     * @return Caracter.
     */
    public static char lerChar(String texto, String opcoes) {
        char ch = '\0';

        do {
            System.out.print(texto);
            ch = sc.next().charAt(0);
            if (opcoes.indexOf(ch) == -1) {
                System.out.println("OpÃ§Ã£o invÃ¡lida. Caracter deve ser um dos seguintes: " + opcoes + ".");
            }
            sc.nextLine();
        } while (opcoes.indexOf(ch) == -1);
        return ch;
    }

    /**
     * Permite ler do teclado uma string.
     *
     * @param texto texto a apresentar no ecrÃ£.
     * @return String.
     */
    public static String lerString(String texto) {
        String str = "";

        do {
            System.out.print(texto);
            str = sc.nextLine();
            if (str.length() == 0) {
                System.out.println("String vazia.");
            }

        } while (str.length() == 0);
        return str;
    }
}
