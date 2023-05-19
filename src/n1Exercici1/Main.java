package n1Exercici1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        var productes = new ArrayList<Producte>();

        productes.add(new Producte("Producte 1", 10));
        productes.add(new Producte("Producte 2", 20));
        productes.add(new Producte("Producte 3", 30));

        var v1 = new Venda();
        v1.setPreuTotal(v1.calculartotal(productes));
        System.out.println(v1.getPreuTotal());

        int[] nombresEnters = {10, 20, 30, 40};

        try {
            System.out.println(nombresEnters[4]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }



    }

}
