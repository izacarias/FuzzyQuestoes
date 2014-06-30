/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzySystem;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author iulisloi
 */
public class BaseDadosEntrada {

    private final TreeMap<Integer, Double> valoresNS;
    private final TreeMap<Integer, Double> valoresSP;
    private final TreeMap<Integer, Double> valoresS;

    public BaseDadosEntrada() {
        valoresNS = new TreeMap<>();
        valoresSP = new TreeMap<>();
        valoresS = new TreeMap<>();
        // valores para NS
        valoresNS.put(0, 1.0);
        valoresNS.put(2, 1.0);
        valoresNS.put(4, 0.8);
        valoresNS.put(6, 0.0);
        valoresNS.put(8, 0.0);
        valoresNS.put(10, 0.0);
        // valores para SP
        valoresSP.put(0, 0.0);
        valoresSP.put(2, 0.0);
        valoresSP.put(4, 0.2);
        valoresSP.put(6, 1.0);
        valoresSP.put(8, 0.2);
        valoresSP.put(10, 0.0);
        // valores S
        valoresS.put(0, 0.0);
        valoresS.put(2, 0.0);
        valoresS.put(4, 0.0);
        valoresS.put(6, 0.0);
        valoresS.put(8, 0.8);
        valoresS.put(10, 1.0);
    }

    public ArrayList<String> getPossibilidadesInferencia(int valoreEntrada) {
        ArrayList<String> possInferencia = new ArrayList<>();
        if (valoresNS.get(valoreEntrada) > 0) {
            possInferencia.add(VariavelLinguistica.NS);
        }

        if (valoresSP.get(valoreEntrada) > 0) {
            possInferencia.add(VariavelLinguistica.SP);
        }

        if (valoresS.get(valoreEntrada) > 0) {
            possInferencia.add(VariavelLinguistica.S);
        }
        return possInferencia;
    }

    public ArrayList<String> getPossibilidadesInferencia(ParFuzzy par) {
        int valor = par.getValor();
        return this.getPossibilidadesInferencia(valor);
    }

}
