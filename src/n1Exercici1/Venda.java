package n1Exercici1;

import n1Exercici1.excepcions.VendaBuidaException;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private List<Producte> productes = new ArrayList<>();
    private int preuTotal;

    public int calculartotal(List<Producte> productes) {
        validarLlistaProductes(productes);
        int preuTotal = 0;
        for (Producte p : productes) {
            preuTotal += p.getPreu();
        }
        return preuTotal;
    }

    private void validarLlistaProductes(List<Producte> productes) {
        if (productes.isEmpty()) {
            try {
                throw new VendaBuidaException();
            } catch (VendaBuidaException e) {
                e.getMessage();
            }
        }
    }

    public int getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(int preuTotal) {
        this.preuTotal = preuTotal;
    }

}
