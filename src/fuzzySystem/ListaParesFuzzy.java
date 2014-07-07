package fuzzySystem;

import java.util.ArrayList;

/**
 *
 * @author Gustavo B. Paulus, Iulisloi Zacarias, Rafael A. Vitalli
 */
public class ListaParesFuzzy {
    
    private ArrayList<ParFuzzy> listaPares;

    public ListaParesFuzzy() {
        this.listaPares = new ArrayList<>();
    }
    
    public ArrayList<ParFuzzy> asList(){
        return this.listaPares;
    }
    
    public void addParFuzzy(ParFuzzy par){
        this.listaPares.add(par);
    }
    
    public int size(){
        return this.listaPares.size();
    }
    
    public void print(){
        System.out.print("{");
        for (ParFuzzy pf : listaPares){
            pf.print();
            System.out.print(",");
        }
        System.out.print("}");
        System.out.println();
    }
}
