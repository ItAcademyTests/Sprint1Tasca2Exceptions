package n3Exercici1;

public class Butaca {

    private int fila;
    private int seient;
    private String persona;

    public Butaca(int fila, int seient, String persona) {
        this.fila = fila;
        this.seient = seient;
        this.persona = persona;
    }

    public int getFila() {
        return fila;
    }

    public int getSeient() {
        return seient;
    }

    public String getPersona() {
        return persona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Butaca butaca = (Butaca) o;
        return fila == butaca.fila && seient == butaca.seient;
    }

    @Override
    public String toString() {
        return "Butaca{" +
                "numFila=" + fila +
                ", numSeient=" + seient +
                ", persona='" + persona + '\'' +
                '}';
    }
}
