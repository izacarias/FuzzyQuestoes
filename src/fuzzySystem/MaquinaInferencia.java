/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzySystem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author iulisloi
 */
public class MaquinaInferencia {

    private BaseDadosEntrada baseDadosEntrada;
    private BaseRegras baseRegras;
    private String[][] matrizPossibilidades;
    private String[] matrizResultados;

    public MaquinaInferencia() {
        this.baseDadosEntrada = new BaseDadosEntrada();
        this.baseRegras = new BaseRegras();
    }

    public void geraInferencia(ListaParesFuzzy listaParesFuzzy) {
        this.matrizPossibilidades
                = baseRegras.geraCombinacoesPossiveis(listaParesFuzzy);
        this.matrizResultados = new String[listaParesFuzzy.size()];
        for (int i = 0; i < matrizPossibilidades.length; i++) {
            ArrayList<String> alMatrizPossibilidades = new ArrayList<>();
            alMatrizPossibilidades.addAll(Arrays.asList(this.matrizPossibilidades[i]));
            matrizResultados[i] = baseRegras.queryResultado(alMatrizPossibilidades, true);
        }
        for (int i = 0; i < matrizPossibilidades.length; i++) {
            for (String item : matrizPossibilidades[i]) {
                System.out.print(item + " ");
            }
            System.out.println("-> " + matrizResultados[i]);
        }
    }
}
