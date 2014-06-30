/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fuzzySystem;

/**
 *
 * @author iulisloi
 */
public class ParFuzzy {
    
    private int valor;
    private double valorPertinencia;

    public ParFuzzy(int valor, double valorPertinencia) {
        this.valor = valor;
        this.valorPertinencia = valorPertinencia;
    }

    public int getValor() {
        return valor;
    }

    public double getValorPertinencia() {
        return valorPertinencia;
    }

    void print() {
        System.out.print("(");
        System.out.print(this.valor);
        System.out.print("/");
        System.out.print(this.valorPertinencia);
        System.out.print(")");
    }
}
