package fuzzySystem;

/**
 *
 * @author Gustavo B. Paulus, Iulisloi Zacarias, Rafael A. Vitalli
 */
public class ParFuzzy implements Comparable<ParFuzzy>{
    
    private int valor;
    private double grauPertinencia;

    public ParFuzzy(int valor, double valorPertinencia) {
        this.valor = valor;
        this.grauPertinencia = valorPertinencia;
    }

    public int getValor() {
        return valor;
    }

    public double getValorPertinencia() {
        return grauPertinencia;
    }

    void print() {
        System.out.print("(");
        System.out.print(this.valor);
        System.out.print("/");
        System.out.print(this.grauPertinencia);
        System.out.print(")");
    }

    @Override
    public int compareTo(ParFuzzy other) {
        return Integer.compare(this.valor, other.valor);
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.valor) + "/" + 
                String.valueOf(this.grauPertinencia);
    }
    
    
}
