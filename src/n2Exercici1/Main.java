package n2Exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {

        var edat = llegirByte("Introdueix la teva edat\n");
        System.out.println("Edad ingressada: " + edat);

        var habitants = llegirInt("Introdueix els habitants del teu pais\n");
        System.out.println("Nombre habitants: " + habitants);

        var pes = llegirFloat("Introdueix el teu pes com a nombre decimal\n");
        System.out.println("Pes: " + pes);

        var pes2 = llegirDouble("Introdueix una altra vegada el teu pes com a double\n");
        System.out.println("Pes: " + pes2);

        var nom = llegirChar("Introdueix l'inicial del teu nom\n");
        System.out.println("Inicial del meu nom: " + nom);

        var nomICognom = llegirString("Introdueix nom i cognom\n");
        System.out.println("Nom i cognom: " + nomICognom);

        var siNo =  llegirSiNo("introdueix s o n");
        System.out.println("Si-No: " + siNo);

    }

    public static byte llegirByte(String missatge) {
        System.out.print(missatge);
        byte dada;
        while (true) {
            try {
                dada = teclat.nextByte();
                break;
            } catch (InputMismatchException e) {
                teclat.nextLine(); // Neteja el buffer d'entrada
                e.printStackTrace();
            }
        }
        return dada;
    }

    public static int llegirInt(String missatge) {
        System.out.print(missatge);
        int dada;
        while (true) {
            try {
                dada = teclat.nextInt();
                break;
            } catch (InputMismatchException e) {
                teclat.nextLine();
                e.printStackTrace();
            }
        }
        return dada;
    }

    public static float llegirFloat(String missatge) {
        System.out.print(missatge);
        float dada;
        while (true) {
            try {
                dada = teclat.nextFloat();
                break;
            } catch (InputMismatchException e) {
                teclat.nextLine();
                e.printStackTrace();
            }
        }
        return dada;
    }

    public static double llegirDouble(String missatge) {
        System.out.print(missatge);
        double dada;
        while (true) {
            try {
                dada = teclat.nextDouble();
                break;
            } catch (InputMismatchException e) {
                teclat.nextLine();
                e.printStackTrace();
            }
        }
        return dada;
    }

    public static char llegirChar(String missatge) {
        boolean dadaCorrecta = false;
        char caracter = '\0';
        while (!dadaCorrecta) {
            try {
                System.out.print(missatge);
                String dada = teclat.nextLine();
                if (dada.length() != 1) {
                    throw new Exception("S'esperava només un cacacter.");
                }
                caracter = dada.charAt(0);
                dadaCorrecta = true;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return caracter;
    }

    public static String llegirString(String missatge) {
        boolean dadaCorrecta = false;
        String dada = "";
        while (!dadaCorrecta) {
            try {
                System.out.println(missatge);
                dada = teclat.nextLine();
                for (char c : dada.toCharArray()) {
                    if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                        dadaCorrecta = false;
                        break;
                    } else {
                        dadaCorrecta = true;
                    }
                }
                if (!dadaCorrecta) {
                    throw new Exception("Error: S'esperava dada tipus String");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return dada;
    }

    public static boolean llegirSiNo(String missatge) {
        boolean dadaCorrecta = false;
        char caracter = '\0';
        while (!dadaCorrecta) {
            try {
                System.out.println(missatge);
                String dada = teclat.nextLine();
                if (dada.length() != 1) {
                    throw new Exception("S'esperava només un cacacter ('s' o 'n').");
                }
                caracter = dada.charAt(0);
                dadaCorrecta = true;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return caracter == 's';
    }

}
