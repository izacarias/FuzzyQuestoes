package fuzzySystem;

import java.util.ArrayList;

/**
 *
 * @author iulisloi
 */
public class Regra {

    ArrayList<String> q = new ArrayList<String>();
    String resultado;

    public Regra(String q0, String q1, String q2, String q3, String q4,
            String q5, String q6, String q7, String q8, String q9,
            String resultado) {
        
        this.q.add(q0);
        this.q.add(q1);
        this.q.add(q2);
        this.q.add(q3);
        this.q.add(q4);
        this.q.add(q5);
        this.q.add(q6);
        this.q.add(q7);
        this.q.add(q8);
        this.q.add(q9);
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }
    
    public boolean compare(String q0, String q1, String q2, String q3, 
            String q4, String q5, String q6, String q7, String q8, String q9) {
        
        return  (q0.equals(this.q.get(0)) && 
                q1.equals(this.q.get(1)) && 
                q2.equals(this.q.get(2)) && 
                q3.equals(this.q.get(3)) && 
                q4.equals(this.q.get(4)) && 
                q5.equals(this.q.get(5)) && 
                q6.equals(this.q.get(6)) && 
                q7.equals(this.q.get(7)) && 
                q8.equals(this.q.get(8)) && 
                q9.equals(this.q.get(9)));
    }

    public void print() {
        System.out.print("{ ");
        for(String s : this.q){
            System.out.print(s);
            System.out.print(", ");
        }
        System.out.print(" => ");
        System.out.print(resultado);
        System.out.println(" }");
    }
}
