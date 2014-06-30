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
public class VariavelLinguistica {
    
    public static String NS = "NS";
    public static String SP = "SP";
    public static String S  = "S";
    
    public static double getValor(int valorCrisp, String variavelLinguistica){
        double returnValue = -1;
        switch (variavelLinguistica) {
            case "NS":
                if ((valorCrisp >=0) && (valorCrisp <= 3)) {
                    returnValue = 1;
                } else if(valorCrisp == 4){
                    returnValue = 0.8;
                } else if (valorCrisp == 5){
                    returnValue = 0.2;
                } else if(valorCrisp >= 6){
                    returnValue = 0;
                }
                break;
            case "SP":
                if ((valorCrisp >=0) && (valorCrisp <= 4)) {
                    returnValue = 0;
                } else if(valorCrisp == 5){
                    returnValue = 0.2;
                } else if (valorCrisp == 6){
                    returnValue = 1;
                } else if(valorCrisp >= 7){
                    returnValue = 0.2;
                } else if (valorCrisp >= 8){
                    returnValue = 0;
                }
                break;
            case "S":
                if ((valorCrisp >=0) && (valorCrisp <= 7)) {
                    returnValue = 0;
                } else if(valorCrisp == 8){
                    returnValue = 0.8;
                } else if (valorCrisp >= 9){
                    returnValue = 1;
                }
                break;
            default:
                throw new AssertionError();
        }
        return returnValue;
    }
}
