package fuzzySystem;

import java.util.ArrayList;

/**
 *
 * @author iulisloi
 */
public class Regra {

    ArrayList<String> questoes = new ArrayList<>();
    String resultado;

    public Regra(ArrayList<String> questoes, String resultado) {

        this.questoes = questoes;
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public boolean compare(ArrayList<String> questoes) {
        for (int i = 0; i < this.questoes.size(); i++) {
            if (!this.questoes.get(i).equals(questoes.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        System.out.print("{ ");
        for (String s : this.questoes) {
            System.out.print(s);
            System.out.print(", ");
        }
        System.out.print(" => ");
        System.out.print(resultado);
        System.out.println(" }");
    }
}
