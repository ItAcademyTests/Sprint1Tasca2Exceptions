package n3Exercici1;

import n1Exercici1.excepcions.ExcepcioFilaIncorrecta;
import n1Exercici1.excepcions.ExcepcioSeientIncorrecte;
import n3Exercici1.exception.ExcepcioNomPersonaIncorrecte;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cine {

    private final int NUM_FILES_TOTALS = 20;
    private static final int NUM_SEIENTS_TOTALS = 10;
    private int numFiles;
    private int numSeients;
    private GestioButaques gestioButaques;
    private static Scanner scanner = new Scanner(System.in);


    public Cine() {
        gestioButaques = new GestioButaques();
        demanarDadesInicials();
    }

    public void demanarDadesInicials() {
        this.numFiles = introduirNum("Introduir el nombre de files.");
        this.numSeients = introduirNum("Introduir el nombre de seients.");
    }

    private int introduirNum(String message) {
        System.out.println(message);
        int num;
        while (true) {
            try {
                num = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                e.printStackTrace();
            }
        }
        return num;
    }

    public int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== MENÚ =====");
        System.out.println("1.- Mostrar totes les butaques reservades.");
        System.out.println("2.- Mostrar les butaques reservades per una persona.");
        System.out.println("3.- Reservar una butaca.");
        System.out.println("4.- Anul·lar la reserva d’una butaca.");
        System.out.println("5.- Anul·lar totes les reserves d’una persona.");
        System.out.println("0.- Sortir.");
        System.out.println("Escull una opcio!");
        return sc.nextInt();
    }

    public void mostrarButaques() {
        for (Butaca b : this.gestioButaques.getButaques()) {
            System.out.println(b.toString());
        }
    }

    public void mostrarButaquesPerPersona(String persona) {
        for (Butaca b : this.gestioButaques.getButaques()) {
            if (b.getPersona().equals(persona)) {
                System.out.println(b.toString());
            }
        }
    }

    public void eliminarButaca(int fila, int seient) {
        this.gestioButaques.eliminarButaca(fila, seient);
    }

    public void eliminarButaquesPerPersona(String persona) {
        this.gestioButaques.eliminarButacaPerPersona(persona);
    }

    public void reservarButaca() {
        this.gestioButaques.afegirButaca(new Butaca(introduirFila(),
                introduirSeient(),
                introduirPersona()));
    }

    public int introduirFila() {
        System.out.println("Introduir fila");
        int fila;
        while (true) {
            try {
                fila = scanner.nextInt();
                if (fila < 1 || fila > NUM_FILES_TOTALS) {
                    throw new ExcepcioFilaIncorrecta("Fila incorrecta.");
                }
                break;
            } catch (ExcepcioFilaIncorrecta e) {
                scanner.nextLine();
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Neteja el buffer d'entrada
                e.printStackTrace();
            }
        }
        return fila;
    }

    public int introduirSeient() {
        System.out.println("Introduir seient");
        int seient;
        while (true) {
            try {
                seient = scanner.nextInt();
                if (seient < 1 || seient > NUM_SEIENTS_TOTALS) {
                    throw new ExcepcioSeientIncorrecte("Seient incorrecte.");
                }
                break;
            } catch (ExcepcioSeientIncorrecte e) {
                scanner.nextLine();
                System.out.println("Error: " + e.getMessage());
            }
        }
        return seient;
    }

    public String introduirPersona() {
        var scan = new Scanner(System.in);
        boolean dadaCorrecta = false;
        String dada = null;
        while (!dadaCorrecta) {
            try {
                System.out.println("Introduir persona");
                dada = scan.nextLine();
                for (char c : dada.toCharArray()) {
                    if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                        dadaCorrecta = false;
                        break;
                    } else {
                        dadaCorrecta = true;
                    }
                }
                if (!dadaCorrecta) {
                    throw new ExcepcioNomPersonaIncorrecte("Error: Nom persona incorrecte");
                }
            } catch (ExcepcioNomPersonaIncorrecte e) {
                scan.nextLine(); // Neteja el buffer d'entrada
                System.out.println("Error: " + e.getMessage());
            }
        }
        return dada;
    }

}
