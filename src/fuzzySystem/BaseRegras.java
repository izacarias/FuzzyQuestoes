package fuzzySystem;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.LinkedHashMap;

/**
 *
 * @author Gustavo B. Paulus, Iulisloi Zacarias, Rafael A. Vitalli
 */
public class BaseRegras {

    private final ArrayList<Regra> baseRegras;
    private final TreeMap<String, Integer> valoresLinguisticos;

    public BaseRegras() {
        // declara os Collections utilizados
        this.baseRegras = new ArrayList<>();
        this.valoresLinguisticos = new TreeMap<>();
        // Cria array com variáveis linguísticas
        this.valoresLinguisticos.put(VariavelLinguistica.NS, 2);
        this.valoresLinguisticos.put(VariavelLinguistica.SP, 6);
        this.valoresLinguisticos.put(VariavelLinguistica.S, 9);
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
            ArrayList<String> opcoes = new ArrayList<>();
            opcoes.add(q0);
            opcoes.add(q1);
            opcoes.add(q2);
            opcoes.add(q3);
            opcoes.add(q4);
            opcoes.add(q5);
            opcoes.add(q6);
            opcoes.add(q7);
            opcoes.add(q8);
            opcoes.add(q9);
            Regra regra = new Regra(opcoes, resultado);
            this.baseRegras.add(regra);
        }

        // print of knoledgeBase for debug purpose
        if (fuzzyquestoesgrupo.FuzzyQuestoesGrupo.DEBUG) {
            for (Regra r : this.baseRegras) {
                r.print();
            }
        }
    }
    
    public String queryResultado(ArrayList<String> questoes){
        return this.queryResultado(questoes, false);
    }

    public String queryResultado(ArrayList<String> questoes, boolean debug) {
        String resultado = "";
        if (!debug) {
            for (Regra r : this.baseRegras) {
                if (r.compare(questoes)) {
                    resultado = r.getResultado();
                }
            }
        } else {
            int mediaResult = 0;
            for(String q : questoes){
                mediaResult += valoresLinguisticos.get(q);
            }
            mediaResult = mediaResult / questoes.size();
            // regras 
            if (mediaResult <= 4) {
                resultado = "NS";
            } else if (mediaResult < 8) {
                resultado = "SP";
            } else {
                resultado = "S";
            }
        }
        return resultado;
    }

    public String[][] geraCombinacoesPossiveis(ListaParesFuzzy listaParesFuzzy) {
        BaseDadosEntrada bde = new BaseDadosEntrada();
        LinkedHashMap<ParFuzzy, ArrayList<String>> conjQuestoes = new LinkedHashMap<>();
        int qtdQuestoes = listaParesFuzzy.size();
        int numComb = 1;
        int linhasValidas = 0;
        for (ParFuzzy p : listaParesFuzzy.asList()) {
            ArrayList<String> possInf = bde.getPossibilidadesInferencia(p);
            conjQuestoes.put(p, possInf);
            numComb = numComb * possInf.size();
        }
        String[][] possGeradas = new String[numComb][qtdQuestoes];
        for (int indexLinha = 0; indexLinha < (int) Math.pow(2, qtdQuestoes); indexLinha++) {
            int indexQuestao = 0;
            int fatorExpoente;
            String[] opcoesLinha = new String[qtdQuestoes];
            boolean outOfOptions = false;
            for (ParFuzzy p : listaParesFuzzy.asList()) {
                int indexOpcao;
                // String opAtual = "";
                fatorExpoente = (int) Math.pow(2, indexQuestao);
                indexOpcao = ((int) indexLinha / fatorExpoente) % 2;
                if (indexOpcao > conjQuestoes.get(p).size() - 1) {
                    outOfOptions = true;
                    break;
                }
                opcoesLinha[indexQuestao]
                        = conjQuestoes.get(p).get(indexOpcao);
                indexQuestao++;
            }
            if (!outOfOptions) {
                possGeradas[linhasValidas] = opcoesLinha;
                linhasValidas++;
            }
        }
        return possGeradas;
    }
}
