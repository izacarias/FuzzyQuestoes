package fuzzySystem;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author Gustavo B. Paulus, Iulisloi Zacarias, Rafael A. Vitalli
 */
public class BaseDadosSaida {

    private TreeMap<Integer, Double> valoresNS;
    private TreeMap<Integer, Double> valoresSP;
    private TreeMap<Integer, Double> valoresS;

    public BaseDadosSaida() {
        this.geraBaseSaida();
    }

    private void geraBaseSaida() {
        valoresNS = new TreeMap<>();
        valoresSP = new TreeMap<>();
        valoresS = new TreeMap<>();
        // valores para NS
        valoresNS.put(0, 1.0);
        valoresNS.put(20, 1.0);
        valoresNS.put(40, 0.8);
        valoresNS.put(60, 0.0);
        valoresNS.put(80, 0.0);
        valoresNS.put(100, 0.0);
        // valores para SP
        valoresSP.put(0, 0.0);
        valoresSP.put(20, 0.0);
        valoresSP.put(40, 0.2);
        valoresSP.put(60, 1.0);
        valoresSP.put(80, 0.2);
        valoresSP.put(100, 0.0);
        // valores S
        valoresS.put(0, 0.0);
        valoresS.put(20, 0.0);
        valoresS.put(40, 0.0);
        valoresS.put(60, 0.0);
        valoresS.put(80, 0.8);
        valoresS.put(100, 1.0);
    }

    public double getValorElemento(String varLinguistica, ParFuzzy questao) {
        double resultado = -1.0;
        double grauPertinencia = questao.getValorPertinencia();
        switch (varLinguistica) {
            case "NS":
                resultado = valoresNS.get(questao);
                break;
            case "SP":
                resultado = valoresSP.get(questao);
                break;
            case "S":
                resultado = valoresS.get(questao);
                break;
        }
        return resultado;
    }

    public ArrayList<Double> getLinha(String varLinguistica) {
        ArrayList<Double> resultado = new ArrayList<>();
        switch (varLinguistica) {
            case "NS":
                resultado.addAll(this.valoresNS.values());
                break;
            case "SP":
                resultado.addAll(this.valoresSP.values());
                break;
            case "S":
                resultado.addAll(this.valoresS.values());
                break;
        }
        return resultado;
    }
}
