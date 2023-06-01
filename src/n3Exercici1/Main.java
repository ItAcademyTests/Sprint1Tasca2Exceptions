package n3Exercici1;

public class Main {
    public static Cine cine = new Cine();

    public static void main(String[] args) {

        int opcio;
        do {
            opcio = cine.menu();
            switch (opcio) {
                case 1:
                    mostrarTotesButaquesReservades();
                    break;
                case 2:
                    mostrarButaquesReservadesPerPersona();
                    break;
                case 3:
                    reservarButaca();
                    break;
                case 4:
                    anularReservaButaca();
                    break;
                case 5:
                    anularReservesButaquesPerPersona();
                    break;
                case 0:
                    System.out.println("¡Adeu!");
                    break;
                default:
                    System.out.println("Opció no válida");
            }
            System.out.println();
        } while (opcio != 5);
    }

    private static void mostrarTotesButaquesReservades() {
        cine.mostrarButaques();
    }

    private static void mostrarButaquesReservadesPerPersona() {
        cine.mostrarButaquesPerPersona(cine.introduirPersona());
    }

    private static void reservarButaca() {
        cine.reservarButaca();
    }

    private static void anularReservaButaca() {
        cine.eliminarButaca(cine.introduirFila(),
                cine.introduirSeient());
    }

    private static void anularReservesButaquesPerPersona() {
        cine.eliminarButaquesPerPersona(cine.introduirPersona());
    }

}
