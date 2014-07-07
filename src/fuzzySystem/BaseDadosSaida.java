/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzySystem;

import java.util.TreeMap;

/**
 *
 * @author iulisloi
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

}
