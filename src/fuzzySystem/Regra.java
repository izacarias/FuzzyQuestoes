package fuzzySystem;

/**
 *
 * @author iulisloi
 */
public class Regra {

    String q0;
    String q1;
    String q2;
    String q3;
    String q4;
    String q5;
    String q6;
    String q7;
    String q8;
    String q9;
    String resultado;

    public Regra(String q0, String q1, String q2, String q3, String q4,
            String q5, String q6, String q7, String q8, String q9,
            String resultado) {
        
        this.q0 = q0;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
        this.q9 = q9;
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }
    
    public boolean compare(String q0, String q1, String q2, String q3, 
            String q4, String q5, String q6, String q7, String q8, String q9) {
        
        return  (q0.equals(this.q0) && 
                q1.equals(this.q1) && 
                q2.equals(this.q2) && 
                q3.equals(this.q3) && 
                q4.equals(this.q4) && 
                q5.equals(this.q5) && 
                q6.equals(this.q6) && 
                q7.equals(this.q7) && 
                q8.equals(this.q8) && 
                q9.equals(this.q9));
    }

    public void print() {
        System.out.print("{ ");
        System.out.print(q0);
        System.out.print(", ");
        System.out.print(q1);
        System.out.print(", ");
        System.out.print(q2);
        System.out.print(", ");
        System.out.print(q3);
        System.out.print(", ");
        System.out.print(q4);
        System.out.print(", ");
        System.out.print(q5);
        System.out.print(", ");
        System.out.print(q6);
        System.out.print(", ");
        System.out.print(q7);
        System.out.print(", ");
        System.out.print(q8);
        System.out.print(", ");
        System.out.print(q9);
        System.out.print(" => ");
        System.out.print(resultado);
        System.out.println(" }");
    }
}
