/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fuzzySystem;

import java.util.ArrayList;

/**
 *
 * @author iulisloi
 */
public class Fuzzyficador {
    
    public static ListaParesFuzzy fuzzyficar(ArrayList<Integer> listaValores){
        ListaParesFuzzy listaParesFuzzy = new ListaParesFuzzy();
        for (int valor: listaValores){
            ParFuzzy parFuzzy = new ParFuzzy(valor, 1.0);
            listaParesFuzzy.addParFuzzy(parFuzzy);
        }
        return listaParesFuzzy;
    }
}
