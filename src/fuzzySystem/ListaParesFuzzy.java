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
