package fuzzySystem;

/**
 *
 * @author iulisloi
 */
public class ElementoFuzzy {
    String elemento;
    double grauPertinencia;

    public ElementoFuzzy(String elemento, double grauPertinencia) {
        this.elemento = elemento;
        this.grauPertinencia = grauPertinencia;
    }

    public String getElemento() {
        return elemento;
    }

    public double getGrauPertinencia() {
        return grauPertinencia;
    }
}
