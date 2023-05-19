package n1Exercici1.excepcions;

import org.w3c.dom.ls.LSOutput;

public class VendaBuidaException extends Exception {

    public VendaBuidaException() {
        System.out.println("Per fer una venda primer has d’afegir productes");
    }

}
