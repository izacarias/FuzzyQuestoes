package fuzzySystem;

import java.util.ArrayList;

/**
 *
 * @author Gustavo B. Paulus, Iulisloi Zacarias, Rafael A. Vitalli
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
