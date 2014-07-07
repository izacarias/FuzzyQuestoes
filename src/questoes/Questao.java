package questoes;

import java.util.ArrayList;

/**
 *
 * @author Gustavo B. Paulus, Iulisloi Zacarias, Rafael A. Vitalli
 */
public class Questao {
    
    private String texto;
    private ArrayList<Alternativa> alternativas;

    public Questao(String texto) {
        this.texto = texto;
        this.alternativas = new ArrayList<>();
    }
    
    public void addAlternativa(Alternativa alt){
        this.alternativas.add(alt);
    }

    public String getTexto() {
        return texto;
    }

    public ArrayList<Alternativa> getAlternativas() {
        return alternativas;
    }
    
    public int getAcertos(){
        int pontos = 0;
        for (Alternativa alt : this.alternativas) {
            if (alt.getResposta().equals(alt.getCorreta())) {
                pontos += 2;
            }
        }
        return pontos;
    }
}
