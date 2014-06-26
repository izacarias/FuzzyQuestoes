package fuzzySystem;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author iulisloi
 */
public class BaseRegras {

    private final ArrayList<Regra> baseRegras;
    private final TreeMap<String, Integer> valoresLinguisticos;

    public BaseRegras() {
        // declara os Collections utilizados
        this.baseRegras = new ArrayList<>();
        this.valoresLinguisticos = new TreeMap<>();
        // Cria array com variáveis linguísticas
        this.valoresLinguisticos.put("NS", 2);
        this.valoresLinguisticos.put("SP", 6);
        this.valoresLinguisticos.put("S", 9);
        // monta a base de conhecimento
        double mediaResult;
        String resultado;
        String q0, q1, q2, q3, q4, q5, q6, q7, q8, q9;
        for (int i = 0; i < (Math.pow(3, 10)); i++) {
            q0 = this.valoresLinguisticos.keySet().toArray()[
                    (int) Math.ceil(i / Math.pow(3, 9)) % 3]
                    .toString();
            q1 = this.valoresLinguisticos.keySet().toArray()[
                    (int) Math.ceil(i / Math.pow(3, 8)) % 3]
                    .toString();
            q2 = this.valoresLinguisticos.keySet().toArray()[
                    (int) Math.ceil(i / Math.pow(3, 7)) % 3]
                    .toString();
            q3 = this.valoresLinguisticos.keySet().toArray()[
                    (int) Math.ceil(i / Math.pow(3, 6)) % 3]
                    .toString();
            q4 = this.valoresLinguisticos.keySet().toArray()[
                    (int) Math.ceil(i / Math.pow(3, 5)) % 3]
                    .toString();
            q5 = this.valoresLinguisticos.keySet().toArray()[
                    (int) Math.ceil(i / Math.pow(3, 4)) % 3]
                    .toString();
            q6 = this.valoresLinguisticos.keySet().toArray()[
                    (int) Math.ceil(i / Math.pow(3, 3)) % 3]
                    .toString();
            q7 = this.valoresLinguisticos.keySet().toArray()[
                    (int) Math.ceil(i / Math.pow(3, 2)) % 3]
                    .toString();
            q8 = this.valoresLinguisticos.keySet().toArray()[
                    (int) Math.ceil(i / Math.pow(3, 1)) % 3]
                    .toString();
            q9 = this.valoresLinguisticos.keySet().toArray()[(int) 1 % 3]
                    .toString();
            // calcula o resultado conforme média das notas
            mediaResult = (valoresLinguisticos.get(q0)
                    + valoresLinguisticos.get(q1)
                    + valoresLinguisticos.get(q2)
                    + valoresLinguisticos.get(q3)
                    + valoresLinguisticos.get(q4)
                    + valoresLinguisticos.get(q5)
                    + valoresLinguisticos.get(q6)
                    + valoresLinguisticos.get(q7)
                    + valoresLinguisticos.get(q8)
                    + valoresLinguisticos.get(q9)) / 9;
            // regras 
            if (mediaResult <= 4) {
                resultado = "NS";
            } else if (mediaResult < 8) {
                resultado = "SP";
            } else {
                resultado = "S";
            }
            Regra regra = new Regra(q0, q1, q2, q3, q4, q5, q6, q7, q8, q9, resultado);
            this.baseRegras.add(regra);
        }

        // print of knoledgeBase for debug purpose
        if (fuzzyquestoesgrupo.FuzzyQuestoesGrupo.DEBUG) {
            for (Regra r : this.baseRegras) {
                r.print();
            }
        }
    }
    
    public String findResultado(String q0, String q1, String q2, String q3, String q4,
            String q5, String q6, String q7, String q8, String q9){
        String resultado = "";
        for (Regra r : this.baseRegras) {
            if (r.compare(q0, q1, q2, q3, q4, q5, q6, q7, q8, q9)) {
                resultado = r.getResultado();
            }
        }
        return resultado;
    }
}
