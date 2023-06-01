package n3Exercici1;

import n3Exercici1.exception.ExcepcioButacaLliure;
import n3Exercici1.exception.ExcepcioButacaOcupada;

import java.util.ArrayList;
import java.util.List;

public class GestioButaques {

    private List<Butaca> butaques;

    public GestioButaques() {
        butaques = new ArrayList<>();
    }

    public List<Butaca> getButaques() {
        return butaques;
    }

    public void afegirButaca(Butaca butaca) {
        try {
            if (cercarButaca(butaca.getFila(), butaca.getSeient()) != -1) {
                throw new ExcepcioButacaOcupada("Butaca ocupada.");
            }
        } catch (ExcepcioButacaOcupada e) {
            System.out.println("Error: " + e.getMessage());
        }
        this.butaques.add(butaca);
    }

    public int cercarButaca(int fila, int seient) {
        for (Butaca b : this.butaques) {
            if (b.getFila() == fila && b.getSeient() == seient) {
                return this.butaques.indexOf(b);
            }
        }
        return -1;
    }

    public void eliminarButaca(int fila, int seient) {
        int index = cercarButaca(fila, seient);
        try {
            if (index == -1) {
                throw new ExcepcioButacaLliure("Butaca lliure.");
            }
        } catch (ExcepcioButacaLliure e) {
            System.out.println("Error: " + e.getMessage());
        }
        this.butaques.remove(index);
    }

    public void eliminarButacaPerPersona(String persona) {
        boolean trobat = false;
        try {
            for (Butaca b : this.getButaques()) {
                if (b.getPersona().equals(persona)) {
                    trobat = true;
                }
                if (!trobat) {
                    throw new ExcepcioButacaLliure("Butaca lliure.");
                }
                this.butaques.remove(b);
                if (this.butaques.size() == 0) {
                    break;
                }
            }
        } catch (ExcepcioButacaLliure e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
