/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzySystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 *
 * @author iulisloi
 */
public class MaquinaInferencia {

    private BaseDadosEntrada baseDadosEntrada;
    private BaseDadosSaida baseDadosSaida;
    private BaseRegras baseRegras;
    private String[][] matrizPossibilidades;
    private ArrayList<String> matrizResultados;
    private LinkedHashMap<Integer, ArrayList<Double>> r;
    private ArrayList<Double> rFinal;
    private ArrayList<Double> pertinenciaQuestao;

    public MaquinaInferencia() {
        this.baseDadosEntrada = new BaseDadosEntrada();
        this.baseDadosSaida = new BaseDadosSaida();
        this.baseRegras = new BaseRegras();
        this.matrizResultados = new ArrayList<>();
        this.r = new LinkedHashMap<>();
        this.rFinal = new ArrayList<>();
        this.pertinenciaQuestao = new ArrayList<>();
    }

    public double geraInferencia(ListaParesFuzzy listaParesFuzzy) {
        ArrayList<Double> saidaSelecionada;
        this.matrizPossibilidades
                = baseRegras.geraCombinacoesPossiveis(listaParesFuzzy);
        // this.matrizResultados = new String[listaParesFuzzy.size()];
        for (int i = 0; i < matrizPossibilidades.length; i++) {
            ArrayList<String> alMatrizPossibilidades = new ArrayList<>();
            alMatrizPossibilidades.addAll(
                    Arrays.asList(this.matrizPossibilidades[i]));
            this.matrizResultados.add(i,
                    baseRegras.queryResultado(alMatrizPossibilidades, true));
        }
        this.r.clear();
        for (int i = 0; i < matrizPossibilidades.length; i++) {
            saidaSelecionada = baseDadosSaida.getLinha(
                    this.matrizResultados.get(i));
            this.pertinenciaQuestao.clear();
            for (int j = 0; j < matrizPossibilidades[i].length; j++) {
                this.pertinenciaQuestao.add(
                        baseDadosEntrada.getValorElemento(matrizPossibilidades[i][j],
                                listaParesFuzzy.asList().get(j)));
            }
            ArrayList<Double> rTemp = new ArrayList<>();
            for (int j = 0; j < saidaSelecionada.size(); j++) {
                rTemp.add(minimo(pertinenciaQuestao, saidaSelecionada.get(j)));
            }
            this.r.put(i, rTemp);
        }
        rFinal = rMaximo(r);
        return this.defuzzificacao(rFinal);
    }

    private double minimo(ArrayList<Double> pertQuestoes, double valorR) {
        double minimo = valorR;
        for (double valorQ : pertQuestoes) {
            minimo = Math.min(valorQ, minimo);
        }
        return minimo;
    }

    private ArrayList<Double> rMaximo(LinkedHashMap<Integer, ArrayList<Double>> erres) {
        ArrayList<Double> arrMax = erres.get(0);
        for (int i = 1; i < erres.size(); i++) {
            ArrayList<Double> rAtual = erres.get(i);
            for (int j = 0; j < arrMax.size(); j++) {
                if (rAtual.get(j) > arrMax.get(j)) {
                    arrMax.set(j, rAtual.get(j));
                }
            }
        }
        return arrMax;
    }

    private double defuzzificacao(ArrayList<Double> r) {
        double num = 0;
        double denom = 0;
        for (int i = 0; i < r.size(); i++) {
            num += r.get(i) * (i * 20);
            denom += r.get(i);
        }
        return num / denom;
    }
}
